package chap8inheritance

import chap8inheritance.Ex1.BankAccount
import helpers.Generators._
import org.scalatest.{FunSuite, Matchers}

class Ex2Suite extends FunSuite with Matchers {

  import Ex2._

  def withdrawTest(ba: SavingsAccount, fee: Double): Unit = {
    val balance = ba.currentBalance

    val withdrawAmount = anyPositiveDouble
    ba.withdraw(withdrawAmount)

    ba.currentBalance should be(balance - withdrawAmount - fee)
  }

  def depositTest(ba: BankAccount, fee: Double): Unit = {
    val balance = ba.currentBalance

    val depositAmount = anyPositiveDouble
    ba.deposit(depositAmount)

    ba.currentBalance should be(balance + depositAmount - fee)
  }

  test("initial deposit should be a current balance") {
    val initialDeposit = anyPositiveDouble
    val ba = new SavingsAccount(initialDeposit)
    ba.currentBalance should be(initialDeposit)
  }

  test("saving account deducts 0 on first 3 withdrawals and 1 on any withdrawal following the 3rd one") {
    val ba = new SavingsAccount(anyPositiveDouble)

    for (i <- 1 to 3) {
      withdrawTest(ba, 0)
    }

    for (i <- 1 to 5) {
      withdrawTest(ba, 1.0)
    }
  }

  test("earnMonthlyInterest resets withdrawal allowance") {
    val ba = new SavingsAccount(anyPositiveDouble)

    withdrawTest(ba, 0)

    ba.earnMonthlyInterest(2)

    for (i <- 1 to 3) {
      withdrawTest(ba, 0)
    }

    withdrawTest(ba, 1.0)
  }

  test("saving account deducts 0 on first 3 deposit and 1 on any deposit following the 3rd one") {
    val ba = new SavingsAccount(anyPositiveDouble)

    for (i <- 1 to 3) {
      depositTest(ba, 0)
    }

    for (i <- 1 to 5) {
      depositTest(ba, 1.0)
    }
  }

  test("earnMonthlyInterest resets deposit allowance") {
    val ba = new SavingsAccount(anyPositiveDouble)

    depositTest(ba, 0)

    ba.earnMonthlyInterest(2)

    for (i <- 1 to 3) {
      depositTest(ba, 0)
    }

    depositTest(ba, 1.0)
  }

  test("earn monthly fee increases the balance by the interest") {
    val initialBalance = anyPositiveDouble
    val ba = new SavingsAccount(initialBalance)

    ba.earnMonthlyInterest(0)

    ba.currentBalance should be(initialBalance)

    ba.earnMonthlyInterest(2)

    ba.currentBalance should be(initialBalance * 3)

    val newBalance = ba.currentBalance

    ba.earnMonthlyInterest(0.2)

    ba.currentBalance should be(newBalance + newBalance * 0.2)
  }
}
