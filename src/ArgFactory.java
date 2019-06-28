public class ArgFactory {
    public static Arg createArgBy (String elementTail) {
        if (elementTail.equals("*")) {
            return new StringArg();
        }

        if (elementTail.equals("#")) {
            return new BooleanArg();
        }

        if (elementTail.length() == 0) {
            return new IntegerArg();
        }

        return new NullArg();
    }
}