package ReverseWord;

public class App {

    public static void main(String[] args){

        char[] letters = {'p','r','e',' ','i','s',' ','p','e','r'};
        System.out.println(letters);
        System.out.println(reverse(letters));
    }

    public static char[] reverse(char[] letters){
        int count = letters.length-1;
        char res[] = new char[count+1];
        int end = count ;
        int whereToStart = 0;
        while(count>=0){
            if(count==0){
                addLast(letters,res,0,end,whereToStart);
                count--;
            }else if(letters[count]==' '){

                add(letters,res,count+1,end,whereToStart);
                whereToStart+= end - (count+1) +1 +1;
                end =  count-1;
                count--;
            }else {
                count--;
            }


        }

        return res;
    }

    public static void add(char[] letters,char[] result,int start,int end,int whereToStart){

        for(int i = start;i<=end;i++){
            result[whereToStart] = letters[i];
            whereToStart++;
        }

        result[whereToStart] = ' ';
    }

    public static void addLast(char[] letters,char[] result,int start,int end,int whereToStart){
        for(int i = start;i<=end;i++){
            result[whereToStart] = letters[i];
            whereToStart++;
        }
    }
}
