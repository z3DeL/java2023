package sudoku;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
/** Класс отдельной клетки на игровом поле, содержит в себе ее значение( если есть), позицию по горизонтали,
  вертикали и в каком блоке 3 на 3 она находится, также дополнительно записана информация о том поставил ее игрок
  или алгоритм, для удобства добавлен еще массив чисел которые могут в ней быть**/
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class Cell {
    private HashSet<Integer> possibleVal;
    private int value;
    private Position position;
    private boolean defaultValue;
}
