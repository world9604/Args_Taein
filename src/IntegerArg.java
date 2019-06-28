import java.util.HashMap;
import java.util.Map;

public class IntegerArg implements Arg <Integer> {
    private Map<Character, Integer> args = new HashMap<>();

    public IntegerArg() {
    }

    @Override
    public boolean isSchemaElement(String elementTail) {
        return elementTail.equals("#");
    }

    @Override
    public void put(char elementId, Integer value) {
//        args.put(elementId, 0);
        args.put(elementId, new Integer(value));
    }
}