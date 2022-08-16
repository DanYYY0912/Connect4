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
public class runWholePGM
{
    private static ConnectFour connectFour;
    
    public static void main(String[] args) {
        
        printHeader();
        
        connectFour = new ConnectFour(); 
        connectFour.runPGM();
    }
    
    private static void printHeader() {
        System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\===========////////////");
        System.out.println("************ConnectFour************");
        System.out.println("////////////===========\\\\\\\\\\\\\\\\\\\\\\\\\n");
    }
}
