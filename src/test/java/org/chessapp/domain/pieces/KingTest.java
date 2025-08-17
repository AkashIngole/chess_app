package org.chessapp.domain.pieces;

import org.chessapp.common.Constants;
import org.chessapp.domain.ChessBoardPosition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    private final King king = new King();

    @Test
    void testGetName() {
        assertEquals(Constants.KING, king.getName());
    }

    @Test
    void testPossibleMovesFromCenter() {
        ChessBoardPosition current = ChessBoardPosition.getChessBoardPosition("D4");
        List<ChessBoardPosition> moves = king.possibleMoves(current);

        // King can move to 8 adjacent squares
        assertEquals(8, moves.size());
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("C3")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("C4")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("C5")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("D3")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("D5")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("E3")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("E4")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("E5")));
    }

    @Test
    void testPossibleMovesFromCorner_A1() {
        ChessBoardPosition current = ChessBoardPosition.getChessBoardPosition("A1");
        List<ChessBoardPosition> moves = king.possibleMoves(current);

        // Only 3 valid moves from corner
        assertEquals(3, moves.size());
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("A2")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("B1")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("B2")));
    }

    @Test
    void testPossibleMovesFromEdge_A4() {
        ChessBoardPosition current = ChessBoardPosition.getChessBoardPosition("A4");
        List<ChessBoardPosition> moves = king.possibleMoves(current);

        // King on edge has 5 possible moves
        assertEquals(5, moves.size());
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("A3")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("A5")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("B3")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("B4")));
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("B5")));
    }

}
