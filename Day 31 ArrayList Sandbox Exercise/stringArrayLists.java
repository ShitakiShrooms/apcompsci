import java.util.ArrayList;

public class stringArrayLists {
    private ArrayList<String> myStrAL = new ArrayList<String>();

    public void runStrAL() {
        System.out.println("****Test Case 1 - adding elements to the String ArrayList****");
        myStrAL.add("Hello");
        myStrAL.add("Goodbye");
        printRpts();

        System.out.println("****Test Case 2 - adding element to the first Position of the String ArrayList****");
        myStrAL.add(0, "Hola");
        printRpts();

        System.out.println("****Test Case 3 - adding element to the last Position of the String ArrayList****");
        myStrAL.add("Goodbye 2");
        printRpts();

        System.out.println("****Test Case 4 - Changing element # 1 of the String ArrayList****");
        System.out.println("Previous Value at index 1 = " + myStrAL.set(1, "Aloha"));
        printRpts();

        System.out.println("****Test Case 5 - Deleting element # 3 of the String ArrayList****");
        System.out.println("Previous Value at index 3 = " + myStrAL.remove(3));
        printRpts();
    }

    /*****************************************************
     *
     * Prints Reports
     *
     * *************************************************/
    private void printRpts() {
        printReg();
        printEnh();
        printAL();
        printALSize();
    }

    /*****************************************************
     *
     * Prints using a regular for loop
     *
     * *************************************************/
    private void printReg() {
        for (int i = 0; i < myStrAL.size(); i++) {
            System.out.println("Regular String for loop index = " + i + " " + myStrAL.get(i));
        }

        System.out.println("");

    }

    private void printEnh() {
        for (String myStr : myStrAL) {
            System.out.println("Enhanced String for loop = " + myStr);
        }

        System.out.println("");
    }

    private void printAL() {
        System.out.println("My String Array List values = " + myStrAL);
    }

    private void printALSize() {
        System.out.println("String Array List size = " + myStrAL.size());
        System.out.println("");
    }
}