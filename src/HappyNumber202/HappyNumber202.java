package HappyNumber202;

/*
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process:
 Starting with any positive integer, 
 replace the number by the sum of the squares of its digits, 
 and repeat the process until the number equals 1 (where it will stay),
  or it loops endlessly in a cycle which does not include 1.
   Those numbers for which this process ends in 1 are happy numbers.
 */
/*
 * set to record which has showed up
 * use two while loop to continue do
 */
public class HappyNumber202 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while(!set.contains(1)){
            int temp = 0;
            while(n>0){
                int cur = n%10;
                temp+= cur*cur;
                n = n/10;
            }
            if(set.contains(temp))
                return false;
            set.add(temp);
            n = temp;
        }
        return true;
    }
}
