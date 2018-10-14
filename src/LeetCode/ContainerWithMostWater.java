package LeetCode;

public class ContainerWithMostWater {


    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(maxArea(height));

    }

    private static int maxArea(int[] height) {

        int[] waterCapacity = new int[height.length];
        int[] leftEdges = new int[height.length];
        int[] rightEdges = new int[height.length];
        int leftEdge = 0;
        int rightEdge =0;
        int maxArea = 0;


        for(int i=0;i<height.length;i++){
            if(height[i]>leftEdge){
                leftEdge = height[i];
                leftEdges[i] = leftEdge;
            }
            else {
                leftEdges[i] = leftEdge;

            }
        }

        for(int i=height.length-1;i>=0;i--){
            if(height[i]>rightEdge){
                rightEdge = height[i];
                rightEdges[i] = rightEdge;
            }
            else {
                rightEdges[i] = rightEdge;

            }
        }

        for(int i=0;i<height.length;i++){
            waterCapacity[i] = Math.min(leftEdges[i],rightEdges[i])-height[i];
            maxArea+=waterCapacity[i];
        }

        System.out.println(java.util.Arrays.toString(height));
        System.out.println(java.util.Arrays.toString(leftEdges));
        System.out.println(java.util.Arrays.toString(rightEdges));
        System.out.println(java.util.Arrays.toString(waterCapacity));
        System.out.println(maxArea);

        return maxArea;
    }


}
