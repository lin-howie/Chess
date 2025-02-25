import java.util.ArrayList;


public class Knight extends Piece {

  public Knight(String name, int r, int c, boolean white) {
    super(name, r, c, white);
  }
// checks that the move is the iconic L-shape
  public boolean isValidMove(int r, int c, boolean whiteTurn) {
    int moveR = Math.abs(r - getRow());
    int moveC = Math.abs(c - getCol());
  
    if(((moveR == 2 && moveC == 1) || (moveR == 1 && moveC == 2))) {
      return super.isValidMove(r, c, whiteTurn);
    }
    
    return false;
  }

public boolean checkCheck() {
  // gets king to use its coordinates and see if its in range of the knight
  Piece king = ChessBoard.getOppositeKing(getColor());
  int kr = king.getRow();
  int kc = king.getCol();

  int moveR = Math.abs(kr - getRow());
  int moveC = Math.abs(kc - getCol());

  if(((moveR == 2 && moveC == 1) || (moveR == 1 && moveC == 2))) {
    if(checkCheck(kr, kc))
      return true;
  }
  
  return false;
   
  }
}