package model;

/**
 * User: Mariola
 * Date: 19.11.13
 */
public class Patient {
    private String imie;
    private String nazwisko;
    private Sex plec;
    private boolean ubezpieczony;
    private WorkerType workerType;

    public Patient(String imie, String nazwisko, Sex plec, boolean ubezpieczony, WorkerType workerType) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.ubezpieczony = ubezpieczony;
        this.workerType = workerType;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Sex getPlec() {
        return plec;
    }

    public boolean isUbezpieczony() {
        return ubezpieczony;
    }

    public WorkerType getWorkerType() {
        return workerType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Patient{");
        sb.append("imie='").append(imie).append('\'');
        sb.append(", nazwisko='").append(nazwisko).append('\'');
        sb.append(", plec=").append(plec);
        sb.append(", ubezpieczony=").append(ubezpieczony);
        sb.append(", workerType=").append(workerType);
        sb.append('}');
        return sb.toString();
    }
}
