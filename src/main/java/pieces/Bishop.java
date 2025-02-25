import java.util.ArrayList;

public class Bishop extends Piece {
    // creates the bishop object
    public Bishop(String name, int r, int c, boolean white) {
        super(name, r, c, white);
    }

    @Override
    public boolean isValidMove(int r, int c, boolean whiteTurn) {
        // Checks if the move is within the board bounds
        if (!isInBounds(r, c)) return false;

        // Checks if the destination square is occupied by a friendly piece
        if (!ChessBoard.getPiece(r, c).getName().equals("\u25fc ") && ChessBoard.getPiece(r, c).getColor() == whiteTurn)
            return false;

        // Calculates the difference in row and column indices
        int dr = Math.abs(getRow() - r);
        int dc = Math.abs(getCol() - c);

        // Bishop moves diagonally, so the change in row and column indices should be equal
        if (dr != dc) return false;

        // Check if there are any pieces blocking the diagonal path
        int startRow = getRow();
        int startCol = getCol();
        int rowIncrement = (r - startRow) / dr;
        int colIncrement = (c - startCol) / dc;

        // determines the direction of the diagonal using the row and column increments as negative and positive multipliers.
        for (int i = 1; i < dr; i++) {
            if (!ChessBoard.getPiece(startRow + i * rowIncrement, startCol + i * colIncrement).getName().equals("\u25fc "))
                return false;
        }

        
        if(ChessBoard.getPiece(r, c).getName().equals("\u25fc ")) { // returns true if the move is to a tile
            return true;
        } else if (ChessBoard.getPiece(r, c).getColor() != whiteTurn 
             && (!ChessBoard.getPiece(r, c).getName().equals("\u265A ") && !ChessBoard.getPiece(r, c).getName().equals("\u2654 "))) { // returns true and captures if its an opposing piece and now a king
            ChessBoard.capturePiece(r, c);
            return true;
        }
        return false; // return false otherwise
    }

    // checks all diagonals
    public boolean checkCheck() {
        // gets the opposite king to get its coordinates and check if it is in danger of check
        Piece king = ChessBoard.getOppositeKing(getColor());
        int kr = king.getRow();
        int kc = king.getCol();

        int dr = Math.abs(getRow() - kr);
        int dc = Math.abs(getCol() - kc);

        if ((dr != 0 && dc != 0) && (dr != dc)) return false;

        if (dr == dc && dr != 0) {
            ArrayList<Piece> diagonal = getDiagonal(getRow(), kr, getCol(), kc);
            if (!checkCheck(diagonal)) return false;
        }

        return true;
    }
}
