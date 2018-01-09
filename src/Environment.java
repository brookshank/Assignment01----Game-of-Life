import edu.princeton.cs.introcs.StdDraw;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Joseph Brooksbank
 * Class responsible for running the simulation
 */
public class Environment {
    private int rows, columns;
    private Cell[][] cells;
    private Scanner fileIn = null;

    Environment(String initConfig){
        //TODO read initial settings from file
        // for now, using static config

        // These will be replaced with settings from file

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

        /* Setting up canvas to draw on */
        StdDraw.setCanvasSize(columns*20, rows*20);
        StdDraw.setXscale(0, columns);
        StdDraw.setYscale(0, rows);
    }



    public void runSimulation(){




    }

    private void drawBoard(){

        //TODO ADD RULES:
        //RULE 1: Any living creature (occupied cell) with fewer than two live neighbors dies
        //RULE 2: Any creature with 2 or 3 neighbors lives
        //RULE 3: Any creature with more than 3 neighbors dies
        //RULE 4: Any empty cell with 3 neighbors becomes occupied 

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){

                if(cells[i][j].get_occupied()){
                    StdDraw.filledRectangle(0.5+ j, rows - (0.5 + i), 0.5, 0.5);
                }
            }
        }

    }

}
