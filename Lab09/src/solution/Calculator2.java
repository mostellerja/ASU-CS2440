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
 * Calculator2.
 * 
 * @author Aaron Mosteller
 * @version 4/3/19
 */
public class Calculator2 implements ActionListener
{
    private JFrame frame;   
    private JPanel buttonPanel;
    private JButton button1;
    private JButton button2;
    private JPanel resultPanel;
    private JLabel resultLabel;
    private JPanel textFieldPanel;
    private JTextField textField1;
    

    /**
     * Calculator2 Constructor.
     */
    public Calculator2()
    {
        frame = new JFrame("Calculator"); 
        
        buttonPanel = new JPanel();        
        button1 = new JButton("CALCULATE");
        button1.setName("calculateButton");            
        button2 = new JButton("CLEAR");
        button2.setName("clearButton");
        
        
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        
        button1.addActionListener(this);
        button2.addActionListener(this);
        
        frame.add(buttonPanel, BorderLayout.PAGE_END);
        
        resultPanel = new JPanel();
        resultLabel = new JLabel("Result = ");
        
        
        resultLabel.setName("resultLabel");
        resultPanel.add(resultLabel);
        frame.add(resultPanel, BorderLayout.CENTER);
        
        textFieldPanel = new JPanel();
        textField1 = new JTextField(7);        
        textField1.setName("infixExpression");
        textFieldPanel.add(textField1);               
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
        //Calculator2 calc2 = new Calculator2();       
    }
  
    /**
     * Action Listener.
     * @param e **ActionEvent**
     */
    
    public void actionPerformed(ActionEvent e)
    {
        // TODO Auto-generated method stub
         
        
        try
        {
            if (e.getSource().equals(button1))
            {
                
                resultLabel.setText("Result =");
                String result = textField1.getText();
                ExpressionEvaluator calcEval = new ExpressionEvaluator();
                String endResult = calcEval.toPostfix(result);
                
                if (!endResult.equals("Error"))
                {
                    resultLabel.setText("Result = " 
                        + calcEval.evaluate(endResult));
                }
                else
                {
                    resultLabel.setText("Error");
                }
                
               // resultLabel.setText("Result = " + String.valueOf(a + b));
            }
            else if (e.getSource().equals(button2))
            {
                textField1.setText("");
                resultLabel.setText("Result =");
               // resultLabel.setText("Result = " + String.valueOf(calc2.evaluate));
            
            
            
                
               
            
            }
            
            
        }
        catch (Exception exc)
        {
            resultLabel.setText("Result = Error");
            return;
        }
        
      
      
    }

    
}
