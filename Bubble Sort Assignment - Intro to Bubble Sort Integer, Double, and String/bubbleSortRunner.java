import java.util.ArrayList;

public class bubbleSortRunner
{

    private ArrayList<Integer> myIntAL = new ArrayList<Integer>();
    private ArrayList<Double> myDoubleAl = new ArrayList<Double>();
    private ArrayList<String> myStringAl = new ArrayList<String>();

    public bubbleSortRunner()
    {
        buildIntArray();
        System.out.println("Unsorted");
        printArrayInt();
        bubbleSortIntLowHigh(myIntAL);
        System.out.println("Sorted low to high");
        printArrayInt();
        bubbleSortIntHighLow(myIntAL);
        System.out.println("Sorted high to low");
        printArrayInt();

        buildArrayDouble();
        System.out.println("Unsorted");
        printArrayDouble();
        bubbleSortDoubleLowHigh(myDoubleAl);
        System.out.println("Sorted low to high");
        printArrayDouble();
        bubbleSortDoubleHighLow(myDoubleAl);
        System.out.println("Sorted high to low");
        printArrayDouble();

        buildArrayString();
        System.out.println("Unsorted");
        printArrayString();
        bubbleSortStringLowHigh(myStringAl);
        System.out.println("Sorted low to high");
        printArrayString();
        bubbleSortStringHighLow(myStringAl);
        System.out.println("Sorted high to low");
        printArrayString();
    }

public void buildIntArray()
{
    for (int i = 0; i < 25; i++)
    {
        myIntAL.add((int)(Math.random() * 200));
    }
}
public void buildArrayDouble()
{
    for (int i = 0; i < 25; i++)
    {
        myDoubleAl.add(Math.random() * 200);
    }
}
public void buildArrayString()
{
    myStringAl.add("hfgsa");
    myStringAl.add("asdf");
    myStringAl.add("qwerty");
    myStringAl.add("jsgsdf");
    myStringAl.add("zxcv");
    myStringAl.add("udsrt");
    myStringAl.add("ifytyu");
    myStringAl.add("ldfghd");
    myStringAl.add("weyrt");
    myStringAl.add("sdfhzxd");
    myStringAl.add("uirty");
    myStringAl.add("jgdfg");
    myStringAl.add("zxdfsz");
}

public void printArrayInt()
{
    for (Integer myInt : myIntAL)
    {
        System.out.println(myInt);
    }
}
public void printArrayDouble()
{
    for (double dub : myDoubleAl)
    {
        System.out.println(dub);
    }
}
public void printArrayString()
{
    for (String str : myStringAl)
    {
        System.out.println(str);
    }
}

public void bubbleSortIntHighLow(ArrayList<Integer> arr)
{
    int n = arr.size();
    Integer temp = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 1; j < (n - i); j++)
        {
            if (arr.get(j-1) < arr.get(j))
            {
                //swap elements
                temp = arr.get(j-1);
                arr.set(j-1,arr.get(j));
                arr.set(j, temp);
            }
        }
    }
}
public void bubbleSortIntLowHigh(ArrayList<Integer> arr)
{
    int n = arr.size();
    Integer temp = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 1; j < (n - i); j++)
        {
            if (arr.get(j-1) > arr.get(j))
            {
                //swap elements
                temp = arr.get(j-1);
                arr.set(j-1,arr.get(j));
                arr.set(j, temp);
            }
        }
    }
}
public void bubbleSortDoubleLowHigh(ArrayList<Double> arr)
{
    int n = arr.size();
    double temp = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 1; j < (n - i); j++)
        {
            if (arr.get(j - 1) > arr.get(j))
            {
                temp = arr.get(j - 1);
                arr.set(j - 1, arr.get(j));
                arr.set(j, temp);
            }
        }
    }
}
public void bubbleSortDoubleHighLow(ArrayList<Double> arr)
{
    int n = arr.size();
    double temp = 0;
    for (int i = 0; i < n; i++)
    {
        for (int j = 1; j < (n - i); j++)
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
public void bubbleSortStringLowHigh(ArrayList<String> arr)
{
    int n = arr.size();
    String temp = "";
    for (int i = 0; i < n; i++)
    {
        for (int j = 1; j < (n - i); j++)
        {
            if (arr.get(j - 1).compareTo(arr.get(j)) > 0)
            {
                temp = arr.get(j - 1);
                arr.set(j - 1, arr.get(j));
                arr.set(j, temp);
            }
        }
    }
}
public void bubbleSortStringHighLow(ArrayList<String> arr)
{
    int n = arr.size();
    String temp = "";
    for (int i = 0; i < n; i++)
    {
        for (int j = 1; j < (n - i); j++)
        {
            if (arr.get(j - 1).compareTo(arr.get(j)) < 0)
            {
                temp = arr.get(j - 1);
                arr.set(j - 1, arr.get(j));
                arr.set(j, temp);
            }
        }
    }
}
}