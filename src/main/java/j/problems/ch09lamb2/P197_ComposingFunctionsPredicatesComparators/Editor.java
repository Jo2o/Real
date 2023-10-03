package j.problems.ch09lamb2.P197_ComposingFunctionsPredicatesComparators;

public final class Editor {

    private Editor() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static String addIntroduction(String article) {
        String articleIntroduction = article + "Introduction: ...";

        return articleIntroduction;
    }

    public static String addBody(String article) {
        String articleBody = article + "Body: ...";

        return articleBody;
    }

    public static String addConclusion(String article) {
        String articleEnd = article + "End: ...";

        return articleEnd;
    }

}