package gui; /**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-22
 * @Time: 下午5:08
 * @Project: CheckReport
 */

import analyse.XMLAnalyse;
import dao.*;
import entity.*;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

import java.lang.reflect.*;
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

    private JLabel channel;
    private JLabel analog;
    private JLabel loop;
    private JLabel wave;
    private JLabel selfAlarm;
    private JLabel softVersion;
    private JLabel secCircuit;
    private JLabel hardPlate;
    private JLabel softPlate;
    private JLabel clock;
    private JLabel gpsAlarm;
    private JLabel commStatus;
    private JLabel settings;
    private JLabel zone;
    private JLabel discrete;
    private JLabel switchS;

    private List<JLabel> itemLabels = new ArrayList<JLabel>();
    private static Map<String, String> labelAndData = new HashMap<String, String>(); // 排序
    private static JSONObject jsonObject;
    private static Map<String, Object> map;

    static {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        map = XMLAnalyse.map;
    }

    private volatile String deviceIdG;

    public Interf() {
        itemLabels.add(channel);
        itemLabels.add(analog);
        itemLabels.add(loop);
        itemLabels.add(wave);
        itemLabels.add(selfAlarm);
        itemLabels.add(softVersion);
        itemLabels.add(secCircuit);
        itemLabels.add(hardPlate);
        itemLabels.add(softPlate);
        itemLabels.add(clock);
        itemLabels.add(gpsAlarm);
        itemLabels.add(commStatus);
        itemLabels.add(settings);
        itemLabels.add(zone);
        itemLabels.add(discrete);
        itemLabels.add(switchS);

        seeReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 读取文件并写入数据库100s
                System.out.println("正在查询数据库ing");
                // 更新概要信息
                updateSystemInfo();
                // 更新装置信息
                updateDeviceInfo();
            }
        });

        devicesInfoTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
                int r = devicesInfoTable.getSelectedRow(); // row就是唯一标志
                int c = devicesInfoTable.getSelectedColumn();
                System.out.println("row: " + r + " - column: " + c);
                // 刷新详细列表
//                String deviceName = (String) devicesInfoTable.getValueAt(r, 1);
                updateCheckItems(r);
            }
        });


        // label添加事件
        for (final JLabel l : itemLabels) {
            l.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("触发label事件,deviceId =" + deviceIdG);
                    try {
                        updateItemDetails(l, deviceIdG);
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (NoSuchMethodException ex) {
                        ex.printStackTrace();
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    } catch (InstantiationException ex) {
                        ex.printStackTrace();
                    } catch (InvocationTargetException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }
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
        DefaultTableModel defaultTableModel = new DefaultTableModel(tableDevInfoHeader, 0);
        devicesInfoTable = new JTable();// 创建表格组件
        devicesInfoTable.setModel(defaultTableModel);
        devicesInfoTable.setRowHeight(25);

        DefaultTableModel defaultTableModel1 = new DefaultTableModel(tableCheckInfoDetailHeader, 0);
        itemDetailsTable = new JTable();
        itemDetailsTable.setModel(defaultTableModel1);
        itemDetailsTable.setRowHeight(25);
    }

    private void setTableEditableFalse(JTable t) {
        int r = t.getRowCount(), c = t.getColumnCount();
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                t.isCellEditable(i, j);
            }
        }
    }

    private final static String[] RESULT = {"未知状态", "正常不需检修", "异常需关注", "严重需检修", "无法评价需人工确认"};
    private final static String[] UNCHECKEDREASON = {"不涉及（实际已巡视）", "装置不在巡视范围内", "装置通信中断", "装置正在检修", "未下发标准值"};
    private final static String[] ISCHECKED = {"未巡视", "已巡视"};

    private final static String[] tableDevInfoHeader = {"序号", "装置", "是否巡视", "巡视结果", "未巡或失败原因"};
    private final static String[] tableCheckInfoDetailHeader = {"序号", "名称", "巡视时间", "巡视结果", "实际值"};

    // anything should be done by computer. no man self
    private final static String[] checkItemsString = {"光纤通道巡视", "电路电压回路巡视", "其他模拟量巡视", "录波巡视", "GPS告警巡视", "自检告警巡视", "软件版本巡视", "二次回路巡视", "通信状态巡视情况", "时钟巡视", "开入状态量巡视", "硬压板巡视", "软压板巡视", "定值巡视", "定值区巡视"};
    private final static Map<String, String> checkItemsMap = new HashMap<String, String>();
    // list is angry

    private final String[] systemInfoString = {"厂站名称：", "巡视时间：", "巡视方式：", "接入装置数：", "巡视装置数：", "异常装置数："};

    private List<TbCheckSummaryEntity> ltcse;

    private void updateDeviceInfo() {
        //1.获取所有的数据
        CheckSummaryDao csd = new CheckSummaryImpl();
        ltcse = csd.getCheckSummary();
        //2.更新表格
//        TableModel model = devicesInfoTable.getModel();
        DefaultTableModel defaultTableModel = new DefaultTableModel(tableDevInfoHeader, 0);
        int len = ltcse.size();
        for (int i = 0; i < len; i++) {
            Object[] row = {String.valueOf(i + 1), ltcse.get(i).getDeviceId(), ISCHECKED[ltcse.get(i).getIsChecked()], RESULT[ltcse.get(i).getResult()], UNCHECKEDREASON[ltcse.get(i).getUnCheckReason()]};
            defaultTableModel.addRow(row);
        }
        devicesInfoTable.setModel(defaultTableModel);

        // 更新巡检项目统计
    }

    TreeSet ts;

    private void updateCheckItems(int r) {
        ts = new TreeSet(new ResultComparator());
        TbCheckSummaryEntity tcse = null;
        if (ltcse != null) {
            tcse = ltcse.get(r);
            deviceIdG = tcse.getDeviceId();
            Map<String, String> mp = (Map<String, String>) map.get("InspectionCategories");
            try {
                Class obj = Class.forName("entity.TbCheckSummaryEntity");
                Field[] fields = obj.getDeclaredFields();
                for (Field f : fields) {
                    f.setAccessible(true);
                    for (Map.Entry<String, String> entry : mp.entrySet()) {
                        if (f.getName().startsWith(entry.getKey()) && f.getName().equals(entry.getKey() + "Result")) {
                            LableData ld = new LableData();
                            ld.itemName = entry.getKey();
                            ld.chineseName = entry.getValue();
                            try {
                                ld.result = Integer.parseInt(f.get(tcse).toString());
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            ts.add(ld);
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            // 未选中设备
        }

        // 更新label
        updateItemsLabels();

    }

    private void updateItemsLabels() {
        int i = 0;
        JLabel l;
        LableData ld;
        for (Iterator iterator = ts.iterator(); iterator.hasNext(); ) {
            l = itemLabels.get(i++);
            ld = (LableData) iterator.next();
            l.setText(ld.chineseName);
            l.setOpaque(true);
            if (ld.result >= 2) {
                l.setBackground(Color.RED);
            } else {
                l.setBackground(Color.GREEN);
            }
        }
    }

    private void updateSystemInfo() {
        SystemInfoDao sid = new SystemInfoDaoImpl();
        TbSystemEntity tse = sid.getSystemInfo();
        factoryName.setText(systemInfoString[0] + tse.getSubstation());
        checkTime.setText(systemInfoString[1] + formater(tse.getCheckTime()));
        checkMethod.setText(systemInfoString[2] + "自动巡视");
        pluginInDevNum.setText(systemInfoString[3] + tse.getCheckDeviceSum().toString());
        checkDevNum.setText(systemInfoString[4] + tse.getCheckDeviceSum().toString());
        excepionDevNum.setText(systemInfoString[5] + tse.getAbnormalDeviceSum().toString());
    }

    private String formater(Date d) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(d);
    }

    private void updateItemDetails(JLabel label, String deviceId) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String s = label.getText();

        DefaultTableModel defaultTableModel;
        List<String> columnStrs = new ArrayList<String>();
        columnStrs.add(0, "序号");

        String key = "";
        Map<String, String> mp = (Map<String, String>) map.get("InspectionCategories");
        for (Map.Entry<String, String> entry : mp.entrySet()) {
            if (entry.getValue().equals(s)) {
                key = entry.getKey();
            }
        }

        List<String> columns = (List<String>) map.get(captureName(key));

        for(String item:checkItemsString){
            if (item.equals(s)) {

                Class obj = Class.forName("entity.TbCheckDiff"+ captureName(key) +"Entity");
                Class obj1 = Class.forName("dao.Diff"+captureName(key)+"Impl");

                Method m = obj1.getDeclaredMethod("get"+captureName(key),String.class);
                Object invoke = m.invoke(obj1.newInstance(), deviceId);
                List<Object> result = (List<Object>)invoke;

                for (Field f : obj.getDeclaredFields()) {
                    if(!"id".equals(f.getName())){
                        f.setAccessible(true);
                        columnStrs.add(f.getName());
                    }
                }

                defaultTableModel = new DefaultTableModel(columnStrs.toArray(), 0);
                for(int i = 0; i< result.size(); i++){
                    Object[] row = new Object[columns.size()+1];
                    row[0] =(i+1);
                    for(int j = 1; j < columnStrs.size(); j++){
                        for(Field f:obj.getDeclaredFields()){
                            if (f.getName().equals(columnStrs.get(j))) {
                                f.setAccessible(true);
                                try {
                                    row[j] = f.get(result.get(i));
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    defaultTableModel.addRow(row);
                }
                itemDetailsTable.setModel(defaultTableModel);
            }
        }
    }

    public static String captureName(String name) {
        //  name = name.substring(0, 1).toUpperCase() + name.substring(1);
        //  return name;
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

    public static String reverseCaptureName(String name) {
        //  name = name.substring(0, 1).toUpperCase() + name.substring(1);
        //  return name;
        char[] cs = name.toCharArray();
        cs[0] += 32;
        return String.valueOf(cs);


    }

}

class ResultComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        LableData ld1 = (LableData) o1, ld2 = (LableData) o2;
        if (ld1.result != ld2.result) {
            return ld2.result - ld1.result;
        } else {
            return ld1.chineseName.compareTo(ld2.chineseName);
        }
    }
}