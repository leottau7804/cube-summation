package cube.summation.model;

import cube.summation.exception.CubeSummationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public UpdateOperation(String operationText) throws CubeSummationException {

        Pattern pattern = Pattern.compile(OperationType.UPDATE.getPattern());
        Matcher matcher = pattern.matcher(operationText);
        
        if (matcher.matches()) {
            coordinate = new Coordinate(Integer.parseInt(matcher.group(2)),
                    Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));

            value = Integer.parseInt(matcher.group(5));
        } else {
            throw new CubeSummationException("La siguiente operacion no es valida: "
                    + operationText);
        }

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
