/***
 * Mitra Kian
 * TrieNode
 * Version 1
 */

public class TrieNode<T> {
    private T data;
    private TrieNode<T> [] nextLinks;

    /**
     * Constructor for object of TrieNode
     */
    public TrieNode(){
        nextLinks = new TrieNode[26];
    }

    /**
     * getter function for the data variable
     * @return data
     */
    public T getData(){
        return data;
    }

    /**
     * setter for the data variable
     * @param data
     */
    public void setData(T data){
        this.data = data;
    }

    /**
     * getter of the childNode of a letter
     * @param letter
     * @return childNode
     */
    public TrieNode<T> getChild(char letter){
        if(!isLowerCase(letter)){
            return null;
        }else{
            int index = charToNum(letter);
            if(nextLinks[index] == null) {
                nextLinks[index] = new TrieNode<T>();
            }
            return nextLinks[index];
        }
    }

    /**
     * gets the size recursively of the tree, will find the 'depth'
     * @return size
     */
    public int getTreeSize() {
        int size = 1;
        for (int i = 0; i < 26; i++) {
            if (nextLinks[i] != null) {
                size += nextLinks[i].getTreeSize();
            }
        }
        return size;
    }

    /**
     * converts alphabetic character to lowercase
     * @param letter
     * @return lower case letter
     */
    public boolean isLowerCase(char letter){
        char newLetter = Character.toLowerCase(letter);
        return newLetter == letter && Character.isAlphabetic(letter);
    }

    /**
     * returns a char integer value
     * @param character
     * @return integer
     */
    public int charToNum(char character){
        int integer = 0;
        char newLetter = Character.toLowerCase(character);
        integer = (int)(newLetter-'a');
        return integer;
    }
}
