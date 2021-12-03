package java.packt.Chapter08.P170_StrategyPattern.src.modern.challenge;

public class WhitespacesRemover implements RemoveStrategy {

    @Override
    public String execute(String s) {
        return s.replaceAll("\\s", "");
    }

}
