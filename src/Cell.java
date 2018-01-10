/**
 * @author Joseph Brooksbank
 * Represents a single cell object
 */
public class Cell {
    private boolean occupied;

    Cell(boolean occupied){
        this.occupied = occupied;
    }

    boolean getOccupied(){
        return occupied;
    }

    void setOccupied(boolean occupied){
        this.occupied = occupied;
    }

}
