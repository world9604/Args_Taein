public class IntergerArg implements Arg {
    private int args;
    private String schema;

    public IntergerArg(String schema, int args) {
        this.schema = schema;
        this.args = args;
    }

    @Override
    public boolean isSchemaElement(String elementTail) {
        return elementTail.equals("#");
    }
}
