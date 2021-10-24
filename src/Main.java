import java.util.*;

public class Main {

    // programmers level 2 - [3차] 파일명 정렬
    // head, number, tail 부분을 나눠서 정렬하는 문제다
    // 나누는 것까지도 충분히 할 수 있는데 정렬하는 부분에서 문제가 생겼다
    // Arrays.sort(file, new Comparator<>()) 를 활용해서
    // 정렬을 하려고 했는데 문제가 몇가지 발생한다.
    // 1. compare의 리턴형이 int 라서 문자열을 형변환해야한다.
    // 2. b-, .gif 등의 특수문자를 int로 자동형변환을 할때 오류가 발생한다.
    // 즉, 나눈 부분들에 대해서 정렬하는 방식에 대해 새로 고민해 봐야 할 것 같다.


    public static void main(String[] args) {

        String[] files = {"F-5 Freedom Fighter",
                "B-50 Superfortress",
                "A-10 Thunderbolt II", "F-14 Tomcat"};

        String head = "";
        String number = "";
        String tail = "";

        String[][] file = new String[files.length][3];

        ArrayList<Integer> idxNum = new ArrayList<>();



        for(int j=0;j<files.length;j++) {

            boolean check = false;
            int cntNum = 0;

            for (int i = 0; i < files[j].length(); i++) {
                if (files[j].charAt(i) >= '0' && files[j].charAt(i) <= '9') {
                    idxNum.add(i);
                    check = true;
                    cntNum++;
                } else {
                    check = false;
                }


                if (!check && cntNum > 0) {
                    break;
                }
            }

            head = files[j].substring(0,idxNum.get(0));
            if(cntNum > 0){
                number = files[j].substring(idxNum.get(0),idxNum.get(0) + cntNum);
                tail = files[j].substring(idxNum.get(0) + cntNum);
            }
            else{
                tail = files[j].substring(idxNum.get(0));
            }

            file[j][0] = head.toLowerCase(Locale.ROOT);
            file[j][1] = number.toLowerCase(Locale.ROOT);
            file[j][2] = tail.toLowerCase(Locale.ROOT);

        }

        Arrays.sort(file, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(!(o1[0].charAt(0) ==(o2[0].charAt(0)))) return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                return Integer.parseInt(String.valueOf(o1[1].charAt(0))) - Integer.parseInt(String.valueOf(o2[1].charAt(0)));

            }
        });

        String[] answer = new String[file.length];
        for(int i=0;i< files.length;i++){
            StringBuffer sb = new StringBuffer();
            sb.append(file[i][0]);
            sb.append(file[i][1]);
            sb.append(file[i][2]);

            answer[i] = sb.toString();
        }


        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }

    }
}