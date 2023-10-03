package j.problems.ch08lamb1.P170_StrategyPattern;

public class WhitespacesRemover implements RemoveStrategy {

    @Override
    public String execute(String s) {
        return s.replaceAll("\\s", "");
    }

}
