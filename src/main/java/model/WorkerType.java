package model;

/**
 * Author: Mariola
 * Date: 25.11.13
 */

public enum WorkerType {
    student("Student"),
    pracownik_fizyczny("Pracownik fizyczny"),
    pracownik_umyslowy("Pracownik umysłowy");

    private String name;

    WorkerType(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
