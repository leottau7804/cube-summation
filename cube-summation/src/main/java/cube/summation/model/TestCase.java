package cube.summation.model;

/**
 * Test case
 *
 * @author sergioleottau
 */
public class TestCase {

    /**
     * Operations array
     */
    private Operation[] operations;
    /**
     * Cube dimension
     */
    private int cubeDimension;
    /**
     * Operation amount
     */
    private int operationAmount;

    /**
     * Constructor with all attributes
     *
     * @param operations
     * @param cubeDimension
     * @param operationAmount
     */
    public TestCase(Operation[] operations, int cubeDimension, int operationAmount) {
        this.operations = operations;
        this.cubeDimension = cubeDimension;
        this.operationAmount = operationAmount;
    }

    /**
     * Default constructor
     */
    public TestCase() {
    }

    public Operation[] getOperations() {
        return operations;
    }

    public void setOperations(Operation[] operations) {
        this.operations = operations;
    }

    public int getCubeDimension() {
        return cubeDimension;
    }

    public void setCubeDimension(int cubeDimension) {
        this.cubeDimension = cubeDimension;
    }

    public int getOperationAmount() {
        return operationAmount;
    }

    public void setOperationAmount(int operationAmount) {
        this.operationAmount = operationAmount;
    }

    @Override
    public String toString() {
        return "TestCase{ cubeDimension=" + cubeDimension + ", operationAmount=" + operationAmount + '}';
    }

}
