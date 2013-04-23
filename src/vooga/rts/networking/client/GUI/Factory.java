package vooga.rts.networking.client.GUI;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public final class Factory {
    /**
     * @wbp.factory
     */
    public static JComboBox createJComboBox() {
        JComboBox comboBox = new JComboBox();
        return comboBox;
    }
    /**
     * @wbp.factory
     */
    public static JLabel createJLabel() {
        JLabel label = new JLabel("Player Name 1");
        return label;
    }
}