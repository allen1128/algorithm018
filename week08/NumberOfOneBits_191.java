public class NumberOfOneBits_191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1; //this doesn't work well with negative value. that's why for loop instead of while(n != 0)
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfOneBits_191 nof = new NumberOfOneBits_191();
        System.out.print(nof.hammingWeight(-3));
    }
}
