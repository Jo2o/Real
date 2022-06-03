package j.problems.mycodingtests.equalsndhashcode;

import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        Player player01 = new Player(1, "Rafael");
        Player player02 = new Player(1, "Rafael");
        log.info("Equality for Player: {}", player01.equals(player02));
        log.info("Player1 hashCode: {}", player01.hashCode());
        log.info("Player1 hashCode: {}", player02.hashCode());
        
        PlayerWithCorrectEqualsAndHashCode playerWithCorrectEqualsAndHashCode01 = new PlayerWithCorrectEqualsAndHashCode(1, "Rafael");
        PlayerWithCorrectEqualsAndHashCode playerWithCorrectEqualsAndHashCode02 = new PlayerWithCorrectEqualsAndHashCode(1, "Rafael");
        log.info("Equality for PlayerWithCorrectEqualsAndHashCode: {}", playerWithCorrectEqualsAndHashCode01.equals(playerWithCorrectEqualsAndHashCode02));

        Set<Player> players = Set.of(player01, player02); // <<<< also a problem 2 equal objects in the SET
        log.info("Set size: {}", players.size());
        log.info("Contains player01: {}", players.contains(player01));
        log.info("Contains new same player: {}", players.contains(new Player(1, "Rafael"))); // <<<< this is important, therefore hashCode needs to be overridden too

        Set<PlayerWithCorrectEqualsAndHashCode> playersWithCorrectEqualsAndHashCode = Set.of(playerWithCorrectEqualsAndHashCode01); //, playerWithCorrectEqualsAndHashCode02);
        log.info("Set size: {}", playersWithCorrectEqualsAndHashCode.size());
        log.info("Contains player01: {}", playersWithCorrectEqualsAndHashCode.contains(playerWithCorrectEqualsAndHashCode01));
        log.info("Contains new same player: {}", playersWithCorrectEqualsAndHashCode.contains(new PlayerWithCorrectEqualsAndHashCode(1, "Rafael")));
    }
}
