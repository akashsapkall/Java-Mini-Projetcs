 import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TempConverter {
    public static void main(String[] args) {
        new tempConvert();
    }
}
class tempConvert{
    JFrame f;
    JButton b1;
    JTextField tf1;
    JLabel l1,l2,l3;
    public tempConvert(){
        f=new JFrame("Temp Converter");
        l1=new JLabel("TEMPRATURE CONVERTER FROM CELCIUS TO FAHRENHEIT");
        l1.setBounds(50,20,400,30);
        l2=new JLabel("Enter Temp In Celcius: ");
        l2.setBounds(50,70,170,30);
        tf1=new JTextField();
        tf1.setBounds(220,70,140,30);
        l3=new JLabel();
        l3.setBounds(80,120,220,30);

        b1=new JButton("Convert");
        b1.setBounds(200,170,120,30);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(tf1);
        f.add(b1);
        // f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(500,400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(ActionEvent e){
                if (!tf1.getText().isEmpty()) {
                    Double f=Double.valueOf(tf1.getText())*(9/5)+32;
                    l3.setText("Temp In Fahrenheit : "+String.valueOf(f)+" f");
                }
                else{
                    JOptionPane.showMessageDialog(f,"Enter Temp in celcius first");
                }
            }
        });
    }
}