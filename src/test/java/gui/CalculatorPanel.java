/**
 * Created by Intellij IDEA.
 *
 * @Author: suzumiya
 * @Date: 19-6-22
 * @Time: 下午2:48
 * @Project: CheckReport
 */

package gui;

import javax.swing.*;
import java.awt.*;

public class CalculatorPanel extends JPanel {

    private JButton display;
    private JPanel panel;
    private double result;
    private String lastCommond;
    private boolean start;

    public CalculatorPanel(){
        this.setLayout(new BorderLayout());
        result = 0;
        lastCommond = "=";
        start = true;


        display = new JButton("0");
        display.setEnabled(false);
        add(display,BorderLayout.NORTH);

//        ActionListener insert = new InsertAction();
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,4));

        addButton("7");
        addButton("8");
        addButton("9");
        addButton("/");

        addButton("4");
        addButton("5");
        addButton("6");
        addButton("*");

        addButton("1");
        addButton("2");
        addButton("3");
        addButton("-");

        addButton("0");
        addButton(".");
        addButton("=");
        addButton("+");

        add(panel, BorderLayout.CENTER);


    }

    private void addButton(String label){
        JButton button = new JButton(label);
//        button.addActionListener(listener);
        panel.add(button);
    }

    public static void main(String[] args) {
        new CalculatorPanel().setVisible(true);
    }

}
