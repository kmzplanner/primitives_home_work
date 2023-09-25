import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int earnings = 0;   // доходы
        int spendings = 0;  // расходы

        while (true) {
            System.out.println(
                    "Выберите операцию и введите её номер:\n" +
                            "1. Добавить новый доход\n" +
                            "2. Добавить новый расход\n" +
                            "3. Выбрать систему налогообложения\n" +
                            "end. Чтоб завершить программу");

            String input = scanner.nextLine();

            if ("end".equals(input)) {
                break;
            } else {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        String moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                        int money = Integer.parseInt(moneyStr); //
                        earnings += money;
                        break;
                    case 2:
                        System.out.println("Введите сумму расхода:");
                        String moneyStr1 = scanner.nextLine(); // Не используйте тут nextInt (!)
                        int money1 = Integer.parseInt(moneyStr1); //
                        spendings += money1;
                        break;
                    case 3:
                        int amountTaxEarning = Usn.taxEarnings(earnings);
                        int amountTaxEaMinSpen = Usn.taxEarningsMinusSpendings(earnings, spendings);
                        if (amountTaxEaMinSpen > amountTaxEarning) {
                            System.out.println("Мы советуем вам УСН доходы \n" +
                                    "Ваш налог составит: " + amountTaxEarning + " руб.\n" +
                                    "Налог на другой системе: " + amountTaxEaMinSpen + " руб.\n" +
                                    "Экономия составит: " + (amountTaxEaMinSpen - amountTaxEarning) + " руб.");
                        } else {
                            System.out.println("Мы советуем вам УСН доходы минус\n" +
                                    "Ваш налог составит: " + amountTaxEaMinSpen + " руб. \n" +
                                    "Налог на другой системе: " + amountTaxEarning + " руб.\n" +
                                    "Экономия составит: " + (amountTaxEarning - amountTaxEaMinSpen) + " руб.");
                        }
                        break;
                    default:
                        System.out.println("Такой операции нет");
                }

            }
        }
        System.out.println("Программа завершена!");
    }
}
