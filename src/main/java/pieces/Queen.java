import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(String name, int r, int c, boolean white) {
        super(name, r, c, white);
    }

    @Override
    public boolean isValidMove(int r, int c, boolean whiteTurn) {
        // Check if the move is within the board bounds
        if (!isInBounds(r, c)) return false;

        // Check if the destination square is occupied by a friendly piece
        if (!ChessBoard.getPiece(r, c).getName().equals("\u25fc ") && ChessBoard.getPiece(r, c).getColor() == whiteTurn)
            return false;

        // Calculate the difference in row and column indices
        int dr = Math.abs(getRow() - r);
        int dc = Math.abs(getCol() - c);

        // Queen moves horizontally, vertically, or diagonally, so the change in  row and column indices should be equal
        if ((dr != 0 && dc != 0) && (dr != dc && dr != 0 && dc != 0)) return false;

        // Check if there are any pieces blocking the path
        if (dr == 0 && dc != 0) {
            ArrayList<Piece> horizontal = getHorizontal(getCol(), c, getRow());
            if (!checkArray(horizontal, whiteTurn)) return false;
        } else if (dr != 0 && dc == 0) {
            ArrayList<Piece> vertical = getVertical(getRow(), r, getCol());
            if (!checkArray(vertical, whiteTurn)) return false;
        } else if (dr == dc && dr != 0) {
            ArrayList<Piece> diagonal = getDiagonal(getRow(), r, getCol(), c);
            if (!checkArray(diagonal, whiteTurn)) return false;
        }

        if(ChessBoard.getPiece(r, c).getName().equals("\u25fc ")) 
            return true;
        
        if( (!ChessBoard.getPiece(r, c).getName().equals("\u265A ") 
             && !ChessBoard.getPiece(r, c).getName().equals("\u2654 ")) ) { // returns true and captures if its an opposing piece and now a king
            ChessBoard.capturePiece(r, c);
            return true;
        } 
        return false;
    }

    public boolean checkCheck() {
        Piece king = ChessBoard.getOppositeKing(getColor());
        int kr = king.getRow();
        int kc = king.getCol();

        int dr = Math.abs(getRow() - kr);
        int dc = Math.abs(getCol() - kc);
        
        if ((dr != 0 && dc != 0) && (dr != dc && dr != 0 && dc != 0)) return false;
        
        if (dr == 0 && dc != 0) {
            ArrayList<Piece> horizontal = getHorizontal(getCol(), kc, kr);
            if (!checkCheck(horizontal)) return false;
        } else if (dr != 0 && dc == 0) {
            ArrayList<Piece> vertical = getVertical(getRow(), kr, kc);
            if (!checkCheck(vertical)) return false;
        } else if (dr == dc && dr != 0) {
            ArrayList<Piece> diagonal = getDiagonal(getRow(), kr, getCol(), kc);
            if (!checkCheck(diagonal)) return false;
        }
        
        return true;
    }
}
