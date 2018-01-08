import edu.princeton.cs.introcs.StdDraw;

/**
 * @author Joseph Brooksbank
 * Class responsible for running the simulation
 */
public class Environment {
    private int rows, columns;
    private Cell[][] cells;

    Environment(String initConfig){
        //TODO read initial settings from file
        // for now, using static config

        // These will be replaced with settings from file
        this.rows = 5;
        this.columns = 5;

        /* Setting up canvas to draw on */
        //TODO figure out how to set scale so that each cell is 1x1 in coords
        StdDraw.setCanvasSize(columns*20, rows*20);
        StdDraw.setXscale(0, columns*20);
        StdDraw.setYscale(0, rows*20);



    }

    public void runSimulation(){
        //TODO do something
    }

}
