package com.jayvijay.scottie.feature.interacbanking.domain.usecase

import com.jayvijay.scottie.feature.interacbanking.domain.entities.InteracContact

/**
 * Ranked fuzzy contact search (research R6). Pure so the data service and the presenter share one
 * ranking.
 */
object ContactMatcher {
  const val EXACT = 100
  const val PREFIX = 80
  const val SUBSTRING = 60
  const val FUZZY = 40

  // Research R6 says 4, but its own table ("Rob" → Bob 40) needs 3; short queries get one edit.
  private const val FUZZY_MIN_QUERY = 3
  private const val FUZZY_LONG_QUERY = 4
  private const val FUZZY_MAX_DISTANCE = 2
  private const val PHONE_MIN_DIGITS = 4
  private const val NATIONAL_DIGITS = 10

  fun rankContacts(query: String, contacts: List<InteracContact>): List<InteracContact> =
    contacts
      .map { it to contactScore(query, it) }
      .filter { it.second > 0 }
      .sortedWith(
        compareByDescending<Pair<InteracContact, Int>> { it.second }.thenBy { it.first.name }
      )
      .map { it.first }

  fun contactScore(query: String, contact: InteracContact): Int {
    val q = query.trim().lowercase()
    if (q.isEmpty()) return EXACT
    val digits = q.filter { it.isDigit() }.takeLast(NATIONAL_DIGITS)
    val phoneQuery = digits.length >= PHONE_MIN_DIGITS && q.none { it.isLetter() }
    return if (phoneQuery) phoneScore(digits, contact) else textScore(q, contact)
  }

  private fun phoneScore(digits: String, contact: InteracContact): Int {
    val phone = contact.phoneNumber?.filter { it.isDigit() }?.takeLast(NATIONAL_DIGITS) ?: return 0
    return when {
      phone == digits -> EXACT
      phone.endsWith(digits) -> PREFIX
      phone.contains(digits) -> SUBSTRING
      else -> 0
    }
  }

  private fun textScore(q: String, contact: InteracContact): Int {
    val name = contact.name.lowercase()
    val tokens = name.split(' ').filter { it.isNotEmpty() }
    val email = contact.email?.lowercase()
    val local = email?.substringBefore('@')
    return when {
      q == name || q == tokens.first() || q == email -> EXACT
      tokens.any { it.startsWith(q) } || local?.startsWith(q) == true -> PREFIX
      name.contains(q) || email?.contains(q) == true -> SUBSTRING
      q.length >= FUZZY_MIN_QUERY && tokens.any { distance(q, it) <= maxDistance(q) } -> FUZZY
      else -> 0
    }
  }

  private fun maxDistance(q: String) = if (q.length >= FUZZY_LONG_QUERY) FUZZY_MAX_DISTANCE else 1

  /** Damerau-Levenshtein (optimal string alignment) distance. */
  private fun distance(a: String, b: String): Int {
    val d = Array(a.length + 1) { IntArray(b.length + 1) }
    for (i in 0..a.length) d[i][0] = i
    for (j in 0..b.length) d[0][j] = j
    for (i in 1..a.length) {
      for (j in 1..b.length) {
        val cost = if (a[i - 1] == b[j - 1]) 0 else 1
        d[i][j] = minOf(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + cost)
        val transposed = i > 1 && j > 1 && a[i - 1] == b[j - 2]
        if (transposed && a[i - 2] == b[j - 1]) d[i][j] = minOf(d[i][j], d[i - 2][j - 2] + 1)
      }
    }
    return d[a.length][b.length]
  }
}
