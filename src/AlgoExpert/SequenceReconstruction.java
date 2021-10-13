package AlgoExpert;

import java.util.*;

public class SequenceReconstruction {

    public static void main(String[] args) {
          int[] orgs = {4,1,5,2,6,3};
//[[5,2,6,3],[4,1,5,2]]
          List<Integer> list1 = new ArrayList<>();
          List<Integer> list2 = new ArrayList<>();
          List<Integer> list3 = new ArrayList<>();

          list1.add(5);
          list1.add(2);
          list1.add(6);
          list1.add(3);

          list2.add(4);
          list2.add(1);
          list2.add(5);
          list2.add(2);


          List<List<Integer>> sw = new ArrayList<>();
          sw.add(list1);
         sw.add(list2);
//         sw.add(list3);

        System.out.println(sequenceReconstruction(orgs,sw));
    }
        public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {

            Map<Integer,Nod> integerNodeMap = new HashMap<>();

            System.out.println();
            for(List<Integer> singleSeq : seqs) {

                for (int k = 0; k<singleSeq.size()-1;k++){
                    if (k == 1) {
                        System.out.println("");
                    }
                    int firstNode = singleSeq.get(k);
                    int secondNode = singleSeq.get(k+1);

                    Nod firstElement = new Nod(firstNode);
                    Nod secondElement = new Nod(secondNode);

                    if (integerNodeMap.containsKey(firstNode)) {
                        firstElement = integerNodeMap.get(firstNode);
                    }

                    if (integerNodeMap.containsKey(secondNode)) {
                        secondElement = integerNodeMap.get(secondNode);
                    }


                  Nod secPrev = secondElement.prev;
                  Nod secNext = secondElement.next;

                  if (secPrev != null) {
                      secPrev.next = secNext;
                  }

                  if (secNext !=null) {
                      secNext.prev = secPrev;
                  }


                  Nod firNext = firstElement.next;

                  if (firNext != null) {
                      firNext.prev = secondElement;
                  }

                  secondElement.next = firNext;

                  firstElement.next = secondElement;
                  secondElement.prev = firstElement;

                    integerNodeMap.put(firstNode, firstElement);
                    integerNodeMap.put(secondNode, secondElement);
                }
            }

            Nod temp = integerNodeMap.get(org[0]);
            int count = 0;
            while (temp!= null){
                if (temp.val == org[count]) {
                    temp = temp.next;
                    count++;
                } else {
                    return false;
                }
            }
            return count == org.length ? true : false;
        }
    }



class Nod {
    int val;
    Nod next;
    Nod prev;

    public Nod(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        Nod node = (Nod)o;
        return this.val == node.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
