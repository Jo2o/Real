package j.problems.ch01strs.P08_RemoveWhitespacesFromString;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String removeWhitespaces(String str) {

        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        return str.replaceAll("\\s", "");
    }

}
