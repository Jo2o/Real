package j.problems.ch08lamb1.P170_StrategyPattern;

@FunctionalInterface
public interface RemoveStrategy {

    String execute(String s);
}
