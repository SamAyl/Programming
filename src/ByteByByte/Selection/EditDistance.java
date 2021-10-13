package ByteByByte.Selection;

public class EditDistance {

    public static void main(String[] args) {
        String s1 = "cab";
        String s2 = "abc";

        int[] size = {Integer.MAX_VALUE};
        int[] tempSize = {0};
        minEditDist(s1,s2,0,0,tempSize,size);
        System.out.println(size[0]);
    }


    public static void minEditDist(String s1, String s2, int idx1, int idx2, int[] editDist, int[] maxDist) {

      if (idx2 == s2.length() && idx1 == s1.length()) {
          maxDist[0] = Math.min(maxDist[0],editDist[0]);
          return;
      }  else if (idx2 == s2.length() && idx1 < s1.length()) {
          int delCharCount = s1.length() - idx1;
          editDist[0]+=delCharCount;
          maxDist[0] = Math.min(maxDist[0],editDist[0]);
          editDist[0]-=delCharCount;
          return;
      } else if (idx1 == s1.length() && idx2  < s2.length()) {
          int inserCharCount = s2.length() - idx2;
          editDist[0]+=inserCharCount;
          maxDist[0] = Math.min(maxDist[0],editDist[0]);
          editDist[0]-=inserCharCount;
          return;
      }



        if (idx1 < s1.length() && idx2 < s2.length()) {

            if (s1.charAt(idx1) == s2.charAt(idx2)) {
               idx1++;
               idx2++;
               minEditDist(s1,s2,idx1,idx2, editDist,maxDist);
               idx1--;
               idx2--;
            }  else {

                //insertion
                idx2++;
                editDist[0]+=1;
                minEditDist(s1,s2,idx1,idx2,editDist,maxDist);
                editDist[0]-=1;
                idx2--;
                //deletion

                idx1++;
                editDist[0]+=1;
                minEditDist(s1,s2,idx1,idx2,editDist,maxDist);
                editDist[0]-=1;
                idx1--;

            }

        }


    }
}
