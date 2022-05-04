import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 17413 단어 뒤집기 2
    // < > 사이에 있는 단어는 그대로 놔두고 <> 밖에 있는 단어들만
    // 거꾸로 뒤집어 출력한다.
    // < > 사이에 있는지에 대한 여부는 boolean 을 활용해서 체크했는데
    // 이걸 체크하는 과정에서 조금 혼돈이 있어서 그런가 시간이 상당히 오래걸렸다 ㅠㅠ.
    // 근데 뒤집을 때 stack에서 pop하면서 넣으려고 했는데 이럴 때 왜 boolean이 걸리는 가
    // 의아 했는데 알아보니까 < > 를 만났을 때 단순히 상태를 변화시키고 끝나는 게 아니라
    // 변화가 생겼을 때 stack이 비어있는지를 확인해서 추가 작업을 해야 했다....

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        // 열린 꺽새와 닫힌 꺽새를 판별하기 위한 flag
        boolean flag = false;

        Stack <Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '<') {
                while (!stack.isEmpty()) { // < > 바깥의 단어가 있다면
                    sb.append(stack.pop());
                }
                flag = true;
            }
            // 닫힌 꺽새를 만났을 경우, flag를 false로 입력 후 '>'저장
            else if (str.charAt(i) == '>') {
                flag = false; // 이제부터 괄호 바깥의 단어라는 의미
                sb.append('>'); // '>' 넣는다
                continue;
            }

            // flag가 true일 경우, '>'를 만나기 전까지 그대로 입력
            if (flag) {
                sb.append(str.charAt(i));
            }
            // flag가 false일 경우, 괄호 이외의 문자를 처리
            else if (!flag) {
                // 해당 인덱스의 i번째 문자가 공백일 경우, 모든 원소를 POP수행 후 공백 추가
                if (str.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                } else {
                    // 그외의 경우, Stack에 문자 추가
                    stack.push(str.charAt(i));
                }
            }

            // 반복문이 마지막 횟수일 때, 스택이 비어있지 않다면 원소 추가
            if (i == str.length() - 1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        // 결과문 출력
        System.out.println(sb);

    }

}