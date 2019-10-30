package InterviewKickstart;

public class QuickSort {


    public static void main(String[] args) {


        int[] num = {0,100,-10};
        quickSort(num,0,num.length-1);

        for(int i : num){
            System.out.println(i);
        }

    }

    private static void quickSort(int[] num,int str,int end){

        if(str==end){
            return;
        }

        if(str==end+1){
            return;
        }

        int pivotIndex = getPivot(str,end);
        int pivotElementActualIndex = partition(num,str,end,pivotIndex);

        quickSort(num,str,pivotElementActualIndex-1);
        quickSort(num,pivotElementActualIndex+1,end);


    }


    private static int getPivot(int str,int end){
        return end;
    }

    private static int partition(int[] num,int str,int end,int pivotIndex){

        int indexStore = str-1;
        int indexTraverse = str;

        while (indexTraverse<=end){
            if(num[indexTraverse]<=num[pivotIndex]){
                indexStore++;
                swap(num,indexStore,indexTraverse);
                indexTraverse++;
            }else if(num[indexTraverse]>num[pivotIndex]){
                indexTraverse++;
            }
        }


        indexStore++;
        swap(num,indexStore,pivotIndex);

        return indexStore;

    }

    private static void swap(int[] num,int a,int b){
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }



}


