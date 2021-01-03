/**********************************************************************
 * REVISION HISTORY (newest first)
 * THIS CLASS IS FINISHED - DO NOT CHANGE
 **********************************************************************
 * 12/2020 - Caleb Tracey - finished class
 * 04/19/2017 - Anne Applin - added documentation
 * 2015 - David Briggs - original starting code
 *********************************************************************/ 
package bullsandcows;

/**
 * Represents the classification score for a cow. The correct ranges are
 * <ul>
 * <li>general appearance 0-30 </li>
 * <li>dairy character 0-20 </li>
 * <li>body capacity 0-20 </li>
 * <li>mammary system 0-30</li>
 * </ul>
 * but we are not testing for input validity.
 *
 * @author David Briggs 
 * 
 */
public class CowClassificationScore extends ClassificationScore {
    /**
     * General appearance is a score between 0 and 30.
     */
    private int generalAppearance;
    /**
     * Dairy character is a score between 0 and 20.
     */
    private int dairyCharacter;
    /**
     * Body capacity is a score between 0 and 20.
     */
    private int bodyCapacity;
    /**
     * Mammary system is a score between 0 and 30.
     */
    private int mammarySystem;

    /**
     * default constructor all members are initialized to 0 already.
     */
    public CowClassificationScore() {
    }

    /**
     * Parameterized Constructor for CowClassificationScore
     *
     * @param month int representing the month the score was determined
     * @param day int representing the day the score was determined
     * @param year int representing the year the score was determined
     * @param gnrlAppearance int ranking for general appearance of the cow
     * @param dryCharacter int ranking for dairy characteristics of the cow
     * @param bdyCapacity int ranking for body capacity of the cow
     * @param mmrySystem int ranking for the mammary system of the cow
     */
    public CowClassificationScore(int month, int day, int year, 
            int gnrlAppearance, int dryCharacter, int bdyCapacity, 
            int mmrySystem) {
        super(month, day, year);
        this.generalAppearance = gnrlAppearance;
        this.dairyCharacter = dryCharacter;
        this.bodyCapacity = bdyCapacity;        
        this.mammarySystem = mmrySystem;
    }
    /**
     * Accessor for the property generalAppearance.
     * @return the integer value of the property
     */
    public int getGeneralAppearance() {
        return generalAppearance;
    }
    
    /**
     * Accessor for the property dairyCharacter
     * @return the integer value of the property 
     */
    public int getDairyCharacter() {
        return dairyCharacter;
    }
    
    /**
     * Accessor for the property bodyCapacity.
     * @return the integer value of the property
     */
    public int getBodyCapacity() {
        return bodyCapacity;
    }
    
    /**
     * Accessor for the property mammarySystem
     * @return the integer value of the property
     */
    public int getMammarySystem() {
        return mammarySystem;
    }
    
    /**
     * Constructs a  string representation of the date and score.
     * All values are labeled.
     * required format:<br>
     * <em>Date = 6-1-2001</em>    - from super class<br>
     * <em>GA = 28 DC = 17 BC = 18 MS = 27 Total = 90</em> -- from this class
     */
    public String toString() {
        StringBuffer temp = new StringBuffer();
        // get the first part of the string from the super class
        temp.append(super.toString());
        temp.append(' ');
        temp.append("GA = ").append(generalAppearance);
        temp.append(" DC = ").append(dairyCharacter);
        temp.append(" BC = ").append(bodyCapacity);
        temp.append(" MS = ").append(mammarySystem);
        temp.append(" Total = ").append(generalAppearance + dairyCharacter
                + bodyCapacity + mammarySystem);

        return temp.toString();
    }

    /**
     * Unit test for CowClassificationScore.
     * Tests constructor and toString .
     * @param args command line arguments
     */
    public static void main(String[] args){
      
        ClassificationScore
            perfectCow =   new CowClassificationScore(1, 2, 2010, 30,20,20,30),
            aveCow  =      new CowClassificationScore(3, 4, 2011, 10,11,12,13);
      
        System.out.println("Pefect Cow\n" + perfectCow);
        System.out.println("Average Cow\n" + aveCow);
    }
}
