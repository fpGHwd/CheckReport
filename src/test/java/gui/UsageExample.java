/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-21
 * @Time: 下午9:21
 * @Project: CheckReport
 */

package gui;

import com.alee.laf.WebLookAndFeel;

import javax.swing.*;
import java.awt.*;

public class UsageExample
{
    public static void main ( String[] args )
    {
        // You should work with UI (including installing L&F) inside Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater (new Runnable ()
        {
            public void run ()
            {
                // Install WebLaF as application L&F
                WebLookAndFeel.install ();

                // You can also do that with one of old-fashioned ways:
                // UIManager.setLookAndFeel ( new WebLookAndFeel () );
//                 UIManager.setLookAndFeel ( "com.alee.laf.WebLookAndFeel" );
//                 UIManager.setLookAndFeel ( WebLookAndFeel.class.getCanonicalName () );

                // Create you application here using Swing components
                // JFrame frame = ...

                // Or use similar Web* components to get access to some extended features
                // WebFrame frame = ...


                JFrame frame=new JFrame("Java第三个GUI程序");    //创建Frame窗口
                frame.setSize(400,200);
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
        } );
    }
}