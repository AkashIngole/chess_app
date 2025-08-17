# Chess App

A simple **console-based Java application** that calculates all possible valid moves for a given chess piece from a specified position on the board.  
The app demonstrates **object-oriented design**, **factory pattern**, and **input validation** in a clean, extensible way.

---

## Overview
This Chess App is designed as a lightweight utility for exploring valid chess moves.  
It allows users to enter a chess piece and a board position, then computes all legal moves for that piece based on simplified rules.

The focus is on **clean architecture and extensibility** rather than full chess gameplay.

---

## Features
- Input-driven console application.
- Supported Chess Pieces:
    - King
    - Queen
    - Pawn
- Input validation with user-friendly hints.
- Extensible design:
    - Add new chess pieces by extending `ChessPiece` and updating `ChessPieceFactory`.
- Continuous interaction until the user types `exit`.
- Logging support via **SLF4J**.

---

## Constraints & Assumptions
- Only **King, Queen, and Pawn** are supported.
- Moves are calculated **without considering other pieces** (no blocking or captures).
- Standard **8x8 chessboard** (`A1` to `H8`).
- Pawns follow simplified movement (no color distinction, en passant, or promotion).
- Input format must be: <chess_piece>,<board_position>
- Example: Queen,H5

---
## Getting Started

### 1. Prerequisites
- Java **21** (or a compatible version).
- Maven (for build and dependency management).

### 2. Clone the repository
```bash
git clone https://github.com/<your-username>/chess_app.git
cd chess_app
mvn clean install
java -cp target/classes org.chessapp.Main
