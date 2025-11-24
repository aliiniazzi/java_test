public class MathOperation {

     public double add (double numberOne , double numberTwo){
         return numberOne + numberTwo;
     }

     public double subtraction(double numberOne , double numberTwo){
         return numberOne - numberTwo;
     }

     public double multiply(double numberOne , double numberTwo){
         return numberOne * numberTwo;
     }

     public double divide(double numberOne , double numberTwo){
         if (numberTwo == 0){
             throw new ArithmeticException("cannot divide by zero !");
         }
         return  numberOne / numberTwo;
     }

}
