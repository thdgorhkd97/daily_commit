import com.sun.management.GarbageCollectionNotificationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main {

    // java 알고리즘 스터디
    // java programmers 폰켓몬

    // set과 arraylist의 indexOf()를 활용하여 arraylist에 없는
    // 원소를 구하는 과정에 대해서 시간복잡도를 비교해 보았다.

    // nums배열에 있는 숫자들 중 nums.length / 2 인 숫자와 비교한 최대 종류를 구하는 문제
    // 처음에는 set을 활용하여 중복되지 않은 종류수를 구하고 그를 통해 답을 도출
    // 두번째는 for문을 돌면서 직접 종류를 구해서 종류와 최대값인 nums.length /2 를 비교

    public static void main(String[] args) throws IOException {

        int[] nums = {3,3,3,2,2,4};

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=100000;i++){
            list.add(i);
        }

        long before = System.currentTimeMillis();
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<list.size();i++){
            set.add(list.get(i)); //O(1)
        }

        int answer = 1;
        while(true){
            if(set.add(answer)){
                break;
            }
            answer++;
        }

        System.out.println(answer);
        long after = System.currentTimeMillis();
        System.out.println("Set 사용 시 : " + (after-before) / 1000);

        before = System.currentTimeMillis();
        answer = 1;
        while(true){
            if(list.indexOf(answer) < 0){ // O(n)
                break;
            }
            answer++;
        }
        System.out.println(answer);
        after = System.currentTimeMillis();
        System.out.println("indexOf 사용 시 : " + (after-before) / 1000);


        /*
        int pocketmon = nums.length/2;
        int prev = nums[0];
        int species = 1;
        for(int i=0;i<nums.length;i++){
            if(prev != nums[i]){
                species++;
                prev = nums[i];
            }
        }

        if(pocketmon > species){
            System.out.println(species);
        }
        else{
            System.out.println(pocketmon);
        }
         */

        /*
        Arrays.sort(nums);

        int pocketmon = nums.length/2;

        Set<Integer> set = new HashSet<>();
        int pick = 0;
        for(int i=0;i<nums.length;i++){
            if(set.add(nums[i])){
                pick++;
            }

            if(pick == pocketmon){
                break;
            }
        }

        System.out.println(pick);
        */









    }
}
