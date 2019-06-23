package gui; /**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-22
 * @Time: 下午5:08
 * @Project: CheckReport
 */

import dao.CheckSummaryDao;
import dao.CheckSummaryImpl;
import entity.TbCheckSummaryEntity;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.*;
import java.util.List;

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
                System.out.println("正在查询数据库");
                // 更新装置信息
                updateDeviceInfo();
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


    private final String[] RESULT = {"未知状态","正常不需检修","异常需关注","严重需检修","无法评价需人工确认"};
    private final String[] UNCHECKEDREASON ={"不涉及（实际已巡视）","装置不在巡视范围内","装置通信中断","装置正在检修","未下发标准值"};
    private final String[] ISCHECKED={"未巡视","已巡视"};

    private void updateDeviceInfo(){
        //1.获取所有的数据
        CheckSummaryDao csd = new CheckSummaryImpl();
        List<TbCheckSummaryEntity> ltcse = csd.getCheckSummary();
        //2.更新表格
        TableModel model = devicesInfoTable.getModel();
        int len = ltcse.size();
        for(int i = 0; i < len; i++){
            model.setValueAt(String.valueOf(i+1), i,0); // 序号
            model.setValueAt(ltcse.get(i).getDeviceName(), i ,1); // 设备名字
            model.setValueAt(ISCHECKED[ltcse.get(i).getIsChecked()], i,2); // 是否巡视
            model.setValueAt(RESULT[ltcse.get(i).getResult()], i ,3);   // 巡视结果
            model.setValueAt(UNCHECKEDREASON[ltcse.get(i).getUnCheckReason()], i ,4);   // 未巡视或失败原因
        }
    }
}
