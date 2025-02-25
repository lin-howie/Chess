import java.util.ArrayList;

import jdk.jfr.BooleanFlag;

public class Pawn extends Piece {
  private boolean firstMove;
  private Piece current;
  private int moveCounter = 0;

  public Pawn(String name, int r, int c, boolean firstMove, boolean white) {
    super(name, r, c, white);
    this.firstMove = firstMove;
  }

  public void move(boolean whiteTurn, int r, int c) {
    super.move(whiteTurn, r, c);
    moveCounter++;
    firstMove = false;
  }

  public int getCounter() {
    return moveCounter;
  }
  
  public boolean isValidMove(int r, int c, boolean whiteTurn) {
    ArrayList<Piece> vertical = getVertical(getRow(), r, getCol());

    if(isInBounds(r,c)) { // if the move is not in bounds then the method returns false
      if(whiteTurn && r >= getRow()) // if it is white's turn and the row is greater than or equal to the current row then it returns false
        return false;
      else if (!whiteTurn && r <= getRow()) // if it is black's turn and the row is less than or equal to the current row then it returns false
        return false;
      
      if(firstMove && (Math.abs(getRow()-r) == 2) && (getCol() == c)) { // if it is their first move and they are pushing two squares
          if(vertical.get(0).getName().equals("\u25fc ") && vertical.get(1).getName().equals("\u25fc ")) { // we check if the two squares in front are empty
            return true;
          }
        return false;
        } else { // they either want to push one or take diagonally
          if(Math.abs(getRow() - r) == 1 && Math.abs(getCol() - c) == 1 && ChessBoard.getPiece(r, c).getColor() != whiteTurn && !ChessBoard.getPiece(r, c).getName().equals("\u25fc ") && !ChessBoard.getPiece(r, c).getName().equals("\u2654 ") && !ChessBoard.getPiece(r, c).getName().equals("\u265A ")) { // Otherwise, we check if they want to take diagonally, which checks that the pawn is moving diagonally and that the piece in the way is of the opposite color   
            ChessBoard.capturePiece(r, c);
            return true;
          } else if (Math.abs(getRow()-r) == 1 && vertical.get(0).getName().equals("\u25fc ") && getCol() == c) { // if they want to push one square we check if it is free
            return true;
          }
          return false; // otherwise it's an illegal move
        }
      }
    return false; 
    }

  
  public boolean checkCheck() { // return error if not diagonal
    ArrayList<Piece> diagonal1 = new ArrayList<Piece>();
    ArrayList<Piece> diagonal2 = new ArrayList<Piece>();
    // gets the two attack diagonals depending on the colors 
    if(this.getColor()) { // if its in bounds // I have a try catch to keep running
      diagonal1 = getDiagonal(getRow(), getRow()-1, getCol(), getCol()+1);
      diagonal2 = getDiagonal(getRow(), getRow()-1, getCol(), getCol()-1);
    } else {
      diagonal1 = getDiagonal(getRow(), getRow()+1, getCol(), getCol()+1);
      diagonal2 = getDiagonal(getRow(), getRow()+1, getCol(), getCol()-1);
    }
// checking if a king is in those diagonals.
    if(super.checkCheck(diagonal1))
      return true;
    else if(super.checkCheck(diagonal2))
      return true;
    
      return false; 
  }
  
}
