package cube.summation.model;

/**
 * Operation type enumeration
 *
 * @author sergioleottau
 */
public enum OperationType {

    /**
     * Update operation type.
     */
    UPDATE("^(UPDATE) (\\d*)\\s(\\d*)\\s(\\d*)\\s(\\d*)$"),
    /**
     * Query operation type.
     */
    QUERY("^(QUERY) (\\d*)\\s(\\d*)\\s(\\d*)\\s(\\d*)\\s(\\d*)\\s(\\d*)$");

    /**
     * Operation pattern
     */
    private final String pattern;

    /**
     * Constructor
     *
     * @param pattern operation pattern
     */
    private OperationType(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

}
