/* more of an en passant method that belongs in the pawn class rather than a whole class
import java.util.ArrayList;

public class Pawn extends Piece {
  private boolean firstMove;
  private boolean enPassantPossible;
  private static Piece lastMovedPawn = null;

  public Pawn(String name, int r, int c, boolean firstMove, boolean white) {
    super(name, r, c, white);
    this.firstMove = firstMove;
    this.enPassantPossible = false;
  }

  @Override
  public void move(boolean whiteTurn, int r, int c) {
    // Handle en passant capture
    if (enPassantPossible && Math.abs(getCol() - c) == 1 && getRow() == (whiteTurn ? r + 1 : r - 1) && ChessBoard.getPiece(r, c).getName().equals("\u25fc ")) {
      int captureRow = whiteTurn ? r + 1 : r - 1;
      ChessBoard.capturePiece(captureRow, c);
      ChessBoard.getPiece(captureRow, c).setName("\u25fc ");
    }

    super.move(whiteTurn, r, c);
    firstMove = false;
    enPassantPossible = false;

    // Update the last moved pawn
    if (Math.abs(getRow() - r) == 2) {
      lastMovedPawn = this;
    } else {
      lastMovedPawn = null;
    }
  }
}
*/
