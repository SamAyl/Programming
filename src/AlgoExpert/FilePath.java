package AlgoExpert;

import java.util.*;

public class FilePath {
    public static void main(String[] args) {


        String path = "/foo/../test/../test/../foo//bar/./baz";
        String[] dir = path.split("/");
        Stack<String> stk = new Stack<>();

        if (path.charAt(0) == '/') {
            stk.push("/");
        }

        for (int i = 0; i< dir.length; i++) {
            if (dir[i] == "." || dir[i] == "") {
                continue;
            } 	else if (dir[i] == "..") {
                if (stk.isEmpty()) {
                    stk.push("..");
                } else if (stk.size() >1){
                    stk.pop();
                }
            } else {
                stk.push(dir[i]);
            }
        }

        List<String> listOfDirectories = new ArrayList<>();
        listOfDirectories.addAll(stk);
        StringBuilder sb = new StringBuilder();
        for (String singleFile : listOfDirectories) {
            if (singleFile.equalsIgnoreCase("/")){
                sb.append(singleFile);
            } else {
                sb.append(singleFile);
                sb.append("/");
            }
        }

        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb.toString());
    }
}
