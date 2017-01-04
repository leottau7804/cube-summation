package cube.summation.service;

import cube.summation.model.TestCase;

/**
 * Test case processor
 * @author sergioleottau
 */
public interface ITestCaseProcessor {

    /**
     * Process a test case and return query operations results
     *
     * @param testCase test case to process
     * @return querys results
     */
    String process(TestCase testCase);

}
