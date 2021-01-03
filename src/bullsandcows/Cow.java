/**********************************************************************
 * REVISION HISTORY (newest first)
 * THIS CLASS IS FINISHED - DO NOT CHANGE
 **********************************************************************
 * 12/2020 - Caleb Tracey - finished class
 *********************************************************************/ 
package bullsandcows;

import java.util.ArrayList;

/**
 * A class to represent a Cow in a pedigree
 * 
 * @author calebtracey
 */
public class Cow extends Animal {

    private ArrayList<LactationRecord> lacRecords = new ArrayList<>();
    
    /**
     * Parameterized constructor for the Animal class
     *
     * @param regNum Registration Number
     * @param sireRegNum Sire registration number
     * @param damRegNum Dam registration number
     * @param gender The animal's gender
     * @param dobMonth Birth month
     * @param dobDay Birth day
     * @param dobYear Birth year
     * @param name The animal's name
     * @param ccs The Cow's classification score
     * @param lacRecords The Cow's list of lactation records
     */
    public Cow(String regNum, String sireRegNum,
            String damRegNum, char gender, int dobMonth, int dobDay,
            int dobYear, String name, ClassificationScore ccs,
            ArrayList<LactationRecord> lacRecords) {
        super(regNum, sireRegNum, damRegNum, gender, dobMonth, dobDay, dobYear,
                name, ccs);
        this.lacRecords = lacRecords;
    }
    
    /**
     * Accessor for sireRegNum.
     *
     * @return value for sireRegNum
     */
    @Override
    public String getSireRegNum() {
        return sireRegNum;
    }
    
    /**
     * Accessor for damRegNum.
     *
     * @return value for damRegNum
     */
    @Override
    public String getDamRegNum() {
        return damRegNum;
    }

    public ArrayList<LactationRecord> getLacRecords() {
        return lacRecords;
    }

    
    
    /**
     * Constructs a string representation of the data in the Bull class.
     *
     * @return Formatted String output
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Milk Records:\n");
        if (lacRecords != null) {
            for (int i = 0; i < lacRecords.size(); i++) {
                str.append(lacRecords.get(i).toString());
                str.append("\n");
            }
        } else {
            str.append("No Milk Records\n");
        }
        return super.toString() + str.toString();
    }
}
