//------------------------------------------------------------------------------------------------------------------------------
// Dictionary.java
// My Dictionary ADT.
// Tristan Clark
//------------------------------------------------------------------------------------------------------------------------------

public class Dictionary implements DictionaryInterface{

    // variables
    int numItems = 0;

    // Node class

    // Pair class

    // Accessors

    public boolean isEmpty() { return (numItems==0); }

    public int size() { return numItems;}

    public String lookup(String key) {
        return key;
    }

    // Manipulators

    public void insert(String key, String value) throws DuplicateKeyException {
        //code
    }

    public void delete(String key) throws KeyNotFoundException {
        //code
    }

    public void makeEmpty(){
        //code
    }

    public String toString() {
        String a = "";
        return a;
    }
    
}