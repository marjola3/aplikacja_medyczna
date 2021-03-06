package gui.main_frame.view;

import gui.main_frame.controler.MainFrameControler;
import gui.main_frame.model.PatientTableModel;
import model.Patient;
import model.Sex;
import model.WorkerType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Mariola
 * Date: 25.11.13
 */

public class RightPanel extends JPanel {
    private JTable tablePatient;

    private JButton dodajBtn;
    private JButton usunBtn;

    public RightPanel() {
        setUpPanel();
        initializeComponent();
    }

    private void setUpPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }

    private void initializeComponent() {
        FormPanel formPanel = new FormPanel();
        ButtonRightPanel buttonRightPanel = new ButtonRightPanel();

        add(formPanel, BorderLayout.CENTER);
        add(buttonRightPanel, BorderLayout.SOUTH);
    }

    class FormPanel extends JPanel {

        public FormPanel() {
            setUpPanel();
            initializeComponent();
        }

        private void setUpPanel() {
            setLayout(new BorderLayout());
        }

        private void initializeComponent() {

            PatientTableModel model = new PatientTableModel();
            tablePatient = new JTable(model);

            JScrollPane jsp = new JScrollPane(tablePatient);
            add(jsp);
        }
    }

    class ButtonRightPanel extends JPanel {

        public ButtonRightPanel() {
            dodajBtn = new JButton("Dodaj");
            usunBtn = new JButton("Usuń");

            add(dodajBtn);
            add(usunBtn);
        }
    }

    public JTable getTablePatient() {
        return tablePatient;
    }

    public JButton getDodajBtn() {
        return dodajBtn;
    }

    public JButton getUsunBtn() {
        return usunBtn;
    }
}
