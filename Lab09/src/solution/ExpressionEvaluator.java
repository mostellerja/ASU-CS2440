package solution;


import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Stack;


/**
 * 
 * @author AaronMosteller
 * @version 4/4/2019
 * 
 */
public class ExpressionEvaluator
{

    public static final Pattern UNSIGNED_DOUBLE =
            Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
    public static final Pattern CHARACTER = Pattern.compile("\\S.*?");
    

    /**
     * Takes an infix expression and converts it to postfix.
     * 
     * @param expression
     *            The infix expression.
     * @return the postfix expression.
     * 
     */
    public String toPostfix(String expression)
    {
        // ... other local variables
        Scanner input = new Scanner(expression);
        String next;
        char symbol;
        Stack<Character> stack = new Stack<Character>(); 
        String postfixExpression = "";
        int countOperand = 0;
        int countOperator = 0;
        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                // TODO: do what you want to with a String that
                // holds a number
                countOperand++;
                postfixExpression += next + " ";
            }
            else
            {
                next = input.findInLine(CHARACTER);
                symbol = next.charAt(0);

                // TODO: do what you want to with a symbol
                // such as (, ), *, /, +, -
                if (symbol == '(')
                {
                    
                    
                    //3 + 4 * 2
                    //4 / 2
                    //(3 * 5) + 10 / 7
                    stack.push(symbol);
                    
                }
                else if (symbol == '*' || symbol == '/' 
                    || symbol == '+' || symbol == '-')                    
                {
                    while (!stack.isEmpty() && stack.peek() != '('
                        && ((stack.peek() == '*')
                        || (stack.peek() == '/')
                        || (stack.peek() == '+' 
                        && (symbol == '+' || symbol == '-'))
                        || (stack.peek() == '-' 
                        && (symbol == '+' || symbol == '-'))))
                    {
                        countOperator++;
                        postfixExpression += (char) stack.pop() + " ";
                    }
                    stack.push(symbol);
                }
                else if (symbol == ')')
                {
                    while (!stack.isEmpty() && stack.peek() != '(')
                    {
                        countOperator++;
                        postfixExpression += (char) stack.pop() + " ";
                        
                    }
                    
                    if (stack.peek() == '(')
                    {
                        stack.pop();
                    }
                    else
                    {
                        input.close();
                        return "Error";
                    }
                }
                else
                {
                    postfixExpression = "Error";
                }
                
                        
            }
            
               
        }
        while (!stack.empty())
        {
            symbol = stack.pop();
            if (symbol != '(')
            {
                countOperator++;
                postfixExpression += symbol + " ";
                
                    
            }
            
        }
        if (countOperand - 1 != countOperator)
        {
            input.close();
            return "Error";
            
        }
        input.close();
        return postfixExpression;
        
    }
        


    /**
     * Evaluates a postfix expression and returns the result.
     * 
     * @param postfixExpression
     *            The postfix expression.
     * @return The result of the expression.
     */
    public double evaluate(String postfixExpression)
    {
        // other local variables you may need
        Scanner input = new Scanner(postfixExpression);
        String next;
        char operator;
        double answer = Double.NaN;
        Stack<Double> stack = new Stack<Double>();
        
        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                // TODO: do what you want to with a String that
                // holds a number
                stack.push(Double.parseDouble(next));
                //postfixExpression += next + " ";
            }
            else
            {
                next = input.findInLine(CHARACTER);
                operator = next.charAt(0);

                // TODO: do what you want to with an operator
                // such as *, /, +, -
                
                
                double operand2 = 0.0;
                double operand1 = 0.0;
                
               
                    
                if (operator == '*')
                {
                    
                    
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push((operand1 * operand2));
                }
                else if (operator == '/')
                {
                    
                    operand2 = stack.pop();
                    operand1 = stack.pop();
                    stack.push((operand1 / operand2));
                }
                else if (operator == '+')
                {
                    
                    operand2 = stack.pop();
                    operand1 = stack.pop();
                    stack.push((operand1 + operand2));
                }
                else if (operator == '-')
                {
                    
                    operand2 = stack.pop();
                    operand1 = stack.pop();
                    stack.push((operand1 - operand2));
                }
            }
            
        }
        answer = stack.pop();
        input.close();
        return answer;
        
    }
    
}
