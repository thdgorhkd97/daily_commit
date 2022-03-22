import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.*;

public class Main {

    // java 11723 집합

    // 비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
    // add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
    // remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
    // check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
    // toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
    // all: S를 {1, 2, ..., 20} 으로 바꾼다.
    // empty: S를 공집합으로 바꾼다.

    // 처음에는 arraylist로 해서 각 연산마다 탐색함으로써 처리했다.
    // 근데 arraylist에서 탐색이 O(n)이다 보니까 연산의 수가 많아지면 시간초과가 나는 것 같았다
    // 어떻게 시간을 줄일 수 있을까 고민하면서 로직을 바꿔나갔는데도 계속 못했다 ㅠㅠ
    // 그래서 아이디어를 얻고자 조금 찾아봤는데 굳이 arraylist로 복잡하게 하지 않아도 되는 것이
    // 추가되거나 삭제되는 숫자가 1~20이라는 제한이 문제에서 있기 때문에 boolean[] 타입으로
    // 선언해서 만약 20이 들어있다면 [20]을 true로 빠지면 [20]을 false로 바꿈으로써
    // boolean[20]이면 1byte * 20으로 처리가 가능했다.


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        boolean[] bitmask = new boolean[21];
        String operator = "";
        int num = 0;

        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++){
            String str = br.readLine();

            if(str.equals("all")){
                for(int j=1;j<=20;j++) bitmask[j] = true;
            }
            else if(str.equals("empty")){
                for(int j=1;j<=20;j++) bitmask[j] = false;
            }
            else{
                String[] map = str.split(" ");
                operator = map[0];
                num = Integer.parseInt(map[1]);

                switch (operator){
                    case "add" :
                        bitmask[num] = true;
                        break;
                    case "remove" :
                        bitmask[num] = false;
                        break;
                    case "check" :
                        if(bitmask[num]) sb.append("1").append("\n");
                        else sb.append("0").append("\n");
                        break;
                    case "toggle" :
                        if(bitmask[num]) bitmask[num] = false;
                        else bitmask[num] = true;
                        break;
                }


            }
        }

        System.out.println(sb.toString());

        /*
        ArrayList<Integer> list = new ArrayList<>();
        String operator = "";
        int num = 0;

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0;i<M;i++){
            String str = br.readLine();

            if(str.equals("all")){
                list.clear();
                for(int j=1;j<=20;j++){
                    list.add(j);
                }
            }
            else if(str.equals("empty")){
                if(!list.isEmpty())list.clear();
            }
            else{
                String[] map = str.split(" ");
                operator = map[0];
                num = Integer.parseInt(map[1]);

                switch (operator){
                    case "add" :
                        if(!list.contains(num)){
                            list.add(num);
                        }
                        break;
                    case "remove" :
                        if(list.contains(num)){
                            list.remove(new Integer(num));
                        }
                        break;
                    case "check" :
                        if(list.contains(num)){
                            answer.add(1);
                        }
                        else answer.add(0);
                        break;
                    case "toggle" :
                        if(list.contains(num)){
                            list.remove(new Integer(num));
                        }
                        else{
                            list.add(num);
                        }
                        break;
                }

            }
        }

        for(int i=0;i<answer.size();i++){
            System.out.println(answer.get(i));
        }
         */
    }
}
