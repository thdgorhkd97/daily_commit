import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {


// java programmers 모의고사
// first , second , third 사람들의 정답과 주어진 정답을 비교해서 누가 가장 많은 문제를 맞혔는지 구하는 문제
// 정해진 패턴에 맞게 모든 사람들의 정답을 모두 구하고 정답 배열과 비교하면서 각 사람이 얼마나
// 정답을 맞췄는지를 사람과 정답수로 map에 넣은 다음에 가장 많은 정답수를 가지는 사람을 구한다.


    public static void main(String[] args) throws IOException {

        int[] answers = {1,2,3,4,5};

        int[] first = new int[10001];
        int[] second = new int[10001];
        int[] third = new int[10001];


        for(int i=0;i<first.length;i++){
            int idx = i % 5;
            switch (idx){
                case 0 : first[i] = 1; break;
                case 1 : first[i] = 2; break;
                case 2 : first[i] = 3; break;
                case 3 : first[i] = 4; break;
                case 4 : first[i] = 5; break;
            }
        }

        int idx = 1;
        for(int i=0;i<second.length;i++){
            if(i%2 == 0){
                second[i] = 2;
            }
            else{
                second[i] = idx++;
                if(idx == 2) idx++;
                if(idx == 6) idx = 1;
            }
        }

        idx = 1;
        for(int i=0;i<third.length-1;i = i+2){
            switch (idx){
                case 1 : third[i] = 3; third[i+1] = 3; idx++; break;
                case 2 : third[i] = 1; third[i+1] = 1; idx++; break;
                case 3 : third[i] = 2; third[i+1] = 2; idx++; break;
                case 4 : third[i] = 4; third[i+1] = 4; idx++; break;
                case 5 : third[i] = 5; third[i+1] = 5; idx++; break;
            }
            if(idx == 6) idx = 1;

        }

        HashMap<Integer,Integer> map = new HashMap<>();

        int[] value = new int[3];
        for(int i=0;i<answers.length;i++){
            if(answers[i] == first[i]) value[0]++;
            if(answers[i] == second[i]) value[1]++;
            if(answers[i] == third[i]) value[2]++;
        }

        int max = 0;

        for(int i=0;i<3;i++){
            max = Math.max(max,value[i]);
            map.put(i+1,value[i]);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<map.size();i++){
            if(map.get(i+1) == max){
                list.add(i+1);
            }
        }

        int[] answer = new int[list.size()];

        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }





    }
}