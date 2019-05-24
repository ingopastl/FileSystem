public class SystemObject {
    private String name;
    private int memoryPosition;

    SystemObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemoryPosition() {
        return memoryPosition;
    }

    public void setMemoryPosition(int memoryPosition) {
        this.memoryPosition = memoryPosition;
    }
}
