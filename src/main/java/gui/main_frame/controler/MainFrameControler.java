package gui.main_frame.controler;

import model.Patient;
import model.Sex;
import model.WorkerType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Author: Mariola
 * Date: 25.11.13
 */

public class MainFrameControler {
    private JTextField imieTF;
    private JTextField nazwiskoTF;
    private ButtonGroup buttonGroup;
    private JRadioButton kobietaRB;
    private JRadioButton mezczyznaRB;
    private JCheckBox ubezpieczonyChB;
    private JComboBox<WorkerType> zawodCB;
    private JTable tablePatient;

    class ZapiszListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (isFormComplete()) {
                Patient patient = getPatientFromFields();
                System.out.println(patient);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Uzupełnij wszystkie wymagane dane",
                        "Informacja",
                        JOptionPane.INFORMATION_MESSAGE);
            }


        }
    }

    class AnulujListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            cleanForm();
        }
    }

    class DodajListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Dodaj");
        }
    }

    class UsunListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Usuń");
        }
    }

    private boolean isFormComplete() {
        if (!imieTF.getText().isEmpty() &&
                !nazwiskoTF.getText().isEmpty() &&
                (kobietaRB.isSelected() || mezczyznaRB.isSelected())) {
            return true;
        }
        return false;
    }

    private void cleanForm() {
        imieTF.setText("");
        nazwiskoTF.setText("");
        buttonGroup.clearSelection();
        ubezpieczonyChB.setSelected(false);
        zawodCB.setSelectedIndex(0);
    }

    private Patient getPatientFromFields() {
        String imie = imieTF.getText();
        String nazwisko = nazwiskoTF.getText();
        Sex sex = getSexFromFields();
        boolean ubezpieczony = ubezpieczonyChB.isSelected();
        WorkerType workerType = zawodCB.getItemAt(zawodCB.getSelectedIndex());

        return new Patient(imie, nazwisko, sex, ubezpieczony, workerType);
    }

    private Sex getSexFromFields() {
        if (kobietaRB.isSelected()){
           return Sex.kobieta;
        } else {
           return Sex.mezczyzna;
        }
    }

    public void setImieTF(JTextField imieTF) {
        this.imieTF = imieTF;
    }

    public void setNazwiskoTF(JTextField nazwiskoTF) {
        this.nazwiskoTF = nazwiskoTF;
    }

    public void setKobietaRB(JRadioButton kobietaRB) {
        this.kobietaRB = kobietaRB;
    }

    public void setMezczyznaRB(JRadioButton mezczyznaRB) {
        this.mezczyznaRB = mezczyznaRB;
    }

    public void setUbezpieczonyChB(JCheckBox ubezpieczonyChB) {
        this.ubezpieczonyChB = ubezpieczonyChB;
    }

    public void setZawodCB(JComboBox<WorkerType> zawodCB) {
        this.zawodCB = zawodCB;
    }

    public void setZapiszBtn(JButton zapiszBtn) {
        zapiszBtn.addActionListener(new ZapiszListener());
    }

    public void setAnulujBtn(JButton anulujBtn) {
        anulujBtn.addActionListener(new AnulujListener());
    }

    public void setTablePatient(JTable tablePatient) {
        this.tablePatient = tablePatient;
    }

    public void setDodajBtn(JButton dodajBtn) {
        dodajBtn.addActionListener(new DodajListener());
    }

    public void setUsunBtn(JButton usunBtn) {
        usunBtn.addActionListener(new UsunListener());
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }
}