package sudoku;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/** хранит отдельную строку игрового поля */
@Getter@Setter@AllArgsConstructor
public class Row {
    private Cell[] row;

}
