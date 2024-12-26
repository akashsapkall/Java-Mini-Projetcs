import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VotingPoll {
    public static void main(String[] args) {
        new vote();
    }
}

class vote {
    JFrame f;
    JRadioButton rb1, rb2, rb3, rb4;
    JLabel l1, l2;
    JButton b1, b2;
    int java = 0;
    int javascript = 0;
    int cpp = 0;
    int rust = 0;

    public vote() {
        f = new JFrame("voting poll");
        l1 = new JLabel("VOTING POLL FOR LANGUAGES");
        l1.setBounds(80, 20, 200, 30);

        l2 = new JLabel("Vote Your Favourite Language * : ");
        l2.setBounds(80, 70, 200, 30);

        rb1 = new JRadioButton("Java");
        rb1.setBounds(90, 110, 160, 30);
        rb2 = new JRadioButton("JavaScript");
        rb2.setBounds(90, 150, 160, 30);
        rb3 = new JRadioButton("C++");
        rb3.setBounds(90, 190, 160, 30);
        rb4 = new JRadioButton("Rust");
        rb4.setBounds(90, 230, 160, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        bg.add(rb4);

        b1 = new JButton("Submit Vote");
        b1.setBounds(80, 280, 120, 30);
        b2 = new JButton("Submit Poll");
        b2.setBounds(230, 280, 120, 30);

        // l3 = new JLabel();
        // l3.setBounds(50, 310, 300, 100);

        f.add(l1);
        f.add(l2);
        f.add(rb1);
        f.add(rb2);
        f.add(rb3);
        f.add(rb4);
        f.add(b1);
        f.add(b2);
        // f.add(l3);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rb1.isSelected() || rb2.isSelected() || rb3.isSelected() || rb4.isSelected()) {
                    if (rb1.isSelected()) java++;
                    if (rb2.isSelected()) javascript++;
                    if (rb3.isSelected()) cpp++;
                    if (rb4.isSelected()) rust++;
                    JOptionPane.showMessageDialog(f, "Vote Submitted !");
                    bg.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(f, "Please select and submit your vote");
                    return;
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(f, "POll Submitted !");
                JOptionPane.showMessageDialog(f,"RESULT : \nJAVA : "+java+"\n"
                +"JAVASCRIPT : "+javascript+"\n"
                +"CPP : "+cpp+"\n"
                +"RUST : "+rust );
                java=0;
                javascript=0;
                cpp=0;
                rust=0;
            }
        });
        f.setSize(400, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}