package sudoku;

import lombok.AllArgsConstructor;
import lombok.Getter;
/** пока не использующийся класс, должен хранить однозначное значения для клетки в столбце, строке или блоке 3 на 3 */
@Getter
@AllArgsConstructor
public class UniqueValue {
    private int value;
    private int index;
}
