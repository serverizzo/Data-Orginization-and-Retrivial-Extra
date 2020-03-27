package EditDistance;/*
* How it works:
* Goal: Dynamically build (bottom-up approach) the distance between two strings.
*
* Method:
* Start with a 2d array of mxn where m is the length of the first string + 1,
* and n is the length of the second string + 1.
*
* Since we are building the array dynamically, we only have to focus on the last character
* (The idea is, we would be building our strings, starting from trivial ones (empty string)
* up until the full length of the actual string, we can skip the string building itself by
* just comparing the last character since we assume that the previous case (mentioned below) will
* be optimal).
*
* Moving down a row would be the same as adding another character from our total string to our partial
* string.
* e.g.
* input = " abcdefg" (note how there is a space in the beginning
* i (our row) = 3;
* So our total string would be " abc" since the first character is the empty string
*
* Normally, adding a character will always result in one more opperation (i.e. dynArr[i-1][j] + 1),
* however, suppose the last character of both strings are the same? We would not have to add 1.
* Include this fact with the array always taking the most optimal path =>
* If we take the min of (dynArr[i-1][j] (adding one char to one of the strings),
*                        dynArr[i][j-1] (adding one char to the other of the strings),
*                        dynArr[i-1][j-1] + (1 or 0) (both added strings have the same value))
*
* we receive the optimal edit distance of two strings.
*
*
*
* Notes:
* * Current implementation does not account for capitals. Which is purposeful.
* * There are many edit  distances, this one is known as Levenshtein distance.
* * For more information :
*      http://www.youtube.com/watch?v=CB425OsE4Fo
*
* */


public class EditDistance {

    int[][] dynArr;


    // For Debugging
    public void printArr(){
        for(int i = 0; i < dynArr.length; i++){
            for(int j = 0; j < dynArr[0].length; j++){
                System.out.print(dynArr[i][j] + " ");
            }
            System.out.println();
        }

    }

    public int myMin(int x,int y,int z){

        int temp = Math.min(x, y);
        return Math.min(temp, z);
    }




    public int calculateDistance(String x, String y){

        // Add empty string to beginning to compare empty strings
        x = " " + x;
        y = " " + y;
        dynArr = new int[x.length()][y.length()];

        // Initialize first row and first column
        for (int i = 0; i < x.length(); i++){
            dynArr[i][0] = i;
        }
        for (int i = 0; i < y.length(); i++){
            dynArr[0][i] = i;
        }

        // Debugging
//        printArr();
//        System.out.println();

        int add;
        // Fill array top to bottom, left to right. Start from the first uninitilized spot (again, 0 row and column compare empty string against final character)
        for (int i = 1; i < x.length(); i++){
            for(int j = 1; j < y.length(); j++){
                // Currently we have (i-1, j), (i, j-1) and (i-1, j-1)
                // If the character we are observing from both strings are equal
                if (x.charAt(i) == y.charAt(j)) {
                    add = 0;
                }
                else
                    add = 1;
                dynArr[i][j] = myMin(dynArr[i-1][j-1]+add, dynArr[i][j-1] + 1, dynArr[i-1][j] + 1);
            }
        }

        // debugging
//        printArr();

        return dynArr[x.length()-1][y.length()-1];
    }




}
