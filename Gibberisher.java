/***
 * Mitra Kian
 * Gibberisher
 * Version 1
 */

public class Gibberisher{
    private Trie <CharBag> model;
    private int segmentLength;
    private int sampleCount;

    /**
     * constructor for the gibberisher class
     * @param segmentLength to set the segment size
     */

    public Gibberisher(int segmentLength){
        this.segmentLength = segmentLength;
        model = new Trie<CharBag>();
        sampleCount = 0;
    }

    /**
     * will add the sample segmentation to the bag, training the occurrences of each char to the array bag
     * @param sample
     */
    public void train(LetterSample sample){
        String key = sample.getSegment();
        CharBag bag = model.get(key);
        char nextLetter = sample.getNextLetter();
        if(bag == null){
            CharBag newBag = new CharBag();
            model.put(key, newBag);
            model.get(key).add(nextLetter);

        }else{
            bag.add(nextLetter);
        }
        sampleCount ++;

    }

    /**
     * trains the array of sample letters for each text segment length
     * @param text
     */
    public void train(String text){
        LetterSample[] array = LetterSample.toSamples(text, segmentLength);
        int length = array.length;
        for(int i=0; i<length; i++){
            train(array[i]);

        }

    }

    /**
     * train the array of the to the text array
     * @param textArray
     */
    public void train(String[] textArray){
        int length = textArray.length;
        for(int i=0; i<length; i++){
            train(textArray[i]);
        }
    }

    /**
     * getter function for the sample count
     * @return sampleCount
     */
    public int getSampleCount(){
        return sampleCount;
    }

    /**
     * generates a word of random chars based off of the trained bag array
     * @return your gibberish word
     */
    public String generate(){
        String retVal = "";
        String segStr = "";
        char addedChar = model.get(segStr).getRandomChar();


        while(addedChar != '.'){
            retVal += addedChar;
            segStr += addedChar;
            if (segStr.length() > segmentLength) {
                segStr = segStr.substring(1);
            }

            addedChar = model.get(segStr).getRandomChar();
        }

        return retVal;
    }

}
