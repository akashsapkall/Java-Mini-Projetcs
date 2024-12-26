import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class ColorPicker {
    public static void main(String[] args) {
        JFrame f = new JFrame("Color Picker");
        JPanel colorPanel = new JPanel();
        colorPanel.setBounds(50, 50, 300, 150);

        JSlider redSlider = new JSlider(0, 255, 0);
        redSlider.setBounds(50, 220, 300, 50);
        JSlider greenSlider = new JSlider(0, 255, 0);
        greenSlider.setBounds(50, 280, 300, 50);
        JSlider blueSlider = new JSlider(0, 255, 0);
        blueSlider.setBounds(50, 340, 300, 50);

        JLabel redLabel = new JLabel("Red");
        redLabel.setBounds(10, 220, 50, 30);
        JLabel greenLabel = new JLabel("Green");
        greenLabel.setBounds(10, 280, 50, 30);
        JLabel blueLabel = new JLabel("Blue");
        blueLabel.setBounds(10, 340, 50, 30);

        ChangeListener listener = e -> {
            int red = redSlider.getValue();
            int green = greenSlider.getValue();
            int blue = blueSlider.getValue();
            colorPanel.setBackground(new Color(red, green, blue));
        };

        redSlider.addChangeListener(listener);
        greenSlider.addChangeListener(listener);
        blueSlider.addChangeListener(listener);

        f.add(colorPanel);
        f.add(redSlider);
        f.add(greenSlider);
        f.add(blueSlider);
        f.add(redLabel);
        f.add(greenLabel);
        f.add(blueLabel);

        f.setSize(400, 450);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}

