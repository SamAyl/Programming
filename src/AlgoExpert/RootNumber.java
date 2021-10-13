package AlgoExpert;

public class RootNumber {

    public static void main(String[] args) {
        double low = 0.001;
        double high = 24.000;
        double x = 98.76;
        int n = 3;
        while (true) {


            double mid = (low + high) / 2;

            if (Math.abs(x - Math.pow(mid, n)) <= 0.001) {
                System.out.println(mid);
                break;
            } else {

                if (x > Math.pow(mid, n)) {
                    low = mid + 0.001;
                } else {
                    high = mid - 0.001;
                }

            }
        }
    }

}