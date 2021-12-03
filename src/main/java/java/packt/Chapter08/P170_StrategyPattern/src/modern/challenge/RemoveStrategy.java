package java.packt.Chapter08.P170_StrategyPattern.src.modern.challenge;

@FunctionalInterface
public interface RemoveStrategy {

    String execute(String s);
}
