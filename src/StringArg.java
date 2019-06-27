public class StringArg implements Arg {
    private String args;
    private String schema;

    public StringArg(String schema, String args) {
        this.schema = schema;
        this.args = args;
    }

    @Override
    public boolean isSchemaElement(String elementTail) {
        return elementTail.equals("*");
    }
}
