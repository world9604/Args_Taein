import java.text.ParseException;
import java.util.Iterator;

public interface ArgumentMarshaler {
//    boolean isSchemaElement(String elementTail);
//    void put(char elementId, T value);
    void set(Iterator<String> currentArgument) throws ArgsException;
}
