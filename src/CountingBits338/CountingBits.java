package CountingBits338;

public class CountingBits {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        int base = 1;
        for(int i=1;i<result.length;i++){
            if(i<base*2)
                result[i] = 1+result[i-base];
            else{
                result[i] = 1;
                base = i;
            }
        }
        return result;
    }
    //An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
    public int[] countBits2(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }
}
