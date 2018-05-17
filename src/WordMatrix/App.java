package WordMatrix;

public class App {

    public static void main(String[] args) {
        char[][] ch = {{'a','b','c'},
                       {'d','e','f'},
                       {'g','h','i'},
        };

        System.out.println(findWord(ch,"adg"));

    }

    public static boolean findWord(char[][] ch,String word){
        boolean answer = false;
        for(int i = 0;i<ch.length;i++){
            for(int j = 0;j<ch[0].length;j++){
                   if(ch[i][j] == word.charAt(0) ){
                          answer = check(ch,i,j,word,0,word.length()-1);
                          if(answer){
                              return answer;
                          }
                   }
            }
        }

        return answer;
    }

    public static boolean check(char[][] ch,int i, int j, String word,int index,int size){

        if(i+1<=ch.length-1 && index+1<=size && word.charAt(index+1)==ch[i+1][j]){
           int temp1 = i+1;
           int temp2 = index+1;

           while (temp1<=ch[i].length-1 && temp2<=size){
               if(word.charAt(temp2)==ch[temp1][j]){
                   temp2++;
                   temp1++;
               }else {
                   break;
               }
           }

           if(temp2==size+1 && temp1<=ch[i].length){
               return true;
           }

        }

        if(i-1>=0 && index+1<=size && word.charAt(index+1)==ch[i-1][j]){
            int temp1 = i-1;
            int temp2 = index+1;

            while (temp1<=ch[i].length-1 && temp2<=size){
                if(word.charAt(temp2)==ch[temp1][j]){
                    temp2++;
                    temp1--;
                }else {
                    break;
                }
            }

            if(temp2==size+1 && temp1>=0){
                return true;
            }

        }

        if(j+1>=ch[0].length-1 && index+1<=size && word.charAt(index+1)==ch[i][j+1]){
            int temp1 = j+1;
            int temp2 = index+1;

            while (temp1<=ch[i][j] && temp2<=size){
                if(word.charAt(temp2)==ch[temp1][j]){
                    temp2++;
                    temp1++;
                }else {
                    break;
                }
            }

            if(temp2==size+1 && temp1<=ch[i].length){
                return true;
            }

        }


        if(j-1>=0 && index+1<=size && word.charAt(index+1)==ch[i][j-1]){
            int temp1 = j-1;
            int temp2 = index+1;

            while (temp1<=ch[i][j] && temp2<=size){
                if(word.charAt(temp2)==ch[temp1][j]){
                    temp2++;
                    temp1--;
                }else {
                    break;
                }
            }

            if(temp2==size+1 && temp1>=0){
                return true;
            }

        }


        return false;
    }

}

