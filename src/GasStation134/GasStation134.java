package GasStation134;

public class GasStation134 {
/*
 * 1. if sum of gas - sum of cost >=0 , always has a solution
 * 2. if start from i to i+j total<cost then from i to i+j there is no solution
 * 		so restart from i+j+1
 * 3. in this way we don't need to consider circles
 * O n
 */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==0||cost.length==0)
            return -1;
        int sum = 0;
        int n = gas.length;
        int total = 0;
        int station = 0;
        for(int i=0; i<n; i++){
            sum += gas[i]-cost[i];
            total += gas[i];
            if(total<cost[i]){
                station = i+1;
                total = 0;
            }
            else{
                total -= cost[i];
            }
        }
        return (station==n||sum<0)? -1:station;
    }
}
