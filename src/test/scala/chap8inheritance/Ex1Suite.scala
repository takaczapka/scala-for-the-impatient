package chap8inheritance

import generators.Generators._
import org.scalatest.{FunSuite, Matchers}

class Ex1Suite extends FunSuite with Matchers {

  import Ex1._

  test("checking account deducts 1 on withdrawal") {
    val initialDeposit = anyPositiveDouble
    val ba = new CheckingAccount(initialDeposit)

    ba.currentBalance should be (initialDeposit)

    val withdrawAmount = anyPositiveDouble
    ba.withdraw(withdrawAmount)

    ba.currentBalance should be (initialDeposit - withdrawAmount - 1)
  }

  test("checking account deducts 1 on deposit") {
    val initialDeposit = anyPositiveDouble
    val ba = new CheckingAccount(initialDeposit)

    ba.currentBalance should be (initialDeposit)

    val depositAmount = anyPositiveDouble
    ba.deposit(depositAmount)

    ba.currentBalance should be (initialDeposit + depositAmount - 1)
  }
}
