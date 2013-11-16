package gui.main_frame.view;

import model.WorkerType;

import javax.swing.*;
import java.awt.*;

/**
 * User: Mariola
 * Date: 16.11.13
 */
public class LeftPanel extends JPanel {

    public LeftPanel() {
        setUpPanel();
        initializeComponent();
    }

    private void setUpPanel() {
        setLayout(new BorderLayout());
    }

    private void initializeComponent() {
        FormPanel formPanel = new FormPanel();
        ButtonPanel buttonPanel = new ButtonPanel();

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    class FormPanel extends JPanel {

        public FormPanel() {
            setUpPanel();
            initializeComponent();

        }

        private void setUpPanel() {
            setLayout(new GridLayout(5, 2, 10, 20));
            setBorder(BorderFactory.createEmptyBorder(30,10,30,10));
        }

        private void initializeComponent() {
            JPanel plecPanel = createPlecPanel();

            JLabel imieLbl = new JLabel("Imię:");
            JTextField imieTf = new JTextField();
            JLabel nazwiskoLbl = new JLabel("Nazwisko:");
            JTextField nazwiskoTf = new JTextField();
            JLabel plecLbl = new JLabel("Płeć:");
            JLabel ubezpieczonyLbl = new JLabel("Ubezpieczony:");
            JCheckBox ubezpieczonyChB = new JCheckBox();
            JLabel zawodLbl = new JLabel("Zawód:");
            JComboBox<WorkerType> zawodCB = createJComboBox();

            add(imieLbl);
            add(imieTf);
            add(nazwiskoLbl);
            add(nazwiskoTf);
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
            ButtonGroup buttonGroup = new ButtonGroup();

            JRadioButton kobietaRb = new JRadioButton("Kobieta");
            JRadioButton mezczyznaRb = new JRadioButton("Mężczyzna");

            buttonGroup.add(kobietaRb);
            buttonGroup.add(mezczyznaRb);

            plecPanel.add(kobietaRb);
            plecPanel.add(mezczyznaRb);

            return plecPanel;
        }
    }

    class ButtonPanel extends JPanel {
        public ButtonPanel() {
            JButton zapiszBtn = new JButton("Zapisz");
            JButton anulujBtn = new JButton("Anuluj");

            add(zapiszBtn);
            add(anulujBtn);

        }
    }
}
