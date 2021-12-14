import java.util.ArrayList;

public class integerArrayLists {
    private ArrayList<Integer> myIntAL = new ArrayList<Integer>();

    public void runIntAL() {
        System.out.println("****Test Case 1 - adding elements to the Integer ArrayList****");
        myIntAL.add(50);
        myIntAL.add(150);
        printRpts();

        System.out.println("****Test Case 2 - adding element to the first Position of the Integer ArrayList****");
        myIntAL.add(0, 350);
        printRpts();

        System.out.println("****Test Case 3 - adding element to the last Position of the Integer ArrayList****");
        myIntAL.add(450);
        printRpts();

        System.out.println("****Test Case 4 - Changing element # 1 of the Integer ArrayList****");
        System.out.println("Previous Value at index 1 = " + myIntAL.set(1, 650));
        printRpts();

        System.out.println("****Test Case 5 - Deleting element # 3 of the Integer ArrayList****");
        System.out.println("Previous Value at index 3 = " + myIntAL.remove(3));
        printRpts();
    }

    private void printRpts() {
        printReg();
        printEnh();
        printAL();
        printALSize();
    }

    private void printReg() {
        for (int i = 0; i < myIntAL.size(); i++) {
            System.out.println("Regular Integer for loop index = " + (i) + "  " + myIntAL.get(i));
        }

        System.out.println("");

    }

    private void printEnh() {
        for (Integer myInt : myIntAL) {
            System.out.println("Enhanced Integer for loop = " + myInt);
        }

        System.out.println("");
    }

    private void printAL() {
        System.out.println("My Int Array List values = " + myIntAL);
    }

    private void printALSize() {
        System.out.println("Int Array List size = " + myIntAL.size());
        System.out.println("");
    }
}