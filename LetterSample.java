/***
 * Mitra Kian
 * LetterSample
 * Version 1
 */

public class LetterSample {
    private String segment;
    private char nextLetter;
    public static final char STOP = '.';

    /***
     * Constructor for Letter Sample
     * @param segment
     * @param nextLetter
     */

    public LetterSample(String segment, char nextLetter) {
        this.segment = segment;
        this.nextLetter = nextLetter;
    }

    /***
     * getter for the segment variabale
     * @return string segment
     */
    public String getSegment() {
        return segment;
    }

    /**
     * getter for the nextLetter variable
     * @return nextLetter char variable
     */
    public char getNextLetter() {
        return nextLetter;
    }

    /**
     * parses the string into segments and next letter
     * @param input string of text
     * @param segmentSize
     * @return
     */
    public static LetterSample[] toSamples(String input, int segmentSize){

        String cleanString = cleanUp(input);
        int length = cleanString.length();
        LetterSample[] array = new LetterSample[length];
        String segmentedString ="";
        for(int i=0; i<length; i++){
            LetterSample object = new LetterSample(segmentedString,cleanString.charAt(i));
            segmentedString += cleanString.charAt(i);
            if(segmentedString.length()>segmentSize){
                segmentedString = segmentedString.substring(1);
            }
            array[i]=object;
        }
        return array;
    }

    /**
     * cleans up raw text to format as lowercase alphabetical char values
     * @param input text
     * @return lower case string
     */
    public static String cleanUp(String input){
        String cleanString="";
        input = input.toLowerCase();
        int length = input.length();
        for(int i=0; i<length; i++){
            if(Character.isAlphabetic(input.charAt(i))){
                cleanString += input.charAt(i);
            }
        }
        return cleanString+".";
    }

    /**
     * formats objects of Letter Sample to string "segement" -> nextletter
     * @return formatted string
     */
    public String toString(){
        return '"'+segment+'"'+" -> "+nextLetter;
    }

}
