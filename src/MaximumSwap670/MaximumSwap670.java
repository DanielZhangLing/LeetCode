package MaximumSwap670;

public class MaximumSwap670 {
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        int[] index = new int[10];
        // loop through record the last number of 1-9
        for(int i = 0 ; i<arr.length;i++){
            index[arr[i]-'0'] = i;
        }
        // for each number check whether bigger number exists behind them
        for(int i = 0; i<arr.length; i++){
            for(int j = 9; j>arr[i]-'0';j--){
                if(index[j]>i){
                    char temp = arr[i];
                    arr[i] = arr[index[j]];
                    arr[index[j]] = temp;
                    return Integer.valueOf(new String(arr));
                }
            }
        }
        return num;
    }
}
