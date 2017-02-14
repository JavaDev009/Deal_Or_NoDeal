/**
 * Created by admin on 26-10-2016.
 */
class Banker {

    private double total = 0;
    private int a = 0;
    private double amount =0;

    public void setOffer(int turn, Briefcase[] cases, double myAmount) {

        for (Briefcase aCase : cases) {
            if (aCase == null) {
            } else {
                total = total + aCase.getAmount();
                a++;
            }
        }
        double average = myAmount + total / a;
        amount = average *turn/ 10;
    }

    public double getOffer(int turn, Briefcase[] cases, double myAmount) {
        setOffer(turn, cases, myAmount);
        return amount;
    }
}