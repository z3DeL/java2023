package sudoku;

import lombok.Getter;
import lombok.Setter;
/** Сделан для удобства, хранит в себе отдельный столбец поля */
@Getter@Setter
public class Column {
    private Cell[] column;

}
