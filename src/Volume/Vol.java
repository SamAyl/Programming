package Volume;

public class Vol {

    public static int[] a = {5,2,10,0,11,3,5};

    public static void main(String[] args){
        System.out.println(getVol(0,a.length-1));
    }
    public static int getVol(int str,int end){

        int index1=-1;
        int index2=-1;

        if(str<=end) {
             index1 = max(str, end);
             index2 = getNextMax(str,end,index1);
        }


        int str1;
        int str2;

        if(index1>index2){
            str1 = index2;
            str2 = index1;
        }else{
            str1 = index1;
            str2 = index2;
        }

        int sum = 0;

        if(str1==str2){
            return 0;
        }else if(str2-str1 == 1 || str1-str2 == 1){
            return 0;
        }else if(str1==-1 || str2 == -1){
            return 0;
        }
        else {
            sum =  cal(str1,str2);
                return sum + getVol(str, str1) + getVol(str2, end);
        }

    }


    public static int max(int str,int end){
        int val = a[str];
        int index = str;

        for(int i = str+1;i<=end;i++){
            if(val<a[i]){
                val = a[i];
                index = i;
            }
        }


        return index;
    }

    public static int getNextMax(int str,int end, int index){
        if(str == end){
            return str;
        } else if(index == str){
            return max(str+1,end);
        }else{
            int val = a[str];
            int indx = str;

            for(int i = str;i<end;i++){
                if(i == index){
                    continue;
                }

                if(val<a[i]){
                    val = a[i];
                    indx = i;
                }

            }

         return indx;
        }
    }
    public static int cal(int str,int end){

       int ref = (a[str]>a[end])?a[end]:a[str];
       int tempSum = 0;


           for (int i = str + 1; i < end; i++) {
               tempSum += ref - a[i];
           }


       return tempSum;
    }
}
