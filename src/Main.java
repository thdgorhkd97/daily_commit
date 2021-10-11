import java.util.*;

public class Main {

    // programmers level 2 - 튜플
    // 로직을 처음부터 다시 구현해 보았다.
    // ","를 기준으로 자르는 것이 아니라 애초에 "},{" 를 기준으로
    // 자르니까 배열 기준으로 자를 수 있었다.( 이부분은 참고하였다)
    // 그리고 길이 순으로 정렬한 다음에
    // 앞에 포함되지 않는다면 정답에 추가한다.

    public static void main(String[] args) {

        String s = "{{2},{2,1,3},{2,1},{2,1,3,4}}";

        s = s.substring(2,s.length()-2).replace("},{","/");

        System.out.println(s);

        String[] arr = s.split("/");
        Arrays.sort(arr, new Comparator<String>() { // 길이순으로 정렬
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(arr[0]));
        for(int i=0;i<arr.length;i++){
            String[] str = arr[i].split(","); // 숫자별로 나눔

            for(int j=0;j<str.length;j++){ // 숫자를 하나씩 체크하면서
                int num = Integer.valueOf(str[j]);

                if(!list.contains(num)){ // 앞에 포함되지 않는다면
                    list.add(num);
                    break;
                }
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }


    }
}