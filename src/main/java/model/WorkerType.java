package model;

/**
 * User: Mariola
 * Date: 16.11.13
 */
public enum WorkerType {
    student("Student"),
    pracownik_fizyczny("Pracownik fizyczny"),
    pracownik_umysłowy("Pracownik umysłowy");

    private String name;

    WorkerType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
