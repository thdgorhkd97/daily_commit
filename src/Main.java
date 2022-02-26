import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // java 2981 검문

//    먼저 근처에 보이는 숫자 N개를 종이에 적는다. 그 다음, 종이에 적은 수를 M으로 나누었을 때, 나머지가 모두 같게 되는 M을 모두 찾으려고 한다.
//    M은 1보다 커야 한다.
//
//    N개의 수가 주어졌을 때, 가능한 M을 모두 찾는 프로그램을 작성하시오.

    // 실패다.. 메모리 초과가 발생한다..
    // 나름 시간을 줄이기 위해서 정렬후에 2부터 가장 작은 원소까지만 for문을 돌리면서
    // ( 큰수로 나누면 나머지가 없기 때문에)
    // 나머지를 set에 저장하고 만약 같지 않다면 set에 추가로 저장되면서 size가 커지기 때문에
    // 나머지를 저장하면서 set의 사이즈가 2이상이라면 바로 break로 for문을 빠지면서
    // 해당 i를 벗어나도록 했는데도 메모리 초과가 발생한다.
    // 아마 약수를 사용하기 때문에 약수를 활용한 공식인 유클리드 호제법이나 최대공약수를 활용한
    // 공식을 활용해야 할 거 같긴한데... 해당 방법은 내가 미리 아는 게 아니라서 다른 방법을
    // 최대한 고민했는데도 결국 알지 못하겠다 ㅠㅠ

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];

        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(num);

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2;i<=num[0];i++){
            Set<Integer> set = new HashSet<>();
            boolean flag = true;
            for(int j=0;j<num.length;j++){
                set.add(num[j] % i);
                if(set.size() > 1){
                    flag = false;
                    break;
                }
            }

            if(flag){
                list.add(i);
            }
        }

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + " ");
        }
    }
}