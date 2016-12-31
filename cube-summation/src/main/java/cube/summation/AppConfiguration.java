package cube.summation;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Application Spring configuration
 * @author sergioleottau
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = {"cube.summation"}, excludeFilters = {
    @ComponentScan.Filter(value = {Configuration.class})})
@Configuration
public class AppConfiguration {

}
