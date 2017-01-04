package cube.summation.service.impl;

import cube.summation.model.Operation;
import cube.summation.model.QueryOperation;
import cube.summation.model.TestCase;
import cube.summation.model.UpdateOperation;
import cube.summation.service.ITestCaseProcessor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * Test case processor
 *
 * @author sergioleottau
 */
@Service
public class TestCaseProcessor implements ITestCaseProcessor {

    /**
     * First index constant
     */
    private static final int FIRST_INDEX = 0;
    
    /**
     * {@inheritDoc}
     *
     * @param testCase test case object
     * @return the output of the text case
     */
    @Override
    public String process(TestCase testCase) {

        StringBuilder result = new StringBuilder();
        int operationIndex = 0;
        for (Operation operation : testCase.getOperations()) {

            if (operation instanceof QueryOperation) {

                QueryOperation queryOperation = (QueryOperation) operation;

                result.append(updateOperationSummation(
                        Arrays.copyOfRange(testCase.getOperations(), FIRST_INDEX,
                                operationIndex), queryOperation));
                result.append(System.lineSeparator());
            }
            operationIndex++;
        }
        return result.toString();
    }    

    /**
     * Update operation summation process
     *
     * @param operations
     * @param queryOperation
     * @return summations
     */
    private long updateOperationSummation(Operation[] operations,
            QueryOperation queryOperation) {

        Map<String, Integer> updates = new HashMap<>();
        long cubeSummation = 0;        

        for (Operation operation : operations) {
            if (operation instanceof UpdateOperation) {

                UpdateOperation updateOperation = (UpdateOperation) operation;

                if (queryOperation.isInside(updateOperation.getCoordinate())) {

                    String key = updateOperation.getCoordinate().generateKey();
                    Integer value = updates.get(key);

                    if (value != null) {
                        cubeSummation -= value;
                    }

                    updates.put(key, updateOperation.getValue());
                    cubeSummation += updateOperation.getValue();

                }

            }
        }

        return cubeSummation;
    }
}
