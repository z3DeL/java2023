package sudoku;

import java.util.Iterator;
import java.util.Set;

public class Algoritm {
    private Cell[][] matrix;
    private Column[] columns;
    private Row[] rows;
    private Block[] blocks;
    private int valuesSet;
    private int valuesSetBefore;

    public Cell[] rowGet(int j, Cell[][] matrix){
        Cell[]  row =  new Cell[j];
        for (int i = 0; i < matrix.length; i++){
            row[i] = matrix[i][j];
        }
        return  row;
    }
    public Cell[] blockGet(int i, Cell[][] matrix){
        int size = matrix.length / 3;
        int rowBlock = i / size;
        int columnBlock = i % size;
        Cell[] block = new Cell[matrix.length];
        int count = 0;
        for (int row = rowBlock * 3; row < matrix.length; row++){
            for (int column = columnBlock * 3; column < matrix.length; column++){
                block[count] = matrix[row][column];
                count++;
            }
        }
        return block;
    }
    public Cell[] columnGet(int i,Cell[][] matrix){
        return matrix[i];
    }
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

    public void setPreValuesForAll(){
        for (Cell[] row: matrix){
            for (Cell cell: row){
                setPreValuesForCell(cell);
            }
        }
    }
}
