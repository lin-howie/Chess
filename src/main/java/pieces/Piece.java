import java.util.ArrayList;

public class Piece {
  private String name;
  private boolean white;
  private int c;
  private int r;
// constuctor
  public Piece(String name, int r, int c, boolean white) {
    this.name = name;
    this.c = c;
    this.r = r;
    this.white = white;
  }
// acccessor method 
  public String getName(){
    return name;
  }

  public int getRow(){
   return r;
  }

  public int getCol(){
    return c;
  }

  // mutator methods
  public void setCol(int c) {
    this.c = c;
  }

  public void setRow(int r){
    this.r = r;
  } 

  // accessor
  public boolean getColor() {
    return white;
  }

  // generic movement helper methods
  public boolean isInBounds(int row, int col) {
      return row >= 0 && row < 8 && col >= 0 && col < 8;
  }
// test method for en passant (didn't work)
  public int getCounter() {
    System.out.println("wrong counter");
    return -1;
  }
  // generic movement helper methods by changing the coordinates and displaying the new board
  public void move(boolean whiteTurn, int r, int c) {
      if(isValidMove(r, c, whiteTurn)) {
        setRow(r);
        setCol(c);
        ChessBoard.update();
      } else {
        int[] i = new int[0];
        int e = i[10];
      }
  }
// checks if a single coordinate is legal including capturing if its an opponent piece and not a king
  public boolean isValidMove(int r, int c, boolean whiteTurn) {
    if(!isInBounds(r, c))
      return false;
    
    if(!ChessBoard.getPiece(r, c).getName().equals("\u25fc ")) {
      if(ChessBoard.getPiece(r, c).getColor() != whiteTurn 
         && (!ChessBoard.getPiece(r, c).getName().equals("\u265A ") && !ChessBoard.getPiece(r, c).getName().equals("\u2654 "))) {
        ChessBoard.capturePiece(r, c);
        return true;
      }
        return false;
    } 
    return true;
  }
// checks if a piece is in the way of a nother piece's movemnet
  public boolean checkArray(ArrayList<Piece> arr, boolean whiteTurn) {
    String tile = "\u25fc ";
    for(int i = 0; i < arr.size()-1; i++) {
      // may have an error due to overriding IDK
      if(!arr.get(i).getName().equals(tile)) {
        return false;
      }
    }
    return true;
  }

  // white piece can only check black king
  // black piece can only check white king
  // cecks for check given a coordinate
  public boolean checkCheck(int r, int c) {
    if(this.getColor()) {
      if(ChessBoard.getPiece(r, c).equals("\u2654 "))
      return true;
    } else {
      if(ChessBoard.getPiece(r, c).equals("\u265A "))
        return true;
    }
    return false; 
  }

  //checks for check given an array
  public boolean checkCheck(ArrayList<Piece> arr) {
    String tile = "\u25fc ";
    
    for(int i = 0; i < arr.size(); i++) {
      if(this.getColor()) {
        if(arr.get(i).getName().equals("\u2654 "))
          return true;
        else if (!arr.get(i).getName().equals(tile))
          return false;
      } else {
        if(arr.get(i).getName().equals("\u265A "))
          return true;
        else if (!arr.get(i).getName().equals(tile))
          return false;
        }
      }
      return false;
  }

  // a generic method that gives all pieces access to the king's checkCheckMate()
  public boolean checkCheckMate(boolean whiteTurn) {
    Piece king = ChessBoard.getOppositeKing(whiteTurn);
    
    return king.checkCheckMate(whiteTurn);
  }

  // just so there's no error for the sub classes
  public boolean checkCheck() {
    System.out.println("wrong checkCheck");
    Piece king = ChessBoard.getOppositeKing(getColor());
    return king.checkCheck();
  }

  // need to be aware of out of bound error, which can be addressed in the piece class, but maybe we can account for it here
  // account for when the length of an array is 0
  // returns a horizontal from a start coordinate to end coordinate
  public ArrayList<Piece> getHorizontal(int c1, int c2, int r1) {
    ArrayList<Piece> horizontal = new ArrayList<Piece>();
    int difference = c2-c1;
    if(difference > 0) {
      for(int i = 1; i <= c2-c1; i++){
        horizontal.add(ChessBoard.getPiece(r1, c1+i));
      }
    } else if (difference < 0) {
      for(int i = c1-1; i >= c2; i--) {
        horizontal.add(ChessBoard.getPiece(r1, i));
      }
    } else {
      // maybe throw an exception so try catch works 
      //System.out.println("length of 0");
    }

    return horizontal;
  }

  // returns a vertical from a start coordinate to end coordinate
  public ArrayList<Piece> getVertical(int r1, int r2, int c1) {
    ArrayList<Piece> vertical = new ArrayList<Piece>();

    int difference = r2-r1;
    if(difference > 0) {
      for(int i = 1; i <= r2-r1; i++){
        vertical.add(ChessBoard.getPiece(r1+i, c1));
      }
    } else if (difference < 0) {
      for(int i = r1-1; i >= r2; i--) {
        vertical.add(ChessBoard.getPiece(i, c1));
      }
    } else {
      // maybe throw an exception so try catch works
      //System.out.println("length of 0");
    }

    return vertical;
  }

  // returns the array of pieces that are in between the start and end coordinates
// might need to work on try catchp
  
  public ArrayList<Piece> getDiagonal(int r1, int r2, int c1, int c2) {
    ArrayList<Piece> diagonal = new ArrayList<Piece>();
    int differenceR = Math.abs(r2-r1);
    int differenceC = Math.abs(c2-c1);
    
    // if the two squares arent diagonal, then return an empty array
    try { // accounts for when checkCheck goes out of bounds
      if(differenceR != differenceC) {
        return diagonal;
      }
        
      int r;
      int c;
      for(int i = 1; i <= differenceR; i++) {
        if(r2 > r1)
          r = r1+i;
        else 
          r = r1-i;

        if(c2 > c1)
          c = c1+i;
        else
          c = c1-i;

        diagonal.add(ChessBoard.getPiece(r,c));
      }
    } catch(Exception e) {
      return diagonal;
    }
    
    return diagonal; 
  }

  // @overrides .equals() method to compare two pieces 
  // does not account for the piece's color
  // assistance from geeksforgeeks.org
  // @overrides .equals() method to compare two pieces 
  // does not account for the piece's color
  // assistance from geeksforgeeks.org
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    // Check if o is an instance of Piece or not
    if (!(o instanceof Piece)) {
      return false;
    }

    // Casts o to a Piece so we can access the values of the Piece class for the object.
    Piece c = (Piece) o;

    return c.getName() == this.getName() && c.getRow() == this.getRow() && c.getCol() == this.getCol();
  }

  /*
  public void promotion(Pawn pawn, Piece piece) {
    ArrayList<Piece> black = ChessBoard.getBlackPieces();
    ArrayList<Piece> white = ChessBoard.getWhitePieces();
    
    if(!pawn.getColor()) {
      if (pawn.getRow() == 7) {
        //System.out.println("promote to a new piece");
        for(int i = 0; i < black.size(); i++) {
          if(black.get(i).getName().equals(pawn.getName())) {
            black.remove(i);
            black.add(piece);
          }
        }
      }
    } else {
      
    }
  }
  */
  
}

//public 