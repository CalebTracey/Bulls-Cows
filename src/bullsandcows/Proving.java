/**********************************************************************
 * REVISION HISTORY (newest first)
 * THIS CLASS IS FINISHED - DO NOT CHANGE
 **********************************************************************
 * 12/2020 - Caleb Tracey - finished class
 *********************************************************************/ 
package bullsandcows;

/**
 * A class to represent an instance of a bull Proving record.
 * 
 * @author calebtracey
 */
public class Proving {
    private final int day;
    private final int month;
    private final int year;
    private final int daughters;
    private final int recordsUsed;
    private final int avgPoundsMilk;
    private final double percentButterfat;
    private final double totalButterfat;
    private final double expectedIncrease;

    /**
     * Constructor for a proving record.
     * 
     * @param day day of birth
     * @param month month of birth
     * @param year  year of birth
     * @param daughters number of daughters
     * @param recordsUsed number of records used
     * @param avgPoundsMilk average pounds of butterfat for all records
     * @param percentButterfat butterfat percentages
     * @param expectedIncrease expected increase in pounds of milk
     */
    public Proving(int day, int month, int year, int daughters, int recordsUsed, 
            int avgPoundsMilk, double percentButterfat, double expectedIncrease) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.daughters = daughters;
        this.recordsUsed = recordsUsed;
        this.avgPoundsMilk = avgPoundsMilk;
        this.percentButterfat = percentButterfat;
        this.expectedIncrease = expectedIncrease;
        this.totalButterfat = calcAvgPoundsMilk();
        
    }
    
    /**
     * Helper method to calculate the average pounds of milk
     * 
     * @return the calculated average pounds of milk
     */
    private double calcAvgPoundsMilk(){
        return avgPoundsMilk * percentButterfat / 100;
    }
    
    /**
     * toString allows an object to be directly printed by returning a String
     * that can be printed to the console or to a file.
     *
     * @return a formatted string representing the values of the attributes for
     * a Proving record object.
     */
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format(" Date = %02d-%02d-%d\n", day, month, year));
        str.append(String.format("Dtrs = %d Records = %d\n", daughters, 
                recordsUsed));
        str.append(String.format("AveMilk = %d AveBF%% = %.1f AveBf = %.0f\n", 
                avgPoundsMilk, percentButterfat, totalButterfat));
        str.append(String.format("ExImp = %1$+.1f\n", expectedIncrease));

        return str.toString();
    }
     /*
     * Unit Test for Proving  Copy this into Proving and use Run File to 
     *   to test it.
     */

    public static void main (String[] args){
        Proving proof1 = new Proving(6, 13, 1920, 93, 180, 15894, 3.4, -476.8);
        Proving proof2 = new Proving(6, 13, 1920, 93, 180, 15894, 3.4, 476.8);
        System.out.println(proof1);
        System.out.println();
        System.out.println(proof2);
    }
}
