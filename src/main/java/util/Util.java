package util;

import javax.swing.*;

/**
 * User: Mariola
 * Date: 16.11.13
 */
public class Util {

    public static void setPlatformView() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ignored) {
        } catch (InstantiationException ignored) {
        } catch (IllegalAccessException ignored) {
        } catch (UnsupportedLookAndFeelException ignored) {
        }
    }
}
