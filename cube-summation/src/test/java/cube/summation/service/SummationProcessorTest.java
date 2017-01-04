package cube.summation.service;

import cube.summation.exception.CubeSummationException;
import cube.summation.model.TestCase;
import cube.summation.service.impl.SummationProcessor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit test to the service SummationProcessor
 *
 * @author sergioleottau
 */
@RunWith(MockitoJUnitRunner.class)
public class SummationProcessorTest extends Mockito {

    /**
     * Test case processor
     */
    @Mock
    private ITestCaseProcessor testCaseProcessor;

    /**
     * Service to test
     */
    @InjectMocks
    private final ISummationProcessor summationProcessor = new SummationProcessor();

    /**
     * Test case sucessful
     *
     * @throws CubeSummationException
     */
    @Test
    public void case1_sucessfulTest() throws CubeSummationException {

        StringBuilder sb = new StringBuilder();
        sb.append("1\r\n");
        sb.append("4 5\r\n");
        sb.append("UPDATE 2 2 2 4\r\n");
        sb.append("QUERY 1 1 1 3 3 3\r\n");
        sb.append("UPDATE 1 1 1 23\r\n");
        sb.append("QUERY 2 2 2 4 4 4\r\n");
        sb.append("QUERY 1 1 1 3 3 3\r\n");        

        StringBuilder expectedOutput = new StringBuilder();
        expectedOutput.append("4\r\n");
        expectedOutput.append("4\r\n");
        expectedOutput.append("27\r\n");        

        when(this.testCaseProcessor.
                process(any(TestCase.class))).thenReturn("4\r\n4\r\n27\r\n");

        String output = summationProcessor.process(sb.toString());

        Assert.assertEquals(expectedOutput.toString(), output);
    }
    
    /**
     * Test case sucessful
     *
     * @throws CubeSummationException
     */
    @Test(expected = CubeSummationException.class)
    public void case2_failTest() throws CubeSummationException {

        StringBuilder sb = new StringBuilder();
        sb.append("1\r\n");
        sb.append("4      5\r\n");//Too much space
        sb.append("UPDATE 2 2 2 4\r\n"); 
        sb.append("QUERY 1 1 1 3 3 3\r\n");
        sb.append("UPDATE 1 1 1 23\r\n");
        sb.append("QUERY 2 2 2 4 4 4\r\n");
        sb.append("QUERY 1 1 1 3 3 3\r\n");                      

        when(this.testCaseProcessor.
                process(any(TestCase.class))).thenReturn("4\r\n4\r\n27\r\n");

        summationProcessor.process(sb.toString());        
    }

}
