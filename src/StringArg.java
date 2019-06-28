import java.util.HashMap;
import java.util.Map;

public class StringArg implements Arg <String> {
    private Map<Character, String> args = new HashMap<>();

    public StringArg() {
    }

    @Override
    public boolean isSchemaElement(String elementTail) {
        return elementTail.equals("*");
    }

    @Override
    public void put(char elementId, String value) {
//        args.put(elementId, "");
        args.put(elementId, args[value]);
    }
}
