package Accenture;

import java.util.Arrays;

public final class StepGame {

    public static int countSteps(int currentStep) {
        int numberOfSteps = 0;
        int[] dp = new int[currentStep + 1];
        Arrays.fill(dp, -1);
        return countSteps(currentStep, numberOfSteps, dp);
    }

    public static int countSteps(int currentStep, int numberOfSteps, int[] dp) {
        if (currentStep == 0)
            return numberOfSteps;

        if (currentStep == 1)
            return 1 + numberOfSteps;

        if (currentStep % 2 == 0 && dp[currentStep] == -1) {
            dp[currentStep] = 1 + numberOfSteps + countSteps(currentStep / 2, numberOfSteps, dp);
        }

        if (dp[currentStep] == -1) {
            dp[currentStep] = 1 + numberOfSteps + countSteps(currentStep - 1, numberOfSteps, dp);
        }

        return dp[currentStep];
    }

    public static void main(String[] args) {
        System.out.println(countSteps(10));
    }
}
