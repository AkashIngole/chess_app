package org.chessapp.domain.pieces;

import org.chessapp.common.Constants;
import org.chessapp.domain.ChessBoardPosition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    private final Queen queen = new Queen();

    @Test
    void testGetName() {
        assertEquals(Constants.QUEEN, queen.getName());
    }

    @Test
    void testPossibleMovesFromCenter() {
        ChessBoardPosition current = ChessBoardPosition.getChessBoardPosition("D4");
        List<ChessBoardPosition> moves = queen.possibleMoves(current);

        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("D8"))); // up
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("D1"))); // down
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("A4"))); // left
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("H4"))); // right
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("A1"))); // diagonal down-left
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("G7"))); // diagonal up-right
    }

    @Test
    void testPossibleMovesFromCorner() {
        ChessBoardPosition current = ChessBoardPosition.getChessBoardPosition("A1");
        List<ChessBoardPosition> moves = queen.possibleMoves(current);

        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("A8"))); // up
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("H1"))); // right
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("H8"))); // diagonal up-right

        assertThrows(IllegalArgumentException.class, () -> moves.contains(ChessBoardPosition.getChessBoardPosition("A0")));
    }

    @Test()
    void testPossibleMovesFromEdge() {
        ChessBoardPosition current = ChessBoardPosition.getChessBoardPosition("H5");
        List<ChessBoardPosition> moves = queen.possibleMoves(current);

        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("H8"))); // up
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("H1"))); // down
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("A5"))); // left
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("E2"))); // diagonal down-left
        assertThrows(IllegalArgumentException.class, () -> moves.contains(ChessBoardPosition.getChessBoardPosition("I5")));
    }
}
