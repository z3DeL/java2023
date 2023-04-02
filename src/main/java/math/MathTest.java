package math;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertAll;


class MathTest {

    @org.junit.jupiter.api.Test
    void fact() {
        assertAll(() -> Assertions.assertEquals(1, Math.fact(0)),
                () -> Assertions.assertEquals(1, Math.fact(1)),
                () -> Assertions.assertEquals(120, Math.fact(5)),
                () -> Assertions.assertEquals(6, Math.fact(3)));
    }

    @org.junit.jupiter.api.Test
    void sign() {
        assertAll(() -> Assertions.assertEquals(0, Math.sign(0)),
                () -> Assertions.assertEquals(-1, Math.sign(-1241)),
                () -> Assertions.assertEquals(1, Math.sign(15145)));
    }
}