package cube.summation.model;

/**
 * Query operation
 *
 * @author sergioleottau
 */
public class QueryOperation implements Operation {

    /**
     * Initial coordinate
     */
    private Coordinate initialCoordinate;
    /**
     * Final coordinate
     */
    private Coordinate finalCoordinate;

    /**
     * Full constructor
     *
     * @param initialCoordinate
     * @param finalCoordinate
     */
    public QueryOperation(Coordinate initialCoordinate, Coordinate finalCoordinate) {
        this.initialCoordinate = initialCoordinate;
        this.finalCoordinate = finalCoordinate;
    }

    /**
     * Default constructor
     */
    public QueryOperation() {
    }

    public Coordinate getInitialCoordinate() {
        return initialCoordinate;
    }

    public void setInitialCoordinate(Coordinate initialCoordinate) {
        this.initialCoordinate = initialCoordinate;
    }

    public Coordinate getFinalCoordinate() {
        return finalCoordinate;
    }

    public void setFinalCoordinate(Coordinate finalCoordinate) {
        this.finalCoordinate = finalCoordinate;
    }

    @Override
    public String toString() {
        return "QueryOperation{" + "initialCoordinate=" + initialCoordinate + ", finalCoordinate=" + finalCoordinate + '}';
    }

}
