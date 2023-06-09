package sudoku;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;

public class PreValuesTest {
    Algoritm testTable = new Algoritm();



    @org.junit.jupiter.api.Test
    public void CreateMatrix(){
        int[][] table = new int[9][9];
        table[0] = new int[] {0,0,0,6,7,2,0,4,0};
        table[1] = new int[] {0,2,7,5,0,9,0,3,6};
        table[2] = new int[] {6,4,0,0,3,1,0,7,0};
        table[3] = new int[] {0,7,0,9,2,0,0,1,0};
        table[4] = new int[] {1,0,5,0,6,3,2,0,0};
        table[5] = new int[] {0,6,2,4,0,0,7,0,0};
        table[6] = new int[] {0,9,0,0,0,0,0,0,0};
        table[7] = new int[] {2,0,8,3,9,0,0,0,0};
        table[8] = new int[] {7,0,0,2,0,0,9,6,1};
        Cell[][] matrix = new Cell[9][9];
        matrix[0][0] = new Cell(null,0,new Position(0,0,0),0,false);
        matrix[0][1] = new Cell(null,0,new Position(0,1,0),0,false);
        matrix[0][2] = new Cell(null,0,new Position(0,2,0),0,false);
        matrix[0][3] = new Cell(null,6,new Position(0,3,1),1,false);
        matrix[0][4] = new Cell(null,7,new Position(0,4,1),1,false);
        matrix[0][5] = new Cell(null,2,new Position(0,5,1),1,false);
        matrix[0][6] = new Cell(null,0,new Position(0,6,2),0,false);
        matrix[0][7] = new Cell(null,4,new Position(0,7,2),1,false);
        matrix[0][8] = new Cell(null,0,new Position(0,8,2),0,false);

        matrix[1][0] = new Cell(null,0,new Position(1,0,0),0,false);
        matrix[1][1] = new Cell(null,2,new Position(1,1,0),1,false);
        matrix[1][2] = new Cell(null,7,new Position(1,2,0),1,false);
        matrix[1][3] = new Cell(null,5,new Position(1,3,1),1,false);
        matrix[1][4] = new Cell(null,0,new Position(1,4,1),0,false);
        matrix[1][5] = new Cell(null,9,new Position(1,5,1),1,false);
        matrix[1][6] = new Cell(null,0,new Position(1,6,2),0,false);
        matrix[1][7] = new Cell(null,3,new Position(1,7,2),1,false);
        matrix[1][8] = new Cell(null,6,new Position(1,8,2),1,false);

        matrix[2][0] = new Cell(null,6,new Position(2,0,0),1,false);
        matrix[2][1] = new Cell(null,4,new Position(2,1,0),1,false);
        matrix[2][2] = new Cell(null,0,new Position(2,2,0),0,false);
        matrix[2][3] = new Cell(null,0,new Position(2,3,1),0,false);
        matrix[2][4] = new Cell(null,3,new Position(2,4,1),1,false);
        matrix[2][5] = new Cell(null,1,new Position(2,5,1),1,false);
        matrix[2][6] = new Cell(null,0,new Position(2,6,2),0,false);
        matrix[2][7] = new Cell(null,7,new Position(2,7,2),1,false);
        matrix[2][8] = new Cell(null,0,new Position(2,8,2),0,false);

        matrix[3][0] = new Cell(null,0,new Position(3,0,3),0,false);
        matrix[3][1] = new Cell(null,7,new Position(3,1,3),1,false);
        matrix[3][2] = new Cell(null,0,new Position(3,2,3),0,false);
        matrix[3][3] = new Cell(null,9,new Position(3,3,4),1,false);
        matrix[3][4] = new Cell(null,2,new Position(3,4,4),1,false);
        matrix[3][5] = new Cell(null,0,new Position(3,5,4),0,false);
        matrix[3][6] = new Cell(null,0,new Position(3,6,5),0,false);
        matrix[3][7] = new Cell(null,1,new Position(3,7,5),1,false);
        matrix[3][8] = new Cell(null,0,new Position(3,8,5),0,false);

        matrix[4][0] = new Cell(null,1,new Position(4,0,3),1,false);
        matrix[4][1] = new Cell(null,0,new Position(4,1,3),0,false);
        matrix[4][2] = new Cell(null,5,new Position(4,2,3),1,false);
        matrix[4][3] = new Cell(null,0,new Position(4,3,4),0,false);
        matrix[4][4] = new Cell(null,6,new Position(4,4,4),1,false);
        matrix[4][5] = new Cell(null,3,new Position(4,5,4),1,false);
        matrix[4][6] = new Cell(null,2,new Position(4,6,5),1,false);
        matrix[4][7] = new Cell(null,0,new Position(4,7,5),0,false);
        matrix[4][8] = new Cell(null,0,new Position(4,8,5),0,false);

        matrix[5][0] = new Cell(null,0,new Position(5,0,3),0,false);
        matrix[5][1] = new Cell(null,6,new Position(5,1,3),1,false);
        matrix[5][2] = new Cell(null,2,new Position(5,2,3),1,false);
        matrix[5][3] = new Cell(null,4,new Position(5,3,4),1,false);
        matrix[5][4] = new Cell(null,0,new Position(5,4,4),0,false);
        matrix[5][5] = new Cell(null,0,new Position(5,5,4),0,false);
        matrix[5][6] = new Cell(null,7,new Position(5,6,5),1,false);
        matrix[5][7] = new Cell(null,0,new Position(5,7,5),0,false);
        matrix[5][8] = new Cell(null,0,new Position(5,8,5),0,false);

        matrix[6][0] = new Cell(null,0,new Position(6,0,6),0,false);
        matrix[6][1] = new Cell(null,9,new Position(6,1,6),1,false);
        matrix[6][2] = new Cell(null,0,new Position(6,2,6),0,false);
        matrix[6][3] = new Cell(null,0,new Position(6,3,7),0,false);
        matrix[6][4] = new Cell(null,0,new Position(6,4,7),0,false);
        matrix[6][5] = new Cell(null,0,new Position(6,5,7),0,false);
        matrix[6][6] = new Cell(null,0,new Position(6,6,8),0,false);
        matrix[6][7] = new Cell(null,0,new Position(6,7,8),0,false);
        matrix[6][8] = new Cell(null,0,new Position(6,8,8),0,false);

        matrix[7][0] = new Cell(null,2,new Position(7,0,6),1,false);
        matrix[7][1] = new Cell(null,0,new Position(7,1,6),0,false);
        matrix[7][2] = new Cell(null,8,new Position(7,2,6),1,false);
        matrix[7][3] = new Cell(null,3,new Position(7,3,7),1,false);
        matrix[7][4] = new Cell(null,9,new Position(7,4,7),1,false);
        matrix[7][5] = new Cell(null,0,new Position(7,5,7),0,false);
        matrix[7][6] = new Cell(null,0,new Position(7,6,8),0,false);
        matrix[7][7] = new Cell(null,0,new Position(7,7,8),0,false);
        matrix[7][8] = new Cell(null,0,new Position(7,8,8),0,false);

        matrix[8][0] = new Cell(null,7,new Position(8,0,6),1,false);
        matrix[8][1] = new Cell(null,0,new Position(8,1,6),0,false);
        matrix[8][2] = new Cell(null,0,new Position(8,2,6),0,false);
        matrix[8][3] = new Cell(null,2,new Position(8,3,7),1,false);
        matrix[8][4] = new Cell(null,0,new Position(8,4,7),0,false);
        matrix[8][5] = new Cell(null,0,new Position(8,5,7),0,false);
        matrix[8][6] = new Cell(null,9,new Position(8,6,8),1,false);
        matrix[8][7] = new Cell(null,6,new Position(8,7,8),1,false);
        matrix[8][8] = new Cell(null,1,new Position(8,8,8),1,false);
        testTable.createMatrix(table);
        Cell[][] createdMatrix = testTable.getMatrix();
        for (int i = 0; i<9; i++){
            for (int j = 0; j<9; j++){
                Assertions.assertEquals(matrix[i][j].getValue(),createdMatrix[i][j].getValue());
                Assertions.assertEquals(matrix[i][j].getDepth(),createdMatrix[i][j].getDepth());
                Assertions.assertEquals(matrix[i][j].getPossibleVal(),createdMatrix[i][j].getPossibleVal());
                Assertions.assertEquals(matrix[i][j].getPosition().getColumn(),createdMatrix[i][j].getPosition().getColumn());
                Assertions.assertEquals(matrix[i][j].getPosition().getRow(),createdMatrix[i][j].getPosition().getRow());
                Assertions.assertEquals(matrix[i][j].getPosition().getBlock(),createdMatrix[i][j].getPosition().getBlock());
            }
        }
    }
    @org.junit.jupiter.api.Test
    public void getRow(){
        int[][] table = new int[9][9];
        table[0] = new int[] {0,0,0,6,7,2,0,4,0};
        table[1] = new int[] {0,2,7,5,0,9,0,3,6};
        table[2] = new int[] {6,4,0,0,3,1,0,7,0};
        table[3] = new int[] {0,7,0,9,2,0,0,1,0};
        table[4] = new int[] {1,0,5,0,6,3,2,0,0};
        table[5] = new int[] {0,6,2,4,0,0,7,0,0};
        table[6] = new int[] {0,9,0,0,0,0,0,0,0};
        table[7] = new int[] {2,0,8,3,9,0,0,0,0};
        table[8] = new int[] {7,0,0,2,0,0,9,6,1};
    testTable.createMatrix(table);
    Cell[] row = new Cell[9];
    row[0] = new Cell(null,0,new Position(0,0,0),0,false);
    row[1] = new Cell(null,0,new Position(0,1,0),0,false);
    row[2] = new Cell(null,0,new Position(0,2,0),0,false);
    row[3] = new Cell(null,6,new Position(0,3,1),1,false);
    row[4] = new Cell(null,7,new Position(0,4,1),1,false);
    row[5] = new Cell(null,2,new Position(0,5,1),1,false);
    row[6] = new Cell(null,0,new Position(0,6,2),0,false);
    row[7] = new Cell(null,4,new Position(0,7,2),1,false);
    row[8] = new Cell(null,0,new Position(0,8,2),0,false);
    Cell[] rowGets = Algoritm.rowGet(0, testTable.getMatrix());
        for (int i = 0; i<9; i++){
            Assertions.assertEquals(row[i].getValue(),rowGets[i].getValue());
            Assertions.assertEquals(row[i].getDepth(),rowGets[i].getDepth());
            Assertions.assertEquals(row[i].getPossibleVal(),rowGets[i].getPossibleVal());
            Assertions.assertEquals(row[i].getPosition().getColumn(),rowGets[i].getPosition().getColumn());
            Assertions.assertEquals(row[i].getPosition().getRow(),rowGets[i].getPosition().getRow());
            Assertions.assertEquals(row[i].getPosition().getBlock(),rowGets[i].getPosition().getBlock());
        }
    }
    @org.junit.jupiter.api.Test
    public void getColumn(){
        int[][] table = new int[9][9];
        table[0] = new int[] {0,0,0,6,7,2,0,4,0};
        table[1] = new int[] {0,2,7,5,0,9,0,3,6};
        table[2] = new int[] {6,4,0,0,3,1,0,7,0};
        table[3] = new int[] {0,7,0,9,2,0,0,1,0};
        table[4] = new int[] {1,0,5,0,6,3,2,0,0};
        table[5] = new int[] {0,6,2,4,0,0,7,0,0};
        table[6] = new int[] {0,9,0,0,0,0,0,0,0};
        table[7] = new int[] {2,0,8,3,9,0,0,0,0};
        table[8] = new int[] {7,0,0,2,0,0,9,6,1};
        testTable.createMatrix(table);

        Cell[] column = new Cell[9];
        column[0] = new Cell(null,0,new Position(0,0,0),0,false);
        column[1] = new Cell(null,0,new Position(1,0,0),0,false);
        column[2] = new Cell(null,6,new Position(2,0,0),1,false);
        column[3] = new Cell(null,0,new Position(3,0,3),0,false);
        column[4] = new Cell(null,1,new Position(4,0,3),1,false);
        column[5] = new Cell(null,0,new Position(5,0,3),0,false);
        column[6] = new Cell(null,0,new Position(6,0,6),0,false);
        column[7] = new Cell(null,2,new Position(7,0,6),1,false);
        column[8] = new Cell(null,7,new Position(8,0,6),1,false);
        Cell[] columnGets = Algoritm.columnGet(0, testTable.getMatrix());
        for (int i = 0; i<9; i++){
            Assertions.assertEquals(column[i].getValue(),columnGets[i].getValue());
            Assertions.assertEquals(column[i].getDepth(),columnGets[i].getDepth());
            Assertions.assertEquals(column[i].getPossibleVal(),columnGets[i].getPossibleVal());
            Assertions.assertEquals(column[i].getPosition().getColumn(),columnGets[i].getPosition().getColumn());
            Assertions.assertEquals(column[i].getPosition().getRow(),columnGets[i].getPosition().getRow());
            Assertions.assertEquals(column[i].getPosition().getBlock(),columnGets[i].getPosition().getBlock());
        }
    }
    @org.junit.jupiter.api.Test
    public void getBlock(){
        int[][] table = new int[9][9];
        table[0] = new int[] {0,0,0,6,7,2,0,4,0};
        table[1] = new int[] {0,2,7,5,0,9,0,3,6};
        table[2] = new int[] {6,4,0,0,3,1,0,7,0};
        table[3] = new int[] {0,7,0,9,2,0,0,1,0};
        table[4] = new int[] {1,0,5,0,6,3,2,0,0};
        table[5] = new int[] {0,6,2,4,0,0,7,0,0};
        table[6] = new int[] {0,9,0,0,0,0,0,0,0};
        table[7] = new int[] {2,0,8,3,9,0,0,0,0};
        table[8] = new int[] {7,0,0,2,0,0,9,6,1};
        testTable.createMatrix(table);

        Cell[] block = new Cell[9];
        block[0] = new Cell(null,0,new Position(6,0,6),0,false);
        block[1] = new Cell(null,9,new Position(6,1,6),1,false);
        block[2] = new Cell(null,0,new Position(6,2,6),0,false);
        block[3] = new Cell(null,2,new Position(7,0,6),1,false);
        block[4] = new Cell(null,0,new Position(7,1,6),0,false);
        block[5] = new Cell(null,8,new Position(7,2,6),1,false);
        block[6] = new Cell(null,7,new Position(8,0,6),1,false);
        block[7] = new Cell(null,0,new Position(8,1,6),0,false);
        block[8] = new Cell(null,0,new Position(8,2,6),0,false);
        Cell[] blockGets = Algoritm.blockGet(6, testTable.getMatrix());
        for (int i = 0; i<9; i++){
            Assertions.assertEquals(block[i].getValue(),blockGets[i].getValue());
            Assertions.assertEquals(block[i].getDepth(),blockGets[i].getDepth());
            Assertions.assertEquals(block[i].getPossibleVal(),blockGets[i].getPossibleVal());
            Assertions.assertEquals(block[i].getPosition().getColumn(),blockGets[i].getPosition().getColumn());
            Assertions.assertEquals(block[i].getPosition().getRow(),blockGets[i].getPosition().getRow());
            Assertions.assertEquals(block[i].getPosition().getBlock(),blockGets[i].getPosition().getBlock());
        }
    }
    @org.junit.jupiter.api.Test
    public void setPreValuesForCellTest(){
        int[][] table = new int[9][9];
        table[0] = new int[] {0,0,0,6,7,2,0,4,0};
        table[1] = new int[] {0,2,7,5,0,9,0,3,6};
        table[2] = new int[] {6,4,0,0,3,1,0,7,0};
        table[3] = new int[] {0,7,0,9,2,0,0,1,0};
        table[4] = new int[] {1,0,5,0,6,3,2,0,0};
        table[5] = new int[] {0,6,2,4,0,0,7,0,0};
        table[6] = new int[] {0,9,0,0,0,0,0,0,0};
        table[7] = new int[] {2,0,8,3,9,0,0,0,0};
        table[8] = new int[] {7,0,0,2,0,0,9,6,1};
        testTable.createMatrix(table);
        testTable.setPreValuesForCell(testTable.getMatrix()[0][0]);
        HashSet<Integer> preValue = new HashSet<Integer>();
        preValue.add(3);
        preValue.add(5);
        preValue.add(8);
        preValue.add(9);
        Cell testCell = new Cell(preValue,0,new Position(0,0,0),0,false);
        Assertions.assertEquals(testTable.getMatrix()[0][0].getValue(),testCell.getValue());
        Assertions.assertEquals(testTable.getMatrix()[0][0].getDepth(),testCell.getDepth());
        Assertions.assertEquals(testTable.getMatrix()[0][0].getPossibleVal(),testCell.getPossibleVal());
        Assertions.assertEquals(testTable.getMatrix()[0][0].getPosition().getColumn(),testCell.getPosition().getColumn());
        Assertions.assertEquals(testTable.getMatrix()[0][0].getPosition().getRow(),testCell.getPosition().getRow());
        Assertions.assertEquals(testTable.getMatrix()[0][0].getPosition().getBlock(),testCell.getPosition().getBlock());
    }


}
