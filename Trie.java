/***
 * Mitra Kian
 * Trie
 * Version 1
 */

public class Trie<T>{
    private TrieNode<T> root;

    /**
     * constructs the root as a new TrieNode object
     */
    public Trie(){
        root = new TrieNode();
    }

    /**
     * returns the node association of a segment
     * @param text ie the segment
     * @return currentNode
     */
    private TrieNode getNode(String text){
        int length = text.length();
        TrieNode currentNode = root;

        for(int i = 0; i < length; i++){
           currentNode = currentNode.getChild(text.charAt(i));
        }
        return currentNode;
    }

    /**
     * returns the data stored in a node
     * @param text
     * @return data
     */
    public T get(String text){
        TrieNode<T> node = getNode(text);
        return node.getData();
    }

    /**
     * sets the data of the node
     * @param text
     * @param obj of variable type T
     */
    public void put(String text, T obj){
        TrieNode<T> node = getNode(text);
        node.setData(obj);
    }

    /**
     * getter function for the root nose
     * @return root
     */
    public TrieNode<T> getRoot(){
        return root;
    }

}
