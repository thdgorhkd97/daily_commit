public class Main {

    //programmers level 2 - 2개 이하로 다른 비트

    // 홀수일 때
    // 홀수일 때는 끝자리 비트가 반드시 1이다.
    // 1 0 1 = 5
    // 1 1 0 = 6
    // 1 1 1 = 7
    // 1000 = 8
    // 1001 = 9
    // 0을 포함한 경우와 아닌 경우로 나눌 수 있다.
    // 0이 없으면 +1(짝수와 같이 취급)
    // 0을 포함하면 가장 끝자리 0을 1로 바꾸고 마지막을 0으로 바꾼다.
    // 라는 방식으로 접근했는데 내가 방식이 틀린 건지 모르겠다.
    // 추석이라 오래 해보지 못해서 조금 더 고민해봐야 할 것 같다.

    public static void main(String[] args) {
        long[] numbers = {2,7};

        long[] answer = new long[numbers.length];

        for(int i=0;i< numbers.length;i++){
            if(numbers[i] % 2 == 0){
                // 짝수일 때는 끝자리 비트가 반드시 0이므로 1만 더하면 조건 만족
                answer[i] = numbers[i] + 1;
            }
            else{ // 홀수일 때
                // 홀수일 때는 끝자리 비트가 반드시 1이다.
                // 1 0 1 = 5
                // 1 1 0 = 6
                // 1 1 1 = 7
                // 1000 = 8
                // 1001 = 9
                // 0을 포함한 경우와 아닌 경우로 나눌 수 있다.
                // 0이 없으면 +1(짝수와 같이 취급)
                // 0을 포함하면 가장 끝자리 0을 1로 바꾸고 마지막을 0으로 바꾼다.

                String str = make_2bit(numbers[i]);
                if(str.contains("0")){ // 홀수면서 0을 포함하는 경우
                    int idx_0 = str.lastIndexOf("0");
                    int idx_1= str.lastIndexOf("1");

                    char[] ch = new char[str.length()];
                    ch = str.toCharArray();
                    ch[idx_0] = '1';
                    ch[idx_1] = '0';

                    StringBuffer sb = new StringBuffer();
                    for(int j=0;j<ch.length;j++){
                        sb.append(ch[j]);
                    }
                    String change = sb.toString();
                    answer[i] = make_number(change);



                }else{ // 홀수면서 1로만 이루어진 경우
                    answer[i] = numbers[i] + 1;
                }

            }
        }

        for(int i=0;i< answer.length;i++){
            System.out.println(answer[i]);
        }
    }

    public static long make_number(String change) {
        long number = 0;
        long multiply = 1;
        for(int i=change.length()-1; i>=0; i--){
            if(change.charAt(i) == '1'){
                number += multiply;
            }
            multiply = multiply * 2;
        }

        return number;
    }

    public static String make_2bit(long number){
        String str = "";
        StringBuffer sb = new StringBuffer();
        while(number > 0){
            sb.append(number%2);
            number = number / 2;
        }
        str = sb.reverse().toString();

        return str;
    }
}
