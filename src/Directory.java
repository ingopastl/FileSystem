import java.util.ArrayList;
import java.util.List;

public class Directory extends SystemObject {
    private List<File> childs;

    Directory (String name) {
        super(name);
        this.childs = new ArrayList<>();
    }
}
