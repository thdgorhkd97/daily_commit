import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 구명보트 & 튜플
    //

    public static void main(String[] args) throws IOException {

//        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//
//        s = s.substring(2,s.length()-2);
//
//        s = s.replace("},{","/");
//
//        String[] arr = s.split("/");
//
//        System.out.println(s);
//
//        Arrays.sort(arr,((o1, o2) -> o1.length() - o2.length()));
//
//        // 처음에는 단순히 arr배열의 각 순서의 맨 마지막 원소만을 취하는 방식으로 했었는데
//        // 문제를 보면 원소 순서가 반드시 맨 마지막 원소가 새로운 원소일 것이라는 조건이 없기 때문에
//        // 그렇게 하면 안 된다.
//        // 예를들어 1 / 1 2 / 1 2 3 / 1 2 3 4 이런 식이면 1 2 3 4 라는 정답이 나오지만
//        // 1 / 2 1 / 2 1 3 / 2 1 3 4 이렇게 정렬이 안 되어 있다면 단순히 맨 뒤 원소를 취하는 건
//        // 정답이 될 수 없다.
//
//        /* 그래서 혹시 정렬을 해서 맨 마지막 원소를 취하면 되지 않을까 생각해서 이렇게도 구현해 봤는데
//
//        // 길이가 1인 제일 첫번째 arr[0]가 길이가 2인 두번째 arr[1]을 기준으로 큰 지 작은지 모르기 때문에
//        // 크기를 비교해서 정렬하는 기준을 잡아야 하는 문제가 또 생긴다
//        // 예를 들어 arr[0] = 1이면 1 2 이렇게 되어야 하므로 오름차순 정렬
//        // arr[1] = 2면 2 1 이렇게 되어야 하므로 내림차순 정렬이 되어야 하므로 맨 뒤를 취하는 건 옳지 않은 것 같다.
//        for(int i=1;i<arr.length;i++){
//            String[] str = arr[i].split(",");
//
//            Arrays.sort(str);
//
//            list.add(Integer.parseInt(String.valueOf(str[i].charAt(str[i].length()-1))));
//        }
//        */
//
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(Integer.parseInt(arr[0]));
//
//        for(int i=1;i<arr.length;i++){
//            String[] str = arr[i].split(",");
//
//            for(int j=0;j<str.length;j++){
//                if(!list.contains(Integer.parseInt(str[j]))){
//                    list.add(Integer.parseInt(str[j]));
//                    break;
//                }
//            }
//        }
//
//        int[] answer = new int[list.size()];
//
//        for(int i=0;i<list.size();i++){
//            answer[i] = list.get(i);
//        }

        int[] people = {70,80,50};
        int limit = 100;
        int answer = 0;

        Arrays.sort(people); // 50 60 70 80

        int l = 0, r = people.length-1;

        while(l <= r){
            if(people[l] + people[r] <= limit){
                l++;
            }
            r--;
            answer++;

        }

        System.out.println(answer);






    }
}