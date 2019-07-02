import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BooleanArgumentMarshaler implements ArgumentMarshaler {
//    private Map<Character, Boolean> args = new HashMap<>();
    private boolean booleanValue = false;

/*
    @Override
    public boolean isSchemaElement(String elementTail) {
        return elementTail.length() == 0;
    }
*/

    /*@Override
    public void put(char elementId, Boolean value) {
//        args.put(elementId, false);
        args.put(elementId, value);
    }*/

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        booleanValue = true;
    }

    public static boolean getValue(ArgumentMarshaler am) {
        if (am instanceof BooleanArgumentMarshaler)
            return ((BooleanArgumentMarshaler) am).booleanValue;
        else
            return false;
    }
}
