package WordSearch;

public class App {

    public static void main(String[] args) {

        char[][] letters = {{'a','b','c'},
                            {'d','e','f'},
                             {'g','h','i'}};

        System.out.println(findWord(letters,""));
    }

    public static boolean findWord(char[][] letters,String s){
        for(int i = 0;i<letters.length;i++){
            for(int j = 0;j<letters[0].length;j++){
                if(letters[i][j]==s.charAt(0)){
                    boolean check = checkWord(letters,i,j,s,0);
                    if(check){
                        return check;
                    }
                }
            }
        }

        return false;
    }


    public static boolean checkWord(char[][] letters,int i,int j,String s,int index){


        if(i+1<letters.length && s.charAt(index+1) == letters[i+1][j] ){
           int temp = i;
           int tempIndex = index;
           while (temp<letters.length && tempIndex<s.length()){
               if(s.charAt(tempIndex)==letters[temp][j]){
                   tempIndex++;
                   temp++;
               }
           }

           if(tempIndex==s.length()){
               return true;
           }


        }

        if(i-1>=0 && s.charAt(index+1)==letters[i-1][j]){
            int temp = i;
            int tempIndex = index;

            while (temp>=0 && tempIndex<s.length()){
                if(s.charAt(tempIndex)==letters[temp][j]){
                    tempIndex++;
                    temp--;
                }
            }

            if(tempIndex==s.length()){
                return true;
            }
        }

        if(j+1<letters[0].length && s.charAt(index+1)==letters[i][j+1]){
            int tempIndex  = index;
            int temp = j;

            while (temp<letters[0].length && tempIndex<s.length()){
                if(s.charAt(tempIndex)==letters[i][temp]){
                    tempIndex++;
                    temp++;
                }
            }

            if(tempIndex==s.length()){
                return true;
            }
        }

        if(j-1 >=0 && s.charAt(index+1)==letters[i][j-1]){

            int tempIndex = index;
            int temp = j;

            while (temp>=0 && tempIndex<s.length()){
                if(letters[i][temp] == s.charAt(tempIndex)){
                    temp--;
                    tempIndex++;
                }
            }

            if(tempIndex==s.length()){
                return true;
            }
        }

        return false;
    }
}
