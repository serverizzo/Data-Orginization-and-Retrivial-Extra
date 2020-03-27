package kTable;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Vector;

public class KTable {

    KTable(){
        System.out.println("hello from ktable");
//        ascii arithmitic works in java
//        System.out.println('a' + 'a');
    }

    public void constructKTable(int klength){

        Vector<String> KKeys = constructKKeys(klength);
        Hashtable<String, LinkedList<String>> KTable = new Hashtable<String, LinkedList<String>>();

//        Initilize KTable
        for( int i = 0; i < KKeys.size(); i++){
            KTable.put(KKeys.get(i), new LinkedList<String>());
        }

        System.out.println(KTable);

    }


//    TODO: NEEDS TO BE GENERALIZED TO ACTUALLY BE K (I AM THINKING THAT RECURSRION MIGHT BE THE BEST WAY TO CONSTRUCT)
//      work with k-table of 2 for now.
    private Vector<String> constructKKeys(int klength){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder temp = new StringBuilder();
        Vector<String> ans = new Vector<String>();
        for (int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                temp.delete(0, temp.length());
                temp.append(alphabet.charAt(i));
                temp.append(alphabet.charAt(j));
                ans.addElement(temp.toString());
//                System.out.println(temp);
            }
        }
//        test
//        System.out.println(ans);
        return ans;
    }


}
