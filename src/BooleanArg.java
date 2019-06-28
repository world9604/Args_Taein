import java.util.HashMap;
import java.util.Map;

public class BooleanArg implements Arg <Boolean>{
    private Map<Character, Boolean> args = new HashMap<>();

    public BooleanArg() {
    }

    @Override
    public boolean isSchemaElement(String elementTail) {
        return elementTail.length() == 0;
    }

    @Override
    public void put(char elementId, Boolean value) {
//        args.put(elementId, false);
        args.put(elementId, value);
    }
}
