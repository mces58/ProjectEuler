import java.util.*;

/*
@author: mces58

Problem 41
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. 
For example, 2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?

Answer: 7652413
*/

public class Main {
    public static void main(String[] args) {
        System.out.println(largestPandigitalPrime());
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    public static int largestPandigitalPrime() {
        for (int n = 9; n >= 1; n--) { 
            String digits = "";
            for (int i = 1; i <= n; i++) {
                digits += i;
            }
            
            Set<String> pandigitalNumbers = new HashSet<>();
            permute(digits, 0, digits.length() - 1, pandigitalNumbers);
            
            List<Integer> pandigitalList = new ArrayList<>();
            for (String numStr : pandigitalNumbers) {
                pandigitalList.add(Integer.parseInt(numStr));
            }
            Collections.sort(pandigitalList, Collections.reverseOrder());
            
            for (int num : pandigitalList) {
                if (isPrime(num)) {
                    return num;
                }
            }
        }
        return -1;
    }
    
    public static void permute(String str, int left, int right, Set<String> result) {
        if (left == right) {
            result.add(str);
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                permute(str, left + 1, right, result);
                str = swap(str, left, i);
            }
        }
    }
    
    public static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }

}
