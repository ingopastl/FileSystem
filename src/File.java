public class File extends Entity {
    private String extension;
    private String path;

    File(String name, String extension) {
        super(name);
        this.extension = extension;
    }
}
