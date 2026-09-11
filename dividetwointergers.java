class Solution {
    public int divide(int dividend, int divisor) {

        // Overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long a = dividend;
        long b = divisor;

        // Find the sign of the answer
        boolean negative = (a < 0) ^ (b < 0);

        // Convert both to positive
        a = Math.abs(a);
        b = Math.abs(b);

        long quotient = 0;

        while (a >= b) {
            long temp = b;
            long multiple = 1;

            // Double using left shift
            while (a >= (temp << 1)) {
                temp = temp << 1;
                multiple = multiple << 1;
            }

            a = a - temp;
            quotient = quotient + multiple;
        }

        // Apply sign
        if (negative) {
            quotient = -quotient;
        }

        return (int) quotient;
    }
}
