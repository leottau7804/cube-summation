package cube.summation.controller;

import cube.summation.exception.CubeSummationException;
import cube.summation.service.ISummationProcessor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sergioleottau
 */
@Controller
@RequestMapping(path = {"/cube"})
public class CubeSummationController {

    /**
     * Logger de la clase.
     */
    private static final Logger LOGGER = Logger.getLogger(CubeSummationController.class);

    @Autowired
    private ISummationProcessor summationProcessor;

    @RequestMapping(method = {RequestMethod.POST}, headers = {"accept=text/plain;charset=UTF-8"})
    public ResponseEntity<String> summation(
            @RequestBody(required = true) String input) {
        ResponseEntity response;
        try {
            String result = summationProcessor.process(input);
            response = new ResponseEntity(
                    (Object) result, HttpStatus.OK);
        } catch (CubeSummationException e) {
            LOGGER.error("Cube summation error", e);
            response = new ResponseEntity(
                    (Object) e.getMessage(),
                    HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            LOGGER.error("Unexpected error", e);
            response = new ResponseEntity(
                    (Object) "Error inesperado ",
                    HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
