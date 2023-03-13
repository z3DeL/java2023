import static org.junit.jupiter.api.Assertions.assertAll;


import static org.junit.Assert.assertEquals;


class MathTest {

    @org.junit.jupiter.api.Test
    void fact() {
        assertAll(() -> assertEquals(1, Math.fact(0)),
                () -> assertEquals(1, Math.fact(1)),
                () -> assertEquals(120, Math.fact(5)),
                () -> assertEquals(6, Math.fact(3)));
    }

    @org.junit.jupiter.api.Test
    void sign() {
        assertAll(() -> assertEquals(0, Math.sign(0)),
                () -> assertEquals(-1, Math.sign(-1241)),
                () -> assertEquals(1, Math.sign(15145)));
    }
}