
public class NullArg implements Arg {
    @Override
    public boolean isSchemaElement(String elementTail) {
        return false;
    }

    @Override
    public void put(char elementId, Object value) {

    }
}
