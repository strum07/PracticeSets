package LeetCode;

public class ContainerWithMostWater {


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));

    }

    private static int maxArea(int[] height) {

        int[] waterCapacity = new int[height.length];
        int[] leftEdges = new int[height.length];
        int[] rightEdges = new int[height.length];
        int leftEdge = 0;
        int rightEdge =0;
        int maxArea = 0;


        int minBoundingEdge = 0;
        int maxBoundingEdge = 0;

        int minBoundingEdgeIndex = 0;
        int maxBoundingEdgeIndex = 0;


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

            if(waterCapacity[i]==0){
                minBoundingEdge = height[i];
                minBoundingEdgeIndex = i+1;
                if(minBoundingEdge!=0){
                    minBoundingEdge = Math.min(minBoundingEdge,height[i]);
                }
            }

            if(waterCapacity[i]==0){

                minBoundingEdgeIndex = i+1;

                maxBoundingEdgeIndex = i+1;


                //assign start
                //assign end


            }

            maxArea+=waterCapacity[i];
        }

        System.out.println(java.util.Arrays.toString(height)+" Original");
        System.out.println(java.util.Arrays.toString(leftEdges)+" Left Edges");
        System.out.println(java.util.Arrays.toString(rightEdges)+" Right Edges");
        System.out.println(java.util.Arrays.toString(waterCapacity)+" Water Capacity");
        System.out.println(minBoundingEdge*minBoundingEdge);
        System.out.println(minBoundingEdgeIndex);
        System.out.println(maxBoundingEdge);

        return maxArea;
    }


}
