
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.concurrent.*;

public class JavaStopWatch {
    public static void main(String[] args) {
        new stopWatch();
    }
}

class stopWatch {
    int h = 0;
    int m = 0;
    int s = 0;
    JFrame f;
    JButton b1, b2, b3;
    JLabel l1, l2;

    ScheduledExecutorService executor = null;

    public stopWatch() {
        f = new JFrame("StopWatch");

        // Title and timer display
        l1 = new JLabel("STOPWATCH");
        l1.setBounds(110, 20, 100, 30);
        l2 = new JLabel("00:00:00");
        l2.setBounds(120, 80, 100, 40);

        // Buttons
        b1 = new JButton("Start");
        b1.setBounds(20, 150, 80, 30);
        b2 = new JButton("Stop");
        b2.setBounds(120, 150, 80, 30);
        b3 = new JButton("Reset");
        b3.setBounds(220, 150, 80, 30);

        // Add components to frame
        f.add(l1);
        f.add(l2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        // Button actions
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (executor == null || executor.isShutdown()) {
                    executor = Executors.newSingleThreadScheduledExecutor();
                    executor.scheduleAtFixedRate(() -> increment(), 0, 1, TimeUnit.SECONDS);
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (executor != null && !executor.isShutdown()) {
                    executor.shutdown();
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (executor != null && !executor.isShutdown()) {
                    executor.shutdown();
                }
                h = 0;
                m = 0;
                s = 0;
                display();
            }
        });
    }

    // Display the time in HH:MM:SS format
    public void display() {
        SwingUtilities.invokeLater(() -> 
            l2.setText(((h < 10) ? "0" + h : h) + ":" +
                       ((m < 10) ? "0" + m : m) + ":" +
                       ((s < 10) ? "0" + s : s)));
    }

    // Increment the timer
    public void increment() {
        s++;
        if (s == 60) {
            s = 0;
            m++;
            if (m == 60) {
                m = 0;
                h++;
            }
        }
        display();
    }
}
