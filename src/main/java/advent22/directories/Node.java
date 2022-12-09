package advent22.directories;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node {

    private String name;
    private String path;
    private int size = -1;
    private DirTreeNodeType dirTreeNodeType;

    private Node parent;
    private List<Node> children;

    public void addChild(Node child) {
        child.setParent(this);
        if (children == null) {
            children = new ArrayList<>();
        }
        if (children.contains(child)) {
            return;
        }
        children.add(child);
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        final Node other = (Node) o;
        if (!other.canEqual(this)) {
            return false;
        }
        return Objects.equals(this.getPath(), other.getPath());
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Node;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object path = this.getPath();
        result = result * PRIME + (path == null ? 43 : path.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return path;
    }
}
