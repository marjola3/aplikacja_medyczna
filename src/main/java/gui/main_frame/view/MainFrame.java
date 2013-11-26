package gui.main_frame.view;

import gui.main_frame.controler.MainFrameControler;
import util.Util;

import javax.swing.*;
import java.awt.*;

/**
 * Author: Mariola
 * Date: 25.11.13
 */

public class MainFrame extends JFrame{

    public MainFrame() {
        setUpFrame();
        initializeComponent();
        setMenu();
    }

    private void setUpFrame() {
        setSize(700, 350);
        setLocationRelativeTo(null);
        setTitle("Rejestracja pacjentów");
        Util.setPlatformView();
    }

    private void initializeComponent() {
        MainFrameControler mainFrameControler = new MainFrameControler();

        LeftPanel leftPanel = new LeftPanel();
        RightPanel rightPanel = new RightPanel();

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        mainFrameControler.setImieTF(leftPanel.getImieTF());
        mainFrameControler.setNazwiskoTF(leftPanel.getNazwiskoTF());
        mainFrameControler.setKobietaRB(leftPanel.getKobietaRB());
        mainFrameControler.setMezczyznaRB(leftPanel.getMezczyznaRB());
        mainFrameControler.setUbezpieczonyChB(leftPanel.getUbezpieczonyChB());
        mainFrameControler.setZawodCB(leftPanel.getZawodCB());
        mainFrameControler.setZapiszBtn(leftPanel.getZapiszBtn());
        mainFrameControler.setAnulujBtn(leftPanel.getAnulujBtn());
        mainFrameControler.setTablePatient(rightPanel.getTablePatient());
        mainFrameControler.setDodajBtn(rightPanel.getDodajBtn());
        mainFrameControler.setUsunBtn(rightPanel.getUsunBtn());
        mainFrameControler.setButtonGroup(leftPanel.getButtonGroup());

    }

    private void setMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menuAplikacja = new JMenu("Aplikacja");
        JMenuItem menuItem = new JMenuItem("Zapisz");

        menuBar.add(menuAplikacja);
        menuAplikacja.add(menuItem);

        setJMenuBar(menuBar);
    }
}
