import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class JavaCurrencyConverter {
    public static void main(String[] args) {
        new currencyConverter();
    }
}

class currencyConverter {
    JFrame f;
    JButton b1;
    JTextField tf;
    JComboBox<String> cb;
    JLabel l1,l2,l3;
    Set<Currency> currencies = Currency.getAvailableCurrencies();
    Map<String, Double> exchangeRates = new HashMap<>();
    public currencyConverter() {
        f=new JFrame("currency converter");
        l1=new JLabel("CURRENCY CONVERTER");
        l1.setBounds(110, 20, 200, 30);
        l2=new JLabel("Enter Amount In USD :");
        l2.setBounds(30, 90, 200, 30);
        tf=new JTextField();
        tf.setBounds(180, 90, 120, 30);
        cb=new JComboBox<>(currency());
        cb.setBounds(50,150,200,30);
        b1=new JButton("Convert");
        b1.setBounds(120,260,100,30);

        l3=new JLabel();
        l3.setBounds(30, 200, 320, 30);

        f.add(l1);
        f.add(tf);
        f.add(l2);
        f.add(cb);
        f.add(b1);
        f.add(l3);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                double usdamt=Double.valueOf(tf.getText());
                String currCode=cb.getItemAt(cb.getSelectedIndex());
                if(!(getValue(currCode, usdamt)==-1)){
                l3.setText(usdamt+" UDS Converted to "+currCode+" : "+getValue(currCode, usdamt));
                }else{
                    JOptionPane.showMessageDialog(f, "Do Not Have Exchange Rate For "+currCode);
                }
            }
        });
        f.setSize(400,400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public String[] currency(){

        String[] currencyCodes = new String[currencies.size()+1];
        currencyCodes[0]="Select Currency Code";
        int index = 1;

        for (Currency currency : currencies) {
            currencyCodes[index++] = currency.getCurrencyCode();
        }
        return currencyCodes;
    }
    public double getValue(String targetCurrency,double usdAmount){

        exchangeRates.put("USD", 1.0);  // Base currency
        exchangeRates.put("EUR", 0.91); // 1 USD = 0.91 EUR
        exchangeRates.put("GBP", 0.78); // 1 USD = 0.78 GBP
        exchangeRates.put("INR", 83.10); // 1 USD = 83.10 INR
        exchangeRates.put("JPY", 148.5); // 1 USD = 148.50 JPY
        exchangeRates.put("AUD", 1.56); // 1 USD = 1.56 AUD
        exchangeRates.put("CAD", 1.34); 

        if (exchangeRates.containsKey(targetCurrency)) {
            return usdAmount * exchangeRates.get(targetCurrency);

        } else {
            return -1;
        }
    }
}