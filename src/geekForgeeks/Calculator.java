package geekForgeeks;


public class Calculator {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.calculate("(3-(2-(5-(9-(4)))))"));
       // System.out.println(c.calculate("1+1"));
    }

       int index = 0;
        public Integer calculate(String s) {

            s = s.replace(" ", "");
            if (s.length() == 1) {
                return Integer.parseInt(s);
            } else if ((!s.contains("+") && !s.contains("-"))) {
                s = s.replace("(", "");
                s = s.replace(")", "");
                return Integer.parseInt(s);
            }

            return calculater(s);
        }


        public int calculater(String s) {

            int sum = 0;
            int tempSum=0;
            int operand = 1;
            while (index<s.length()){

                if(s.charAt(index) == '('){
                     index++;
                     sum+=(calculater(s)*operand);
                } else if(s.charAt(index) == ')'){
                    index++;
                    sum+=(tempSum * operand);
                    return sum;
                } else if(s.charAt(index)-'0'>=0 && s.charAt(index) - '0'<=9){
                    tempSum = tempSum*10 + (s.charAt(index)-'0');
                    index++;
                } else if(s.charAt(index) == '+'){
                    sum+=(tempSum * operand);
                    tempSum=0;
                    operand=1;
                    index++;
                } else if(s.charAt(index) == '-'){
                  sum+=(tempSum * operand);
                  tempSum=0;
                  operand = -1;
                  index++;
                }

            }

            return sum+tempSum*operand;

        }
    }




