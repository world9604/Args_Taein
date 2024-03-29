import java.util.*;

public class Args {
//    private String schema;
    private Map<Character, ArgumentMarshaler> marshalers;
    private Set<Character> argsFound;
    private ListIterator<String> currentArgument;
/*    private int currentArgument;
    private char errorArgumentId = '\0';
    private String errorParameter = "TILT";
    private ErrorCode errorCode = ErrorCode.OK;*/

    public Args(String schema, String[] args) throws ArgsException {
        this.marshalers = new HashMap<>();
        this.argsFound = new HashSet<>();

        parseSchema(schema);
        parseArgumentStrings(Arrays.asList(args));
    }

    private void parseSchema(String schema) throws ArgsException{
        for (String element : schema.split(",")) {
            if (element.length() > 0)
                parseSchemaElement(element.trim());
        }
    }

    private boolean parseSchemaElement(String element) throws ArgsException {
        char elementId = element.charAt(0);
        String elementTail = element.substring(1);
        validateSchemaElementId(elementId);

        if (elementTail.length() == 0)
            marshalers.put(elementId, new BooleanArgumentMarshaler());
        else if(elementTail.equals("*"))
            marshalers.put(elementId, new StringArgumentMarshaler());
        else if(elementTail.equals("#"))
            marshalers.put(elementId, new IntegerArgumentMarshaler());
        else
            throw new ArgsException(ArgsException.ErrorCode.INVALID_ARGUMENT_FORMAT, elementId, elementTail);
    }

    private void validateSchemaElementId(char elementId) throws ArgsException {
        if (!Character.isLetter(elementId))
            throw new ArgsException(ArgsException.ErrorCode.INVALID_ARGUMENT_NAME, elementId, null);
    }

    private void parseArgumentStrings(List<String> argsList) throws ArgsException {
        for (currentArgument = argsList.listIterator(); currentArgument.hasNext();){
            String argString = currentArgument.next();
            if (argString.startsWith("-")) {
                parseArgumentCharacters(argString.substring(1));
            } else {
                currentArgument.previous();
                break;
            }
        }
    }

    private void parseArgumentCharacters(String argChars) throws ArgsException{
        for (int i = 0; i < argChars.length(); i++) {
            parseArgumentCharacter(argChars.charAt(i));
        }
    }

    private void parseArgumentCharacter(char argChar) throws ArgsException {
        ArgumentMarshaler m = marshalers.get(argChar);
        if (m == null) {
            throw new ArgsException(ArgsException.ErrorCode.UNEXPECTED_ARGUMENT, argChar, null);
        } else {
            argsFound.add(argChar);
            try {
                m.set(currentArgument);
            } catch (ArgsException e) {
                e.setErrorArgumentId(argChar);
                throw e;
            }
        }
    }

    public boolean has(char arg) {
        return argsFound.contains(arg);
    }

    public int nextArgument() {
        return currentArgument.nextIndex();
    }

    public boolean getBoolean(char arg) {
        return BooleanArgumentMarshaler.getValue(marshalers.get(arg));
    }

    public String getString(char arg) {
        return StringArgumentMarshaler.getValue(marshalers.get(arg));
    }

    public int getInt(char arg) {
        return IntegerArgumentMarshaler.getValue(marshalers.get(arg));
    }

}