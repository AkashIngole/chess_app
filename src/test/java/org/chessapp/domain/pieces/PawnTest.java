package org.chessapp.domain.pieces;

import org.chessapp.common.Constants;
import org.chessapp.domain.ChessBoardPosition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PawnTest {

    private final Pawn pawn = new Pawn();

    @Test
    void testGetName() {
        assertEquals(Constants.PAWN, pawn.getName());
    }

    @Test
    void testPossibleMovesFromFirstRow() {
        ChessBoardPosition current = ChessBoardPosition.getChessBoardPosition("B2");
        List<ChessBoardPosition> moves = pawn.possibleMoves(current);

        assertEquals(1, moves.size());
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("B3")));
    }

    @Test
    void testPossibleMovesFromMiddleOfBoard() {
        ChessBoardPosition current = ChessBoardPosition.getChessBoardPosition("D4"); // row=3, col=3
        List<ChessBoardPosition> moves = pawn.possibleMoves(current);

        assertEquals(1, moves.size(), "Pawn should have exactly 1 move forward");
        assertTrue(moves.contains(ChessBoardPosition.getChessBoardPosition("D5")));
    }

    @Test
    void testPossibleMovesFromLastRow() {
        ChessBoardPosition current = ChessBoardPosition.getChessBoardPosition("E8"); // top edge
        List<ChessBoardPosition> moves = pawn.possibleMoves(current);

        assertTrue(moves.isEmpty(), "Pawn on last row should have no moves");
    }

}
