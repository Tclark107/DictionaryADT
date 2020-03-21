//-----------------------------------------------------------------------------------------
// DictionaryTest.java
// This will be used to test the Dictionary ADT.
//-----------------------------------------------------------------------------------------

public class DictionaryTest {

    public static void main(String args[]){
        Dictionary A = new Dictionary();
        /*D.insert("butt","face"); 
        System.out.println(D);
        System.out.println(D.lookup("butt"));
        D.insert("1","2");
        System.out.println(D);
        D.insert("something","else");
        System.out.println(D);*/

        A.insert("1","a");
        A.insert("2","b");
        A.insert("3","c");
        A.insert("4","d");
        A.insert("5","e");
        A.insert("6","f");
        A.insert("7","g");
        System.out.println(A);

        A.delete("1");
        System.out.println(A);
        A.delete("7");
        System.out.println(A);
        A.delete("4");
        System.out.println(A);
        A.delete("5");
        System.out.println(A);

        A.makeEmpty();
        System.out.println(A);

        System.out.println("did i finish");


        

        //A.insert("2","f");
    }
}