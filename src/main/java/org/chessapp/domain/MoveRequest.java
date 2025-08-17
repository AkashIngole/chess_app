package org.chessapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MoveRequest {
    private String piece;
    private ChessBoardPosition chessBoardPosition;

    private MoveRequest() {}

    @Override
    public String toString() {
        return "MoveRequest{" + piece + " at " + chessBoardPosition + '}';
    }
}
