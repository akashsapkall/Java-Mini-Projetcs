
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GradeCalci {
    public static void main(String[] args) {
        new gradeCalculator();
    }
}
class gradeCalculator{
    JFrame f;
    JButton b1;
    JTextField tf1,tf2,tf3;
    JLabel l1,l2,l3,l4,l5;
    public gradeCalculator(){
        f=new JFrame("Grade Clci");
        l1=new JLabel("STUDENT GRADE CALCULATOR");
        l1.setBounds(50,20,220,30);

        l2=new JLabel("SUB 1 : ");
        l2.setBounds(50,70,80,30);
        tf1=new JTextField();
        tf1.setBounds(100,70,100,30);

        l3=new JLabel("SUB 2 : ");
        l3.setBounds(50,120,80,30);
        tf2=new JTextField();
        tf2.setBounds(100,120,100,30);

        l4=new JLabel("SUB 3 : ");
        l4.setBounds(50,170,80,30);
        tf3=new JTextField();
        tf3.setBounds(100,170,100,30);

        l5=new JLabel();
        l5.setBounds(50,220,200,30);

        b1=new JButton("Calculate Grade");
        b1.setBounds(30,250,200,30);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(b1);
        // f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setSize(400,400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(!(tf1.getText().isEmpty() || tf2.getText().isEmpty() || tf3.getText().isEmpty())){
                Double total=Double.valueOf(tf1.getText())+Double.valueOf(tf2.getText())+Double.valueOf(tf3.getText());
                Double percent=total/300*100;
                l5.setText("Student Grade : "+gradeCalculator.grade(percent));
                }else{
                    JOptionPane.showMessageDialog(f, "Enter All Subjects Marks");
                }
            }
        });
    }
    public static char grade(double percent){
        if (percent>=90 && percent<=100) {
            return 'A';
        }else if (percent>=80 && percent<90) {
            return 'B';
        }else if (percent>=70 && percent<80) {
            return 'C';
        }else if (percent>=60 && percent<70) {
            return 'D';
        }else{
            return 'F';
        }
    }
}