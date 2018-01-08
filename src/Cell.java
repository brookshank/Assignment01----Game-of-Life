/**
 * @author Joseph Brooksbank
 * Represents a single cell object
 */
public class Cell {
    private boolean occupied;

    Cell(boolean occupied){
        this.occupied = occupied;
    }

    boolean get_occupied(){
        return occupied;
    }

}
