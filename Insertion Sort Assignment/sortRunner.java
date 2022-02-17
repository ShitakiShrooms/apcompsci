import java.util.ArrayList;

public class sortRunner
{

    private ArrayList<Integer> sortList1 = new ArrayList<Integer>();
    private ArrayList<Integer> sortList2;
    private ArrayList<Integer> sortList3;

    public void run()
    {
        fillArraylists(10000);
        sortLists();

        fillArraylists(25000);
        sortLists();

        fillArraylists(50000);
        sortLists();
    }

    private void fillArraylists(int numbers)
    {
        sortList1 = new ArrayList<Integer>();
        for (int i = 0; i < numbers; i++) {
            sortList1.add((int) (Math.random() * numbers));
        }

        sortList2 = (ArrayList<Integer>) sortList1.clone();
        sortList3 = (ArrayList<Integer>) sortList1.clone();
    }
    
    private void bubbleSort(ArrayList<Integer> arr) 
    {
        int n = arr.size();
        int temp = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 1; j < n - i; j++)
            {
                if (arr.get(j - 1) < arr.get(j))
                {
                    temp = arr.get(j - 1);
                    arr.set(j - 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }

    private void selectionSort(ArrayList<Integer> arr)
    {
        int n = arr.size();
        int temp = 0;

        for (int i = 0; i < n; i++)
        {
            int min_idx = i;

            for (int j = i; j < n; j++)
            {
                if (arr.get(j) < arr.get(min_idx))
                {
                    min_idx = j;
                }
            }

            temp = arr.get(min_idx);
            arr.set(min_idx, arr.get(i));
            arr.set(i, temp);
        }
    }

    private void insertionSort(ArrayList<Integer> arr)
    {
        int n = arr.size();

        for (int i = 1; i < n; i++)
        {
            int value = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > value)
            {
                arr.set(j + 1, arr.get(j));
                j--;
            }

            arr.set(j + 1, value);
        }
    }

    private void sortLists()
    {
        int numToSort = sortList1.size();

        long startTime = System.nanoTime();
        bubbleSort(sortList1);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        double seconds = (double)totalTime / 1_000_000_000.0;
        System.out.println("Bubble Sort " + numToSort + " in seconds = " + seconds);


        startTime = System.nanoTime();
        selectionSort(sortList2);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1_000_000_000.0;
        System.out.println("Selection Sort " + numToSort + " in seconds = " + seconds);

        startTime = System.nanoTime();
        insertionSort(sortList3);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1_000_000_000.0;
        System.out.println("Insertion Sort " + numToSort + " in seconds = " + seconds);
    }

}
