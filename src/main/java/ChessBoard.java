import java.util.ArrayList;

public class ChessBoard {
  private static Piece[][] board = new Piece[8][8]; // The chess board
  private static ArrayList<Piece> blackPieces = new ArrayList<Piece>(); // black's pieces
  private static ArrayList<Piece> whitePieces = new ArrayList<Piece>(); // white's pieces
  private Piece[] blackUnique = {new Rook("\u2656 ", 0, 0, false), new Knight("\u2658 ", 0, 1, false), new Bishop("\u2657 ", 0, 2, false), new Queen("\u2655 ", 0, 3, false), new King("\u2654 ", 0, 4, false), new Bishop("\u2657 ", 0, 5, false), new Knight("\u2658 ", 0, 6, false), new Rook("\u2656 ", 0, 7, false)};
  private Piece[] whiteUnique = {new Rook("\u265C ", 7, 0, true), new Knight("\u265E ", 7, 1, true), new Bishop("\u265D ", 7, 2, true), new Queen("\u265B ", 7, 3, true), new King("\u265A ", 7, 4, true), new Bishop("\u265D ", 7, 5, true), new Knight("\u265E ", 7, 6, true), new Rook("\u265C ", 7, 7, true)};

  public static ArrayList<Piece> getBlackPieces() {
    return blackPieces;
  }

  public static ArrayList<Piece> getWhitePieces() {
    return whitePieces;
  }

  public static Piece swapWithKing(int kr, int kc, int pr, int pc) {
    Piece temp = board[pr][pc];
    board[kr][kc].setRow(pr);
    board[kr][kc].setCol(pc);
    board[pr][pc] = board[kr][kc];
    board[kr][kc] = new Piece("\u25fc ", kr, kc, true);

    /*
    String str = "swapWith\n  0 1 2 3 4 5 6 7";

    for(int r = 0; r < 8; r++) {
      str += "\n" + r + " ";
      for(int c = 0; c < 8; c++) {
        str += board[r][c].getName();
      }
    }
    System.out.println(str);
    */
    
    return temp;
  }

  public static void swapBackKing(int kr, int kc, int pr, int pc, Piece temp) {
    board[kr][kc].setRow(kr);
    board[kr][kc].setCol(kc);
    board[kr][kc] = board[pr][pc];
    board[pr][pc] = temp;

    /*
    String str = "swapBack\n  0 1 2 3 4 5 6 7";

    for(int r = 0; r < 8; r++) {
      str += "\n" + r + " ";
      for(int c = 0; c < 8; c++) {
        str += board[r][c].getName();
      }
    }
    System.out.println(str);
    */
  }

  public static Piece getOppositeKing(boolean white) {
    if(white) {
      for(int i = 0; i < blackPieces.size(); i++) {
        if(blackPieces.get(i).getName().equals("\u2654 "))
          return blackPieces.get(i);
      }
    } else {
      for(int i = 0; i < whitePieces.size(); i++) {
        if(whitePieces.get(i).getName().equals("\u265A "))
          return whitePieces.get(i);
      }
    }
    return null; // likely won't return
  }
  
  
  // captures pieces using captureWhite and captureBlack
  public static void capturePiece(int r, int c) {
    if(board[r][c].getColor()) {
      captureWhite(r, c); 
    } else {
      captureBlack(r, c);
    }
  }

  // captures white's pieces
  public static void captureWhite(int r, int c) {
    for(int i = 0; i < whitePieces.size(); i++) {
      if(whitePieces.get(i).equals(board[r][c])) {
        whitePieces.remove(i);
        break;
      }
    }
  }

  // captures black's pieces
  public static void captureBlack(int r, int c) {
    for(int i = 0; i < blackPieces.size(); i++) {
      if(blackPieces.get(i).equals(board[r][c])) {
        blackPieces.remove(i);
        break;
      }
    }
  }

  // constructs chessboard
  public ChessBoard() {
    for(int c = 0; c < 8; c++) {
      // adds the black pieces
      blackPieces.add(blackUnique[c]);
      blackPieces.add(new Pawn("\u2659 ", 1, c, true, false)); // black pawns

      // adds the white pieces
      whitePieces.add(whiteUnique[c]);
      whitePieces.add(new Pawn("\u265F ", 6, c, true, true)); // white pawns
    }
    update();
  }

  // displays the new appearance of the chessboard
  public static void update() {
    for(int r = 0; r < 8; r++) {
      for(int c = 0; c < 8; c++) {
        board[r][c] = new Piece("\u25fc ", r, c, true); // white squares; test null
      }
    }

    for(int i = 0; i < whitePieces.size(); i++) {
      board[whitePieces.get(i).getRow()][whitePieces.get(i).getCol()] = whitePieces.get(i);
    }
    for(int i = 0; i < blackPieces.size(); i++) {
      board[blackPieces.get(i).getRow()][blackPieces.get(i).getCol()] = blackPieces.get(i);
    }
  }

  // returns the pieces at a position on the chessboard
  public static Piece getPiece(int r, int c) {
    return board[r][c];
  }  
   // displays chess board
   public String toString() {
    String str = "  0 1 2 3 4 5 6 7";

    for(int r = 0; r < 8; r++) {
      str += "\n" + r + " ";
      for(int c = 0; c < 8; c++) {
        str += board[r][c].getName();
      }
    }
    return str;
   }
}