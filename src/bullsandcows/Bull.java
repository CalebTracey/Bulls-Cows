/**********************************************************************
 * REVISION HISTORY (newest first)
 * THIS CLASS IS FINISHED - DO NOT CHANGE
 **********************************************************************
 * 12/2020 - Caleb Tracey - finished class
 *********************************************************************/ 
package bullsandcows;

/**
 * A class to represent a Bull in a pedigree
 * 
 * @author calebtracey
 */
public class Bull extends Animal {

    private Proving proving;
    
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
     * @param bcs The Bull's classification score
     * @param proving The Bull's proving record
     */
    public Bull(String regNum, String sireRegNum,
            String damRegNum, char gender, int dobMonth, int dobDay,
            int dobYear, String name, ClassificationScore bcs,
            Proving proving) {
        super(regNum, sireRegNum, damRegNum, gender, dobMonth, dobDay, dobYear,
                name, bcs);
        this.proving = proving;
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
    
    /**
     * Constructs a string representation of the data in the Bull class.
     *
     * @return Formatted String output
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Proof:"));
        if (proving != null) {
            str.append(proving.toString());
        } else {
            str.append(" n/a\n");
        }
        return super.toString() + str.toString();
    }

}
