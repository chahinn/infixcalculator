public class BinaryExpression implements Expression{
Operator operator;
Expression left, right;


  public BinaryExpression(Operator operator, Expression left, Expression right){
     this.operator= operator;
     this.left=left;
     this.right=right;
     
  }
                   
  public int valueOf(){
    
    int result= operator.apply(left.valueOf(),right.valueOf());
    return result;
  
  }
  
 
     
     
   public String toPrefix(){
    String prefix;
    prefix= operator+" "+left+ " " + right;
    return prefix;
   }
   
   public String toInfix(){
   
     String infix;
     infix= "(" + left+" "+ operator + " " + right+")";
     return infix;
   
   }
   
   public String toPostfix(){
     String postfix;
     postfix= left+ " " + right+ " " +operator;
     return postfix;
   
   }
   
   
   public String toString(){
    
    return toInfix();
   }

  
  

//Expression e1=  new BinaryExpression(new Operator("*"), new Number(6), new Number(2));
//Expresssion e2= new BinaryExpression(new Operator("+"), new Number(5),e1);

}