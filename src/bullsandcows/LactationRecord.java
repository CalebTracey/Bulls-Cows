/**********************************************************************
 * REVISION HISTORY (newest first)
 * THIS CLASS IS FINISHED - DO NOT CHANGE
 **********************************************************************
 * 12/2020 - Caleb Tracey - finished class
 *********************************************************************/ 
package bullsandcows;

import java.util.ArrayList;

/**
 * A class to represent an instance of a cow Lactation record.
 * 
 * @author calebtracey
 */

public class LactationRecord {
    
    private final int ageYears;
    private final int ageMonths;
    private final int daysInMilk;
    private final int poundsOfMilk;
    private final double percentButterfat;
    private final double totalButterfat;
    
    /**
     * Constructor for a lactation record
     * 
     * @param ageYears age in years that lactation began
     * @param ageMonths age in months that lactation began
     * @param daysInMilk the total days in milk
     * @param poundsOfMilk the total pounds of milk
     * @param percentButterfat percentage of butterfat
     */

    public LactationRecord(int ageYears, int ageMonths, int daysInMilk, 
            int poundsOfMilk, double percentButterfat) {
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.daysInMilk = daysInMilk;
        this.poundsOfMilk = poundsOfMilk;
        this.percentButterfat = percentButterfat;
        this.totalButterfat = calcTotalButterfat();
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public int getDaysInMilk() {
        return daysInMilk;
    }

    public double getPercentButterfat() {
        return percentButterfat;
    }

    public int getPoundsOfMilk() {
        return poundsOfMilk;
    }

    public double getTotalButterfat() {
        return totalButterfat;
    }
    
    
    /**
     * Helper method to calculate the total amount of butterfat
     * 
     * @return the calculated total amount of butterfat
     */
    private double calcTotalButterfat(){
        return poundsOfMilk * percentButterfat / 100;
    }
    
    /**
     * toString allows an object to be directly printed by returning a String
     * that can be printed to the console or to a file.
     *
     * @return a formatted string representing the values of the attributes for
     * a LactationRecord record object.
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format(" %02d-", ageYears));
        str.append(String.format("%02d", ageMonths));
        str.append(String.format(" %3d", daysInMilk));
        str.append(String.format(" %5d", poundsOfMilk));
        str.append(String.format(" %2.1f", percentButterfat));
        str.append(String.format(" %1.0f", totalButterfat));

        return str.toString();
    }
    
    /*
     * Unit Test for LactationRecord Copy this into LactationRecord and use 
     *    Run File to test it.
     */
     public static void main(String[] args){
        ArrayList<LactationRecord> lacRecs = new ArrayList<>();
        lacRecs.add(new LactationRecord(2, 1, 228, 17232, 5.3));
        lacRecs.add(new LactationRecord(3, 2, 178, 13290, 4.0));
        lacRecs.add(new LactationRecord(12, 5, 260, 19266, 3.2));
        System.out.println("Milk Records");
        for(LactationRecord record: lacRecs){
            System.out.println(record);
        }
    } // end Unit Test
    
}
