public class BooleanArg implements Arg {
    private boolean args;
    private String schema;

    public BooleanArg(boolean args, String schema) {
        this.args = args;
        this.schema = schema;
    }

    @Override
    public boolean isSchemaElement(String elementTail) {
        return elementTail.length() == 0;
    }
}
