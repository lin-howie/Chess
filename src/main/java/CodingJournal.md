# CSA CODE JOURNAL
_____________________________________________________________________________
## Adding Colors to your code... 

< a href = "https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println"> Change Console colors /* //Using ConsoleColors Class System.out.println("\n" + ConsoleColors.RED + "This text is red!" + ConsoleColors.ANSI_RESET); System.out.println(ConsoleColors.BLUE + "BLUE COLORED" + ConsoleColors.RESET + " NORMAL"); System.out.println(ConsoleColors.ANSI_GREEN_BACKGROUND + "This text has a green background but default text!" + ConsoleColors.ANSI_RESET); System.out.println(ConsoleColors.ANSI_RED + "This text has red text but a default background!" + ConsoleColors.ANSI_RESET); System.out.println(ConsoleColors.ANSI_GREEN_BACKGROUND + ConsoleColors.ANSI_RED + "This text has a green background and red text!" + ConsoleColors.ANSI_RESET + "\n");

//Using Color Class System.out.print(Color.BLACK_BOLD); System.out.println("Black_Bold"); System.out.print(Color.RESET);

System.out.print(Color.YELLOW); System.out.print(Color.BLUE_BACKGROUND); System.out.println("YELLOW & BLUE"); System.out.print(Color.RESET);

System.out.print(Color.YELLOW); System.out.println("YELLOW"); System.out.print(Color.RESET); */
_____________________________________________________________________________
## May 19th, 2024 EXAMPLE
Objective - Today, my partner and I are going to work on constructing the classes that will be essential for the Connect Four game. We will create the instance variables, constructors, and methods that will users actually interact with the game. Maybe incoporate some lines of code that use the class methods logically.

Completed - Constructors, methods, and private instance variables for the classes. A few neccesary statments to retrieve information from the user (in the runner class).

Problems Encountered - None so far.

Next steps - Next step for tomorrow is to think how can we make it visually possible and conitinue on working with methods.
_____________________________________________________________________________
## May 20th, 2024
Objective - Today my partners and I are trying to figure out the basics to Replit, like how to invite, how to update the journal, and the Unicode for certain shapes and colors. 

Complete - We figured out how to use the journal and create new files for our different classes. We also have a few methods and classes in mind for how our game is supposed to work. I am also working on creating the starter chess board.

Problems - We still cannot share our project, which makes advancing difficult. 

Next steps - Once we share the project with others we will be able to work on the checking methods.

_____________________________________________________________________________
## May 21st, 2024
Objective -  Today my partners and I are going to develop the Chess board. Also, we are going to neaten our puedo code and ideas.

Complete - Wrote and organized pseudocode, shared project with teammates, and continued to brainstorm how to code. 

Problems  - Need more planning, needs organization, don't have a finished chessboard to work off of, and lots of errors.

Next Steps - Brainstorm how to code the checkHorizontal, checkVertical, and checkDiagonal methods. that checks if a move is allowed, and continue to work on chessboard.

_____________________________________________________________________________
## May 22nd, 2024
Objective - Howie will finish making the chess board. Isabella will work on checking diagonals method. Leo will work on checking horizontal and vertical

Complete - A general idea of how to code the diagonal check method. 

Problems - Despite understanding how to code the diagonal check method, we lack other methods that will make coding the diagonal check method more convienent, so I will likely have to code other methods before getting to the diagonal check, one of the important ones is a method to check if the movement is out of bounds, which will make coding vertical and horizontal movement easier, also, you will have to check if there is a piece in front of the current piece, because if there is, you are unable to move ( with the exception of the knight)

Next Step - Solve our current problems, write classes, organize our ideas of how we are gonna code the classes and methods. Write the methods that will help us write the more complicated methods easily.

_____________________________________________________________________________
## May 23rd, 2024
Objective - Finish the chessboard

Complete - We thought of using an array system that holds the pieces to place the pieces on a chess board. 

Problems - We ran out of time, but we are almost done with the board.

Next Step - Finish chessboard! Think about what our piece methods should work after implementing the array system.

_____________________________________________________________________________

May 24th, 2024

Objective - Finish chessboard and code checkHorizontal and checkVertical methods.

Complete - We were able to print the chessboard successfully into the console and have coded the checkHoritontal and checkVertical methods. We put Isabella in charge of coding checkVertical. We have also changed the return value of the "check" methods so that they return an array that we can manually look through ourselves.

Problems - We realized that we need an update method to assist the move() method to set the pieces to their new position on the board.

Next Step - Divide more steps and start coding the movement of the pieces

------------------------------------------------------------------------------

May 28th, 2024

Objective - Isabella will be in charge of finishing movement of pieces that go diagonally, vertically, and horizontally. Leo will be in charge of coding the knight and pawn. Howie will be in charge of displaying the chessboard and making generic methods like update() to update the board, move() a generic method for all pieces. 

Complete - We managed to debug the move() method in the pawn class, and the update() method so that we can run the code and check for error.s

Problems - The arguments passed into the move methods are different form what we expected. We need to debut that.

Next Step- Continue working on the piece subclasses.

------------------------------------------------------------------------------

May 29th, 2024
Objectvie - Fix update method, and code the rook, knight, and king class.  Leo is assigned to the knight and king class, Howie will be working on the chessboard with some rook class methods. The main method should be created to test the code so far.

Complete - Fixed the update() method so that it can not display the pieces correctly. 

Problems - We still aren't able to check if a move is legal so there is an error if pieces overlap. We will work on this as we code each individual piece.

------------------------------------------------------------------------------

May 30th, 2024
Objective- Leo will continue work on the knight and king class (move methods), Howie will work on the checkmate and check methods that will take the opponents piece, Isabella will work on the move method in the Rook class. 

Complete - We developed an inBounds methods, and isValidMove method for the bishop and rook class, that allows them to move diagonally, horitoznally, and veritically. Addiotnally, we made a portion of the knight class, checking if the movement is L-shaped, and made the move method. 

Problems - Knight class has some problems with even having it checked with a L shape, it doesn't really help it move.

Next steps - Use the getHoritonal, getDiagonal, and getVertical method to further enhance the isValidMove method.

------------------------------------------------------------------------------

May 31st, 2024
Objective - Include the getHorizontal and getVertical methods into the rook and queen class so we can make sure that no pieces are in the way of a piece's movment. Improve the main method to make it more playable and testable. 

Complete - we've completed the moevement for the rook and bishop classes. 

Problem - Checkmate and Check methods are going to be very time consuming to code, since we have to check each piece to see if it can attack the king. 

Next steps - Continue working on the knight, rook, and bishop class.

-------------------------------------------------------------------------

June 3rd, 2024
Objective- Code the get diagonal method to be used in another method to check if there are pieces in the way when trying to move a piece. 

Complete- Mananged to move the knight piece and check for proper movmenets. Finished coding the pawn piece. Finished coding the rook piece however with outOfBounds error when the array doesn't have anything.

Problem- the knight would not re-appear we think its a problem with update method. Unable to code bishop and queen without a getDiagonal method, which is currently being created. Rook outOfBounds error.

Next steps- debug knight, finish debugging rook, continue to develop getDiagonal to return a list from a start to end coordinate of a diagonal. 

-------------------------------------------------------------------------

June 5th, 2024
Objective - code the king movements, start creating the checkCheck method in all pieces that checks if a movement leads to check, and finish getDiagonal method. 

Commplete - we were able to finish the king's movements however we did not account for illegal king moves yet. We also managed to debug all of the rook, pawn, and knight errors so they should work perfectly now.

Problems - Haven't accounted for illegal king moves, cannot make bishop and queens without getDiagonal, have not accounted for the opponent making an illegal move and giving their turn back.

Next step - continue developing getDiagonal, and checkCheck methods

-------------------------------------------------------------------------

June 7th, 2024
Objective - Isabella will finish the Queen and Bishop piece movements while Howie works on the checkCheck method in the Piece class and pawn class. Leo will work on the knight and rook checking.

Completed - We have finished the getDiagonal method which can be implemented in the bishop and queen class. We have also designed the generic checkCheck methods in the Piece class.

Problems - We have not finished the bishop or queen, which we will work on at home. Additionally, there is an error with the pawn's checkCheck method when the king moves to the pawn's attack range.

Next step - complete the bishop and queen and tailor the checkCheck method to all the pieces this weekend.

-------------------------------------------------------------------------

June 10th, 2024
Objective - Finish the bishop and queen checkCheck methods (shoudl be quick). Howie will work on checkmate and the others will work on other features like empassont, castle, or promotion. 

Complete - All the pieces can now move properly, being able to move, capture, and check. a portion of the checkmate method also works, allowing the checkmate of a king if it has no valid squares to move. 

Problems - checkCheckMate runs very inefficiently preventing the program from testing other moves.

next step - Howie will continue to work on checkCheckmate to make it more efficient and run without error. Isabella and Leo will continue to create the speical moves. 

-------------------------------------------------------------------------

June 11th, 2024
Objective - Debug the checkCheckMate method and continue working on the en passant class. 

Complete - The checkCheckMate method runs more efficiently and accounts for moves that the king has without errors. The interface was also tidyed, now displaying the proper text and using try-catch to account for illegal moves. Additionally, some base code was made for the en passant that accounts for the pawn's first move and whether or not a pawn can go behind another pawn for the capture. 

Problems - Although the code can run, the checkCheck method does not account for blocks and other piece captures, which can lead to premature checkmates. the en passant has many errors regarding its math, and acccessing the other classes. 

