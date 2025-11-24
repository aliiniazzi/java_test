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

    public double modulus(double numberOne, double numberTwo) {
         // TODO -> create operation for return remainder of division
         return 0.0;
    }

    public double[] calculateAll(double numberOne, double numberTwo){
         return new double[]{
                 add(numberOne , numberTwo),
                 subtraction(numberOne, numberTwo),
                 multiply(numberOne,numberTwo),
                 divide(numberOne , numberTwo)
         };
    }
}
