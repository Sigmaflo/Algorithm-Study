import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine().replace(",","").replace(";","");
        String[] str = origin.split(" ");

        for (int i = 1; i < str.length; i++) {
            String[] variable = reverseType(str[i]).split("#");
            System.out.println(str[0]+variable[0]+" "+variable[1]+";");
        }
    }

    public static String reverseType(String str){
        char[] origin = str.toCharArray();
        String result = "";

        for (int i = str.length()-1; i >= 0; i--) {
            if(origin[i]!=']'){
                if(origin[i]=='*' || origin[i]=='&'){
                    result += origin[i];
                }else{ 
                // 알파벳일 경우 변수명이기 때문에 reverse 하지 않음. 
                //'#'문자를 이용하여 type과 변수명을 구분
                    result += "#";
                    for(int j=0; j <= i; j++){
                        result += origin[j];
                    }
                    break;
                }
            }else{
                result += "[]";
                i--;
            }
        }
        return result;
    }
}
