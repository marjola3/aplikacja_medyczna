package gui.main_frame.model;

import model.Patient;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Mariola
 * Date: 26.11.13
 */
public class PatientTableModel extends AbstractTableModel {
    String[] naglowki = {"Imię i nazwisko", "Płeć", "Ubezpieczony", "Zawód"};
    List<Patient> patientList;

    public PatientTableModel() {
        patientList = new ArrayList<Patient>();
    }

    public PatientTableModel(List<Patient> patientList) {
        if (patientList != null) {
            this.patientList = patientList;
        } else {
            this.patientList = new ArrayList<Patient>();
        }
    }

    public void addPatient(Patient patient) {
        patientList.add(patient);
        fireTableDataChanged(); // odświażanie widoku tabeli
    }

    public void removePatient(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < patientList.size()) {
            patientList.remove(rowIndex);
            fireTableDataChanged();
        }
    }

    @Override
    public int getRowCount() {
        return patientList.size();
    }

    @Override
    public String getColumnName(int column) {
        return naglowki[column];
    }

    @Override
    public int getColumnCount() {
        return naglowki.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                String imie = patientList.get(rowIndex).getImie();
                String nazwisko = patientList.get(rowIndex).getNazwisko();
                return imie + " " + nazwisko;
            case 1:
                return patientList.get(rowIndex).getPlec();
            case 2:
                return patientList.get(rowIndex).isUbezpieczony();
            case 3:
                return patientList.get(rowIndex).getWorkerType();
        }

        return null;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }
}
