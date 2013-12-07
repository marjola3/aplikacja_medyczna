package gui.main_frame.controler;

import gui.main_frame.model.PatientTableModel;
import model.Patient;
import model.Sex;
import model.WorkerType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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

    public MainFrameControler() {
        KeyboardFocusManager manager =
                KeyboardFocusManager.getCurrentKeyboardFocusManager();

        manager.addKeyEventDispatcher(new MyCtrlSDispatcher());
        manager.addKeyEventDispatcher(new MyCtrlQDispatcher());
    }

    class MyCtrlSDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_S  && e.isControlDown() ) {
                //TODO dodać zapisywanie listy pacjentów do pliku
            }
            return false;
        }
    }

    class MyCtrlQDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_Q  && e.isControlDown()) {
                System.exit(0);
            }
            return false;
        }
    }

    class ZapiszListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isFormComplete()) {
                Patient patient = getPatientFromFields();
                PatientTableModel model = (PatientTableModel) tablePatient.getModel();
                model.addPatient(patient);
                cleanForm();
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
            if (tablePatient.getSelectedRow() != -1) {
                PatientTableModel model = (PatientTableModel) tablePatient.getModel();
                model.removePatient(tablePatient.getSelectedRow());
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Nie zaznaczono wiersza",
                        "Informacja",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    class ZapiszMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class ZamknijMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
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
        if (kobietaRB.isSelected()) {
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

    public void setZapiszMenuItem(JMenuItem zapiszMenuItem) {
        zapiszMenuItem.addActionListener(new ZapiszMenuListener());
    }

    public void setZamknijMenuItem(JMenuItem zamknijMenuItem) {
        zamknijMenuItem.addActionListener(new ZamknijMenuListener());
    }
}
