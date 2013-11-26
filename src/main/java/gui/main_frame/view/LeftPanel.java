package gui.main_frame.view;

import model.WorkerType;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Mariola
 * Date: 25.11.13
 */

public class LeftPanel extends JPanel{
    private JTextField imieTF;
    private JTextField nazwiskoTF;
    private JRadioButton kobietaRB;
    private JRadioButton mezczyznaRB;
    private JCheckBox ubezpieczonyChB;
    private JComboBox<WorkerType> zawodCB;
    private ButtonGroup buttonGroup;

    private JButton zapiszBtn;
    private JButton anulujBtn;

    public LeftPanel() {
        setUpPanel();
        initializeComponent();
    }

    private void setUpPanel() {
        setLayout(new BorderLayout());
    }

    private void initializeComponent() {
        FormPanel formPanel = new FormPanel();
        ButtonLeftPanel buttonLeftPanel = new ButtonLeftPanel();

        add(formPanel, BorderLayout.CENTER);
        add(buttonLeftPanel, BorderLayout.SOUTH);
    }

    class FormPanel extends JPanel {

        public FormPanel() {
            setUpPanel();
            initializeComponent();
        }

        private void setUpPanel() {
            setLayout(new GridLayout(5,2,10,20));
            setBorder(BorderFactory.createEmptyBorder(30,10,30,10));
        }

        private void initializeComponent() {
            JPanel plecPanel = createPlecPanel();

            JLabel imieLbl = new JLabel("Imię");
            imieTF = new JTextField();
            JLabel nazwiskoLbl = new JLabel("Nazwisko");
            nazwiskoTF = new JTextField();
            JLabel plecLbl = new JLabel("Płeć");
            JLabel ubezpieczonyLbl = new JLabel("Ubezpieczony");
            ubezpieczonyChB = new JCheckBox();
            JLabel zawodLbl = new JLabel("Zawód");
            zawodCB = createJComboBox();

            add(imieLbl);
            add(imieTF);
            add(nazwiskoLbl);
            add(nazwiskoTF);
            add(plecLbl);
            add(plecPanel);
            add(ubezpieczonyLbl);
            add(ubezpieczonyChB);
            add(zawodLbl);
            add(zawodCB);
        }

        private JComboBox<WorkerType> createJComboBox() {
            WorkerType[] workerTypes = WorkerType.values();
            return new JComboBox<WorkerType>(workerTypes);
        }

        private JPanel createPlecPanel() {
            JPanel plecPanel = new JPanel();
            buttonGroup = new ButtonGroup();

            kobietaRB = new JRadioButton("Kobieta");
            mezczyznaRB = new JRadioButton("Mężczyzna");

            buttonGroup.add(kobietaRB);
            buttonGroup.add(mezczyznaRB);

            plecPanel.add(kobietaRB);
            plecPanel.add(mezczyznaRB);

            return plecPanel;
        }
    }

    class ButtonLeftPanel extends JPanel {

        public ButtonLeftPanel() {
            zapiszBtn = new JButton("Zapisz");
            anulujBtn = new JButton("Anuluj");

            add(zapiszBtn);
            add(anulujBtn);
        }
    }

    public JTextField getImieTF() {
        return imieTF;
    }

    public JTextField getNazwiskoTF() {
        return nazwiskoTF;
    }

    public JRadioButton getKobietaRB() {
        return kobietaRB;
    }

    public JRadioButton getMezczyznaRB() {
        return mezczyznaRB;
    }

    public JCheckBox getUbezpieczonyChB() {
        return ubezpieczonyChB;
    }

    public JComboBox<WorkerType> getZawodCB() {
        return zawodCB;
    }

    public JButton getZapiszBtn() {
        return zapiszBtn;
    }

    public JButton getAnulujBtn() {
        return anulujBtn;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }
}
