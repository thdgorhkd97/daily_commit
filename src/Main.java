package src; // daily 폴더를 source root로 인식시켰기 때문에

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    // algoexpert easy 1
    // sequence가 array의 부분집합에 해당하는 걸 묻는 문제다
    // index를 구해서 오름차순인지 확인하면 되는 문제라고 생각했는데 생각보다 예외조건이 상당히 많았다
    // 문제에 예외조건이 주어지는 게 아니라 테스트 케이스를 보면서 하나씩 해결해야 하는 게 algoexpert
    // 의 특징이라고 생각된다.( 생길 수 있는 예외조건을 미리 파악해야 하며 테스트 케이스를 통해 이를 알아내야 하는것)
    // 1. sequence가 array보다 클 경우 -> size 확인해서 false 리턴
    // 2. sequence에 array에 없는 원소가 있을 경우 -> flag를 통해 있는지 없는지 확인
    // 3. sequence나 array에 중복되는 원소가 있을 경우 -> 마지막 확인 조건을 arr[i] >= arr[i+1]로 하여 중복되는 경우를 포함하도록 한다.
    // 근데 마지막 하나의 테스트 케이스에 대해 이해가 잘 가지 않는다. [1,1,1,1,1]에 [1,1,1]이 부분집합이 되냐 안되냐는 건데
    // false를 리턴하기를 바라는데 나는 이게 true로 반환되어야 하지 않냐는 생각때문에 이 테스트 케이스를 해결하지 못하겠다..

    public static void main(String[] args) throws IOException {

        List<Integer> array = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();

        int[] arrayValue = {1,1,1,1,1};
        int[] sequenceValue = {1,1,1};

        for(int i=0;i< arrayValue.length;i++){
            array.add(arrayValue[i]);
        }
        for(int j=0;j< sequenceValue.length;j++){
            sequence.add(sequenceValue[j]);
        }


        if(sequence.size() > array.size()) System.out.println("false 1");


        int[] arr = new int[sequenceValue.length];

        boolean[] check = new boolean[sequenceValue.length];

        for(int i=0;i< sequenceValue.length;i++){
            int value = sequenceValue[i];
            boolean flag = false;
            for(int j=0;j< arrayValue.length;j++){
                if(value == arrayValue[j] && !check[i]){
                    arr[i] = j;
                    check[i] = true;
                    flag = true;
                    break;
                }
            }

//            if(!flag) return false;
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        for(int i=0;i< arr.length-1;i++){
            if(arr[i] > arr[i+1]){
//                return false;
                System.out.println("false3");
            }
        }

//        return true;

        System.out.println("true4");
    }
}