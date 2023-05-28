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
    private int depth;

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
            if (possibleValue.size() == 1 && cell.getDepth() == 0){
                Iterator<Integer> iter = possibleValue.iterator();
                Cell newCell = new Cell(possibleValue,iter.next(),cell.getPosition(),depth,false);
                matrix[cell.getPosition().getRow()][cell.getPosition().getColumn()] = newCell;
            } else if (!cell.isGuess())
        {
                Cell newCell = new Cell(possibleValue,cell.getValue(),cell.getPosition(),cell.getDepth(),false);
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
                int isDefaultValue = 1;
                if (table[i][j] == 0){
                    isDefaultValue = 0;
                }
                matrixnew[i][j] = new Cell(null,table[i][j],new Position(i,j,i/3 * 3+j/3),isDefaultValue,false);
            }
        }
        matrix = matrixnew;
    }
    public void setValueBasedPreValues(){
        for (Cell[] str: matrix){
           for (Cell cell: str){
               if (!cell.isGuess() && cell.getDepth() == 0){
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
                if (newPossibleValRow.size() == 1 && cell.getDepth() == 0){
                    Iterator<Integer> iter = newPossibleValRow.iterator();
                    Cell newcell = new Cell(cell.getPossibleVal(),iter.next(),cell.getPosition(),depth,false);
                    matrix[cell.getPosition().getRow()][cell.getPosition().getColumn()] = newcell;
                } else if (newPossibleValColumn.size() == 1 && cell.getDepth() == 0) {
                    Iterator<Integer> iter = newPossibleValColumn.iterator();
                    Cell newcell = new Cell(cell.getPossibleVal(),iter.next(),cell.getPosition(),depth,false);
                    matrix[cell.getPosition().getRow()][cell.getPosition().getColumn()] = newcell;

                } else if (newPossibleValBlock.size() == 1 && cell.getDepth() == 0) {
                    Iterator<Integer> iter = newPossibleValBlock.iterator();
                    Cell newcell = new Cell(cell.getPossibleVal(),iter.next(),cell.getPosition(),depth,false);
                    matrix[cell.getPosition().getRow()][cell.getPosition().getColumn()] = newcell;
                }
            }
        }}
    }
    public void printMatrix(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j].getValue() + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static Cell[][] copy(Cell[][] src) {
        if (src == null) {
            return null;
        }

        Cell[][] copy = new Cell[src.length][];

        for (int i = 0; i < src.length; i++) {
            copy[i] = new Cell[src[i].length];
            System.arraycopy(src[i], 0, copy[i], 0, src[i].length);
        }

        return copy;
    }
    public boolean matrixCompare(Cell[][] matrix1,Cell[][] matrix2){
        for (int i = 0;i<9;i++){
            for (int j =0;j<9;j++){
                if (matrix1[i][j].getValue() != matrix2[i][j].getValue()){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean haveZeros(){
        for (int i = 0;i<9;i++){
            for (int j =0;j<9;j++){
                if (matrix[i][j].getValue() == 0){
                    return true;
                }
            }
        }
        return false;
    }
    public void deleteDepth(){
        for (int i = 0;i<9;i++){
            for (int j =0;j<9;j++){
                if (matrix[i][j].getDepth() == depth){
                    matrix[i][j] = new Cell(null,0,matrix[i][j].getPosition(),0,false);

                }
            }
        }
    }
    public boolean isCorrect(){
        for (int i = 0;i<9;i++){
            for (int j =0;j<9;j++){
                if (matrix[i][j].getPossibleVal().size()<1 && matrix[i][j].getValue()<1){
                    return false;
                }
            }
        }
        return true;
    }
    public void nextGuess(){
        for (int i = 0;i<9;i++){
            for (int j =0;j<9;j++){
                if (matrix[i][j].isGuess() && matrix[i][j].getDepth() == depth && matrix[i][j].getPossibleVal().size()>0) {
                    Iterator<Integer> iter = matrix[i][j].getPossibleVal().iterator();
                    int maybe = iter.next();
                    HashSet<Integer> newPossible = matrix[i][j].getPossibleVal();
                    newPossible.remove(maybe);
                    Cell newcell = new Cell(newPossible,maybe,matrix[i][j].getPosition(),depth,true);
                    deleteDepth();
                    matrix[i][j] = newcell;
                    return;
                } else if (matrix[i][j].isGuess() && matrix[i][j].getDepth() == depth && matrix[i][j].getPossibleVal().size() ==0) {
                   matrix[i][j] = new Cell(null,0,matrix[i][j].getPosition(),0,false);
                   deleteDepth();
                   setPreValuesForAll();
                   depth -=1;
                   nextGuess();
                   return;
                }
            }
        }
        for (int i = 0;i<9;i++){
            for (int j =0;j<9;j++){
                if (matrix[i][j].getDepth() == 0) {
                    Iterator<Integer> iter = matrix[i][j].getPossibleVal().iterator();
                    int maybe = iter.next();
                    HashSet<Integer> newPossible = matrix[i][j].getPossibleVal();
                    newPossible.remove(maybe);
                    Cell newcell = new Cell(newPossible,maybe,matrix[i][j].getPosition(),depth,true);
                    matrix[i][j] = newcell;
                    return;
                }}
        }
    }
    public void guess(){
        setPreValuesForAll();
        while (haveZeros()) {
            Cell[][] oldMatrix = copy(matrix);
            setPreValuesForAll();
            setValueBasedPreValues();
            setPreValuesForAll();
            while (matrixCompare(matrix, oldMatrix)&& isCorrect()) {
                oldMatrix = copy(matrix);
                setPreValuesForAll();
                setValueBasedPreValues();
                setPreValuesForAll();
            }
            if (isCorrect() && haveZeros()){
                depth +=1;
                nextGuess();
                setPreValuesForAll();
            } else if (haveZeros()) {
                nextGuess();
                setPreValuesForAll();
            }
        }
    }

}
