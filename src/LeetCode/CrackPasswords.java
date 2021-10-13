package LeetCode;


import java.util.*;

public class CrackPasswords {


    public static void main(String[] args) {
        CrackPasswords c = new CrackPasswords();
        System.out.println(c.crackSafe(2,2));
    }


        public String crackSafe(int n, int k) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb1 = new StringBuilder();

            for(int i = 0;i<n-1;i++){
                sb.append('0');
            }

            size = 1;
            for(int i = 1;i<=n;i++) {
                size*=k;
            }
            crackPwd(n,k,sb,0,size);
            return sb.toString();
        }

        Set<String> passwords = new HashSet<>();
        int size  = 1;

        public void crackPwd(int n,int k,StringBuilder sb, int str, int max){
            if(passwords.size() == max) {
                return;
            }

            boolean visited = false;
            String originalStr = "";
            for(int i = 0;i<k;i++){
                if(originalStr == ""){
                    sb.append(i);
                    originalStr = sb.substring(sb.length() - (n-1));
                } else if(visited){
                    sb.append(originalStr);
                    sb.append(i);
                } else {
                    sb.append(i);
                }
                //sb.append(i);
                String pwd = sb.substring(sb.length()-n,sb.length());
                if(!passwords.contains(pwd)){
                    passwords.add(pwd);
                    crackPwd(n,k,sb,str+1,max);
                    visited = true;
                }else{

                    sb.deleteCharAt(sb.length()-1);
                }
            }


        }



}
