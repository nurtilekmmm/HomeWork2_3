public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(0.0);

        double depositAmount = 20000.0;
        account.deposit(depositAmount);
        System.out.println("Пополнение счета на " + depositAmount + " сом");
        System.out.println("Остаток на счете: " + account.getAmount() + " сом");

        double withdrawalAmount = 6000.0;
        try {
            while (true) {
                account.withdraw(withdrawalAmount);
                System.out.println("Снятие успешно: " + withdrawalAmount + " сом");
                System.out.println("Остаток на счете: " + account.getAmount() + " сом");
            }
        } catch (LimitException e) {
            double remainingAmount = e.getRemainingAmount();
            System.out.println("Превышение лимита! Максимально возможная сумма для снятия: " + remainingAmount + " сом");

            try {
                account.withdraw(remainingAmount);
            } catch (LimitException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("Снятие оставшихся средств: " + remainingAmount + " сом");
        }

        System.out.println("Остаток на счете: " + account.getAmount() + " сом");

    }
}
