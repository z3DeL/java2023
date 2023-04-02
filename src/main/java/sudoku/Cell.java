package sudoku;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class Cell {
    private List<Integer> possibleVal;
    private int value;
    private Position position;
    private boolean defaultValue;
}
