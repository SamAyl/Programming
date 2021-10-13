package AlgoExpert;

import java.util.*;

public class App4 {

    public static void main(String[] args) {
        App4 app4 = new App4();
        app4.combine(4,2);
    }

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> list = new ArrayList<>();
            combine(n,k,list,new ArrayList<>(),1);
            return list;
        }

        public void combine(int n,int k, List<List<Integer>> list, List<Integer> temp, int strIdx) {

            if (temp.size() == k) {
                List<Integer> ans = new ArrayList<>();
                ans.addAll(temp);
                list.add(ans);
                return;
            }

            if (strIdx > n) {
                return;
            }

            for (int i  = strIdx ;i<=n;i++) {
                temp.add(i);
                combine(n,k,list,temp,strIdx+1);
                temp.remove(temp.size()-1);
            }


            List<Integer> lit = new ArrayList<>();
        //    lit.a
        }

}
