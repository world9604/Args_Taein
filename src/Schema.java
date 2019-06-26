import java.text.ParseException;

public abstract class Schema {
    private String schema;

    public Schema(String schema){
        this.schema = schema;
    }

    /*private boolean isStringSchemaElement(String elementTail) {
        return elementTail.equals("*");
    }
    private boolean isBooleanSchemaElement(String elementTail) {
        return elementTail.length() == 0;
    }
    private boolean isIntegerSchemaElement(String elementTail) {
        return elementTail.equals("#");
    }*/
    protected abstract boolean isSchemaElement(String elementTail);
}
