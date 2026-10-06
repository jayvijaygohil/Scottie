package com.jayvijay.scottie.feature.interacbanking

import com.jayvijay.scottie.feature.interacbanking.domain.entities.Account
import com.jayvijay.scottie.feature.interacbanking.domain.entities.AccountType
import com.jayvijay.scottie.feature.interacbanking.domain.entities.InteracContact

/** The seeded mock data (FR-001/FR-002), for domain tests that must not import `data/`. */
object Fixtures {
  val EVERYDAY =
    Account("acc_chk_101", "Everyday Chequing", AccountType.CHEQUING, "**** 4821", 1540.25)
  val SAVINGS =
    Account("acc_sav_202", "High-Interest Savings", AccountType.SAVINGS, "**** 8830", 6200.00)
  val JOINT = Account("acc_chk_303", "Joint Chequing", AccountType.CHEQUING, "**** 1177", 85.40)
  val VISA = Account("acc_cc_404", "Rewards Visa", AccountType.CREDIT, "**** 3092", 2500.00)
  val ACCOUNTS = listOf(EVERYDAY, SAVINGS, JOINT, VISA)

  val ALICE = InteracContact("ct_alice", "Alice Martin", "alice.m@example.com", null, true)
  val BOB = InteracContact("ct_bob", "Bob Vance", null, "+1-416-555-0143", false)
  val CHARLIE =
    InteracContact("ct_charlie", "Charlie Chen", "charlie.c@example.ca", "+1-647-555-0199", false)
  val JANE = InteracContact("ct_jane", "Jane Doe", "jane.doe@example.com", "+1-905-555-0122", true)
  val ALICIA =
    InteracContact("ct_alicia", "Alicia Moreno", "alicia.moreno@example.com", null, false)
  val ROBERT = InteracContact("ct_robert", "Robert Singh", null, "+1-289-555-0177", true)
  val CONTACTS = listOf(ALICE, BOB, CHARLIE, JANE, ALICIA, ROBERT)
}
