import java.util.*;

public class Main {

    // N사 계열사 코딩테스트 문제
    // 1번 가지는 고정되어 있고 branch가 들어오면 가능한 최소 숫자의 가지가 추가되고
    // merge n이 들어오면 n번 가지를 1번에 합친다.
    // intellij 에서는 완벽하게 돌아갔는데 구름 IDE라는 온라인 코딩테스트 사이트에서는
    // scanner 에러가 계속 떴다.
    // Operation[] operations 로 입력이 주어졌는데 Operation[] 이라는 연산자를
    // 사용해 보지 못해서 해당 입력을 어떻게 활용할 수 있을지 몰랐다...
    // 근데 검색해보고 알아봐도 operation[] 이라는 연산자를 그대로 활용하는 게 없다..

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        int numOfOperation = Integer.parseInt(sc.nextLine());

        int num = 2;

        list.add(0,1);

        while(numOfOperation != 0){

            String str = sc.nextLine();

            if(str.equals("branch")){

                boolean flag = false;
                while(true){
                    for(int i=0;i<list.size();i++){
                        if(num == list.get(i)){
                            num += 1;
                            flag = true;
                            break;
                        }
                    }

                    if(!flag){
                        list.add(num);
                        num = 2;
                        break;
                    }
                    flag = false;
                }
            }
            else if(str.contains("merge")){
                char ch = str.toCharArray()[6];

                for(int i=0;i<list.size();i++){
                    if(list.get(i) == ch - '0'){
                        list.remove(i);
                        break;
                    }
                }
            }

            numOfOperation--;


        }


        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + " ");
        }

    }
}