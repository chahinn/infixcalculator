import java.util.*;
   
class ExpressionManager {
   
    public static List<Token> infixToPostfix(List<Token> list){
    // TODO:  This is where you write your infix to postfix algorithm
      
      ArrayList<Token> tokenlist = new ArrayList<Token>();
      Stack<Operator> operatorStack = new Stack<Operator>();
      Token temp;
      
      
      Token temp2;
      int parentcounter=0;
      for(int j=0;j<list.size();j++){
        
          temp2= list.get(j); 
            System.out.println(parentcounter);
            if(temp2.equals("(")){
              parentcounter= parentcounter+1;
              
            }
            if(temp2.equals(")")){
               parentcounter= parentcounter-1;
               
               
                 
            }
        
                  
            if (parentcounter<0){
                    System.out.println(parentcounter);
                    throw new ArithmeticException("Invalid parentheses start"); 
             }
            System.out.println(parentcounter);
                  
                 
                 
              
      }

        if(parentcounter>0){
         throw new ArithmeticException("Mismatched parentheses"); 
        }
           
          
          
        
      
      
      
      
      
      
      
      for(int i=0;i<list.size();i++)
      {
        temp= list.get(i);
        if(temp.isNumber())
        {
          tokenlist.add(temp); 
        }
        else if (temp.equals("("))
        {
           Operator temp1 = (Operator) temp;
           operatorStack.push(temp1);
        }
        else if (temp.equals(")"))
        {
          while(!operatorStack.peek().equals("(")){
           tokenlist.add(operatorStack.pop()); 
          }
          operatorStack.pop();
        }
          
        else if(temp.isOperator())
        {
          Operator temp1= (Operator) temp;
          while(!operatorStack.isEmpty() && operatorStack.peek().getPriority()>=temp1.getPriority())
          {
             tokenlist.add(operatorStack.pop());
          }
          operatorStack.push(temp1);
        }
        
      }
      
      while(!operatorStack.isEmpty())
      {
         tokenlist.add(operatorStack.pop());
      }
   
     
    return tokenlist;
    }
    
    public static Expression buildExpression(List<Token> postfixList){
      Stack<Expression> stackexp = new Stack<Expression>();
      for(int i=0;i<postfixList.size();i++)
      {
        Token x = postfixList.get(i);
        if(x.isNumber()){
         Number temp= (Number) x;
         stackexp.push(temp);
        }
        else if(x.isOperator())
        {
           Operator temp= (Operator) x;
           Expression tempexp= stackexp.pop();
           Expression tempexp2 = stackexp.pop();
          BinaryExpression BiExp = new BinaryExpression(temp, tempexp2, tempexp);
          stackexp.push(BiExp);  
        
        }
      }
      return stackexp.pop();
      
        
    // TODO:  This is where you write your postfix evaluation algorithm
   
    }
       
}