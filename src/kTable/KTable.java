package kTable;

public class KTable {

    KTable(){
        System.out.println("hello from ktable");
//        ascii arithmitic works in java
//        System.out.println('a' + 'a');
    }



//    TODO: NEEDS TO BE GENERALIZED TO ACTUALLY BE K (I AM THINKING THAT RECURSRION MIGHT BE THE BEST WAY TO CONSTRUCT)
    void constructKKeys(int klength){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//      work with k-table of 2 for now.
        StringBuilder temp = new StringBuilder();
        String[] ans;
        for (int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                temp.delete(0, temp.length());
                temp.append(alphabet.charAt(i));
                temp.append(alphabet.charAt(j));

//                test
//                System.out.println(temp);
            }
        }

    }


}
