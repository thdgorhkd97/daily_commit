import java.util.*;

public class Main {

    // programmers level 2 - 튜플
    // 46.7 / 100
    // 문자열을 잘라서 배열로 넣는 과정까지는 잘 구현했는데
    // 그걸 길이별로 정렬해야 한다는 생각을 못해서 조금 버벅였고
    // 길이순으로 정렬해서 뒤의 것중에서 앞의 인덱스에 없는 것을
    // 넣는 로직으로 구현했는데 테스트 케이스는 통과하는데
    // 정확성에서 조금 부족하다.

    public static void main(String[] args) {

        String s = "{{20,111},{111}}";

        String[] strs = s.replaceAll("[{}]", " ").trim().split(" , ");

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        ArrayList<String> str = new ArrayList<>();

        str.add(strs[0]);

        for(int i=1;i<strs.length;i++){

            String[] list;
            list = strs[i].split(",");

            for(int j=0;j<list.length;j++){
                if(!strs[i-1].contains(list[j])){
                    str.add(list[j]);
                    break;
                }
            }
        }

        int[] answer = new int[str.size()];
        for(int i=0;i<str.size();i++){
            answer[i] = Integer.valueOf(str.get(i));
        }

        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }


    }
}