public class GameBoard
{
    private String grid[][];
    private int row = 0;
    private int column = 0;

    public GameBoard(int row, int column) {
        this.row = row;
        this.column = column;
        this.grid = new String[row][column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String[][] getConnectFour() {
        return grid;
    }

    public void setupGBoard() {
        
        // initialize whole game board as 0
        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[row].length; col++) {

                this.grid[row][col] = "O";

            }
        }
    }

    public void printGBoard() {
        int tRow = 0;
        int tCloumn = 0;

        tRow = grid.length; 
        tRow--;
        for (int row = 0; row < this.grid.length; row++, tRow--) {
            System.out.print(tRow +" : ");
            for (int col = 0; col < this.grid[row].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println("");
        }
        
        tCloumn = grid[0].length;
        System.out.print("    ");
        for (int i = 0; i < (tCloumn * 2 - 1); i++) {
            System.out.print("-");
        }
        
        System.out.print("\n    ");
        for (int count = 0; count < this.grid[0].length; count++) {
            if (count == grid[0].length) {
                System.out.print("\n");
            }else {
                System.out.print(count + " ");
        }
        }
    }
    
    public void updateBoard(int column, String player) {
            for (int col = this.grid.length -1; col >= 0; col--) {

            if (this.grid[col][column ] == "O") {
                this.grid[col][column ] = player;
                break;
            }
        }
    }
}
