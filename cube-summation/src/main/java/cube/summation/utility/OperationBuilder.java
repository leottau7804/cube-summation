package cube.summation.utility;

import cube.summation.exception.CubeSummationException;
import cube.summation.model.Operation;
import cube.summation.model.OperationType;
import cube.summation.model.QueryOperation;
import cube.summation.model.UpdateOperation;
import java.util.regex.Pattern;

/**
 * Operation Builder
 *
 * @author sergioleottau
 */
public final class OperationBuilder {

    /**
     * Private constructor to avoid instantiation
     */
    private OperationBuilder() {
    }

    /**
     * Build a operation if the text match with an operation
     *
     * @param operationText operation text
     * @return the operation built, or thrwos an exception otherwise
     * @throws CubeSummationException
     */
    public static Operation build(String operationText) throws CubeSummationException {

        Operation operation;

        if (match(operationText, OperationType.UPDATE)) {
            operation = new UpdateOperation(operationText);
        } else if (match(operationText, OperationType.QUERY)) {
            operation = new QueryOperation(operationText);
        } else {
            throw new CubeSummationException("La siguiente operacion no es valida: "
                    + operationText);
        }

        return operation;
    }

    /**
     * Match the operation text given with an operation type.
     *
     * @param operationText operation text
     * @param operationType operation type.
     * @return true if match, or false otherwise
     */
    private static boolean match(String operationText, OperationType operationType) {
        Pattern pattern = Pattern.compile(operationType.getPattern());
        return pattern.matcher(operationText).matches();
    }

}
