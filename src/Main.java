import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // baekjoon 1541 - 잃어버린 괄호
    // 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
    // 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
    // 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

    // 최소로 만들기 위해서는 최대한 큰 수를 빼줘야 하기 때문에 - 뒤를 크게 해줘야 한다는 생각을 했다.
    // 그래서 처음에는 - 뒤에 있는 +를 더해준다고 했는데 그렇게 하니 - 다음을 체크하고 더한 다음
    // 다시 확인하는 등 번거로웠다.
    // 그 후 모든 +를 먼저 계산할까라는 생각을 했고 +만 있다면 문제가 해결되고 -가 있다 하더라도
    // 어차피 가장 큰수를 빼려면 가장 큰수를 만들어야하니까 모든 +를 계산한다고 생각했다.

    // 처음에는 +를 split으로 나눌 때 문자 그대로 봐야하기 때문에 \\을 추가해야 하는 부분에서 조금 막혓다
    // -는 그대로 가능한데 +는 \\를 붙였어야 한다.
    // 그 후 -를 토대로 split한 후에 +에 split한 것을 빼주었는데 이렇게 하니
    // -가 없는 문자열이 주어지면 오류가 발생했다.
    // 따라서 가장 먼저 나오는 수는 -가 아닌 양수이기 때문에
    // 만약 처음이라면 그냥 그대로 두고 그 뒤부터는 -를 붙여 계산했다.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] sub = str.split("-"); // -를 기준으로 문자열을 나눈다.

        int answer = 0;

        for(int i=0;i<sub.length;i++){
            String[] plus = sub[i].split("\\+"); // -뒤에 있는 +로 계산하는 부분

            int value = 0;
            for(int j=0;j<plus.length;j++){
                value += Integer.parseInt(plus[j]); // +로 연결된 수를 모두 계산한다.
            }

            if(i==0){ // 맨 앞의 수는 양수
                answer = value;
            }
            else{ // 그 뒤는 앞에 -가 붙어 있는 부분이므로 뺀다.
                answer -= value;
            }

        }

        System.out.println(answer);



    }
}