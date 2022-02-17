import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java programmers level 2 - 전화번호 목록
    // for문으로 원소들을 확인하면서 indexOf로 시작하는 접두사인지를 확인해보는데
    // StartsWith으로 확인해도 된다.
    // 근데 2중 for문으로 O(n^2)이 되다 보니까 정확성은 모두 통과하더라도 효율성에서
    // 문제가 생겼다. 그래서 배열을 정렬하기도 하고 어떤 조건을 걸어서 최대한 빨리 for문을
    // 벗어나려 하더라도 시간초과가 발생했다..

    public static void main(String[] args) throws IOException {

        String[] phone_book = {"456789", "45622", "78912313123"};

//        Arrays.sort(phone_book, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//
//        boolean flag = true;
//        boolean answer = true;
//
//        for(int i=0;i< phone_book.length-1;i++){
//            for(int j=i+1;j< phone_book.length;j++){
//                if(phone_book[j].indexOf(phone_book[i]) == 0){
//                    flag = false;
//                    break;
//                }
//            }
//
//            if(!flag) {
//                answer = false;
//                break;
//            }
//        }

        /* 이 부분은 풀이법을 알아보고나서 체크해본 건데 정렬 후에
        그 다음 원소가 이전 원소로 시작하는 지를 확인하는 건데 내가 문제를 잘못 이해한건지
        그 직후의 원소만 체크하면 되는 건지 잘 모르겠다 ㅠㅠ
        문제에는 길이로 정렬한 후에 바로 다음 원소만을 체크하면 된다는 식의 지문이 없다고
        생각하는데 왜 이렇게 해결하는 것 만으로 해결이 가능한건지...

         */
       Arrays.sort(phone_book);

        for(int i=0;i< phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
//                return false;
            }
        }

//        return true;



    }
}