package gui.main_frame.view;

import util.Util;

import javax.swing.*;
import java.awt.*;

/**
 * User: Mariola
 * Date: 16.11.13
 */
public class MainFrame extends JFrame {

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
        LeftPanel leftPanel = new LeftPanel();
        RightPanel rightPanel = new RightPanel();

        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
    }

    private void setMenu() {

        JMenuBar menuBar = new JMenuBar();
        JMenu aplikacjaMenu = new JMenu("Aplikacja");
        JMenuItem zamknijMenuItem = new JMenuItem("Zamknij");

        menuBar.add(aplikacjaMenu);
        aplikacjaMenu.add(zamknijMenuItem);

        setJMenuBar(menuBar);

    }
}
