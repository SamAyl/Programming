package PriQue;

public class App {

    public static int[] arr = new int[10];
    public static boolean empty = true;
    public static int currentIndex = 0;


    public static void main(String[] args) {
        insert(3);
        insert(2);
        insert(1);
        insert(5);
        insert(10);
        insert(0);

        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());
        System.out.println(remove());


    }

    public static void insert(int val){

        if(empty){
            arr[0] = val;
            currentIndex++;
            empty = false;
        }else {
            arr[currentIndex] = val;
            bubbleUp(currentIndex);
            currentIndex++;
        }

    }


    public static void bubbleUp(int currentIndex){
        int pIndex = -1;
        if(currentIndex%2==0){
            pIndex = (currentIndex-2)/2;
        }else {
            pIndex = (currentIndex-1)/2;
        }

        pIndex = pIndex/2;

        if(pIndex>=0){

            if(arr[currentIndex] < arr[pIndex]){
                swap(currentIndex,pIndex);
                bubbleUp(pIndex);
            }
        }
    }

    public static void bubbleDown(int currentIndex,int pIndex){

        int lIndex = (int)Math.pow(2.0,pIndex);
        int rIndex = lIndex+1;

        if(lIndex<=currentIndex && rIndex<=currentIndex) {
            if(arr[lIndex]<arr[pIndex]  && arr[rIndex]<arr[pIndex]){
                if(arr[lIndex] > arr[rIndex]){
                    swap(rIndex,pIndex);
                    bubbleDown(currentIndex,rIndex);
                }else {
                    swap(lIndex,pIndex);
                    bubbleDown(currentIndex,lIndex);
                }

            }
        }else if(lIndex<=currentIndex){
            if(arr[lIndex]<arr[pIndex]){
                swap(lIndex,pIndex);
            }
        }

    }


    public static void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int peek(){
        if(!empty) {
            return arr[0];
        }else {
            return -1;
        }
    }

    public static int remove(){

        int temp = arr[0];
        if(currentIndex-1>=0) {
            arr[0] = arr[currentIndex - 1];
            currentIndex--;
            if (currentIndex > 0) {
                bubbleDown(currentIndex - 1, 0);
            } else {
                currentIndex = 0;
            }

        }
        return temp;
    }




    public static void print(){
        for(int i =0 ;i<currentIndex;i++){
            System.out.println(arr[i]);
        }
    }

}

