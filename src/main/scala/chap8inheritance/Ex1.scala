package chap8inheritance

/**
 * 1. Extend the following BankAccount class to a CheckingAccount class that charges $ 1 for every deposit and withdrawal.
 *
 * class BankAccount(initialBalance: Double) {
 * private var balance = initialBalance
 * def deposit( amount: Double) = { balance + = amount; balance }
 * def withdraw( amount: Double) = { balance -= amount; balance }
 * }
 *
 */
object Ex1 {

  class BankAccount(initialBalance: Double) {
    protected var balance = initialBalance

    def currentBalance: Double = balance

    def deposit(amount: Double) = {
      balance += amount
      balance
    }

    def withdraw(amount: Double) = {
      balance -= amount
      balance
    }
  }

  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {

    override def deposit(amount: Double) = {
      super.deposit(amount - 1)
    }

    override def withdraw(amount: Double) = {
      super.withdraw(amount + 1)
    }
  }

}
