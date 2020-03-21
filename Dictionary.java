//------------------------------------------------------------------------------------------------------------------------------
// Dictionary.java
// My Dictionary ADT.
// Tristan Clark
//------------------------------------------------------------------------------------------------------------------------------

public class Dictionary implements DictionaryInterface{

    // Node class
    private class Node{
        Pair pair;
        Node next;

        Node(Pair x) {
            pair = x;
            next = null;
        }
    }

    // Pair class
    private class Pair{
        String key;
        String value;

        Pair(String x, String y) {
            key = x;
            value = y;
        }
    }

    // variables
    private int numItems;
    private Node head;
    private Node tail;

    // Constructor
    public Dictionary(){
        head = null;
        tail = null;
        numItems = 0;

    }

    // private Accessor
    
    // findKey()
    // helper funcion for lookup
    private Node findKey(String key) {
        Node N = head;
        for(;N != null; N = N.next) {
            if(N.pair.key == key) {
                return N;
            }
        }
        return null;
    }

//------------------------------------------------------------------------------------------------
// Accessors
//------------------------------------------------------------------------------------------------

    // isEmpty()
    // pre: none
    // returns true if this Dictionary is empty, false otherwise
    public boolean isEmpty() { return (numItems==0); }

    // size()
    // pre: none
    // returns the number of entries in this Dictionary
    public int size() { return numItems;}

    // lookup()
    // pre: none
    // returns value associated key, or null reference if no such key exists
    public String lookup(String key) {
        Node N = findKey(key);
        if(N != null) {
            return N.pair.value;
        }
        return null;
    }
//------------------------------------------------------------------------------------------------
// Manipulators
//------------------------------------------------------------------------------------------------

    // insert()
    // inserts new (key,value) pair into this Dictionary
    // pre: lookup(key)==null
    public void insert(String key, String value) throws DuplicateKeyException {
        if(lookup(key) == null){
            Pair P = new Pair(key,value);
            Node N = new Node(P);
            if(numItems == 0) {
                head = N;
                tail = N;
            } else {
                tail.next = N;
                tail = tail.next;
            }
            numItems++;
        } else {
            throw new DuplicateKeyException("cannot insert duplicate keys");
        }
    }

    // delete()
    // deletes pair with the given key
    // pre: lookup(key)!=null
    public void delete(String key) throws KeyNotFoundException {
        if(lookup(key) != null) {
            //System.out.println("lookup was not null");
            Node P = head;
            Node N = head.next;
            for(;N != null;N = N.next){
                //System.out.println("in for loop");
                if(P.pair.key == key) {
                    //System.out.println("P/head matched the key");
                    head = P.next;
                    P.next = null;
                    break;
                }
                if(N.pair.key == key) {
                    //System.out.println("N matched the key");
                    if(N == tail) {
                        //System.out.println("N equals teh tail");
                        tail = P;
                        P.next = null;
                        break;
                    }
                    P.next = N.next;
                    N.next = null;
                    break;
                }
                P = P.next;
            }
            numItems--;
        } else {
            throw new KeyNotFoundException("cannot delete non-existent key");
        }
    }

    // makeEmpty()
    // pre: none
    public void makeEmpty(){
        head = null;
        tail = null;
        numItems = 0;
    }

//------------------------------------------------------------------------------------------------
// Other functions
//------------------------------------------------------------------------------------------------

    // toString()
    // returns a String representation of this Dictionary
    // overrides Object's toString() method
    // pre: none
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node N = head;
        for(;N != null;N=N.next){
            sb.append(N.pair.key).append(" ").append(N.pair.value).append("\n");
        }
        return new String(sb);
    }

}