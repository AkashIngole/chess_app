package org.chessapp.enums;

import lombok.Getter;

@Getter
public enum PlayDirection {

    // Straight moves
    UP(1, 0),
    DOWN(-1, 0),
    LEFT(0, -1),
    RIGHT(0, 1),

    // Diagonal moves
    DIAGONAL_UP_LEFT(1, -1),
    DIAGONAL_UP_RIGHT(1, 1),
    DIAGONAL_DOWN_LEFT(-1, -1),
    DIAGONAL_DOWN_RIGHT(-1, 1);

    final int rowStep;
    final int columnStep;

    PlayDirection(int rowStep, int columnStep) {
        this.rowStep = rowStep;
        this.columnStep = columnStep;
    }
}
