import java.util.ArrayList;

public class doubleArrayLists {
    private ArrayList<Double> myDubAL = new ArrayList<Double>();

    public void runDubAL() {
        System.out.println("****Test Case 1 - adding elements to the Double ArrayList****");
        myDubAL.add(2.7);
        myDubAL.add(4.2);
        printRpts();

        System.out.println("****Test Case 2 - adding element to the first Position of the Double ArrayList****");
        myDubAL.add(0, 51.37);
        printRpts();

        System.out.println("****Test Case 3 - adding element to the last Position of the Double ArrayList****");
        myDubAL.add(6.2);
        printRpts();

        System.out.println("****Test Case 4 - Changing element # 1 of the Double ArrayList****");
        System.out.println("Previous Value at index 1 = " + myDubAL.set(1, 123.456));
        printRpts();

        System.out.println("****Test Case 5 - Deleting element # 3 of the Double ArrayList****");
        System.out.println("Previous Value at index 3 = " + myDubAL.remove(3));
        printRpts();
    }

    private void printRpts() {
        printReg();
        printEnh();
        printAL();
        printALSize();
    }

    private void printReg() {
        for (int i = 0; i < myDubAL.size(); i++) {
            System.out.println("Regular Double for loop index = " + i + " " + myDubAL.get(i));
        }

        System.out.println("");

    }

    private void printEnh() {
        for (Double myDub : myDubAL) {
            System.out.println("Enhanced Double for loop = " + myDub);
        }

        System.out.println("");
    }

    private void printAL() {
        System.out.println("My Double Array List values = " + myDubAL);
    }

    private void printALSize() {
        System.out.println("Double Array List size = " + myDubAL.size());
        System.out.println("");
    }
}