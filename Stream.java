import java.util.Iterator;
import java.util.List;

public class Stream implements Iterable<Group> {
    private List<Group> groups;

    public Stream(List<Group> groups) {
        this.groups = groups;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public Iterator<Group> iterator() {
        return groups.iterator();
    }
}
