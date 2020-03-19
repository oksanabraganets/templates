import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args){
        StrategyClient client = new StrategyClient();
        client.setStrategy(new BubbleSort());

        int[] arr = {32,1,6,-6, 43, 234, 54, 4};
        client.executeStrategy(arr);
    }
}

interface Sorting{
    void sort(int[] arr);
}
class StrategyClient{
    private Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int[] arr){
        strategy.sort(arr);
    }
}

class BubbleSort implements Sorting{

    public void sort(int[] arr) {
        System.out.println("BubbleSort");
        System.out.println("before: \t"+ Arrays.toString(arr));
        for (int i=1; i<arr.length; i++){
            for (int j=0; j<i; j++){
                if (arr[j]>arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("after: \t"+ Arrays.toString(arr));
    }
}