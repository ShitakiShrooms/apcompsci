import java.util.*;

public class salesRunner {
    private Scanner scanner;
    private int amountOfSalesPersons;
    private ArrayList<Sales> salesPersons;

    public void run() {
        setup();

        getAmountOfSalesPersons();
        setupSalesPersons();
        printSalesPersons();
    }

    private void setup() {
        scanner = new Scanner(System.in);
    }

    private void getAmountOfSalesPersons() {
        System.out.println("Enter the amount of sales persons:");
        amountOfSalesPersons = getNextInt();

        salesPersons = new ArrayList<Sales>();
    }

    private void setupSalesPersons() {
        for (int i = 0; i < amountOfSalesPersons; i++) {
            Sales salesPerson = setupSalesPerson();
            salesPersons.add(i, salesPerson);
        }
    }

    private Sales setupSalesPerson() {
        System.out.println("Enter a unique sales person ID:");
        int id = getUniqueID();

        System.out.println("Enter the daily goal:");
        double dailyGoal = getNextDouble();

        System.out.println("Enter the amount of daily sales:");
        int amountOfDailySales = getNextInt();

        Sales salesPerson = new Sales(id, dailyGoal, amountOfDailySales);

        for (int i = 0; i < amountOfDailySales; i++) {
            System.out.println("Enter the daily sale for day " + (i + 1));
            salesPerson.setDailySale(i, getNextDouble());
        }

        return salesPerson;
    }

    private void printSalesPersons() {
        for (int i = 0; i < amountOfSalesPersons; i++) {
            System.out.println(salesPersons.get(i));
        }
    }

    private int getUniqueID() {
        int id = -1;
        boolean isIdUnique = false;

        while (!isIdUnique) {
            id = getNextInt();

            boolean foundId = false;

            for (int i = 0; i < amountOfSalesPersons; i++) {
                if (salesPersons.contains(i) && salesPersons.get(i) != null && salesPersons.get(i).getId() == id) {
                    System.out.println("ID must be unique!");
                    foundId = true;
                    break;
                }
            }

            isIdUnique = !foundId;
        }

        return id;
    }

    private double getNextDouble() {
        double number = -1;
        boolean isNumberValid = false;

        while (!isNumberValid) {
            while (!scanner.hasNextDouble()) {
                System.out.println("Please enter a valid double value:");
                scanner.next();
            }
            number = scanner.nextDouble();
            if (number <= 0) {
                System.out.println("Number must be greater than 0!");
                continue;
            }
            isNumberValid = true;
        }

        return number;
    }

    private int getNextInt() {
        int number = -1;
        boolean isNumberValid = false;

        while (!isNumberValid) {
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid integer value:");
                scanner.next();
            }
            number = scanner.nextInt();
            if (number <= 0) {
                System.out.println("Number must be greater than 0!");
                continue;
            }
            isNumberValid = true;
        }

        return number;
    }

}

