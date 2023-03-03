import java.io.*;
import java.util.*;

interface PerformOperation {
    boolean check(int a);
}

/*
Write the following methods that return a lambda expression performing a specified action:

PerformOperation isOdd(): The lambda expression must return  if a number is odd or  if it is even.
PerformOperation isPrime(): The lambda expression must return  if a number is prime or  if it is composite.
PerformOperation isPalindrome(): The lambda expression must return  if a number is a palindrome or  if it is not.
Input Format

Input is handled for you by the locked stub code in your editor.

Output Format

The locked stub code in your editor will print  lines of output.

Sample Input

The first line contains an integer,  (the number of test cases).

The  subsequent lines each describe a test case in the form of  space-separated integers:
The first integer specifies the condition to check for ( for Odd/Even,  for Prime, or  for Palindrome). The second integer denotes the number to be checked.

5
1 4
2 5
3 898
1 3
2 12
Sample Output

EVEN
PRIME
PALINDROME
ODD
COMPOSITE
 */

public class Main {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    public PerformOperation odd() {
        return (n) -> n % 2 != 0;
    }
    public PerformOperation prime() {
        return (n) -> primee(n);
    }
    public PerformOperation palindrome() {
        return (n) -> palindromee(n);
    }
    private boolean primee(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    private boolean palindromee(int n) {
        int palindrome = n;
        int reverse = 0;
        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }
        return n == reverse;
    }

    public static void main(String[] args) throws IOException {
        Main ob = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.odd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.prime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.palindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}