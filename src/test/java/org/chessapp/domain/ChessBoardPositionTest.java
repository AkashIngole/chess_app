package org.chessapp.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessBoardPositionTest {

    @Test
    void testValidPosition_A1() {
        ChessBoardPosition pos = ChessBoardPosition.getChessBoardPosition("A1");
        assertEquals(0, pos.getRow());
        assertEquals(0, pos.getColumn());
        assertEquals("A1", pos.toString());
        assertTrue(pos.isValid());
    }

    @Test
    void testValidPosition_H8() {
        ChessBoardPosition pos = ChessBoardPosition.getChessBoardPosition("H8");
        assertEquals(7, pos.getRow());
        assertEquals(7, pos.getColumn());
        assertEquals("H8", pos.toString());
        assertTrue(pos.isValid());
    }

    @Test
    void testInvalidColumn() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> ChessBoardPosition.getChessBoardPosition("Z5"));
        assertTrue(ex.getMessage().contains("Invalid input column"));
    }

    @Test
    void testInvalidRow() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> ChessBoardPosition.getChessBoardPosition("A9"));
        assertTrue(ex.getMessage().contains("Invalid input row"));
    }

    @Test
    void testInvalidLength() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> ChessBoardPosition.getChessBoardPosition("A10"));
        assertTrue(ex.getMessage().contains("Invalid position"));
    }

    @Test
    void testNullInput() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> ChessBoardPosition.getChessBoardPosition(null));
        assertTrue(ex.getMessage().contains("Invalid position"));
    }

    @Test
    void testIsValidMethod() {
        ChessBoardPosition pos = new ChessBoardPosition(3, 3);
        assertTrue(pos.isValid());

        ChessBoardPosition invalidPos = new ChessBoardPosition(9, 0);
        assertFalse(invalidPos.isValid());
    }
}
