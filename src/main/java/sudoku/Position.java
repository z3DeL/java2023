package sudoku;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/** класс позволяющий для каждой клетки понять где она находится */
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class Position {
    private int row;
    private int column;
    private int block;
}
