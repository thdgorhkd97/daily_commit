import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // 커뮤러닝 실전 모의 테스트
    // 모의 테스트 이긴 하지만 빠른 시간내에 모두 풀었다 ㅠㅠㅠㅠ
    // 1번은 전체 경우의 수를 구해서 그 중에 몬스터를 만나게 될 경우를 구했다
    // 시간을 줄인다면 가능한 주사위 수를 구하는 3중 for문일 것으로 보이는데
    // 근데 더해서 나오는 수만 구하는 것이 아니라 해당 수가 나오는 경우의 수를 구해야 하기 때문에
    // 내 생각에는 모든 경우의 수를 구하는 것이 맞다고 생각한다.

    public static void main(String[] args) {


        int[] monster = {4,9,5,8};
        int S1 = 2;
        int S2 = 3;
        int S3 = 4;

        int answer = 1;

        int all = S1 * S2 * S3; // 전체 경우의 수
        int max = S1 + S2 + S3;
        int meet_monster = 0;

        int[] number = new int[100];

        for(int i=1;i<=S1;i++){
            for(int j=1;j<=S2;j++){
                for(int k=1;k<=S3;k++){
                    number[i+j+k] += 1;
                }
            }
        }

        for(int i=0;i<monster.length;i++){
            meet_monster += number[monster[i]-1];
        }


        double p = ((double)(all-meet_monster) / (double)all);

        answer = (int) (p * 1000);

        /*
        String a = "listen";
        String b = "silent";

        a = a.toLowerCase(Locale.ROOT);
        b = b.toLowerCase(Locale.ROOT);

        HashMap<Character, Integer> map_a = new HashMap<>();
        HashMap<Character, Integer> map_b = new HashMap<>();

//        if(a.length() != b.length()) return false;

        for(int i=0;i<a.length();i++){
            map_a.put(a.charAt(i),map_a.getOrDefault(a.charAt(i),0)+1);
            map_b.put(b.charAt(i),map_b.getOrDefault(b.charAt(i),0)+1);
        }

        for(Character key : map_a.keySet()){
            if(!map_a.get(key).equals(map_b.get(key))){
                // return false;
            }
        }
        */




















    }
}