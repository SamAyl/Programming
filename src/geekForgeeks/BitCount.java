package geekForgeeks;

public class BitCount {


    public static void main(String[] args) {
        BitCount b = new BitCount();
        b.smartHammingWeight(11);
    }

    public int hammingWeight(int n) {

        int count = 0;
        Byte[][] ans = getByteArr();
        Byte[] b  = ans[0];
        Byte[] b1 = ans[1];

        boolean negative = false;

        if(n<0){
            negative = true;
        }

        int byteIndex = 0;
        while(n != 0){
            if(n%2 == 1 || n%2==-1){
                count++;
                b[byteIndex] = 0;
            }

            n = n/2;
            byteIndex++;
        }

       if(!negative){
           return count;
       } else {
           return addByteArr(b,b1);
       }
    }

    Byte[][] getByteArr(){
        Byte[] b = new Byte[32];
        Byte[] b1 = new Byte[32];
        for(int i = 0;i<32;i++){
            b[i] = 1;
            b1[i] = 0;
        }

        b1[0] = 1;

        Byte[][] ans = new Byte[2][32];
        ans[0] = b;
        ans[1] = b1;

        return ans;
    }



    public int addByteArr(Byte[] a , Byte[] b){

        byte borrow = 0;
        int count = 0;
        for(int i = 0;i< 32;i++){
            if(a[i] == 0 && b[i] == 0){
                if(borrow == 1){
                    count++;
                    borrow =0;
                }
            } else  if(a[i] == 1 && b[i] == 1){
                if(borrow == 0){
                    borrow = 1;
                } else {
                    borrow = 1;
                    count++;
                }
            } else {
                if(borrow ==0){
                    count++;
                } else {
                    borrow = 1;
                }
            }
        }

        return count;

    }


    public int smartHammingWeight(int n){
        int mask = 1;
        int count = 0;

        for(int i = 0;i<32;i++){
            System.out.println(n & mask);
            if( (n & mask) == 1){
                count++;
            }
            mask<<=1;
        }

        return count;
    }
 }
