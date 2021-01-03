/**
 * /**********************************************************************
 * REVISION HISTORY (newest first)
 * THIS CLASS IS FINISHED - DO NOT CHANGE
 **********************************************************************
 * 12/ 2020 - Caleb Tracey - Finished class
 * 04/19/2017 - Anne Applin - added documentation
 * 2015 - David Briggs - original starting code
 *********************************************************************
 * Driver for the project.
 * PLEASE NOTE:  Use Unit testing to test your classes and
 * ignore the errors in this file until you have all classes
 * working.
 */
package bullsandcows;

import java.util.*;
import java.io.*;

/**
 * The driver for the Holstein-Fresian Pedigree application.
 *
 * @author aapplin
 */
public class BullsAndCows {

    // Properties of the class
    private static Database herdBook;

    /**
     * Displays a menu, asks for and reads a menu choice This Method is complete
     * - DO NOT CHANGE
     *
     * @return an integer between 1 and 4 inclusive
     */
    public int getMenuChoice() {
        Scanner stdIn = new Scanner(System.in);
        int choice;
        do {
            System.out.print("*************************\n"
                    + "* 1. Print Pedigree     *\n"
                    + "* 2. Count Offspring    *\n"
                    + "* 3. Evaluate Offspring *\n"
                    + "* 4. Quit.              *\n"
                    + "*************************\n"
                    + "  Enter Choice --> ");
            choice = stdIn.nextInt();
        } while (choice < 1 || choice > 4);

        return choice;
    }

    /**
     * YOU WRITE THIS ONE Reads the input file and creates either a Bull or Cow
     * object and adds it to the Database NOTE: During development, we print out
     * the full message of the exception by using e.toString() and
     * e.printStackTrace(). That is not recommended for production programs,
     * since it gives hackers too much insight into the innards of the software,
     * possibly allowing them to exploit it.Instead, production programs write
     * error messages to internal log files that hackers wouldn't see.
     *
     * @param fileName a String for the file that we want to use.
     */
    public void loadHerd(String fileName) {
        Scanner inputFile = null;
        try {
            // TODO  put the file reading logic here - look back at baseball!
            inputFile = new Scanner(new File(fileName));
            // comment the next line out when you start on part 5!
            System.out.println(herdBook.printHerd());
            //inputFile.close();
        } catch (InputMismatchException e) {
            System.out.println("Probably using nextInt or nextDouble"
                    + " when the file input is not of that type.");
            System.out.println(e);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Probably some problem with the input"
                    + " data file or the keyboard input.");
            System.out.println(e);
            e.printStackTrace();
        }
        if (!inputFile.hasNext()) {
            System.err.println("No data in file " + fileName);
            return; // exits program
        }
        while (inputFile.hasNext()) { // while the file is not empty
            ArrayList<LactationRecord> lacRecords = new ArrayList<>();
            // Read in each value that is universal for Cow and Bull and are 
            // garunteed to be there.
            String regNum = inputFile.next();
            String sireRegNum = inputFile.next();
            String damRegNum = inputFile.next();
            char gender = inputFile.next().toLowerCase().charAt(0);
            int dobMonth = inputFile.nextInt();
            int dobDay = inputFile.nextInt();
            int dobYear = inputFile.nextInt();
            String name = inputFile.next();
            int classScore = inputFile.nextInt(); // either -1 or start of 
                                                  // classification score
            if (gender == 'm' && classScore == -1) {
                BullClassificationScore bcs = null; // if -1 class score is null
                int provingNum = inputFile.nextInt(); // either -1 or start of
                if (provingNum == -1) {               // proving
                    Proving p = null;  // if -1 proving is null too
                    // create a new Bull object since everything is known
                    Animal bull = new Bull(regNum, sireRegNum, damRegNum, gender,
                            dobMonth, dobDay, dobYear, name, bcs, p);
                    herdBook.addToHerd(bull.regNum, bull); // add to herdBook
                } else { // if proving num is not -1
                    int pMonth = provingNum;
                    int pDay = inputFile.nextInt();
                    int pYear = inputFile.nextInt();
                    // create a new Proving object since we have enough data
                    Proving p = new Proving(pMonth, pDay, pYear,
                            inputFile.nextInt(), inputFile.nextInt(),
                            inputFile.nextInt(), inputFile.nextDouble(),
                            inputFile.nextDouble());
                    // create a new Bull object with the new Proving object
                    Animal bull = new Bull(regNum, sireRegNum, damRegNum, gender,
                            dobMonth, dobDay, dobYear, name, bcs, p);
                    herdBook.addToHerd(bull.regNum, bull); // add to herdBook
                } // if we have date for a classification score, create a new
                  // BullClassificationScore object
            } else if (gender == 'm' && classScore != -1) {
                int csMonth = classScore;
                int csDay = inputFile.nextInt();
                int csYear = inputFile.nextInt();
                ClassificationScore bcs = new BullClassificationScore(csMonth,
                        csDay, csYear,
                        inputFile.nextInt(), inputFile.nextInt(),
                        inputFile.nextInt());
                int provingNum = inputFile.nextInt();
                if (provingNum == -1) { // if the next number is -1 then Proving
                    Proving p = null;   // is null
                    Animal bull = new Bull(regNum, sireRegNum, damRegNum, gender,
                            dobMonth, dobDay, dobYear, name, bcs, p);
                    herdBook.addToHerd(bull.regNum, bull);
                } else { // if the next number is NOT -1 then create new Proving
                         // Object
                    int pMonth = provingNum;
                    int pDay = inputFile.nextInt();
                    int pYear = inputFile.nextInt();
                    inputFile.nextLine();
                    Proving p = new Proving(pMonth,
                            pDay, pYear,
                            inputFile.nextInt(), inputFile.nextInt(),
                            inputFile.nextInt(), inputFile.nextDouble(),
                            inputFile.nextDouble());
                    // create a new Bull object with the BCS and Proving objects
                    Animal bull = new Bull(regNum, sireRegNum, damRegNum, gender,
                            dobMonth, dobDay, dobYear, name, bcs, p);
                    herdBook.addToHerd(bull.regNum, bull); // add to herdBook
                }
                // Go through the same process as above except the gender equals
                // female so we are creating a cow object
            } else if (gender == 'f' && classScore == -1) {
                ClassificationScore ccs = null; // -1 so no classScore
                int lactationNum = inputFile.nextInt();
                if (lactationNum == -1) {
                    lacRecords = null; // -1 so no lacRecords
                    Animal cow = new Cow(regNum, sireRegNum, damRegNum, gender,
                            dobMonth, dobDay, dobYear, name, ccs,
                            lacRecords);
                    herdBook.addToHerd(cow.regNum, cow); // add to herdBook
                } else {
                    while (lactationNum != -1) { // while the next int is not -1
                        // create a new LactationRecord object since there is
                        // data present
                        LactationRecord lr = new LactationRecord(lactationNum,
                                inputFile.nextInt(), inputFile.nextInt(),
                                inputFile.nextInt(), inputFile.nextDouble());
                        lacRecords.add(lr); // add lr to the lacRecords array
                        lactationNum = inputFile.nextInt(); // reset 
                                                            // lactationNum
                    }
                    // create a new Cow object and add it to the herdBook
                    Animal cow = new Cow(regNum, sireRegNum, damRegNum, gender,
                            dobMonth, dobDay, dobYear, name, ccs,
                            lacRecords);
                    herdBook.addToHerd(cow.regNum, cow);
                }
            } else if (gender == 'f' && classScore != -1) {
                // create a new CowClassificationScore object since there is
                // data present
                ClassificationScore ccs = new CowClassificationScore(classScore,
                        inputFile.nextInt(), inputFile.nextInt(),
                        inputFile.nextInt(), inputFile.nextInt(),
                        inputFile.nextInt(), inputFile.nextInt());
                int lactationNum = inputFile.nextInt();
                if (lactationNum == -1) { // if the next number is -1 then 
                    lacRecords = null;    // lacRecords is null
                    // create a new Cow object and add it to herdbook
                    Animal cow = new Cow(regNum, sireRegNum, damRegNum, gender,
                            dobMonth, dobDay, dobYear, name, ccs,
                            lacRecords);
                    herdBook.addToHerd(cow.regNum, cow);
                } else {
                    while (lactationNum != -1) { 
                        // create a new LactationRecord object if data is 
                        // present
                        LactationRecord lr = new LactationRecord(lactationNum,
                                inputFile.nextInt(), inputFile.nextInt(),
                                inputFile.nextInt(), inputFile.nextDouble());
                        lacRecords.add(lr); // add lr to the array
                        lactationNum = inputFile.nextInt(); // reset 
                    }                                       // lactationNum
                    // create new Cow object and add it to herd book
                    Animal cow = new Cow(regNum, sireRegNum, damRegNum, gender,
                            dobMonth, dobDay, dobYear, name, ccs,
                            lacRecords);
                    herdBook.addToHerd(cow.regNum, cow);
                }
            }
        }
    }

    /**
     * Once your method in Database is written, comment out the last line in
     * this method and uncomment the one above it
     *
     * Make no other changes.
     */
    public void printPedigree() {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("Enter the registration number for the animal\n"
                + "that you want the pedigree for: ");
        String regNum = stdIn.next();
         System.out.println(herdBook.printPedigree(regNum));
        //System.out.println("not yet implemented.");
    }

    /**
     * Extra Credit 1 Method Once your method in Database is written, comment
     * out the last line in this method and uncomment the one above it
     *
     * Make no other changes.
     */
    public void countOffspring() {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Enter the registration number for the animal\n"
                + "that you want the number of offspring for: ");
        String regNum = stdIn.next();
        System.out.println(herdBook.countOffspring(regNum));
        //System.out.println("Not Implemented.");
    }

    /**
     * An Extra Credit 2 Method Once your method in Database is written, comment
     * out the last line in this method and uncomment the one above it
     *
     * Make no other changes.
     *
     */
    public void evaluateOffspring() {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Enter the registration number for the animal\n"
                + "whose offspring you would like to evaluate: ");
        String regNum = stdIn.next();
        System.out.println(herdBook.evaluateOffspring(regNum));
        //System.out.println("Not implemented.");
    }

    /**
     * The actual driver for the application This method is DONE - DO NOT CHANGE
     * THIS
     *
     * @param fileName comes from the command line arguments
     */
    public void run(String fileName) {
        boolean finished = false;
        // create an instance of the Database
        herdBook = new Database();
        loadHerd(fileName);
        while (!finished) {
            int choice = getMenuChoice();
            switch (choice) {
                case 1:
                    printPedigree();
                    break;
                case 2:
                    countOffspring();
                    break;
                case 3:
                    evaluateOffspring();
                    break;
                case 4:
                    finished = true;
            }
        }//end while  
    } // end run

    /**
     * This method is DONE DO NOT CHANGE THIS
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("usage: prog datafile");
            return;
        }
        // fileName from the command line arguments
        String fileName = args[0];
        BullsAndCows driver = new BullsAndCows();
        driver.run(fileName);
    }
}
