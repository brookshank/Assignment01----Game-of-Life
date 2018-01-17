/**
 * @author Joseph Brooksbank
 * Driver class to run the simulation
 */
public class Driver {
    public static void main(String[] args) {
        /* Currently using first GameOfLife example sheet, can use any */
        String filename = "GameOfLife1.txt";
        /* Creating Environment object */
        Environment envo = new Environment(filename);

        /* Running simulation */
        envo.runSimulation();
    }
}
