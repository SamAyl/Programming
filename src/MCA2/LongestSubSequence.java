package MCA2;

import java.util.ArrayList;
import java.util.List;

public class LongestSubSequence {

    public static void main(String[] args) {
        String a = "ab";
        String b = "avvdffe";

        List<String> answers = findSubSeq(a,0);
        CommonUtils.printString(answers);

    }


    static List<String> findSubSeq(String a, int index){

        if(index==a.length()-1){
            List<String> subSeqLastIndex = new ArrayList<>();
            subSeqLastIndex.add(((Character)a.charAt(index)).toString());
            return subSeqLastIndex;
        }

        // List<String> subSeqForCurrentIndex = new ArrayList<>();

        List<String> subSeqForIndex = findSubSeq(a,index+1);
        int size = subSeqForIndex.size();
        for(int j = 0;j<size;j++){
            subSeqForIndex.add(a.charAt(index)+subSeqForIndex.get(j));
        }
        subSeqForIndex.add(new String(((Character )(a.charAt(index))).toString()));


        return subSeqForIndex;

    }
}
