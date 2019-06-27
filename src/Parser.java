import java.text.ParseException;

public class Parser {

    private String schema;

    private Parser(String schema) {
        this.schema = schema;
    }

    private boolean parseSchema() throws ParseException {
        for (String element : schema.split(",")) {
            if (element.length() > 0) {
                String trimmedElement = element.trim();
                parseSchemaElement(trimmedElement);
            }
        }
        return true;
    }

    private void parseSchemaElement(String element) throws ParseException {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);

        if (isSchemaElement(elementTail))
            parseSchemaElement(elementId);
        else
            throw new ParseException(String.format("Argument: %c has invalid format: %s.",
                    elementId, elementTail), 0);
    }

    private void validateSchemaElementId(char elementId) throws ParseException {
        if (!Character.isLetter(elementId)) {
            throw new ParseException("Bad character:" + elementId + "in Args format: " + schema, 0);
        }
    }

    /*private void parseBooleanSchemaElement(char elementId) {
        booleanArgs.put(elementId, false);
    }
    private void parseIntegerSchemaElement(char elementId) {
        intArgs.put(elementId, 0);
    }
    private void parseStringSchemaElement(char elementId) {
        stringArgs.put(elementId, "");
    }*/
    protected abstract void parserSchemaElement(char elementId);
}
