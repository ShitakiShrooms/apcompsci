public class Sales
{
    private int salesPersonID;


    public Sales(int id)
    {
        salesPersonID = id;

    }

    public int getID()
    {
        return salesPersonID;
    }


    public String toString ()
    {
        return "Sales Person ID = " + salesPersonID ;
    }
}