import sudoku.Algoritm;

public class Main {
    public static void main(String[] args) {
        Algoritm testTable = new Algoritm();
        int[][] table = new int[9][9];
        table[0] = new int[] {0,0,0,0,0,7,0,0,0};
        table[1] = new int[] {7,0,4,0,1,0,0,0,0};
        table[2] = new int[] {0,0,6,0,0,4,2,0,7};
        table[3] = new int[] {0,0,0,8,0,0,0,0,1};
        table[4] = new int[] {0,0,0,0,0,0,6,7,4};
        table[5] = new int[] {0,0,0,1,0,3,0,0,2};
        table[6] = new int[] {0,3,0,5,9,0,0,0,0};
        table[7] = new int[] {1,0,0,0,0,0,9,0,0};
        table[8] = new int[] {0,2,0,0,0,0,0,6,0};
        testTable.createMatrix(table);
        testTable.printMatrix();
        System.out.println();
        for (int i = 0;i<1  ;i++) {
            testTable.setPreValuesForAll();
        }
            testTable.printMatrix();
        System.out.println();
        System.out.println(testTable.getMatrix()[0][0].getPossibleVal());
        testTable.setPreValuesForCell(testTable.getMatrix()[0][0]);
        System.out.println(testTable.getMatrix()[0][0].getPossibleVal());
        testTable.setValueBasedPreValues();
        testTable.printMatrix();
    }
}