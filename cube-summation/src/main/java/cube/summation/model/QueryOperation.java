package cube.summation.model;

import cube.summation.exception.CubeSummationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public QueryOperation(String operationText) throws CubeSummationException {

        Pattern pattern = Pattern.compile(OperationType.QUERY.getPattern());
        Matcher matcher = pattern.matcher(operationText);

        if (matcher.matches()) {
            initialCoordinate = new Coordinate(Integer.parseInt(matcher.group(2)),
                    Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));

            finalCoordinate = new Coordinate(Integer.parseInt(matcher.group(5)),
                    Integer.parseInt(matcher.group(6)), Integer.parseInt(matcher.group(7)));
        } else {
            throw new CubeSummationException("La siguiente operacion no es valida: "
                    + operationText);
        }

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

    public boolean isInside(Coordinate coordinate) {

        boolean x = coordinate.getX() >= initialCoordinate.getX() && coordinate.getX() <= finalCoordinate.getX();
        boolean y = coordinate.getY() >= initialCoordinate.getY() && coordinate.getY() <= finalCoordinate.getY();
        boolean z = coordinate.getZ() >= initialCoordinate.getZ() && coordinate.getZ() <= finalCoordinate.getZ();

        return x && y && z;
    }

    @Override
    public String toString() {
        return "QueryOperation{" + "initialCoordinate=" + initialCoordinate + ", finalCoordinate=" + finalCoordinate + '}';
    }

}
