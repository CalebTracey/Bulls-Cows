/** ******************************************************
 * Revision History

 ********************************************************
 * 2020 - Caleb Tracey - Finished class
 * 2014 - AA - skeleton written to prevent errors in the
 *             driver.
 ******************************************************* */
package bullsandcows;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * A class to represent a database of cows
 *
 * @author calebtracey
 */
public class Database {

    TreeMap<String, Animal> database = new TreeMap<>();

    /**
     * Constructor for the Database class that initializes the map member to
     * empty.
     *
     */
    public Database() {
        this.database = database;
    }

    /**
     * Helper method to add animals to the database.
     *
     * @param regNum the registration for an animal used as a key value
     * @param a Animal object that is being stored in the database map
     */
    public void addToHerd(String regNum, Animal a) {
        this.database.put(regNum, a);
    }

    /**
     * This method is for debugging part 4. You should iterate through your map
     * to generate the output String Look at BookStoreMap for an example of
     * iterating over a map.
     *
     * @return a string that is the output of the entire herd as long as the
     * herd isn't more than 13 animals.
     */
    public String printHerd() {
        StringBuilder str = new StringBuilder();
        int index = 0;
        for (String regNum : database.keySet()) {
            if (index < 13) { // keeps the output small for testing
                str.append(database.get(regNum));
                str.append("\n");
                index++;
            }
        }
        return str.toString();
    }

    /**
     * Method to create a string that represents 2 generations of an animal's
     * ancestry. If the Animal exists in the database, it is printed. If its dam
     * is present it is printed as are the dam's parents if they exist. If its
     * sire is present it is printed as are the sire's parents if they exist.
     *
     * @param regNum the registration number of the animal to evaluate
     * @return a two generation pedigree of the input animal if it exists or a
     * string that says it does not exist.
     */
    public String printPedigree(String regNum) {
        StringBuilder str = new StringBuilder();
        Animal animal = database.get(regNum); // get Animal with the given key
        Animal dam = database.get(animal.getDamRegNum()); // dam
        Animal sire = database.get(animal.getSireRegNum()); // sire
        if (database.containsKey(regNum)) { // if the regNum is in database
            str.append(String.format("Data for the Animal\n"));
            str.append(animal).append("\n");
            // if database contains Dam
            if (database.containsValue(dam)) {
                str.append(String.format("Data for Dam\n"));
                str.append(dam).append("\n"); // print dam info
                // if database contains Maternal Grandam
                if (database.containsKey(dam.getDamRegNum())) {
                    str.append(String.format("Data for Maternal Grandam\n"));
                    // print Maternal Grandam info
                    str.append(database.get(dam.getDamRegNum())).append("\n");
                } else { // if no Maternal Grandam print n/a
                    str.append(String.format("Data for Maternal Grandam\n"
                            + "n/a\n" + "\n"));
                } // if database contains Maternal Gransire
                if (database.containsKey(dam.getSireRegNum())) {
                    str.append(String.format("Data for Maternal Grandsire\n"));
                    // print Maternal Gransire info
                    str.append(database.get(dam.getSireRegNum())).append("\n");
                } else { // if no Maternal Gransire print n/a
                    str.append(String.format("Data for Maternal Grandsire\n"
                            + "n/a\n" + "\n"));
                }
            } else { // if database doesnt contain dam print n/a for all
                str.append("Data for Dam\n").append("n/a\n" + "\n");
                str.append("Data for Maternal Grandam\n").append("n/a\n"
                        + "\n");
                str.append("Data for Maternal Grandsire\n").append("n/a\n"
                        + "\n");
            } // if database contains Sire
            if (database.containsValue(sire)) {
                str.append("Data for Sire\n");
                str.append(sire).append("\n"); // print sire info
                // if database contains Paternal Grandam
                if (database.containsKey(sire.getDamRegNum())) {
                    str.append("Data for Paternal Grandam\n");
                    // print Paternal Grandam info
                    str.append(database.get(sire.getDamRegNum())).append("\n");
                } else { // if no Paternal Grandam print n/a
                    str.append("Data for Paternal Grandam\n").append("n/a\n"
                            + "\n");
                } // if database contains Paternal Grandsire 
                if (database.containsKey(sire.getSireRegNum())) {
                    str.append("Data for Paternal Grandsire\n");
                    // print Paternal Grandsire info
                    str.append(database.get(sire.getSireRegNum())).append("\n");
                } else { // if no Paternal Grandsire print n/a
                    str.append("Data for Paternal Grandsire\n").append("n/a\n"
                            + "\n");
                }
            } else { // if database doesnt contain sire print n/a for all
                str.append("Data for Sire\n").append("n/a\n" + "\n");
                str.append("Data for Paternal Grandam\n").append("n/a\n"
                        + "\n");
                str.append("Data for Paternal Grandsire\n").append("n/a\n"
                        + "\n");
            }
        } else { // if database doesnt contain Animal then inform user
            str.append("The database contains no information for the given "
                    + "registration number");
        }
        return str.toString();
    }

    /**
     * Returns a count of offspring for sons and daughters of the animal given
     * as an input. If the animal exists in the database, this method searches
     * the database for animals that have sire or dam registration numbers equal
     * to the regNum and adds them to arrays of sons and daughters respectively
     *
     * @param regNum the registration number of the animal to evaluate
     * @return a formatted string that outputs a count of sons and daughters to
     * the user
     */
    public String countOffspring(String regNum) {
        StringBuilder str = new StringBuilder();
        Animal animal = database.get(regNum); // get Animal with the given key
        ArrayList<Animal> daughters = new ArrayList<>();
        ArrayList<Animal> sons = new ArrayList<>();
        if (database.containsKey(regNum)) { // if animal is in database
            if (animal.gender == 'm') { // if gender is male
                for (String nums : database.keySet()) { // search database
                    // if the sireRegNum is the same as regNum
                    if (database.get(nums).sireRegNum.equals(animal.regNum)) {
                        if (database.get(nums).gender == 'm') { //if male
                            sons.add(database.get(nums)); // add to son array
                        } else { // otherwise add to daughter array
                            daughters.add(database.get(nums));
                        }
                    }
                }
            }
            if (animal.gender == 'f') { // if gender of animal is female
                for (String nums : database.keySet()) { // search database
                    // if the damRegNum is the same as regNum
                    if (database.get(nums).damRegNum.equals(animal.regNum)) {
                        if (database.get(nums).gender == 'm') { // if male
                            sons.add(database.get(nums)); // add to son array
                        } else { //otherwise add to daughter array
                            daughters.add(database.get(nums));
                        }
                    }
                }
            }
            // format output for user
            str.append("Sons: ").append(sons.size()).append("\n");
            str.append("Daughters: ").append(daughters.size());
        } else {
            // format output for user if animal is null
            str.append("Sons: 0\n");
            str.append("Daughters: 0\n");
        }
        return str.toString();
    }

    /**
     * Returns totaled and averaged information along with the count of
     * daughters and count of daughters with either classification scores or
     * lactation records depending on the gender of the input animal. If the
     * animal is in the database, it searches for daughters who have a sire or
     * dam registration number that equals the regNum and adds them to an array.
     * it then gathers the desired information and totals then averages it.
     *
     * @param regNum the registration number of the animal to evaluate
     * @return a formatted string that displays the counts and averaged
     * information for the user
     */
    public String evaluateOffspring(String regNum) {
        StringBuilder str = new StringBuilder();
        Animal animal = database.get(regNum);
        ArrayList<Cow> daughters = new ArrayList<>();
        ArrayList<LactationRecord> lacRecords = new ArrayList<>();
        ArrayList<CowClassificationScore> classScores = new ArrayList<>();
        if (database.containsKey(regNum)) { // if animal is in database
            if (animal.gender == 'm') { // if gender is male
                for (String nums : database.keySet()) { // search database
                    // if sireRegNum is equal to regNum
                    if (database.get(nums).sireRegNum.equals(animal.regNum)) {
                        if (database.get(nums).gender == 'f') {
                            // if female add to daughters array
                            daughters.add((Cow) database.get(nums));
                        }
                    }
                } // if no daughters then inform user
                if (daughters.isEmpty()) {
                    str.append(String.format("The Sire \"%s\" has no daughters "
                            + "in the database\n", animal.name));
                } else { // get all lactation records for all daughters and add 
                    // to lacRecords array
                    for (Cow c : daughters) {
                        if (c.getLacRecords() != null) {
                            lacRecords.addAll(c.getLacRecords());
                        }
                    } // if there are daughters but no lac records inform user
                    if (lacRecords.isEmpty()) {
                        str.append(String.format("Evaluation of daughters for "
                                + "the Sire \"%s\":\n", animal.name));
                        str.append(String.format("Total daughters: "
                                + "%d\n", daughters.size()));
                        str.append(String.format("None of the %d daughters "
                                + "recorded any lactations", daughters.size()));
                    } else {
                        // if there are daughters with lac records
                        int daysInMilk = 0;
                        int poundsOfMilk = 0;
                        int totalButterfat = 0;
                        // sum the desired info for each lac record 
                        for (LactationRecord lr : lacRecords) {
                            daysInMilk += lr.getDaysInMilk();
                            poundsOfMilk += lr.getPoundsOfMilk();
                            totalButterfat += lr.getTotalButterfat();
                        } // average the totaled info according based on the 
                        // number of lac records
                        int avgDaysInMilk = daysInMilk / lacRecords.size();
                        int avgPoundsOfMilk = poundsOfMilk
                                / lacRecords.size();
                        int avgPoundsButterfat = totalButterfat
                                / lacRecords.size();
                        // calculate the avg percent butterfat
                        double avgPercentButterfat
                                = (((double) avgPoundsButterfat)
                                / ((double) avgPoundsOfMilk)) * 100.0;
                        // format the info into an organized string for the user
                        str.append(String.format("Evaluation of daughters for "
                                + "the Sire \"%s\":\n", animal.name));
                        str.append(String.format("Total daughters: "
                                + "%d\n", daughters.size()));
                        str.append(String.format("Total lactations: "
                                + "%d\n", lacRecords.size()));
                        str.append(String.format("Average days in milk: "
                                + "%d\n", avgDaysInMilk));
                        str.append(String.format("Average pounds of milk: "
                                + "%d\n", avgPoundsOfMilk));
                        str.append(String.format("Average pounds of butterfat: "
                                + "%d\n", avgPoundsButterfat));
                        str.append(String.format("Average percent butterfat: "
                                + "%.2f\n", avgPercentButterfat));
                    }
                }
            }
            if (animal.gender == 'f') { // if gender is female
                for (String nums : database.keySet()) { // search database
                    // if damRegNum is equal to regNum
                    if (database.get(nums).damRegNum.equals(animal.regNum)) {
                        if (database.get(nums).gender == 'f') {
                            // if female add to daughters array
                            daughters.add((Cow) database.get(nums));
                        }
                    }
                }
                if (daughters.isEmpty()) {
                    str.append(String.format("The Dam \"%s\" has no "
                            + "daughters in the database\n", animal.name));
                } else {
                    // iterate through daughters array and for those who are
                    // classified, add to classScores array
                    for (int i = 0; i < daughters.size(); i++) {
                        if (daughters.get(i).classificationScore != null) {
                            classScores.add((CowClassificationScore) daughters.
                                    get(i).classificationScore);
                        } // if there are daughters but none have class scores
                    }     // then inform the user
                    if (classScores.isEmpty()) {
                        str.append(String.format("Evaluation of daughters for "
                                + "the Dam \"%s\":\n", animal.name));
                        str.append(String.format("Total daughters: "
                                + "%d\n", daughters.size()));
                        str.append(String.format("None of the %d daughters "
                                + "recorded any classification scores",
                                daughters.size()));
                    } else { // if there are daughters with class scores
                        double gnrlAppearance = 0;
                        double dryCharacter = 0;
                        double bdyCapacity = 0;
                        double mmrySystem = 0;
                        // sum the desired info for each class score
                        for (CowClassificationScore cs : classScores) {
                            gnrlAppearance += cs.getGeneralAppearance();
                            dryCharacter += cs.getDairyCharacter();
                            bdyCapacity += cs.getBodyCapacity();
                            mmrySystem += cs.getMammarySystem();
                        } // average the info based on amount of class scores
                        double avgGnrlAppearance = gnrlAppearance
                                / classScores.size();
                        double avgDryCharacter = dryCharacter
                                / classScores.size();
                        double avgBdyCapacity = bdyCapacity
                                / classScores.size();
                        double avgmmrySystem = mmrySystem / classScores.size();
                        // total the average of the four scores together
                        double avgTotal = avgGnrlAppearance + avgDryCharacter
                                + avgBdyCapacity + avgmmrySystem;
                        // format the info into an organized string for the user
                        str.append(String.format("Evaluation of daughters for "
                                + "the Dam \"%s\":\n", animal.name));
                        str.append(String.format("Total daughters: %d\n",
                                daughters.size()));
                        str.append(String.format("Total classified "
                                + "daughters: %d\n", classScores.size()));
                        str.append(String.format("Average General "
                                + "Appearance ranking: %.2f\n",
                                avgGnrlAppearance));
                        str.append(String.format("Average Dairy Character "
                                + "ranking: %.2f\n", avgDryCharacter));
                        str.append(String.format("Average Body Capacity "
                                + "ranking: %.2f\n", avgBdyCapacity));
                        str.append(String.format("Average Mammary System "
                                + "ranking: %.2f\n", avgmmrySystem));
                        str.append(String.format("Total of all averages: "
                                + "%.2f\n", avgTotal));
                    }
                }
            }
        } else { // if the regNum is not in the database
            str.append("The database contains no daughters for that "
                    + "registration number");
        }
        return str.toString();
    }
}
