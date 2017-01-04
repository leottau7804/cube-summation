package cube.summation.service.impl;

import cube.summation.exception.CubeSummationException;
import cube.summation.model.Operation;
import cube.summation.model.TestCase;
import cube.summation.service.ISummationProcessor;
import cube.summation.service.ITestCaseProcessor;
import cube.summation.utility.OperationBuilder;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Summation processor
 *
 * @author sergioleottau
 */
@Service
public class SummationProcessor implements ISummationProcessor {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SummationProcessor.class);
    /**
     * Test case processor
     */
    @Autowired
    private ITestCaseProcessor testCaseProcessor;

    /**
     * {@inheritDoc}
     *
     * @param input text input
     * @return text output
     * @throws CubeSummationException in case of and validation error
     */
    @Override
    public String process(String input) throws CubeSummationException {

        StringBuilder output = new StringBuilder();

        try (ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
                InputStreamReader isr = new InputStreamReader(bais);
                BufferedReader br = new BufferedReader(isr)) {

            int t = Integer.parseInt(br.readLine());
            LOGGER.debug("Test case amount: {}", t);

            for (int i = 0; i < t; i++) {
                LOGGER.debug("Case : {}", i);

                String[] nXm = br.readLine().split(StringUtils.SPACE);
                int n = Integer.parseInt(nXm[0]);
                int m = Integer.parseInt(nXm[1]);
                LOGGER.debug("Case : n [{}] m [{}]", n, m);

                Operation[] operations = new Operation[m];
                for (int j = 0; j < m; j++) {
                    operations[j] = OperationBuilder.build(br.readLine());
                }

                TestCase testCase = new TestCase(operations, n, m);
                output.append(testCaseProcessor.process(testCase));
            }

        } catch (CubeSummationException e) {
            throw e;
        } catch (Exception e) {
            throw new CubeSummationException("No es posible interpretar el texto", e);
        }

        return output.toString();
    }

}
