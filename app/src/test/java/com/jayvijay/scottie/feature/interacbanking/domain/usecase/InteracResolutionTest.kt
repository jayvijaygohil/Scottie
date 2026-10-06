package com.jayvijay.scottie.feature.interacbanking.domain.usecase

import com.jayvijay.scottie.feature.interacbanking.Fixtures
import com.jayvijay.scottie.feature.interacbanking.Fixtures.ACCOUNTS
import com.jayvijay.scottie.feature.interacbanking.Fixtures.EVERYDAY
import com.jayvijay.scottie.feature.interacbanking.Fixtures.JOINT
import com.jayvijay.scottie.feature.interacbanking.Fixtures.SAVINGS
import com.jayvijay.scottie.feature.interacbanking.Fixtures.VISA
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.InteracResolution.clearMatch
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.InteracResolution.eligibleDeposits
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.InteracResolution.eligibleSources
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.InteracResolution.matchAccounts
import com.jayvijay.scottie.feature.interacbanking.domain.usecase.InteracResolution.validateAmount
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class InteracResolutionTest {
  @Test
  fun matchesAccountsByTypeMaskNameOrNothing() {
    assertEquals(listOf(SAVINGS), matchAccounts("savings", ACCOUNTS))
    assertEquals(listOf(EVERYDAY, JOINT), matchAccounts("my chequing", ACCOUNTS))
    assertEquals(listOf(EVERYDAY), matchAccounts("ending 4821", ACCOUNTS))
    assertEquals(listOf(EVERYDAY), matchAccounts("4821", ACCOUNTS))
    assertEquals(listOf(VISA), matchAccounts("my visa", ACCOUNTS))
    assertEquals(listOf(EVERYDAY), matchAccounts("Everyday Chequing", ACCOUNTS))
    assertEquals(listOf(EVERYDAY, JOINT), matchAccounts("chequing", ACCOUNTS))
    assertEquals(emptyList<Any>(), matchAccounts("TFSA", ACCOUNTS))
    assertEquals(ACCOUNTS, matchAccounts(null, ACCOUNTS))
    assertEquals(ACCOUNTS, matchAccounts("  ", ACCOUNTS))
  }

  @Test
  fun eligibleSourcesCoverAmountChequingFirstNeverCredit() {
    assertEquals(listOf(EVERYDAY, SAVINGS), eligibleSources(ACCOUNTS, 100.0))
    assertEquals(listOf(SAVINGS), eligibleSources(ACCOUNTS, 2000.0))
    assertEquals(listOf(EVERYDAY, JOINT, SAVINGS), eligibleSources(ACCOUNTS, null))
    assertEquals(listOf(EVERYDAY, SAVINGS), eligibleSources(ACCOUNTS, 1540.25))
    assertEquals(listOf(EVERYDAY, JOINT, SAVINGS), eligibleDeposits(ACCOUNTS))
  }

  @Test
  fun amountsNeedTwoDecimalsAndPositive() {
    assertEquals(50.0, validateAmount("50")!!, 0.0)
    assertEquals(50.5, validateAmount("50.5")!!, 0.0)
    assertEquals(50.25, validateAmount(" 50.25 ")!!, 0.0)
    assertEquals(2000.0, validateAmount("2,000")!!, 0.0)
    for (bad in listOf("50.255", "0", "-1", "abc", "")) assertNull(bad, validateAmount(bad))
  }

  @Test
  fun clearMatchNeedsStrongTopAndGap() {
    fun ranked(query: String) =
      ContactMatcher.rankContacts(query, Fixtures.CONTACTS).map {
        it to ContactMatcher.contactScore(query, it)
      }
    assertNull(clearMatch(ranked("Ali")))
    assertEquals(Fixtures.BOB, clearMatch(ranked("Bob")))
    assertEquals(Fixtures.ROBERT, clearMatch(ranked("Rob")))
    assertEquals(Fixtures.CHARLIE, clearMatch(ranked("Charly")))
    assertEquals(Fixtures.ALICE, clearMatch(ranked("Alice")))
    assertNull(clearMatch(emptyList()))
  }
}
