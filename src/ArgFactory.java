public class ArgFactory {
    public static ArgumentMarshaler createArgBy (String elementTail) {
        if (elementTail.equals("*")) {
            return new StringArgumentMarshaler();
        }

        if (elementTail.equals("#")) {
            return new BooleanArgumentMarshaler();
        }

        if (elementTail.length() == 0) {
            return new IntegerArgumentMarshaler();
        }

        return new NullArgumentMarshaler();
    }
}