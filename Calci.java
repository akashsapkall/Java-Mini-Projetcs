import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Calci {
    public static void main(String[] args) {
        new basicCalculator();
    }
}
class basicCalculator{
    JFrame f;
    JButton b1,b2,b3,b4;
    JTextField tf1,tf2;
    JLabel l1,l2,l3,l4;
    public basicCalculator(){
        f=new JFrame("Basic Calculator");
        l1=new JLabel("BASIC CALCULATOR");
        l1.setBounds(50,20,150,30);
        l2=new JLabel("NUM 1 : ");
        l2.setBounds(50,70,80,30);
        tf1=new JTextField();
        tf1.setBounds(100,70,100,30);
        l3=new JLabel("NUM 2 : ");
        l3.setBounds(50,120,80,30);
        tf2=new JTextField();
        tf2.setBounds(100,120,100,30);

        l4=new JLabel();
        l4.setBounds(50,170,200,30);

        b1=new JButton("Add");
        b1.setBounds(30,220,120,30);
        b2=new JButton("Substract");
        b2.setBounds(200,220,120,30);
        b3=new JButton("Multiplay");
        b3.setBounds(30,270,120,30);
        b4=new JButton("Divide");
        b4.setBounds(200,270,120,30); 
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(tf1);
        f.add(tf2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        // f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(400,400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        // double num1=Double.parseDouble(tf1.getText());
        // double num2=Double.parseDouble(tf2.getText());
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // System.out.println(num2);
                // Double result=Double.valueOf(tf1.getText())+Double.valueOf(tf2.getText());
                Double result=Double.parseDouble(tf1.getText())+Double.parseDouble(tf2.getText());
                // Double result=num1+num2;
                l4.setText("Result : "+result);
            }
        });
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Double result=Double.valueOf(tf1.getText())-Double.valueOf(tf2.getText());
                l4.setText("Result : "+result);
            }
        });
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Double result=Double.valueOf(tf1.getText())*Double.valueOf(tf2.getText());
                l4.setText("Result : "+result);
            }
        });
        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                Double result=Double.valueOf(tf1.getText())/Double.valueOf(tf2.getText());
                l4.setText("Result : "+result);
                }catch(ArithmeticException e1){
                    l4.setText("ERROR");
                }
            }
        });
    }
}