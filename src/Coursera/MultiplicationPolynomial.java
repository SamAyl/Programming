package Coursera;

public class MultiplicationPolynomial {

    public static void main(String[] args) {

        MultiplicationPolynomial mp = new MultiplicationPolynomial();
        int[] a = {1,2,3,4};
        int[] b = {1,1,1,1};

        int[] c = mp.mulPol(a,b);
        System.out.println(c.length);
    }


    public int[] mulPol(int[] a,int[] b){
        if(a.length==1 && b.length ==1){
            int[] ans = new int[1];
            ans[0] = a[0] * b[0];
            return ans;
        }

        if(a.length <b.length){
            a = setToSameLength(b,a);
        }else if(a.length > b.length){
            b = setToSameLength(a,b);
        }
        int lSize = a.length/2;
        int rSize = a.length - a.length/2;

       int[] E0 = new int[lSize];
       int[] D0 = new int[rSize];

       int[] E1 = new int[lSize];
       int[] D1 = new int[rSize];

       fill(E0,a,0,lSize-1);
       fill(D0,a,lSize,a.length-1);

       fill(E1,b,0,lSize-1);
       fill(D1,b,lSize,b.length-1);

       int[] a1 = mulPol(E1,E0);
       int[] b1 = mulPol(D1,D0);
       int[] c1 = mulPol(E1,D0);
       int[] d1 = mulPol(E0,D1);

       int[] res = new int[a.length + b.length-1];



         int moveFactor1 = 0;
         int moveFactor2 = 0;
         if(a.length%2==0){
            moveFactor1 = a.length;
            moveFactor2 = a.length/2;

         }else {
             moveFactor1 = a.length-1;
             moveFactor2 = (a.length)/2;
         }



        add(res,b1,moveFactor1);
        add(res,c1,moveFactor2 );
        add(res,d1,moveFactor2 );
        add(res,a1,0);

        return res;

    }


    private int[] multiply_X(int[] a,int factor){
        int[] temp = new int[a.length +  factor];

        int count = a.length-1;
        for(int i = temp.length-1;i>=0;i--){
            if(count>=0) {
                temp[i] = a[count];
                count--;
            }else{
                break;
            }
        }

        return temp;
    }

    private void add(int[] a,int [] b,int index){

        for(int i = 0;i<b.length;i++){
            a[i+index]+=b[i];
        }
    }


    private void fill(int[] temp, int[] a,int str,int end){

        for(int i = 0;i<temp.length;i++){
            temp[i] = a[str];
            str++;
        }
    }


    private int[] setToSameLength(int[] a,int[] b) {

        int[] temp = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            temp[i] = b[i];
        }

        return temp;

    }
}
