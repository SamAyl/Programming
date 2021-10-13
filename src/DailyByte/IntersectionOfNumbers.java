package DailyByte;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfNumbers {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8};
        int[] arr2 = {1, 3, 5, 7};

        Set<Integer> set1 = new HashSet<>();

        int[] longestArr = arr2;
        int[] shortestArr = arr;
         if (arr.length > arr2.length) {
             longestArr = arr;
             shortestArr = arr2;
         }
          for (int elementsFromFirsArr : longestArr) {
              set1.add(elementsFromFirsArr);
          }

          Set<Integer> cmonElements = new HashSet<>();
          for (int singleElement :shortestArr) {
              if (set1.contains(singleElement)) {
                  cmonElements.add(singleElement);
              }
          }


        System.out.println("Printing common elements");

          for (Integer elements : cmonElements) {
              System.out.println(elements);
          }
    }
}
