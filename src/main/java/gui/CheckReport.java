/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-21
 * @Time: 下午4:26
 * @Project: CheckReport
 */

package gui;

import com.alee.laf.WebLookAndFeel;

import javax.swing.*;
import java.awt.*;


public class CheckReport {


    private static JFrame addPanel(){
        JFrame frame = new JFrame("CheckReport");
        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0,200,130);



        JFrame jFrame=new JFrame("Java第四个GUI程序");    //创建Frame窗口
        JPanel jPanel=new JPanel();    //创建面板
        JButton btn1=new JButton("1");    //创建按钮
        JButton btn2=new JButton("2");
        JButton btn3=new JButton("3");
        JButton btn4=new JButton("4");
        JButton btn5=new JButton("5");
        JButton btn6=new JButton("6");
        JButton btn7=new JButton("7");
        JButton btn8=new JButton("8");
        JButton btn9=new JButton("9");
        jPanel.add(btn1);    //面板中添加按钮
        jPanel.add(btn2);
        jPanel.add(btn3);
        jPanel.add(btn4);
        jPanel.add(btn5);
        jPanel.add(btn6);
        jPanel.add(btn7);
        jPanel.add(btn8);
        jPanel.add(btn9);
        //向JPanel添加FlowLayout布局管理器，将组件间的横向和纵向间隙都设置为20像素
        jPanel.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));
        jPanel.setBackground(Color.gray);    //设置背景色
        jFrame.add(jPanel);    //添加面板到容器
        jFrame.setBounds(300,200,300,150);    //设置容器的大小
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }

//    public static JFrame


    /**{
     * 创建并显示GUI。出于线程安全的考虑，
     * 这个方法在事件调用线程中调用。
     */
    private static void createAndShowGUI() {

        WebLookAndFeel.install ();

        JFrame frame = new JFrame("CheckReport Demo");
        frame.setSize(1500,927);
        frame.setLocationRelativeTo(null); // 居中
        frame.setBackground(Color.white);    //设置背景色
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); // 显示可见


//        frame.setLayout(new GridLayout(2,1));

        // labels
//        JPanel p1 = new JPanel();
//        JPanel p2 = new JPanel();
        JLabel fn = new JLabel("厂站名称：开普检测" + " "
                +"巡视时间： 2019-06-12T08:10:00" + " "
                + "巡视方式：自动巡视" + " "
                + "接入装置叔：132" + " "
                + "巡视装置叔：132" + " "
                + "异常装置叔：132" + " ");
//        p1.add(fn);
//        p1.setLayout(new GridLayout(1,6));
        frame.add(fn,BorderLayout.NORTH);

/*
        // 下部内容 = 装置信息 + 巡检条目s + 左右布局
        p2.setLayout(new GridLayout(1,2));
        JPanel p21 = new JPanel();
        JPanel p22 = new JPanel();
        p21.add(fn);
        p22.add(fn);
        p2.add(p21);
        p2.add(p22);

        // 巡检条目s = 巡检条目s + 详细条目 + 上下布局
        p22.setLayout(new GridLayout(2,1));
        JPanel p221 = new JPanel();
        JPanel p222 = new JPanel();
        p22.add(p221);
        p22.add(p222);
*/




    }

    public static void main(String[] args) {
        // 显示应用 GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}