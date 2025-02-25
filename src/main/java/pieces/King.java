import java.util.ArrayList;

public class King extends Piece {

  public King(String name, int r, int c, boolean white) {
    super(name, r, c, white);
  }
  
  public void move(boolean whiteTurn, int r, int c) {
// checks that the moves are only one tile
    int moveRK = Math.abs(r - getRow());
    int moveCK = Math.abs(c - getCol());
    
    if(!checkCheck() && ((moveRK == 1 && moveCK == 1) || (moveCK == 1 && moveRK == 0) || (moveRK == 1 && moveCK == 0) && isValidMove(r, c, whiteTurn)))
        super.move(whiteTurn, r, c);
    else {
      //forces error for try catch
      int[] i = new int[0];
      int e = i[10];
    }
  }

  public boolean checkCheck() {
    // checks every opposite color peace and sees if they are in danger of getting checked
    ArrayList<Piece> black = ChessBoard.getBlackPieces();
    ArrayList<Piece> white = ChessBoard.getWhitePieces();
    
    //System.out.println(getColor());
    if(getColor()) {
      for(int i = 0; i < black.size(); i++) {
        if(!black.get(i).getName().equals("\u2654 ") && black.get(i).checkCheck()) {
          return true;
        }
      }
    } else {
      for(int i = 0; i < white.size(); i++) {
        if(!white.get(i).getName().equals("\u265A ") && white.get(i).checkCheck()) {
          return true;
        }
      }
    }
    
    return false;
  }
// checks if all it is checkmate for a king by placing the king in all possibel positions and checking if its legal
  public boolean checkCheckMate(boolean whiteTurn) {
    int prevRow = getRow();
    int prevCol = getCol();
    
    for(int r = prevRow - 1; r <= prevRow + 1; r++) {
      for(int c = prevCol - 1; c <= prevCol + 1; c++) {
        if(isInBounds(r, c) && isValidMove(r, c, !whiteTurn)) {
          Piece temp = ChessBoard.swapWithKing(prevRow, prevCol, r, c);
          if(!checkCheck()) {
          ChessBoard.swapBackKing(prevRow, prevCol, r, c, temp);
            //System.out.println("should not have executed");
          return false;
          }
          ChessBoard.swapBackKing(prevRow, prevCol, r, c, temp);
        }
      }
    }
    return true;
  }

}