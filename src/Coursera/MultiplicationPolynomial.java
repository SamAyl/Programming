package Coursera;

public class MultiplicationPolynomial {

    public static void main(String[] args) {

        MultiplicationPolynomial mp = new MultiplicationPolynomial();
        int[] a = {1,1};
        int[] b = {1,1};

        int[] c = mp.mulPol(a,b);
        System.out.println(c.length);
    }


    public int[] mulPol(int[] a,int[] b){
        if(a.length==1 && b.length ==1){
            int[] ans = new int[1];
            ans[0] = a[0] * b[0];
            return ans;
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

        return add(moveRight(a1,a.length),moveLeft(b1,(a.length)),multiply_X(add(c1,d1,null),lSize+1));

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

    private int[] add(int[] a,int [] b,int[] c){

        if(c==null){
            c=new int[a.length];
        }
        int[] ans = new int[a.length];

        for(int i = 0;i<a.length;i++){
            ans[i] = a[i] + b[i] + c[i];
        }

        return ans;
    }


    private void fill(int[] temp, int[] a,int str,int end){

        for(int i = 0;i<temp.length;i++){
            temp[i] = a[str];
            str++;
        }
    }


}
