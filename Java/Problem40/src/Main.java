/*
@author: mces58

Problem 40
An irrational decimal fraction is created by concatenating the positive integers:
                        0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.
If dn represents the nth digit of the fractional part, find the value of the following expression.

d1×d10×d100×d1000×d10000×d100000​

Answer: 840
*/

public class Main {
    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static int findDigitAtPosition(int position) {
        int length = 1;
        int count = 9;
        int start = 1;
        
        while (position > length * count) {
            position -= length * count;
            length++;
            count *= 10;
            start *= 10;
        }
        
        int number = start + (position - 1) / length;
        String numberStr = Integer.toString(number);
        
        return Character.getNumericValue(numberStr.charAt((position - 1) % length));
    }
    
    public static int solve() {
        int product = 1;
        int[] positions = {1, 10, 100, 1000, 10000, 100000};
        
        for (int pos : positions) {
            product *= findDigitAtPosition(pos);
        }
        
        return product;
    }
}
