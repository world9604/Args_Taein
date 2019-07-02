import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class StringArgumentMarshaler implements ArgumentMarshaler {
//    private Map<Character, String> args = new HashMap<>();
    private String stringValue;

/*    @Override
    public boolean isSchemaElement(String elementTail) {
        return elementTail.equals("*");
    }

    @Override
    public void put(char elementId, String value) {
//        args.put(elementId, "");
        args.put(elementId, args[value]);
    }*/

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringValue = currentArgument.next();
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    public static String getValue(ArgumentMarshaler am) {
        if (am instanceof StringArgumentMarshaler)
            return ((StringArgumentMarshaler) am).stringValue;
        else
            return "";
    }
}
