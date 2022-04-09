package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void positionTest() {
        Cell expected = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(expected);
        Cell result = bishopBlack.position();
        assertThat(result, is(expected));
    }

    @Test
    public void copyTest() {
        Cell dest = Cell.B2;
        Figure bishopBlack = new BishopBlack(Cell.C3);
        bishopBlack = bishopBlack.copy(dest);
        Cell result = bishopBlack.position();
        assertThat(result, is(dest));
    }

    @Test
    public void wayTest() {
        Cell start = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(start);
        Cell dest = Cell.G5;
        Cell[] way = bishopBlack.way(dest);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWrongWayTest() {
        Cell start = Cell.C2;
        BishopBlack bishopBlack = new BishopBlack(start);
        Cell dest = Cell.G5;
        bishopBlack.way(dest);
    }

}