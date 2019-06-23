/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-22
 * @Time: 下午5:08
 * @Project: CheckReport
 */

import javax.swing.*;

public class Interf {
    private JPanel mainPanel;
    private JPanel summaryPanel;
    private JTable deviceInfoTable;
    private JTable checkDetailsTable;
    private JPanel checkInfoPanel;
    private JPanel deviceInfoPanel;

    static {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Interf");
        frame.setContentPane(new Interf().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
