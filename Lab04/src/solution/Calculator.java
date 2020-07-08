package solution;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Calculator using GUI.
 * 
 * @author AaronMosteller
 * @version 2/7/2019
 * 
 */
public class Calculator implements ActionListener
{

    private JFrame frame;
    
    private JPanel buttonPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel resultPanel;
    private JLabel resultLabel;
    private JPanel textFieldPanel;
    private JTextField textField1;
    private JTextField textField2;
    /**
     * Calculator Constructor, initializes many parts.
     */
    public Calculator()
    {
        frame = new JFrame("Calculator"); 
        
        buttonPanel = new JPanel();        
        button1 = new JButton("ADD");
        button1.setName("addButton");            
        button2 = new JButton("SUB");
        button2.setName("subButton");       
        button3 = new JButton("MULT");
        button3.setName("multButton");        
        button4 = new JButton("DIV");         
        button4.setName("divButton");
        
        
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        frame.add(buttonPanel, BorderLayout.PAGE_END);
        
        resultPanel = new JPanel();
        resultLabel = new JLabel("Result = ");
        
        
        resultLabel.setName("resultLabel");
        resultPanel.add(resultLabel);
        frame.add(resultPanel, BorderLayout.CENTER);
        
        textFieldPanel = new JPanel();
        textField1 = new JTextField(7);
        textField2 = new JTextField(7);
        textField1.setName("leftOperand");
        textField2.setName("rightOperand");
        
        textFieldPanel.add(textField1);
        textFieldPanel.add(textField2);
        
        frame.add(textFieldPanel, BorderLayout.PAGE_START);
        
        
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    
    
    
    
    
    
    /**
     * Getter for frame.
     * @return frame
     */
    public JFrame getFrame()
    {       
        return frame;
    }
    
    
    
    
    
    /**
     * Main method for Calculator.
     * @param args **arguments**
     */
    public static void main(String[] args)
    {
        Calculator calc = new Calculator();
        
    }







    
    /**
     * Action Listener.
     * @param e **ActionEvent**
     */
    
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
        int a;
        int b;
        try
        {
            a = Integer.valueOf(textField1.getText());
            b = Integer.valueOf(textField2.getText());
            
        }
        catch (Exception exc)
        {
            resultLabel.setText("Result = Error");
            return;
        }
        
        if (e.getSource().equals(button1))
        {
           
           
            resultLabel.setText("Result = " + String.valueOf(a + b));
        }
        else if (e.getSource().equals(button2))
        {
            
            resultLabel.setText("Result = " + String.valueOf(a - b));
        }
        else if (e.getSource().equals(button3)) 
        {
            
            resultLabel.setText("Result = " + String.valueOf(a * b));
        }
        else if (e.getSource().equals(button4)) 
        {
           
            if (b == 0)
            
                
            {
                resultLabel.setText("Result = Error");
                
                
            }
            
            
            else 
            {
                resultLabel.setText("Result = " + String.valueOf(a / b));
            }
      
        }
    }

    
}
 
    

