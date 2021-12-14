import java.util.ArrayList;

public class salesArrayLists {
    private ArrayList<Sales> mySalesAL = new ArrayList<Sales>();

    public void runSalesAL() {
        System.out.println("****Test Case 1 - adding elements to the Sales ArrayList****");
        mySalesAL.add(new Sales(1));
        mySalesAL.add(new Sales(2));
        printRpts();

        System.out.println("****Test Case 2 - adding element to the first Position of the Sales ArrayList****");
        mySalesAL.add(0, new Sales(3));
        printRpts();

        System.out.println("****Test Case 3 - adding element to the last Position of the Sales ArrayList****");
        mySalesAL.add(new Sales(4));
        printRpts();

        System.out.println("****Test Case 4 - Changing element # 1 of the Sales ArrayList****");
        System.out.println("Previous Value at index 1 = " + mySalesAL.set(1, new Sales(5)));
        printRpts();

        System.out.println("****Test Case 5 - Deleting element # 3 of the Sales ArrayList****");
        System.out.println("Previous Value at index 3 = " + mySalesAL.remove(3));
        printRpts();
    }

    private void printRpts() {
        printReg();
        printEnh();
        printAL();
        printALSize();
    }

    private void printReg() {
        for (int i = 0; i < mySalesAL.size(); i++) {
            System.out.println("Regular Sales for loop index = " + i + " " + mySalesAL.get(i));
        }

        System.out.println("");

    }

    private void printEnh() {
        for (Sales mySales : mySalesAL) {
            System.out.println("Enhanced Sales for loop = " + mySales);
        }

        System.out.println("");
    }

    private void printAL() {
        System.out.println("My Sales Array List values = " + mySalesAL);
    }

    private void printALSize() {
        System.out.println("Sales Array List size = " + mySalesAL.size());
        System.out.println("");
    }
}