import edu.princeton.cs.introcs.StdDraw;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Joseph Brooksbank
 * Class responsible for running the simulation
 */
public class Environment {
    /** The number of rows and columns of the current setting */
    private int rows, columns;
    /** An array of Cell objects, which represent organisms in the game */
    private Cell[][] cells;
    private Cell[][] test;

    Environment(String initConfig){
        /* A Scanner object to read setting files */
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new FileInputStream(initConfig));
        } catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(1);
        }
        this.rows = fileIn.nextInt();
        this.columns = fileIn.nextInt();
        cells = new Cell[rows][columns];

        //Assuming that the file is correct and have the correct number of entries
        int temp;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                temp = fileIn.nextInt();
                if (temp == 1) {
                    cells[i][j] = new Cell(true);
                } else {
                    cells[i][j] = new Cell(false);
                }
            }
        }

        fileIn.close();
        /* Setting up canvas to draw on */
        StdDraw.setCanvasSize(columns*20, rows*20);
        StdDraw.setXscale(0, columns);
        StdDraw.setYscale(0, rows);
        StdDraw.enableDoubleBuffering();
    }

    /**
     * A method, called from the driver, which runs the "game"
     */
    public void runSimulation(){

        for(;;) {
            drawBoard(cells);
            cells = nextBoard();
        }
    }

    /**
     * A method which draws the current state of the board using StdDraw
     */
    private void drawBoard(Cell[][] board){
        StdDraw.clear();

        //TODO ADD RULES:
        //RULE 1: Any living creature (occupied cell) with fewer than two live neighbors dies
        //RULE 2: Any creature with 2 or 3 neighbors lives
        //RULE 3: Any creature with more than 3 neighbors dies
        //RULE 4: Any empty cell with 3 neighbors becomes occupied

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){

                if(board[i][j].getOccupied()){
                    StdDraw.filledRectangle(0.5+ j, board.length - (0.5 + i), 0.5, 0.5);
                }
            }
        }
        StdDraw.show();
        StdDraw.pause(1000);
    }

    /**
     * A method for determining how many neighbors a coordinate in the array has
     * @param row       The INDEX of the position in the first array
     * @param column    The INDEX of the array in the first array
     * @return          The number of neighbors the given position has
     */
    private int numberOfNeighbors(int row, int column){
        int count = 0;



        for (int i = row-1; i < row+2; i++){
            for (int j = column -1; j < column+2; j++){
                if (i == row && j == column)
                    continue;

                // Counting places off of the board as uninhabited
                if (i >= rows || i <0 || j < 0 || j >= columns){
                    continue;
                }
                 if (cells[i][j].getOccupied())
                     count++;
            }
        }
        return count;
    }

    private Cell[][] nextBoard(){



        // Modifying a temp array while observing the "real" array, to make sure changes to the board do not effect
        // other cells of the same generation
        Cell[][] tempArray = new Cell[rows][columns];
        for (int i  = 0; i < tempArray.length; i++){
              tempArray[i] = cells[i].clone();
        }
        for (int i = 0; i < cells.length; i++){
            for (int j = 0; j < cells[i].length; j++){
                /* Any occupied cell with fewer than two live neighbors dies */
                if (cells[i][j].getOccupied() && numberOfNeighbors(i, j) < 2){
                    tempArray[i][j].setOccupied(false);
                }
                /* Any occupied cell with more than 3 neighbors dies */
                if (cells[i][j].getOccupied() && numberOfNeighbors(i,j) > 3){
                    tempArray[i][j].setOccupied(false);
                }

                /* Any unoccupied cell with exactly three neighbors becomes occupied */
                if (!cells[i][j].getOccupied() && numberOfNeighbors(i,j) == 3){
                    tempArray[i][j].setOccupied(true);
                }

            }
        }
        
        return tempArray;
    }
}
