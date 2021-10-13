package LeetCode;

import java.util.*;

public class ValidateIp {


    public static void main(String[] args) {
        ValidateIp v = new ValidateIp();
       List<String> list =  v.restoreIpAddresses("25525511135");
        System.out.println(list.size());
    }

        public List<String> restoreIpAddresses(String s) {
            List<String> ans = new ArrayList<>();

            restoreIp(s.toCharArray(),0,new StringBuilder(),ans);
            return ans;
        }


        public void restoreIp(char[] ch,int index,StringBuilder sb,List<String> list) {
            if(index == ch.length) {
                String temp = sb.toString();
                String[] ans = temp.split("\\.");
                if(ans.length == 4){
                    list.add(temp);
                }
                return;
            }


            if(sb.length()!=0) {
                String chk = sb.toString();
                String[] ch2   = chk.split("\\.");
                if((sb.toString()).split("\\.").length >4){
                    return;
                }
            }

            if(index<ch.length){
                sb.append(ch[index]);
                sb.append(".");
                restoreIp(ch,index+1,sb,list);
                sb.delete(sb.length()-1,sb.length());
            }

            if (index +1  < ch.length){
                sb.append(ch[index+1]);
                String[] numa = sb.toString().split("\\.");
                String num1 = numa[numa.length-1];
                if(num1.charAt(0)!='0'){
                    //sb.append(ch[index+1]);
                    sb.append(".");
                    restoreIp(ch,index+2,sb,list);
                    sb.delete(sb.length()-4,sb.length());
                }

            }

            if(index+2 < ch.length) {
                sb.append(ch[index+2]);
                String[] numa = sb.toString().split("\\.");
                String num = numa[numa.length-1];
                if(num.charAt(0) == '0'){
                    sb.deleteCharAt(sb.length()-1);
                    return;
                } else if ( Integer.parseInt(num)>=0 && Integer.parseInt(num) <=255){
                    sb.append(".");
                    restoreIp(ch,index+3,sb,list);
                    sb.delete(sb.length()-6,sb.length());

                }

            }
        }
    }



