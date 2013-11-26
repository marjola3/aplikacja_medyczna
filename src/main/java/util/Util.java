package util;

import javax.swing.*;

/**
 * Author: Mariola
 * Date: 25.11.13
 */

public class Util {

    public static void setPlatformView() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ignored) {
        } catch (UnsupportedLookAndFeelException ignored) {
        } catch (InstantiationException ignored) {
        } catch (IllegalAccessException ignored) {
        }
    }
}
