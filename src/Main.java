import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.*;

public class Main {

    // programmers level 3 - 불량 사용자
    // 하나하나 비교하는 것이 아니라 아예 banned_id의 길이만큼 유저를 뽑아서
    // 가능한 유저 목록 중 가능한 케이스가 있는지 확인해보고자 하였다.(유저의 총 길이가 8이므로 완전탐색이 가능할 것이라 판단하엿다.)
    // banned_id의 길이만큼 유저를 구해서 set을 통해 중복되지 않는 유저 목록을 구하고자 하였다.
    // 근데 처음에 Set<String[]> 이렇게 받았다가 배열의 순서가 달라서 set에 적용되지 않앗다.
    // 그래서 Arrays.sort()를 활용하여 배열의 순서를 맞게 맞추면 set에서 동일한 배열을 구별할 줄 알았는데
    // 배열의 원소 순서가 같아도 set에서 구별을 하지 못하였다.
    // 아래처럼 아예 배열의 주소 자체를 같게 만들어야 구별을 할 수 있었다.
    // str2 = str; -> set.add() = false;
    // 그래서 중복되지 않는 유저목록을 구하기 위해서 배열의 원소들을 하나의 String으로 모아서
    // 비교하는 방식을 활용하였다.
    // ArrayList에는 중복되지 않는 String의 배열값만 넣어서 arraylist는 결과적으로
    // banned_id의 길이에 해당하는 중복되지 않는 배열이 원소로 들어간다.
    // arraylist의 원소들을 가지고 비교하면 되는데 오늘은 여기까지 하려한다.

    static Set<String> set = new HashSet<>();
    static ArrayList<String[]> list = new ArrayList<>();
    static int len = 0;

    public static void main(String[] args){

        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};

        int n = user_id.length;
        int r = banned_id.length;
        int depth = 0;
        len = banned_id.length;

        permu(user_id,depth,n,r);


        for(int i=0;i<list.size();i++){
            for(int j=0;j<len;j++){
                System.out.print(list.get(i)[j] + " ");
            }
            System.out.println();
        }

    }

    static void permu(String[] user_id,int depth, int n, int r){
        if(depth == r){
            String[] str = new String[len];
            for(int i=0;i<r;i++){
                str[i] = user_id[i];
            }
            Arrays.sort(str);
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<r;i++){
                sb.append(str[i]);
            }

            if(set.add(sb.toString())) list.add(str);
        }

        for(int i=depth;i<n;i++){
            swap(user_id,depth,i);
            permu(user_id,depth+1,n,r);
            swap(user_id,depth,i);
        }
    }

    static void swap(String[] user_id,int depth, int i){
        String tmp = user_id[i];
        user_id[i] = user_id[depth];
        user_id[depth] = tmp;
    }
}