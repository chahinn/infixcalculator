import junit.framework.TestCase;
import java.util.Arrays;
import java.util.*;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class ExpressionTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testExpression() {
    System.out.println("testExpression");
    Expression e1 = new Number(46);
    assertEquals("e1",46,e1.valueOf()); 
    System.out.println(e1.valueOf());
  
    
    Expression e2 = new BinaryExpression(new Operator("*"),new Number(23),new Number(100));
    assertEquals("e2",2300,e2.valueOf());
    
    Expression e3 = new BinaryExpression(new Operator("+"),e2,e1);
    assertEquals("e3",2346,e3.valueOf());
  }

  
  public void testBuildExpression() {
     System.out.println("testBuildExpression");
  
     ArrayList<Token> postfix = new ArrayList<Token>();
     postfix.add(new Number(37));
     Expression e1 = ExpressionManager.buildExpression(postfix);
     assertEquals("build test 1",37,e1.valueOf());
    
     postfix.clear();
     postfix.add(new Number(20));
     postfix.add(new Number(13));
     postfix.add(new Operator("*"));
     Expression e2 = ExpressionManager.buildExpression(postfix);
     assertEquals("build test 2",260,e2.valueOf());
  
    }
    
    public void testInfixToPostfix(){
      List<Token> infix = new ArrayList<Token>();
      infix.add(new Number(20));
      infix.add(new Number(13));
      infix.add(new Operator("-"));
      List<Token> postfix = ExpressionManager.infixToPostfix(infix);
      Expression e2 = ExpressionManager.buildExpression(postfix);
      assertEquals("build test2",7,e2.valueOf());

    
    } 
}
