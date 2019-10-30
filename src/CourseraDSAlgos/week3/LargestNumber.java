package CourseraDSAlgos.week3;

import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {


        // 123 1 => 9239  => 1123

        List<String>  b = new ArrayList<>();

        for(String s : a){
            if(!s.equals("0")){
                b.add(s);
            }
        }




        Collections.sort(b, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer o11 = Integer.parseInt(o1);
                Integer o22 = Integer.parseInt(o2);

                int c1 = 0;
                int c2 = 0;

                if (o1.equals(o2)) {
                    return 0;
                }



                while (c1 < o1.length() && c2 < o2.length()) {
                    if (o1.charAt(c1) > o2.charAt(c2)) {
                        return 1;
                    } else if (o1.charAt(c1) < o2.charAt(c2)) {
                        return -1;
                    }
                    c1++;
                    c2++;
                }

                if (Integer.parseInt(o1+o2) > Integer.parseInt(o2+o1)) {
                    return 1;
                } else {
                    return -1;
                }

            }

        });

        StringBuilder sb = new StringBuilder();

        for(int i = b.size()-1;i>=0;i--){
            sb.append(b.get(i));
        }

        int zeroCount = a.length - b.size();

        while (zeroCount!=0){
            sb.append("0");
            zeroCount--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

