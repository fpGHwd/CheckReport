/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-22
 * @Time: 下午5:08
 * @Project: CheckReport
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Interf {
    private JPanel mainPanel;
    private JPanel summaryPanel;
    private JPanel deviceInfoPanel;
    private JTable checkDetailsTable;
    private JPanel checkInfoPanel;
    private JLabel factoryName;
    private JLabel factoryNameStr;
    private JLabel checkTime;
    private JLabel chckTimeStr;
    private JLabel checkMethod;
    private JLabel checkMethodStr;
    private JLabel pluginInDevNum;
    private JLabel pluginInDevNumStr;
    private JLabel checkDevNum;
    private JLabel checkDevNumStr;
    private JLabel excepionDevNum;
    private JLabel exceptionDevNumStr;
    private JButton seeReport;
    private JPanel checkedItems;
    private JButton projectInfoBtn;
    private JButton onlyExceptionBtn;
    private JPanel selectItems;
    private JPanel itemDetails;


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



}
