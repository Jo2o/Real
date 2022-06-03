package j.problems.ch08.P170_StrategyPattern;

@FunctionalInterface
public interface RemoveStrategy {

    String execute(String s);
}
