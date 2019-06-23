/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-21
 * @Time: 下午9:27
 * @Project: CheckReport
 */

package gui;

import javax.swing.*;
import java.awt.*;

public class BlueEye {

    public static void main(String[] args)
    {
        try
        {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }
        catch(Exception e)
        {
            //TODO exception
        }

        JFrame frame=new JFrame("CheckReport");    //创建Frame窗口
        frame.setSize(800,498);
        frame.setLayout(new BorderLayout());    //为Frame窗口设置布局为BorderLayout
        JButton button1=new JButton ("up quick this problem");
        JButton button2=new JButton("left");
        JButton button3=new JButton("总部这个问题好");
        JButton button4=new JButton("right");
        JButton button5=new JButton("down");
        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.WEST);
        frame.add(button3,BorderLayout.CENTER);
        frame.add(button4,BorderLayout.EAST);
        frame.add(button5,BorderLayout.SOUTH);
        frame.setBounds(300,200,600,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}


