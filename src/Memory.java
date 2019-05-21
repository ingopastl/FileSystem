class Memory {
    private static final Directory root = new Directory("root");

    static Directory getRoot() {
        return Memory.root;
    }
}
