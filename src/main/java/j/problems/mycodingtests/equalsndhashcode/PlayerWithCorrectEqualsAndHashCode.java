package j.problems.mycodingtests.equalsndhashcode;

import java.util.Objects;

public class PlayerWithCorrectEqualsAndHashCode {
    
    private int id;
    private String name;

    public PlayerWithCorrectEqualsAndHashCode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerWithCorrectEqualsAndHashCode that = (PlayerWithCorrectEqualsAndHashCode) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);

//        int hash = 7;
//        hash = 79 * hash + this.id;
//        hash = 79 * hash + Objects.hashCode(this.name); // hashCode for objects
//        return hash;
    }
    
    
}
