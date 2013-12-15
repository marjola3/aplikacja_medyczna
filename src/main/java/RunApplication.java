import gui.main_frame.view.MainFrame;
import model.Sex;

import javax.swing.*;

/**
 * User: Mariola
 * Date: 16.11.13
 */
public class RunApplication {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}
