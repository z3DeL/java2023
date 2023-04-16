package sudoku;

import lombok.Getter;
import lombok.Setter;
/** хранит часть игрового поля (3 на 3) */
@Getter@Setter
public class Block {
    private Cell[] block;

}
