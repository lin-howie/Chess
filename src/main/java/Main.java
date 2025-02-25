//import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Instantiates scanner
    Scanner scan = new Scanner(System.in);
    boolean whiteTurn = true;
    boolean notCheckmate = true;
    boolean inCheck = false;
    int r1;
    int c1;
    int r2;
    int c2;
    ChessBoard object = new ChessBoard();
    // continues the game until checkmate
    while(notCheckmate) {
      System.out.println(object);
      scan.nextLine();
      // recieves inputs
      System.out.println("Enter your piece: ");
      String piece = scan.nextLine();

      //replaces the colors
      if(whiteTurn) { // white pieces
        if(piece.equals("p"))
          piece = "\u265F ";
        if(piece.equals("r"))
          piece = "\u265C ";
        if(piece.equals("k"))
          piece = "\u265A ";
        if(piece.equals("b"))
          piece = "\u265D ";
        if(piece.equals("q"))
          piece = "\u265B ";
        if(piece.equals("n"))
          piece = "\u265E ";
      } else { // black pieces
        if (piece.equals("p"))
        piece = "\u2659 ";
        if(piece.equals("r"))
        piece = "\u2656 ";
        if(piece.equals("n"))
        piece = "\u2658 ";
        if(piece.equals("b"))
        piece = "\u2657 ";
        if(piece.equals("q"))
        piece = "\u2655 ";
        if(piece.equals("k"))
        piece = "\u2654 ";
      }

      System.out.println("Enter your first row: ");
      r1 = scan.nextInt(); 
      System.out.println("Enter your first column: ");
      c1 = scan.nextInt(); 
      System.out.println("Enter your new row: ");
      r2 = scan.nextInt(); 
      System.out.println("Enter your new column: ");
      c2 = scan.nextInt(); 

      Piece selected = ChessBoard.getPiece(r1, c1);
      // trys the codes for errors.
      try {
          if(selected.getName().equals(piece)) {
            System.out.println("executed");
          } else { // force error
            int[] i = new int[0];
            int e = i[10];
          }
        
          selected.move(whiteTurn, r2, c2);
          inCheck = false;
          
          Piece king = ChessBoard.getOppositeKing(whiteTurn);
          if(king.checkCheck()) {
            System.out.println("Check");
            inCheck = true;
            //System.out.println(selected.checkCheckMate(whiteTurn));
            if(selected.checkCheckMate(whiteTurn)) {
              notCheckmate = false;
            }
              
          }
        } catch (Exception e) {
        // catch's errors and prints invalid move
          System.out.println("Invalid move");
        }
      
      whiteTurn = !whiteTurn;
    }
    // prints winning teams 
    System.out.println("Checkmate!");
    if(whiteTurn) {
      System.out.print(" Black wins");
    } else {
      System.out.print(" White wins");
    }
    System.out.println(object);


    // close scanner
    scan.close();
  }
}