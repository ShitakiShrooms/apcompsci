import java.util.ArrayList;

public class sortRunner
{

    private ArrayList<Integer> sortList1 = new ArrayList<Integer>();
    private ArrayList<Integer> sortList2;
    private ArrayList<Integer> sortList3;
    private ArrayList<Integer> sortList4;

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
        sortList4 = (ArrayList<Integer>) sortList1.clone();
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

    private void beginMergeSort(ArrayList<Integer> arr)
    {
        mergeSort(arr, 0, arr.size() - 1);
    }

    private void mergeSort(ArrayList<Integer> arr, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    private void merge(ArrayList<Integer> arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr.get(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = arr.get(m + 1 + j);

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr.set(k, L[i]);
                i++;
            }
            else {
                arr.set(k, R[j]);
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr.set(k, R[j]);
            j++;
            k++;
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

        startTime = System.nanoTime();
        beginMergeSort(sortList4);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1_000_000_000.0;
        System.out.println("Merge Sort " + numToSort + " in seconds = " + seconds);
    }

}
