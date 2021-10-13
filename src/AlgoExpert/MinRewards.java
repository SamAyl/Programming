package AlgoExpert;

public class MinRewards {

    public static void main(String[] args) {
        int[] s = {4, 2, 1, 3};
        System.out.println(minRewards(s));
    }

    public static int minRewards(int[] scores) {

        int str = 0;
        int[] res = new int[scores.length];

        while (str < scores.length) {

            if (str == 0) {
                int index = get(scores,str+1);
                fill(res,index,0);
                str = index+1;
            } else {

                if (scores[str - 1] == scores[str]) {
                    res[str] = res[str - 1];

                } else if (scores[str - 1] < scores[str]) {
                    res[str] = res[str - 1] + 1;

                } else {
                    res[str] = 1;

                }


                int index1 = get(scores, str + 1);
                fill(res, index1, str);
                str = index1 + 1;
            }
        }
        int sum = 0;
        for (int r : res) {
            sum+=r;
        }


        return sum;
    }


    public static int get(int[] scores, int str) {

        if (str == scores.length) {
            return str;
        }

        while(str<scores.length) {
            if (scores[str-1] > scores[str]){
                str++;
            } else {
                break;
            }
        }

        return str-1;

    }


    public static void fill(int[] res, int end,int str) {
        int count = end  + 1;
        int baseScore = res[str];
        int ptr = str;
        while (ptr <= end) {
            res[ptr] = count + baseScore;
            count--;
            ptr++;
        }
    }
}
