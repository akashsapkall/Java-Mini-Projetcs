import javax.swing.*;
import java.awt.event.*;
import java.util.Locale;

public class InfoForm {
    public static void main(String[] args) {
        new PersonalInfoForm();
    }
}

class PersonalInfoForm {
    JFrame f;
    JButton b1;
    JTextField tf1, tf2;
    JComboBox<String> cb;
    JRadioButton rb1, rb2, rb3;
    JLabel l1, l2, l3, l4;

    public PersonalInfoForm() {
        f = new JFrame("Personal Info Form");
        l1 = new JLabel("PERSONAL INFORMATION FORM");
        l1.setBounds(110, 20, 200, 30);
        l2 = new JLabel("Enter Your Name* :");
        l2.setBounds(30, 60, 180, 30);
        tf1 = new JTextField();
        tf1.setBounds(180, 60, 180, 30);

        l3 = new JLabel("Enter Your Age* :");
        l3.setBounds(30, 110, 180, 30);
        tf2 = new JTextField();
        tf2.setBounds(180, 110, 180, 30);

        l4 = new JLabel("Select Your Gender* :");
        l4.setBounds(180, 160, 180, 30);
        rb1 = new JRadioButton(" A) Male");
        rb1.setBounds(190, 180, 100, 30);
        rb2 = new JRadioButton(" B) Female");
        rb2.setBounds(190, 220, 100, 30);
        rb3 = new JRadioButton(" C) Other");
        rb3.setBounds(190, 260, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        cb = new JComboBox<>(getCountry());
        cb.setBounds(150, 320, 200, 30);
        b1 = new JButton("Submit");
        b1.setBounds(180, 390, 100, 30);

        // l3=new JLabel();
        // l3.setBounds(30, 200, 320, 30);
        f.add(b1);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(tf1);
        f.add(tf2);
        f.add(cb);
        f.add(rb1);
        f.add(rb2);
        f.add(rb3);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display();
                tf1.setText("");
                tf2.setText("");
                rb1.setSelected(false);
                rb2.setSelected(false);
                rb3.setSelected(false);
                cb.setSelectedIndex(0);
            }
        });
        f.setSize(600, 600);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String[] getCountry() {
        String[] countryCodes = Locale.getISOCountries();
        String[] countryNames = new String[countryCodes.length];
        countryNames[0] = "Select Your Country";
        for (int i = 1; i < countryCodes.length; i++) {
            Locale locale = Locale.of("", countryCodes[i]);
            countryNames[i] = locale.getDisplayCountry();
        }
        return countryNames;
    }

    public boolean nameAndAge(String name, String age) {
        if (!name.isEmpty() && !age.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean gender() {
        if (rb1.isSelected() || rb2.isSelected() || rb3.isSelected()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean country() {
        if ((cb.getSelectedIndex()) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        if (nameAndAge(tf1.getText(), tf2.getText()) && gender() && country()) {
            String genderText = rb1.isSelected() ? "Male" : rb2.isSelected() ? "Female" : "Other";
            JOptionPane.showMessageDialog(f, "Person Information:\n" +
                    "Name: " + tf1.getText() + "\n" +
                    "Age: " + tf2.getText() + "\n" +
                    "Gender: " + genderText + "\n" +
                    "Country: " + cb.getSelectedItem());
        } else {
            JOptionPane.showMessageDialog(f, "Fill All The Filds");
        }
    }
}