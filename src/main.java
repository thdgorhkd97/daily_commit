import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class main {

    // java baekjoon 9251 LCS
    // LCS(Longest Common Subsequence) 최장 공통 부분 수열
    // 두 수열이 주어졌을 때 두 수열 모두의 부분 수열이 되는 최장 수열

    // LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때,
    // 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
    // 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

    // 처음 보는 유형의 문제라서 처음에는 2중 for 문을 활용하여 수열에 문자를 하나씩 넣으면서
    // 비교하려고 했는데 그렇게 하면 너무 오래 걸릴 것 같아서 반드시 다른 로직이 있을 것이라
    // 생각해 조금 알아보고 풀이를 진행하였다.

    // 가로에 하나의 문자열, 세로에 하나의 문자열을 세워두고 한 문자씩 비교해가면서
    // 2차원 배열을 합쳐나간다. 첫번째 행과 열은 일치하는 문자를 기준으로 그 뒤를 1로 채운다
    // 그 후에 어떤 식으로 행렬을 채워나가야 하냐면
    // 행의 i 와 열의 j 가 일치한다면 lcs[i-1][j-1] + 1로 채운다
    // because 각 이전 문자열의 이전문자가 해당 위치에서 가질 수 있는 최대 lcs 값이므로
    // 만약 해당 위치의 문자가 같다면 lcs가 하나 더 가능하다는 것이기 때문에 +1 을 한다.

    // 그리고 행의 i와 열의 j가 일치하지 않는다면 Math.max(lcs[i-1][j],lcs[i][j-1]) 를 해야 하는데
    // because lcs[i-1][j] 는 i-1 번째 문자가 j 까지의 최대 lcs 값이 된다.
    // lcs[i][j-1]은 j-1 번째 문자가 i 까지의 최대 lcs 값이기 때문에
    // 행과 열의 문자가 다르면 위와 왼쪽의 수 중 큰 수를 취한다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] lcs = new int[str1.length()][str1.length()];

        lcs[0][0] = 0;
        int idx = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i) == str2.charAt(0))
            {
                idx = i;
                break;
            }
        }

        for(int i=idx;i<str1.length();i++){
            lcs[0][i] = 1;
        }

        for(int i=0;i<str1.length();i++){
            if(str2.charAt(i) == str1.charAt(0)){
                idx = i;
                break;
            }
        }
        for(int i=idx;i<str1.length();i++){
            lcs[i][0] = 1;
        }

        for(int i=1;i<str1.length();i++){
            for(int j=1;j<str2.length();j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j],lcs[i][j-1]);
                }
            }
        }

//        for(int i=0;i<str1.length();i++){
//            for(int j=0;j<str1.length();j++){
//                System.out.print(lcs[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(lcs[str1.length()-1][str1.length()-1]);
    }
}
