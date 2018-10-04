package Set1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

    public static void main(String[] args) {

        ArrayList<Integer> demo = new ArrayList<>();
        ArrayList<Integer> anotherDemo = new ArrayList<>();

        demo.add(1);
        demo.add(2);
        demo.add(2);
        demo.add(3);
        demo.add(1);

        anotherDemo.add(1);
        anotherDemo.add(2);
        anotherDemo.add(2);
        anotherDemo.add(3);
        anotherDemo.add(1);
        anotherDemo.add(4);
        anotherDemo.add(2);

        int a = findDegreeOfShortestSubArray(demo);
        int b = findDegreeOfShortestSubArray(anotherDemo);

        System.out.println(demo);
        System.out.println(a);

        System.out.println();

        System.out.println(anotherDemo);
        System.out.println(b);

    }




    private static int findDegreeOfShortestSubArray(ArrayList<Integer> input){

        Map<Integer,Integer> rightIndex = new HashMap<>();
        Map<Integer,Integer> leftIndex = new HashMap<>();
        Map<Integer,Integer> count = new HashMap<>();

        int sizeOfShortestSubArray=0;

        for(int index=0; index<input.size();index++){
            //extract the number
            int number = input.get(index);
            //only if left index for the number is not set; set it
            leftIndex.putIfAbsent(number, index);
            //set right index to current index
            rightIndex.put(number,index);
            //increment count of occurrences + 1; if its not found ; its just 1
            count.put(number, count.getOrDefault(number, 0) + 1);

            sizeOfShortestSubArray = input.size();
            int degree = Collections.max(count.values());

            for(int x: count.keySet()){
                if(count.get(x)==degree){
                    sizeOfShortestSubArray = Math.min(sizeOfShortestSubArray,(rightIndex.get(x)-leftIndex.get(x))+1);
                }
            }
        }
        return sizeOfShortestSubArray;
    }
}
