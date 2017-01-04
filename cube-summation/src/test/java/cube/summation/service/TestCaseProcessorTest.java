package cube.summation.service;

import cube.summation.exception.CubeSummationException;
import cube.summation.model.Operation;
import cube.summation.model.OperationType;
import cube.summation.model.QueryOperation;
import cube.summation.model.TestCase;
import cube.summation.model.UpdateOperation;
import cube.summation.service.impl.TestCaseProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit test to the service TestCaseProcessor
 *
 * @author sergioleottau
 */
@RunWith(MockitoJUnitRunner.class)
public class TestCaseProcessorTest extends Mockito {

    /**
     * Service to test
     */
    private final ITestCaseProcessor testCaseProcessor = new TestCaseProcessor();

    /**
     * Test case sucessful
     *
     * @throws CubeSummationException
     */
    @Test
    public void case1_sucessfulTest() throws CubeSummationException {

        TestCase testCase = new TestCase();
        testCase.setCubeDimension(5);
        testCase.setOperationAmount(2);

        Operation[] operations = new Operation[5];
        operations[0] = buildOperation(OperationType.UPDATE, "UPDATE 2 2 2 4");
        operations[1] = buildOperation(OperationType.QUERY, "QUERY 1 1 1 3 3 3");
        operations[2] = buildOperation(OperationType.UPDATE, "UPDATE 1 1 1 23");
        operations[3] = buildOperation(OperationType.QUERY, "QUERY 2 2 2 4 4 4");
        operations[4] = buildOperation(OperationType.QUERY, "QUERY 1 1 1 3 3 3");

        testCase.setOperations(operations);

        String output = testCaseProcessor.process(testCase);

        Assert.assertEquals("4\n4\n27\n", output);
    }

    /**
     * Build an operation according to the type given
     *
     * @param operationType operation type
     * @return operations
     */
    private Operation buildOperation(OperationType operationType, String operationText) throws CubeSummationException {

        Operation operation = null;

        switch (operationType) {
            case QUERY:
                operation = new QueryOperation(operationText);
                break;
            case UPDATE:
                operation = new UpdateOperation(operationText);
                break;
            default:
                throw new AssertionError();
        }

        return operation;
    }

}
