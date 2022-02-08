import java.util.*;

public class salesRunner {
    private Scanner scanner;
    private int amountOfSalesPersons;
    private ArrayList<Sales> salesPersons;

    public void run() {
        setup();

        getAmountOfSalesPersons();
        setupSalesPersons();
        addNewSalesPersons();
        deleteSalesPersons();
        updateSalesPersons();
        printSalesPersons();
        System.out.println("Sorted low to high:");
        sortLowToHigh();
        printSalesPersons();
        System.out.println("Sorted high to low:");
        sortHighToLow();
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

    private void addNewSalesPersons() {
        System.out.println("Would you like to add a new sales person?");

        while (getNextYesOrNo()) {
            Sales person = setupSalesPerson();
            salesPersons.add(person);
            amountOfSalesPersons++;

            System.out.println("Would you like to add a new sales person?");
        }
    }

    private void deleteSalesPersons() {
        System.out.println("Would you like to delete a sales person?");

        while (getNextYesOrNo() && amountOfSalesPersons > 0) {
            System.out.println("Enter the unique ID for the sales person:");
            int id = getNextInt();
            Sales sales = getSalesPersonByID(id);
            while (sales == null) {
                System.out.println("Could not find sales person with that ID, please enter a valid ID:");
                id = getNextInt();
                sales = getSalesPersonByID(id);
            }

            salesPersons.remove(sales);
            amountOfSalesPersons--;

            System.out.println("Removed a sales person with the id: " + id);
            printSalesPersons();

            if (amountOfSalesPersons > 0) {
                System.out.println("Would you like to delete a sales person?");
            }
        }
    }

    private void updateSalesPersons() {
        System.out.println("Would you like to update a sales person?");
        while (getNextYesOrNo() && amountOfSalesPersons > 0) {
            System.out.println("Enter the unique ID for the sales person:");
            int id = getNextInt();
            Sales sales = getSalesPersonByID(id);
            while (sales == null) {
                System.out.println("Could not find sales person with that ID, please enter a valid ID:");
                id = getNextInt();
                sales = getSalesPersonByID(id);
            }

            System.out.println("Enter the new daily goal:");
            double dailyGoal = getNextDouble();
            sales.setDailyGoal(dailyGoal);

            System.out.println("Updated person's daily goal");
            System.out.println("Would you like to update another sales person?");
        }
    }

    private void sortLowToHigh() {
        int n = salesPersons.size();
        Sales temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n-i); j++) {
                if (salesPersons.get(j-1).getId() > salesPersons.get(j).getId()) {
                    temp = salesPersons.get(j-1);
                    salesPersons.set(j-1, salesPersons.get(j));
                    salesPersons.set(j, temp);
                }
            }
        }
    }

    private void sortHighToLow() {
        int n = salesPersons.size();
        Sales temp = null;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n-i); j++) {
                if (salesPersons.get(j-1).getId() < salesPersons.get(j).getId()) {
                    temp = salesPersons.get(j-1);
                    salesPersons.set(j-1, salesPersons.get(j));
                    salesPersons.set(j, temp);
                }
            }
        }
    }

    private void printSalesPersons() {
        for (int i = 0; i < amountOfSalesPersons; i++) {
            System.out.println(salesPersons.get(i));
        }
    }

    private Sales getSalesPersonByID(int id) {
        for (int i = 0; i < salesPersons.size(); i++) {
            if (salesPersons.get(i).getId() == id) {
                return salesPersons.get(i);
            }
        }
        return null;
    }

    private int getUniqueID() {
        int id = -1;
        boolean isIdUnique = false;

        while (!isIdUnique) {
            id = getNextInt();

            boolean foundId = false;

            for (int i = 0; i < amountOfSalesPersons && i < salesPersons.size(); i++) {
                if (salesPersons.get(i) != null && salesPersons.get(i).getId() == id) {
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

    private String getNextStr() {
        while (!scanner.hasNextLine()) {
            System.out.println("Please enter a valid string value:");
            scanner.next();
        }

        return scanner.nextLine();
    }

    private boolean getNextYesOrNo() {
        boolean yesOrNo = false;
        boolean isYesOrNoValid = false;

        while (!isYesOrNoValid) {
            String string = getNextStr();

            if (string.toLowerCase().equals("yes")) {
                yesOrNo = true;
                isYesOrNoValid = true;
            } else if (string.toLowerCase().equals("no")) {
                yesOrNo = false;
                isYesOrNoValid = true;
            } else {
                System.out.println("Please enter a valid yes or no answer.");
            }
        }

        return yesOrNo;
    }

}