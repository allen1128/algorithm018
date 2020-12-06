public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int pp = 1;
        int p = 2;

        for (int i = 3; i < n + 1; i++) {
            int temp = pp + p;
            pp = p;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        ClimbingStairs_70 cs = new ClimbingStairs_70();
        System.out.println(cs.climbStairs(4));
    }

}
