package gui.main_frame.view;

import gui.main_frame.controler.MainFrameControler;
import javafx.scene.input.KeyCode;
import util.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Author: Mariola
 * Date: 25.11.13
 */

public class MainFrame extends JFrame{

    JMenuItem zapiszMenuItem;
    JMenuItem zamknijMenuItem;

    public MainFrame() {
        setUpFrame();
        setMenu();
        initializeComponent();
    }

    private void setUpFrame() {
        setSize(800, 350);
        setLocationRelativeTo(null);
        setTitle("Rejestracja pacjentów");
        Util.setPlatformView();
    }

    private void initializeComponent() {
        final MainFrameControler mainFrameControler = new MainFrameControler();

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
        mainFrameControler.setZapiszMenuItem(zapiszMenuItem);
        mainFrameControler.setZamknijMenuItem(zamknijMenuItem);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mainFrameControler.writeToFile();
            }
        });
    }

    private void setMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu plikMenu = new JMenu("Plik");
        zapiszMenuItem = new JMenuItem("Zapisz");
        zamknijMenuItem = new JMenuItem("Zamknij");

        menuBar.add(plikMenu);
        plikMenu.add(zapiszMenuItem);
        plikMenu.add(zamknijMenuItem);

        setJMenuBar(menuBar);
    }
}