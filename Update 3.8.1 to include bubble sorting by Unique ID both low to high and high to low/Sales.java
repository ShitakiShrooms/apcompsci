public class Sales {

    private int id;
    private double dailyGoal;
    private double[] dailySales;

    public Sales(int myId, double myDailyGoal, int myAmountOfSales) {
        id = myId;
        dailyGoal = myDailyGoal;
        dailySales = new double[myAmountOfSales];
    }

    public int getId() {
        return id;
    }
    public void setDailySale(int day, double sale) {
        dailySales[day] = sale;
    }

    public void setDailyGoal(double goal) {
        this.dailyGoal = goal;
    }

    @Override
    public String toString() {
        double totalBonus = 0;
        String text = "ID: " + id + "\t";
        text += "Goal: " + dailyGoal + "\t";
        text += "Days: " + dailySales.length + "\n";

        for (int i = 0; i < dailySales.length; i++) {
            double bonus = calculateBonus(dailySales[i]);
            text += "   \tDay " + (i + 1) + " Sales: " + dailySales[i];
            text += "\tDay " + (i + 1) + " Bonus: " + bonus + "\n";
            totalBonus += bonus;
        }

        text += "\tTotal Bonus: " + totalBonus;

        return text;
    }

    private double calculateBonus(double dailySale) {
        if (dailySale >= (dailyGoal * 0.8) && dailySale < dailyGoal) {
            return 50;
        } else if (dailySale >= dailyGoal) {
            return 75;
        } else {
            return 0;
        }
    }

}