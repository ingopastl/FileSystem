class Memory {
    private static final Directory root = new Directory();

    static Directory getRoot() {
        return Memory.root;
    }
}
