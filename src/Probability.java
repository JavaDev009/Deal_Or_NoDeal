/**
 * Created by admin on 14-11-2016.
 */
public class Probability {
    private int a = 0;
    private int total = 0;
    private double probability;

    Boolean Aiworks(double offer,Briefcase[] cases,double MyCase)
    {
        for (Briefcase aCase : cases)
        {
            if (aCase == null)
            {   }
            else if(aCase.getAmount() > MyCase)
            {
                a++;
            }
            else
                total++;
        }
        total = total + a;
        probability = (a/total)*100;
        if(probability<50)
            return true;
        else
            return false;

    }
}
