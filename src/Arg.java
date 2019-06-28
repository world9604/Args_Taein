import java.text.ParseException;

public interface Arg <T> {
    boolean isSchemaElement(String elementTail);
    void put(char elementId, T value);
}
