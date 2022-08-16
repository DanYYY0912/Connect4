/*************************************************************************
*                                                                        *
*      "ConnectFour"                                                     *
*                                                                        *
* @Name        : YUEN YIU YEUNG                                          *
* @StudentID   : 200171873                                               *
* @Class       : IT114105/1C                                             *
* @Date        : 02-11-2020                                              *
* @Program     : Assignment                                              *
* @Description : A two-players game in which the players take turns      *
*                to drop a colored disc of their own side and            *
*                the objective of the game is to make successive four    *
*                discs of the same colour aligned vertically,            *
*                horizontally, or diagonally before the opponent doing   *
*                the same likewisely.                                    *
* @Input       : A column number of the vertically-suspended grid        *
* @Output      : One of the player has won or draw game                  *
* @Input       : Column Number (As player's disc)                        *
* @Output      : Player win this game  or Draw Game                      *
* @History     :                                                         *
*      02/11/2020    new today                                           *
*      10/11/2020    Setup the class Game Board                          *
*      13/11/2020    Setup the class SetPlayer                           *
*      14/11/2020    Setup the class Situation                           *
*      15/11/2020    Finished the checking bottom left to top right      *
*      24/11/2020    Finished the checking top left to bottom right      *
*      29/11/2020    Fixed the problem on checking                       *
*                                                                        *
**************************************************************************/
import java.util.Scanner; 
public class ConnectFour
{
    static final int ROWS = 6;
    static final int COLUMNS = 7;
    static Scanner kb;
    static SetPlayer[] players;
    static int num = 0;
    static Situation circumST;
    static int totalMoves = 0;
    static GameBoard board;
    static int number;

    
    public ConnectFour() { 
        kb = new Scanner(System.in);
        board = new GameBoard(ROWS, COLUMNS);
        players = new SetPlayer[2];
        for (int num = 0; num < players.length; num++)
            players[num] = new SetPlayer();
        circumST = new Situation(board);
    }

    
    public void runPGM() {
        Players();
        board.setupGBoard();
        board.printGBoard(); 
        takeTurn();
    }
    
    private void Players() { 
        System.out.println("Welcome to The Connect Four");
        System.out.println("Player 1 please enter your name?");
        players[0].setName(kb.next());
        if (players[0].getName().length() <= 0) {
            System.out.println("The player name will be set default as Player 1.");
            players[0].setName("Player1");
            } else {
                players[0].setName(players[0].getName());
        }
        
        System.out.println("Player 2 please enter your name?");
        players[1].setName(kb.next());
        if (players[1].getName().length() <= 0) {
            System.out.println("The player name will be set default as Player 1.");
            players[1].setName("Player 2");
            } else {
                players[1].setName(players[1].getName());
        }
    }
    
    private void takeTurn() {
        
        while (true) {
            System.out.print("\nPlayer " + players[0].getName() + " type a column <0-6> or 9 to quit current game: ");
            playerDisc("1");
            System.out.println();
            board.printGBoard();
            num++;
            totalMoves = totalMoves + 1;
            circumST.checkDraw(totalMoves);

            System.out.print("\nPlayer " + players[1].getName() + " type a column <0-6> or 9 to quit current game: ");
            playerDisc("2");
            System.out.println();
            board.printGBoard();
            num--;
            totalMoves = totalMoves + 1;
            circumST.checkDraw(totalMoves);

        }

    }
 

    
    private void playerDisc(String nDisc) {
        boolean process = true; 

        while (process) {
            number = kb.nextInt();
            if (number == 9) { 
                        System.out.println("Bye Bye!");
                        System.out.println("\nProgram created by YUEN Yiu Yeung");
                        System.out.println("Thank you for using this <ConnectFour>.");
                        System.out.println("The Program has terminated normally.\n");
                        System.exit(0); 
                        } else if(number >= 0 && number < COLUMNS) {
                            if (circumST.columnFull(number)) {
                                System.out.println("Column " + number + " is full!");
                                System.out.print("Player " + players[num].getName() + " type a column <0-6> or 9 to quit current game: ");
                                continue;
                                } else
                                    board.updateBoard(number, nDisc);
                                    circumST.checkConnect(number,nDisc);
                                    process = false;    // end while-loop
                            } else
                                System.out.println("Range of column should be 0 to 6!");
                                System.out.print("Player " + nDisc + " type a column <0-6> or 9 to quit current game: ");
           }

    }
}


