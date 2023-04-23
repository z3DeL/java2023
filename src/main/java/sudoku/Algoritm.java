package sudoku;

import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.Set;
/** основное наше решение */
@Getter@Setter
public class Algoritm {
    private Cell[][] matrix;
    private Column[] columns;
    private Row[] rows;
    private Block[] blocks;
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
    public Set<Integer> possibleVal(Cell[] arrCell){
      Set<Integer> impossible = null;
      for (Cell cell: arrCell){
          impossible.add(cell.getValue());
      }
      Set<Integer> possible = null;
      for (int i = 1; i <10; i++){
          if (!impossible.contains(i)){
              possible.add(i);
          }
      }
      return possible;
    }
    /** для отдельной клетки на поле заполняет ее массив возможных значений */
    public  void setPreValuesForCell(Cell cell){
        if (!cell.isDefaultValue()){
            Set<Integer> possibleValue = null;
            Set<Integer> possibleRow = possibleVal(rows[cell.getPosition().getRow()].getRow());
            Set<Integer> possibleColumn = possibleVal(columns[cell.getPosition().getColumn()].getColumn());
            Set<Integer> possibleBlock = possibleVal(blocks[cell.getPosition().getBlock()].getBlock());
            possibleValue.addAll(possibleRow);
            possibleValue.retainAll(possibleColumn);
            possibleValue.retainAll(possibleBlock);
            if (possibleValue.size() == 1){
                Iterator<Integer> iter = possibleValue.iterator();
                Cell newCell = new Cell(possibleValue,iter.next(),cell.getPosition(),true);
                matrix[cell.getPosition().getRow()][cell.getPosition().getColumn()] = newCell;
            }
            else{
                Cell newCell = new Cell(possibleValue,cell.getValue(),cell.getPosition(),cell.isDefaultValue());
                matrix[cell.getPosition().getRow()][cell.getPosition().getColumn()] = newCell;
            }
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
}
