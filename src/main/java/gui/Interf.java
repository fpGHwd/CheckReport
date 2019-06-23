package gui; /**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-22
 * @Time: 下午5:08
 * @Project: CheckReport
 */

import javax.swing.*;
import java.awt.event.*;

public class Interf {
    private JPanel mainPanel;
    private JPanel summaryPanel;
    private JPanel deviceInfoPanel;
    private JTable checkDetailsTable;
    private JPanel checkInfoPanel;
    private JLabel factoryName;
    private JLabel checkTime;
    private JLabel checkMethod;
    private JLabel pluginInDevNum;
    private JLabel checkDevNum;
    private JLabel excepionDevNum;
    private JButton seeReport;
    private JPanel checkedItems;
    private JButton projectInfoBtn;
    private JButton onlyExceptionBtn;
    private JPanel selectItems;
    private JTable devicesInfoTable;
    private JTable itemDetailsTable;
    private JButton deviceInfoBtn;
    private JButton onlyExceptionDevBtn;
    private JScrollPane itemDetails;

    static {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Interf() {
        seeReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 读取文件并写入数据库100s
                System.out.println("查看报告被按下");
                // 更新装置信息

            }
        });

        devicesInfoTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                int r= devicesInfoTable.getSelectedRow(); // row就是唯一标志
                int c= devicesInfoTable.getSelectedColumn();
                System.out.println("row: " + r + "column: " + c );
                // 刷新详细列表
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckReport");
        frame.setContentPane(new Interf().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here

        String[] metaData = { "", "", "", "", ""};
        Object[][] content = {metaData};
        String[] head = { "序号", "装置", "是否巡视", "巡视结果", "未巡或失败原因"};
        devicesInfoTable = new JTable(content,head);// 创建表格组件
        devicesInfoTable.setRowHeight(25);
//        devicesInfoTable.isCellEditable();

        String[] metaData1 = { "", "", "", "", ""};
        Object[][] content1 = {metaData};
        String[] head1 = { "序号", "名称", "巡视时间", "巡视结果", "实际值"};
        itemDetailsTable = new JTable(content1,head1);

    }

    private void setTableEditableFalse(JTable t){
        int r = t.getRowCount(),c = t.getColumnCount();
        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++){
                t.isCellEditable(i,j);
            }
        }
    }

    private void updateDeviceInfo(){
        //1.获取所有的数据

        //2.更新表格
    }
}