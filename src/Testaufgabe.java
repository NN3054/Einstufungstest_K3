/**
 * @author NN
 */

import java.util.Arrays;

public class Testaufgabe {
    public static void main(String[] args) {
        int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};
        int[][] data1 = {{0, 1, 0, 0, 1, 0}, {}, {2, 2, 2, 2, 0, 1}};
        int[] target1 = {0, 0, 0};
        int[] target2 = {9, 9, 9, 9};

        //region LabelPath
        System.out.println("LabelPath ouput:");
        int[][] resArr1 = labelPath(3, new int[][]{});
        int[][] resArr2 = labelPath(4, data0);
        System.out.println(Arrays.deepToString(resArr1));
        System.out.println("--------");
        System.out.println(Arrays.deepToString(resArr2));
        System.out.println("--------");
        //endregion

        //region FindMatches
        System.out.println("FindMatches output:");
        findMatches(data0, data0[1], target1);
        System.out.println("--------");
        findMatches(data1, data0[1], target1);
        System.out.println("--------");
        findMatches(data1, data0[2], target2);
        System.out.println("--------");
        //endregion

        //region InsertMiddle
        String resString1 = insertMiddle("XY", "abc");
        String resString2 = insertMiddle("01234", "abc");
        String resString3 = insertMiddle("01234567890123", "./-");

        System.out.println("InsertMiddle output:");
        System.out.println(resString1);
        System.out.println("--------");
        System.out.println(resString2);
        System.out.println("--------");
        System.out.println(resString3);
        //endregion
    }

    public static int[][] labelPath(int n, int[][] points) {

        int[][] myArr = new int[n][n];
        int pointsArrSize = points.length;

        for (int[] row : myArr) {
            Arrays.fill(row, n);
        }

        for (int i = 0; i < pointsArrSize; i++) { // could also do:  for (int[] point : points)

            myArr[points[i][0]][points[i][1]] = -1;
        }

        return myArr;
    }

    public static void findMatches(int[][] data, int[] pattern, int[] target) {

        int lengthInput = data.length;

        for (int i = 0; i < lengthInput; i++) {

            int n_fits = 0;

            for (int j = 0; j <= (data[i].length); j++) {

                if (pattern.length > data[i].length - j) {
                    break;
                }

                boolean fits = true;

                for (int k = 0; k < pattern.length; k++) {
                    if (pattern[k] != data[i][j + k]) {
                        fits = false;
                        break;
                    }
                }

                if (fits) {
                    target[i] = 0;
                    n_fits++;
                }
            }

            target[i] = n_fits;
        }

        System.out.println(Arrays.toString(target));
    }


    public static String insertMiddle(String input, String seps) {
        if (input.length() > 1 && seps.length() > 0) {
            String firstHalf = input.substring(0, input.length() / 2);
            String secondHalf = input.substring((int) Math.ceil(input.length() / 2));
            input = insertMiddle(firstHalf, seps.substring(1)) + seps.charAt(0) + insertMiddle(secondHalf, seps.substring(1));
        }
        return input;
    }
}
