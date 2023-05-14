package sudoku;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/** Сделан для удобства, хранит в себе отдельный столбец поля */
@Getter@Setter@AllArgsConstructor
public class Column {
    private Cell[] column;

}
