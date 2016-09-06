public class Number implements Token, Expression {
   
   int number;
   String numberAsString="";
   
   public Number(int number){
      this.number = number;
   }
      
   public boolean isNumber(){
      return true;
   }
   
   public boolean isOperator(){
      return false;
   }
   
   
   public int valueOf(){
    
    return number;
   }
   
   public String toPrefix(){
   
    numberAsString= number + "";
    return numberAsString;  
   }
   
   public String toInfix(){
    
    numberAsString= number + "";
    return numberAsString;  
   }
   
   public String toPostfix(){
    
    numberAsString= number + "";
    return numberAsString;  
   }
   
   public String toString(){
   
    numberAsString= number + "";
    return numberAsString; 
   
   }
   
}