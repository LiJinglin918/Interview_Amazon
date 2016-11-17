/*
有一个容器double capacity, 還有一個array(double[] weights), 和int numOfContainers。

要求在array中选出两个weights總总和小于等于capacity但最接近capacity 然後指定到一個Container object並且return。

first和second的顺序不做要求，numOfContainer在java里好像没用,因为double[]本身就自带length信息。
*/


import java.util.Arrays;

class Container {
    public double first;
    public double second;
}

public class Main {
    public static void main(String[] args) {
        double capacity = 35;
        double[] weights = {10,24,30,9,19,23,7};
        double maxWei = 0;
        double maxSmall = 0;
        double maxLarge = 0;

        Arrays.sort(weights);
        int i = 0;
        int j = weights.length-1;
        while (i < j) {
            if ((weights[i] + weights[j]) < capacity) {
                if (weights[i] + weights[j] > maxWei) {
                    maxWei = weights[i] + weights[j];
                    maxSmall = weights[i];
                    maxLarge = weights[j];
                }
                i += 1;
            } else if (weights[i] + weights[j] == capacity) {
                maxSmall = weights[i];
                maxLarge = weights[j];
                maxWei = capacity;
                break;
            } else {
                j -= 1;
            }
        }
        System.out.println("The maximum weights is" + maxWei + ", the index are" + maxSmall + "and" + maxLarge);
    }
}
