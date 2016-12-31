package cube.summation.model;

/**
 * Update operation
 *
 * @author sergioleottau
 */
public class UpdateOperation implements Operation {

    /**
     * Coordinate to update
     */
    private Coordinate coordinate;
    /**
     * Value to update
     */
    private int value;

    public UpdateOperation(Coordinate coordinate, int value) {
        this.coordinate = coordinate;
        this.value = value;
    }

    public UpdateOperation() {
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UpdateOperation{" + "coordinate=" + coordinate + ", value=" + value + '}';
    }

}
