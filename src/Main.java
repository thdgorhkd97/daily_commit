import java.util.ArrayList;

public class Main {

    //programmers level 2 - 순위 검색
    // 효율성까지 한 번에 고려하면서 하려다 보니 상당히 오래 걸렸다...
    // 쓰다 지우다를 반복했는데 처음부터 너무 효율성을 따지는 게 아니라
    // 일단 구현을 하고 나서 방법에 대해서 다시 고민해봐야 할 것 같다
    // query에 해당하는 모든 조건을 담아서 info 배열과 일일이 대조해보려 했는데
    // 이 과정에서 3중 반복문처럼 효율성에 문제가 생길 거 같으면 다시 해보고 다시 지우고
    // 하다 보니까 너무 시간이 오래 걸리기도 하고 너무 못한 것 같다...

    public static void main(String[] args) {

        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        int[] answer = new int[query.length];
        ArrayList<String> list =  new ArrayList<>();

        for(int i=0;i< query.length;i++) {
            list.clear();

            String[] str = query[i].split("and");
            for(int j=0;j<str.length;j++){
                list.add(str[j]);
            }

            for(int j=0;j<5;j++){
                if(list.get(j).equals(String.valueOf('-'))){
                    continue;
                }
                else{

                }
            }


        }


    }

}
