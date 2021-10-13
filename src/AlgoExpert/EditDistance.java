package AlgoExpert;

import java.util.*;

public class EditDistance {

    static Map<Index,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(getMin("ABCD", "ABXD",0,0));
    }

    public static int getMin(String s, String p, int index1, int index2) {

         if (index1>= s.length() && index2 >= p.length()) {
             return 0;
         } else if (index1 < s.length() && index2>=p.length()) {
             return s.length() - index1;
         } else if (index1>=s.length() && index2 < p.length()) {
             return p.length() - index2;
         }


         Index obj = new Index(index1,index2);
         if (map.containsKey(obj)) {
             return map.get(obj);
         }

        if (s.charAt(index1) == p.charAt(index2)) {
            index1++;
            index2++;

            int res =  getMin(s,p,index1+1,index2+1);
            map.put(obj,res);
            return res;
        } else {
            int replaceCount = 0;
            int insertCount = 0;
            int deleteCount = 0;

            Index replaceIndex = new Index(index1+1,index2+1);
            Index insertIndex = new Index(index1+1,index2);
            Index deleteIndex = new Index(index1,index2+1);

            if (map.containsKey(replaceIndex)) {
                replaceCount = map.get(replaceIndex);
            } else {
                replaceCount = getMin(s,p,index1+1,index2+1);
                map.put(replaceIndex,replaceCount);
            }


            if (map.containsKey(insertIndex)) {
                insertCount = map.get(insertIndex);
            } else {
                insertCount = getMin(s,p,index1+1,index2);
                map.put(insertIndex,insertCount);
            }

            if (map.containsKey(deleteIndex)) {
                deleteCount = map.get(deleteIndex);
            } else {
                deleteCount = getMin(s,p,index1+1,index2);
                map.put(deleteIndex,deleteCount);
            }

            int replaceEdit = 1 + replaceCount;
            int insertEdit = 1  + insertCount;
            int deleteEdit = 1  + deleteCount;

             int finalAns = Math.min(deleteEdit,Math.min(replaceEdit,insertEdit));
             map.put(obj,finalAns);
             return finalAns;
        }

    }
}

class Index{
    int sIdx;
    int pIdx;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return sIdx == index.sIdx &&
                pIdx == index.pIdx;
    }

    public Index(int sIdx, int pIdx) {
        this.sIdx = sIdx;
        this.pIdx = pIdx;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sIdx, pIdx);
    }
}
