import javax.swing.text.View;
import java.util.*;

public class Main {

    // programmers level 2 - 전력망을 둘로 나누기
    // 트리구조에 대해서 최대한 개수를 비슷하게 나눠야 하는데
    // 가장 많이 연결된 정점에 대해서 하나씩 간선을 끊어가면서
    // 개수를 확인하려고 했는데
    // 정점과 직접적으로 연결된 정점은 확인가능한데
    // 연결 연결 이런식인게 조금 어렵다....

    public static void main(String[] args) {

        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},
                {7,8},{7,9}};

        int answer = n;

        int[] many = new int[n+1];

        for(int i=0;i<wires.length;i++){
            many[wires[i][0]]++;
            many[wires[i][1]]++;
        }

        int max = 0;
        int max_idx = 0;
        for(int i=0;i<many.length;i++){
            if(max < many[i]){
                max_idx = i;
                max = many[i];
            }
        }

        if(max_idx == 0){
            max_idx = many.length / 2;
        }

        System.out.println(max + " " + max_idx);

        for(int i=0;i<wires.length;i++){
            if(wires[i][0] == max_idx || wires[i][1] == max_idx){
                cut(answer,wires,i);
            }
        }

        System.out.println(answer);


    }

    public static void cut(int answer, int[][] wires, int i){
        int left = wires[i][0];
        int right = wires[i][1];
        int left_cnt =0;
        int right_cnt=0;

        ArrayList<Integer> left_chain = new ArrayList<>();
        ArrayList<Integer> right_chain = new ArrayList<>();

        for(int j=0;j<wires.length;j++){
            if(wires[j][0] == left){
                left_chain.add(wires[j][1]);
            }
            else if(wires[j][1] == left){
                left_chain.add(wires[j][0]);
            }

            if(wires[j][0] == right){
                right_chain.add(wires[j][1]);
            }
            else if(wires[j][1] == right){
                right_chain.add(wires[j][0]);
            }
        }

        System.out.println(left + " 일때 " + left_chain.size() + " ");

        for(int j=0;j<left_chain.size();j++){
            System.out.println(" "+left_chain.get(j));
        }
        System.out.println();
        System.out.print(right + " 일때 " + right_chain.size());
        for(int j=0;j<right_chain.size();j++){
            System.out.print(" "+right_chain.get(j));
        }

        answer = Math.min(answer,Math.abs(left_cnt-right_cnt));


    }
}