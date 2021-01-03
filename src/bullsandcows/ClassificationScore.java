/**********************************************************************
 * REVISION HISTORY (newest first)
 * THIS CLASS IS FINISHED - DO NOT CHANGE
 **********************************************************************
 * 04/19/2017 - Anne Applin - added documentation
 * 2015 - David Briggs - original starting code
 *********************************************************************/ 
 
package bullsandcows;

/**
 *  The superclass to hold classification scores for
 *  both genders of Holsteins.
 *  
 *  It has integer fields for the year, month and day of the
 *  score.  The representation scheme is<br> 
 *  <br>
 *  year  : some positive value >= 1700<br>
 *  month : 1-12 for January to December<br>
 *  day   : 1-31 for the day of the month<br>
 *  <br>
 *  such that the three together represent a valid date.
 *  We are not testing for input validity, however.
 *  
 * @author David Briggs
 * 
 */

public abstract class ClassificationScore {
    /**
     * The month that this classification was done.
     */
    protected int scoreMonth;
    /**
     * The day of the month that this classification was done.
     */
    protected int scoreDay;
    /**
     * The year that this classification was done.
     */
    protected int scoreYear;
    /**
     *default constructor.
     */
    protected ClassificationScore(){}
    /**
     * Parameterized constructor.
     * @param month int representing the month the score was determined
     * @param day int representing the day the score was determined 
     * @param year int representing the year the score was determined
    */
    protected ClassificationScore(int month, int day, int year){
       scoreMonth = month;
       scoreDay   = day;
       scoreYear  = year;
    }
    
    /**
     * A string representation of the date the classification was done
     * @return constructed and labeled string in the mm/dd/yyyy format
     */
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Date = ");
        if (scoreMonth < 10){
            str.append("0");
        }
        str.append(scoreMonth);
        str.append("-");
        if (scoreDay < 10) {
            str.append("0");
        }
        str.append(scoreDay);
        str.append("-");
        str.append(scoreYear);
        return str.toString();
    }
}

