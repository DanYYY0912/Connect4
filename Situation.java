public class Situation
{
    private GameBoard board;
    private String grid[][];

    public Situation(GameBoard board) {
        this.board = board;
        this.grid = this.board.getConnectFour();
    }

    public boolean columnFull(int number) {
        int count = 0;
        boolean full = true;

        for (int col = this.grid.length ; col > 0; col--) {

            if (this.grid[count][number] != "O") {
                count = count + 1;
            }
        }

        if (count == this.grid.length) 
            full = true;
        else
            full = false;
        return full;

    }

    public void checkDraw(int totalMoves) {
        int count = this.board.getRow() * this.board.getColumn();

        if (totalMoves == count) {
            System.out.println();
            System.out.println("Draw!");
            System.out.println("========END GAME!========");
            System.out.println("Bye Bye!");
            System.out.println("\nProgram created by YUEN Yiu Yeung");
            System.out.println("Thank you for using this <ConnectFour>.");
            System.out.println("The Program has terminated normally.\n");
            System.exit(0);
        }
    }

    public void checkrun(int count, String player) {
        int total = 4;

        if (count >= total) {
            board.printGBoard();
            System.out.println();
            System.out.println( "Player" + player +" win this game!");
            System.out.println("========END GAME!========");
            System.out.println("Bye Bye!");
            System.out.println("\nProgram created by YUEN Yiu Yeung");
            System.out.println("Thank you for using this <ConnectFour>.");
            System.out.println("The Program has terminated normally.\n");
            System.exit(0);
        }
    }

    public void checkConnect(int colNum, String player) {
        
        for (int xAxi = 0, yAxi = 0; xAxi < this.grid.length; xAxi++, yAxi++) {
            int count = 0;
            int row = colNum;

            // check horizontal
            while (row < board.getRow() && grid[xAxi][row] == player) {
                count++;
                row++;
            }
            row = colNum - 1;

            while (row >= 0 && grid[xAxi][row] == player) {
                count++;
                row--;
            }
            checkrun(count,player);

            // check vertical
            count = 0;
            int col = this.grid.length - 1;
            while (col < this.grid[0].length && this.grid[col][colNum] == player) {
                count++;
                col--;
            }
            checkrun(count,player);

            // check diagram run - bottom left to top right
            count = 0;
            row = xAxi;
            col = colNum - 1;
            while (row < board.getRow() && col >= 0 && this.grid[row][col] == player) {
                count++;
                row++;
                col--;
            }
            row = xAxi - 1;
            col = colNum;
            while (row >= 0 && col < board.getColumn() && this.grid[row][col] == player) {
                count++;
                row--;
                col++;
            }
            checkrun(count,player);
        }
        
        // check diagram run - top left to bottom right
        for(int xAxi = 0; xAxi < this.grid.length; xAxi++){
            int count = 0;
            int row, col;
            for(row = xAxi, col = 0; row < board.getRow() && col < board.getColumn(); row++, col++ ){
                if(this.grid[row][col] == player){
                    count++;
                    checkrun(count,player);
                }else 
                    count = 0;  
            }
        }
            
        for(int yAxi = 1; yAxi < this.grid.length - 5; yAxi++){
            int count = 0;
            int row, col;
            for(row = 0, col = yAxi; row < board.getRow() && col < board.getColumn(); row++, col++ ){
               if(this.grid[row][col] == player){
                   count++;
                   checkrun(count,player);
                }else 
                   count = 0;
            }
        }
    }
}

