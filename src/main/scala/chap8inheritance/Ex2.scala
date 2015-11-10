package chap8inheritance

/**
 * 2. Extend the BankAccount class of the preceding exercise into a class SavingsAccount that earns interest
 * every month (when a method earnMonthlyInterest is called) and has three free deposits or withdrawals every
 * month. Reset the transaction count in the earnMonthlyInterest method.
 */
object Ex2 {
  import Ex1.BankAccount

  class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {

    val MONTHLY_FREE_OPERATIONS = 3

    var freeDeposits = MONTHLY_FREE_OPERATIONS
    var freeWithdrawals = MONTHLY_FREE_OPERATIONS

    override def deposit(amount: Double) = {
      val fee = if (freeDeposits > 0) {
        freeDeposits -= 1
        0
      } else 1

      super.deposit(amount - fee)
    }

    override def withdraw(amount: Double) = {
      val fee = if (freeWithdrawals > 0) {
        freeWithdrawals -= 1
        0
      } else 1

      super.withdraw(amount + fee)
    }

    def earnMonthlyInterest(interest: Double): Unit = {
      freeDeposits = MONTHLY_FREE_OPERATIONS
      freeWithdrawals = MONTHLY_FREE_OPERATIONS

      balance += balance * interest
    }
  }
}
