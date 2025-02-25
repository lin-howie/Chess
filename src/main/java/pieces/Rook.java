import java.util.ArrayList;

public class Rook extends Piece {

  public Rook(String name, int r, int c, boolean white) {
    super(name, r, c, white);
  }

  // account for when it's 0
  public boolean isValidMove(int newRow, int newCol, boolean whiteTurn) {
    ArrayList<Piece> horizontal = getHorizontal(getCol(), newCol, getRow()); // found in the Piece class
    // change this parameter
    ArrayList<Piece> vertical = getVertical(getRow(), newRow, getCol()); // found in the Piece class
    
      if ((getRow() == newRow && getCol() != newCol)) {
       if(checkArray(horizontal, whiteTurn))
         return super.isValidMove(newRow, newCol, whiteTurn);
        else
         return false;
      } 
      if(getCol() == newCol && getRow() != newRow) {
        if(checkArray(vertical, whiteTurn))
           return super.isValidMove(newRow, newCol, whiteTurn);
          else
           return false;
      }
        return false;
  }

  
  public boolean checkCheck() {
    ArrayList<Piece> horizontal = new ArrayList<Piece>();
    ArrayList<Piece> vertical = new ArrayList<Piece>();
    ArrayList<Piece> black = ChessBoard.getBlackPieces();
    ArrayList<Piece> white = ChessBoard.getWhitePieces();
    Piece king = ChessBoard.getOppositeKing(getColor());

    int kr = king.getRow();
    int kc = king.getCol();

    if(kr == getRow() && kc != getCol() ) {
      horizontal = getHorizontal(getCol(), kc, kr);
      if(super.checkCheck(horizontal))
        return true;
      return false;
    } else if(kr != getRow() && kc == getCol()) {
      vertical = getVertical(getRow(), kr, kc);
      if(super.checkCheck(horizontal))
        return true;
      return false;
    } else {
      return false;
    }
  }


  
/*
  public boolean checkCheck() {
    ArrayList<Piece> black = ChessBoard.getBlackPieces();
    ArrayList<Piece> white = ChessBoard.getWhitePieces();

    if(getColor()) {
      for(int i = 0; i < black.size(); i++) {
        if(Super.black.get(i).checkCheck()) {
          return true;
        }
      }
    } else {
      for(int i = 0; i < white.size(); i++) {
        if(Super.white.get(i).checkCheck()) {
          return true;
        }
      }
    }

    return false;
  }

  public boolean checkCheckMate(boolean whiteTurn) {
    int CR1 = getRow() - 1;
    int CR2 = getRow() + 1;

    for(int r = CR1; r <= CR2; r++)) {
      for(int c = CC-1; c <= CC+1; c++)) {
        if(isValidMove(r, c, !whiteTurn)) {
          return false;
        }
      }
    }
    return true;
  }
*/
  
/*
  public boolean checkCheck(boolean whiteTurn){
    if (whiteTurn){
      for(int i = 0; i < getHorizontal(0, getCol(), getRow()).size(), i++){
        if (!getHorizontal(0, getCol(), getRow()).get(i).equals("\u265A ")){
return false;
        } else {
          return true;
        }
      }

    }else {
      for (int i = 0; i < getVertical(0, getRow(), getCol()).size(), i++){
        if (!getVertical(0, getRow(), getCol()).get(i).equals("\u2654 ")){
          return false;
        } else {
          return true;
        }
      }
    }
    return false;
  }
*/

}