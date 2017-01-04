package cube.summation.service;

import cube.summation.exception.CubeSummationException;

/**
 * Cube summation processor
 *
 * @author sergioleottau
 */
public interface ISummationProcessor {

    /**
     * Method in charge to process the input text and execute
     *
     * @param input
     * @return output
     */
    String process(String input)throws CubeSummationException;

}
