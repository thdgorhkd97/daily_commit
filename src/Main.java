import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java programmers level 2 주식가격
    // 떨어지지 않는 주식가격의 시간을 구하는 문제인데 2중 for문으로 기준이 되는 인덱스와
    // 그 뒤쪽의 인덱스를 비교하는 문제라 쉽다고 생각했는데 한 가지 고려 요소가 있었다.
    // 바로 가격이 떨어지는 구간을 시간에 더한다는 점이었다
    // 예를 들면 2 3 4 3 이렇게 있다면 2는 끝까지 떨어지지 않기 때문에 answer[0] = 3이 된다
    // 하지만 3은 바로뒤의 원소가 4로 가격이 올라가기 때문에 for문을 종료시켜야 하는데
    // 이 경우에 answer[1] = 0이 아니라 1초후에 올랐다는 의미로 answer[1] = 1이 된다.
    // 이 부분을 하나의 조건으로 해결하기는 부분에서 조금 걸려서
    // if문으로 분기를 두어 가격이 올라가서 종료되는 경우와 끝까지 가격이 오르지 않고 인덱스가 끝나서
    // 종료되는 경우로 나눠서 !flag 와 flag로 조건을 두어 문제를 해결했다.

    public static void main(String[] args) throws IOException {

        int[] prices = {2,4,5,3,1,6};

        int[] answer = new int[prices.length];

        for(int i=0;i< prices.length-1;i++){
            int cnt = 0;
            boolean flag = true;
            for(int j=i+1;j< prices.length;j++){
                if(prices[i] <= prices[j]){
                    cnt++;
                }
                else{
                    flag = false;
                    break;
                }
            }

            if(!flag){
                answer[i] = cnt + 1;
            }
            else answer[i] = cnt;
        }

        answer[prices.length-1] = 0;

        for(int i=0;i<answer.length;i++){
            System.out.print(answer[i] + " ");
        }

    }
}