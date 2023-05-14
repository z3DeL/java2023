package sudoku;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Iterator;
/** основное наше решение */
@Getter@Setter
public class Algoritm {
    private Cell[][] matrix;
    private int valuesSet;
    private int valuesSetBefore;

    public static Cell[] columnGet(int j, Cell[][] matrix){
        Cell[]  row =  new Cell[9];
        for (int i = 0; i < matrix.length; i++){
            row[i] = matrix[i][j];
        }
        return  row;
    }
    public static Cell[] blockGet(int i, Cell[][] matrix){
        int size = matrix.length / 3;
        int rowBlock = i / size;
        int columnBlock = i % size;
        Cell[] block = new Cell[matrix.length];
        int count = 0;
        int endRow = rowBlock*3 +3;
        int endColumn = columnBlock*3 +3;
        for (int row = rowBlock * 3; row <endRow ; row++){
            for (int column = columnBlock * 3; column < endColumn; column++){
                block[count] = matrix[row][column];
                count++;
            }
        }
        return block;
    }
    public static Cell[] rowGet(int i, Cell[][] matrix){
        return matrix[i];
    }
    /** Возвращает множество значений, которых нет в нашей строке ( столбце, блоке) */
    public HashSet<Integer> possibleVal(Cell[] arrCell){
      HashSet<Integer> impossible = new HashSet<Integer>();
      for (Cell cell: arrCell){
          impossible.add(cell.getValue());
      }
      HashSet<Integer> possible = new HashSet<Integer>();
      for (int i = 1; i <10; i++){
          if (!impossible.contains(i)){
              possible.add(i);
          }
      }
      return possible;
    }
    /** для отдельной клетки на поле заполняет ее массив возможных значений */
    public  void setPreValuesForCell(Cell cell){
            HashSet<Integer> possibleValue = new HashSet<Integer>();
            HashSet<Integer> possibleRow = possibleVal(rowGet(cell.getPosition().getRow(),matrix));
            HashSet<Integer> possibleColumn = possibleVal(columnGet(cell.getPosition().getColumn(),matrix));
            HashSet<Integer> possibleBlock = possibleVal(blockGet(cell.getPosition().getBlock(),matrix));
            possibleValue.addAll(possibleRow);
            possibleValue.retainAll(possibleColumn);
            possibleValue.retainAll(possibleBlock);
            if (possibleValue.size() == 1 && !cell.isDefaultValue()){
                Iterator<Integer> iter = possibleValue.iterator();
                Cell newCell = new Cell(possibleValue,iter.next(),cell.getPosition(),true);
                matrix[cell.getPosition().getRow()][cell.getPosition().getColumn()] = newCell;
            }
            else{
                Cell newCell = new Cell(possibleValue,cell.getValue(),cell.getPosition(),cell.isDefaultValue());
                matrix[cell.getPosition().getRow()][cell.getPosition().getColumn()] = newCell;
            }
    }
    /** заполняет возможные значения для всего поля*/
    public void setPreValuesForAll(){
        for (Cell[] row: matrix){
            for (Cell cell: row){
                setPreValuesForCell(cell);
            }
        }
    }
    /** создает из двумерного массива чисел, массив ячеек, служит для удобства ввода */
    public  void createMatrix(int[][] table){
        Cell[][] matrixnew = new Cell[9][9];
        for(int i = 0; i<table.length;i++){
            for (int j = 0; j<table.length;j++){
                boolean isDefaultValue = true;
                if (table[i][j] == 0){
                    isDefaultValue = false;
                }
                matrixnew[i][j] = new Cell(null,table[i][j],new Position(i,j,i/3 * 3+j/3),isDefaultValue);
            }
        }
        matrix = matrixnew;
    }
    public void setValueBasedPreValues(){
        for (Cell[] str: matrix){
            for (Cell cell: str){
                HashSet<Integer> unionRow = new HashSet<Integer>();
                HashSet<Integer> unionColumn = new HashSet<Integer>();
                HashSet<Integer> unionBlock = new HashSet<Integer>();
                Cell[] row = rowGet(cell.getPosition().getRow(),matrix);
                Cell[] column = columnGet(cell.getPosition().getColumn(),matrix);
                Cell[] block  = blockGet(cell.getPosition().getBlock(),matrix);
                for (Cell cel:row){
                    unionRow.addAll(cel.getPossibleVal());
                }
                for (Cell cel:column){
                    unionColumn.addAll(cel.getPossibleVal());
                }
                for (Cell cel: block){
                    unionBlock.addAll(cel.getPossibleVal());
                }
                HashSet<Integer> intesectionRow = cell.getPossibleVal();
                HashSet<Integer> intesectionColumn = cell.getPossibleVal();
                HashSet<Integer> intesectionBlock = cell.getPossibleVal();
                intesectionRow.retainAll(unionRow);
                intesectionColumn.retainAll(unionColumn);
                intesectionBlock.retainAll(unionBlock);
                HashSet<Integer> newPossibleValRow = cell.getPossibleVal();
                HashSet<Integer> newPossibleValColumn = cell.getPossibleVal();
                HashSet<Integer> newPossibleValBlock = cell.getPossibleVal();
                newPossibleValRow.removeAll(intesectionRow);
                newPossibleValColumn.removeAll(intesectionColumn);
                newPossibleValBlock.removeAll(intesectionBlock);
                if (newPossibleValRow.size() == 1 && !cell.isDefaultValue()){
                    Iterator<Integer> iter = newPossibleValRow.iterator();
                    Cell newcell = new Cell(cell.getPossibleVal(),iter.next(),cell.getPosition(),true);
                    matrix[cell.getPosition().getRow()][cell.getPosition().getRow()] = newcell;
                } else if (newPossibleValColumn.size() == 1 && !cell.isDefaultValue()) {
                    Iterator<Integer> iter = newPossibleValColumn.iterator();
                    Cell newcell = new Cell(cell.getPossibleVal(),iter.next(),cell.getPosition(),true);
                    matrix[cell.getPosition().getRow()][cell.getPosition().getRow()] = newcell;

                } else if (newPossibleValBlock.size() == 1 && !cell.isDefaultValue()) {
                    Iterator<Integer> iter = newPossibleValBlock.iterator();
                    Cell newcell = new Cell(cell.getPossibleVal(),iter.next(),cell.getPosition(),true);
                    matrix[cell.getPosition().getRow()][cell.getPosition().getRow()] = newcell;
                }
            }
        }
    }
    public void printMatrix(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j].getValue() + "\t");
            }
            System.out.println();
        }
    }
}
