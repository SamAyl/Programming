package RecursionSum;

public class App {

    public static void main(String[] args){

        System.out.println(findSum(1234,2));
    }

    public static int findSum(int num,int b){
        int sum = 0;

        while (num/10!=0){
            sum+=num%10;
            num = num/10;
        }

        sum+=num;

        sum*=b;

        if(sum>=10){
            return findSum(sum,1);
        }else {
            return sum;
        }
    }
}
