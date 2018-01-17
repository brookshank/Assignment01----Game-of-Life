/**
 * @author Joseph Brooksbank
 * Represents a single cell object
 */
public class Cell {
    /** Whether or not the cell is currently occupied */
    private boolean occupied;

    /**
     * Constructor that initializes with current occupation status
     * @param occupied      Whether or not the cell is occupied at start
     */
    Cell(boolean occupied){
        this.occupied = occupied;
    }

    /**
     * Getter method for occupation status
     * @return      whether or not the cell is currently occupied
     */
    boolean getOccupied(){
        return occupied;
    }

    /**
     * A Setter method for occupation status
     * @param occupied      whether or not the cell is going to be occupied
     */
    void setOccupied(boolean occupied){
        this.occupied = occupied;
    }

}
