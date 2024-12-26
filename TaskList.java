import javax.swing.*;
import java.awt.event.*;
public class TaskList {
    public static void main(String[] args) {
        new ToDoList();
    }
}
class ToDoList {
    JFrame f;
    JButton add, remove;
    JTextField tf;

    public ToDoList() {
        f = new JFrame("To Do List");

        JLabel l1 = new JLabel("To Do List App");
        l1.setBounds(400, 30, 200, 30);
        f.add(l1);

        JLabel l2 = new JLabel("Write Task:");
        l2.setBounds(50, 80, 120, 30);
        tf = new JTextField();
        tf.setBounds(180, 80, 500, 30);

        add = new JButton("Add Task");
        add.setBounds(700, 80, 120, 30);

        remove = new JButton("Remove Task");
        remove.setBounds(700, 130, 120, 30);

        DefaultListModel<String> list1 = new DefaultListModel<>();
        JList<String> list = new JList<>(list1);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // JScrollPane scrollPane = new JScrollPane(list);
        list.setBounds(180, 150, 500, 400);
        f.add(l2);
        f.add(tf);
        f.add(add);
        f.add(remove);  
        f.add(list);

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = tf.getText().trim();
                if (!task.isEmpty()) {
                    list1.addElement(task);
                    tf.setText("");
                } else {
                    JOptionPane.showMessageDialog(f, "Task cannot be empty!");
                }
            }
        });
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex != -1) {
                    list1.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(f, "Select a task to remove!");
                }
            }
        });
    }
}
