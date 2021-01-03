/**********************************************************************
 * REVISION HISTORY (newest first)
 * THIS CLASS IS FINISHED - DO NOT CHANGE
 **********************************************************************
 * 12/2020 - Caleb Tracey - finished class
 *********************************************************************/ 
package bullsandcows;

import java.util.ArrayList;

/**
 * A class to represent generalized information for Bulls and Cows.
 *
 * @author calebtracey
 */
public abstract class Animal {

    protected String regNum;
    protected String sireRegNum;
    protected String damRegNum;
    protected char gender;
    protected int dobMonth;
    protected int dobDay;
    protected int dobYear;
    protected String name;
    protected ClassificationScore classificationScore;

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
     * @param classificationScore The animal's classification score
     */
    public Animal(String regNum, String sireRegNum, String damRegNum,
            char gender, int dobMonth, int dobDay, int dobYear, String name,
            ClassificationScore classificationScore) {
        this.regNum = regNum;
        this.sireRegNum = sireRegNum;
        this.damRegNum = damRegNum;
        this.gender = gender;
        this.dobMonth = dobMonth;
        this.dobDay = dobDay;
        this.dobYear = dobYear;
        this.name = name;
        this.classificationScore = classificationScore;
    }

    /**
     * Abstract accessor for sireRegNum.
     *
     * @return value for sireRegNum
     */
    public abstract String getSireRegNum();

    /**
     * Abstract accessor for damRegNum.
     *
     * @return value for damRegNum
     */
    public abstract String getDamRegNum();

    /**
     * Constructs a string representation of the data in the Animal class.
     *
     * @return Formatted String output
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Registration Number: %s\n", regNum));
        str.append(String.format("Name: %s\n", name));
        str.append(String.format("Date of Birth: %02d-%02d-%d\n", dobMonth,
                dobDay, dobYear));
        str.append("Classification: ");
        if (classificationScore != null) {
            str.append(classificationScore.toString());
            str.append("\n");
        } else {
            str.append("n/a\n");
        }
        return str.toString();
    }

    /**
     * Unit Tester for Animal, Cow and Bull.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ClassificationScore perfectCow = new CowClassificationScore(1, 2, 2010,
                30, 20, 20, 30),
                nullCow = null,
                perfectBull = new BullClassificationScore(5, 6, 2012, 40, 30,
                        30),
                nullBull = null;

        Proving noProving = null,
                proving = new Proving(6, 4, 2016, 20, 200,
                        1500, 3.25, 324);
        ArrayList<LactationRecord> empty = null;
        ArrayList<LactationRecord> lacRecs = new ArrayList<>();
        lacRecs.add(new LactationRecord(2, 10, 228, 17232, 5.3));
        lacRecs.add(new LactationRecord(3, 2, 178, 13290, 4.0));
        lacRecs.add(new LactationRecord(4, 3, 260, 19266, 3.2));
        Animal bull1 = new Bull("0001", "0002", "0003", 'm', 4, 8, 2000,
                "aBull", perfectBull, noProving);
        Animal bull2 = new Bull("0001", "0002", "0003", 'm', 4, 8, 2000,
                "anotherBull", nullBull, proving);
        Animal cow1 = new Cow("0001", "0002", "0003", 'f', 4, 8, 2000,
                "aCow", perfectCow, empty);
        Animal cow2 = new Cow("0001", "0002", "0003", 'f', 4, 8, 2000,
                "anotherCow", nullCow, lacRecs);
        System.out.println(bull1);
        System.out.println();
        System.out.println(bull2);
        System.out.println();
        System.out.println(cow1);
        System.out.println();
        System.out.println(cow2);
    }

}
