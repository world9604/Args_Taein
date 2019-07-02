import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class IntegerArgumentMarshaler implements ArgumentMarshaler {
//    private Map<Character, Integer> args = new HashMap<>();
    private int intValue;

/*    @Override
    public boolean isSchemaElement(String elementTail) {
        return elementTail.equals("#");
    }

    @Override
    public void put(char elementId, Integer value) {
//        args.put(elementId, 0);
        args.put(elementId, new Integer(value));
    }*/

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        String parameter = null;
        try {
            parameter = currentArgument.next();
            intValue = Integer.parseInt(parameter);
        } catch (NoSuchElementException e) {
            throw new ArgsException(ArgsException.ErrorCode.MISSING_INTEGER);
        } catch (NumberFormatException e) {
            throw new ArgsException(ArgsException.ErrorCode.INVALID_INTEGER, parameter);
        }
    }

    public static int getValue(ArgumentMarshaler am) {
        if (am instanceof IntegerArgumentMarshaler)
            return ((IntegerArgumentMarshaler) am).intValue;
        else
            return 0;
    }
}