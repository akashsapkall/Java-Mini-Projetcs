import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class LoginIterface {
    public static void main(String[] args) {
        new LoginForm();
    }
}
class LoginForm{
    JFrame frame;
    JLabel l1,l2,l3,l4;
    JButton b1;
    JTextField tf1;
    public LoginForm(){
        frame=new JFrame("Login form");

        l1=new JLabel("LOGIN FORM ");
        l1.setBounds(150, 20, 100, 30);

        
        l3=new JLabel("Enter UserName :");
        l3.setBounds(50, 70, 120, 30);
        tf1=new JTextField(20);
        tf1.setBounds(180, 70, 150, 30);

        l4=new JLabel("Enter Password :");
        l4.setBounds(50, 120, 120, 30);
        JPasswordField tf2=new JPasswordField(20);
        tf2.setBounds(180, 120, 150, 30);

        l2=new JLabel();
        l2.setBounds(50, 170, 200, 30);

        b1=new JButton("Login");
        b1.setBounds(150, 220, 100, 30);
        
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(b1);
        frame.add(tf1);
        frame.add(tf2);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String username="admin";
                String password="1234";
                if (username.equals(tf1.getText()) && password.equals(new String(tf2.getPassword()))) {
                    l2.setText("Login Successfull ...");
                }
                else{
                    l2.setText("Login Failed...");
                }
            }
        });
    }
}