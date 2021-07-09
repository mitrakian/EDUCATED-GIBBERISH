/**
 * Mitra Kian
 * CharBag
 * 4/27 Revision 1
 */

import java.util.Random;

public class CharBag {
    public int[] charArray;
    int size;

    /**
     * Creates an array used to store char/occurence relations
     */
    public CharBag(){
       charArray = new int[27];
       size = 0;

    }

    /**
     * adds a new char to the array by increasing the increment of the int at the associated char index
     * @param newChar
     */
    public void add(char newChar){
        int charIndex = charToNum(newChar);
        charArray[charIndex] += 1;
        size++;
    }

    /**
     * remmoves one integer from the indec associated to c
     * @param c, which is the item being removed
     */
    public void remove(char c){
        int charIndex = charToNum(c);
        if(charArray[charIndex]>0){
            charArray[charIndex]-= 1;
            size--;
        }
    }

    /**
     * returns the number of occurences if that char in the text file
     * @param character
     * @return count
     */
    public int getCount(char character){
        int index = charToNum(character);
        int count = charArray[index];
        return count;
    }

    /**
     * getter function for number of chars in the text array
     * @return size
     */
    public int getSize(){
        return size;
    }

    /**
     * generates random char or the stop character in lower case
     * @return alphabetic char or the stop character
     */
    public char getRandomChar(){
        if(size <1){
            return '.';
        }else{
            Random rand= new Random();
            int count = rand.nextInt(size);
            for(int i = 0; i< 27; i++){
                count -= charArray[i];
                if( count < 0){
                    return numberToChar(i);

                }
            }
            return '.';
        }
    }

    /**
     * converts an integer value to a char
     * @param index
     * @return
     */
    public char numberToChar(int index) {
        if (index < 26) {
            return (char) (index + 'a');
        }else{
            return '.';
        }
    }

    /**
     * typecasts a char to an integer
     * @param character
     * @return integer
     */
    public int charToNum(char character){
        int integer = 0;
        if(Character.isAlphabetic(character)) {
            char newLetter = Character.toLowerCase(character);
            integer = (int)(newLetter-'a');
        }else{
            integer = 26;
        }
        return integer;
    }

    /**
     * formats return vlaue as {char:count, ....}
     * @return string retval
     */
    public String toString(){
        String retVal = "{";
        for( int i =0; i <26; i++){
            retVal += (numberToChar(i)+":"+charArray[i]+", ");
        }
        retVal += (".:"+charArray[26]+'}');
        return retVal;

    }
}

