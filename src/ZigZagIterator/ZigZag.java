package ZigZagIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ZigZag {

    private List<List<Integer>> list;
    private List<Iterator<Integer>> iterators = new ArrayList<>();
    private int totalItems = 0;
    private int maxRow = -1;
    private int currentRow = 0;





    public ZigZag(List<List<Integer>> list){
        this.list = list;

        for(List<Integer> list1 : list){
            iterators.add(list1.iterator());
            totalItems+=list1.size();
            maxRow++;
        }

    }


    public boolean hasNext(){
        if(totalItems==0){
            return false;
        }

        return true;
    }


    public int next(){
        if(currentRow>maxRow){
            currentRow = 0;
        }

        int row;
        if(iterators.get(currentRow).hasNext()){
           row  = currentRow;
            totalItems--;
            currentRow++;
            return iterators.get(row).next();

        }else {

            while (!iterators.get(currentRow).hasNext()){
                currentRow++;
                if(currentRow>maxRow){
                    currentRow =0;
                }
            }

            row = currentRow;
            currentRow++;
            totalItems--;
          return   iterators.get(row).next();
        }
    }


}
