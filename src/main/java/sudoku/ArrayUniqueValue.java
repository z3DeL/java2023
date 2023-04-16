package sudoku;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
/** класс хранилище всех уникальных значений в строке, столбце или блоке */
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class ArrayUniqueValue {
    private List<UniqueValue> uniqueValues;
    public void add(int val,int ind){
        UniqueValue newValue = new UniqueValue(val,ind);
        uniqueValues.add(newValue);
    }
    public void remove(int val){
        List<UniqueValue> newList = null;
        for (UniqueValue curVal: uniqueValues){
            if (curVal.getValue() != val){
                newList.add(curVal);
            }
        }
        uniqueValues = newList;
    }
    public  void clearArray(){
        uniqueValues.clear();
    }
    public boolean containsVal(int val){
        boolean flag = false;
        for (UniqueValue curVal: uniqueValues){
            if (curVal.getValue() == val){
                flag = true;
            }
        }
        return flag;
    }
}
