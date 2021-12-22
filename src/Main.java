import java.util.*;

public class Main {

    // programmers level 2 - 3차 파일명 정렬
    // 처음에는 처음 숫자가 나오는 부분의 앞을 head
    // 처음 나오는 숫자부터 이어지는 숫자 number
    // 그 뒷 부분을 tail 로 문제에서 주어지는 그대로 구현하였다. indexOf로 위치를 찾아서 substring으로 잘랐다.
    // 근데 그렇게 하니 코드도 복잡하고 예외상황이 많이 발생하였다.
    // 그래서 정렬에 대한 부분만 참고해서 어떻게 구현해야 빠르고 정확하게 할 수 있을지 확인했다.
    // 일단 "[0-9]" 라는 정규표현식을 활용하여 처음 나오는 숫자를 더 간결하게 표현하고
    // Character.isDigit(c) 으로 표현하는 방법으로 하면 훨씬 더 간단해졌다.
    // 나는 모든 걸 정리해서 String[][] 배열에 넣고 하나하나 비교했는데
    // 이걸 정렬을 통해서 한번에 나오는 걸 정리하고 그 내부에서 다시 정리해야 하는 걸
    // 따로 함수로 정리해서 표현하니까 코드도 간결하고 보기 좋게 표현할 수 있었다.
    // 이쁘게 정렬하는 방법을 좀 더 연구해 보면 좋을 것 같다.

    public static void main(String[] args) {

        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 숫자 앞부분을 잘라서 head로 만든다.(처음 나오는 숫자의 앞부분)
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                // compareTo로 비교하기 위해서 소문자로 변경 후에 비교
                int result = head1.toLowerCase(Locale.ROOT).compareTo(head2.toLowerCase(Locale.ROOT));

                // 같은 문자일 경우 뒤에 오는 숫자로 비교한다.
                if(result == 0){
                    result = convertNum(o1,head1) - convertNum(o2,head2);
                }
                return result;
            }
        });

//        return files;

    }

    public static int convertNum(String str, String head){
        str = str.substring(head.length()); // head 길이만큼 잘라서 숫자부터 오는 중간 부분을 확인
        String result = "";
        for(char c : str.toCharArray()){
            if(Character.isDigit(c) && result.length() < 5){
                // 숫자이면서 result 길이가 5이하일때만 확인한다.
                result += c;
            }
            else break;
        }
        return Integer.valueOf(result);
    }
}
