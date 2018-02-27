package Consecutive;

public class App2 {

    static double[] a = {1,2,2,4,4,5,3,3,1};

    public static void main(String[] args){

        int i = 0;
        int temp1 = i;
        int temp2 = i+1;

        while (i<a.length-1){
            if(a[i]==Double.NaN){
                i++;
                temp1 = i;
                temp2=temp1+1;
                continue;
            }

            if(a[temp1] == a[temp2]){
                a[temp1] = Double.NaN;
                a[temp2] = Double.NaN;
                i--;
                if(i>=0) {
                    temp1 = i;
                    temp2 = temp2 + 1;
                }else {
                    i = temp2+1;
                    temp1 = i;
                    temp2 = temp1+1;
                }

            }else {
                i++;
                temp1 = i;
                temp2 = i+1;
            }


        }

        for(i =0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }



}
