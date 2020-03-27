package kTable;

import java.io.File;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;
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

//        Test
//        System.out.println(KTable);

        String temp;

//        reading in file
        try{
            File dic = new File("src/kTable/d2.txt");
            Scanner s = new Scanner(dic);
            while (s.hasNextLine()){
                temp = s.next();
                for(int i = 0; i < KKeys.size(); i++){
                    if(temp.contains(KKeys.get(i))){
                        KTable.get(KKeys.get(i)).add(temp);
                    }
                }
            }
            s.close();
        }
        catch (Exception e){
            System.out.println("Error in ConstructKTable: ");
            System.out.println("            " + e);
        }


        // Test
        for (int i = 0; i < KKeys.size(); i++){
            System.out.println(KKeys.get(i) + "   " + KTable.get(KKeys.get(i)));
        }


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
