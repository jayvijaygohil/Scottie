package com.jayvijay.scottie.feature.interacbanking.domain.usecase

import com.jayvijay.scottie.feature.interacbanking.Fixtures
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.ContactMatcher.contactScore
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.ContactMatcher.rankContacts
import org.junit.Assert.assertEquals
import org.junit.Test

class ContactMatcherTest {
  private fun ids(query: String) = rankContacts(query, Fixtures.CONTACTS).map { it.contactId }

  @Test
  fun typoMatchesClosestName() {
    assertEquals(listOf("ct_charlie"), ids("Charly"))
    assertEquals(40, contactScore("Charly", Fixtures.CHARLIE))
  }

  @Test
  fun prefixMatchesSeveralAtEqualStrength() {
    assertEquals(listOf("ct_alice", "ct_alicia"), ids("Ali"))
    assertEquals(80, contactScore("Ali", Fixtures.ALICE))
    assertEquals(80, contactScore("Ali", Fixtures.ALICIA))
  }

  @Test
  fun exactFirstNameBeatsRobert() {
    assertEquals(listOf("ct_bob"), ids("Bob"))
    assertEquals(100, contactScore("Bob", Fixtures.BOB))
    assertEquals(0, contactScore("Bob", Fixtures.ROBERT))
  }

  @Test
  fun robRanksRobertThenBob() {
    assertEquals(listOf("ct_robert", "ct_bob"), ids("Rob"))
    assertEquals(80, contactScore("Rob", Fixtures.ROBERT))
    assertEquals(40, contactScore("Rob", Fixtures.BOB))
  }

  @Test
  fun phoneDigitsMatchRegardlessOfFormatting() {
    assertEquals(listOf("ct_bob"), ids("4165550143"))
    assertEquals(listOf("ct_bob"), ids("416-555-0143"))
    assertEquals(100, contactScore("4165550143", Fixtures.BOB))
    assertEquals(100, contactScore("416-555-0143", Fixtures.BOB))
  }

  @Test
  fun emailMatches() {
    assertEquals(100, contactScore("charlie.c@example.ca", Fixtures.CHARLIE))
    assertEquals(listOf("ct_charlie"), ids("EXAMPLE.CA"))
    assertEquals(60, contactScore("EXAMPLE.CA", Fixtures.CHARLIE))
  }

  @Test
  fun nothingCloseIsEmptyAndBlankIsEveryone() {
    assertEquals(emptyList<String>(), ids("zzz"))
    assertEquals(emptyList<String>(), ids("sam@example.com"))
    assertEquals(Fixtures.CONTACTS.size, ids("").size)
  }
}
