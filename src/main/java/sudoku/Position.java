package sudoku;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class Position {
    private int row;
    private int column;
    private int block;
}
