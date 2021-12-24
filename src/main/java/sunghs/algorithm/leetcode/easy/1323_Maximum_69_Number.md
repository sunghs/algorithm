Given a positive integer num consisting only of digits 6 and 9.

Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

### Examples:
```
Input: num = 9669
Output: 9969
Explanation: 
Changing the first digit results in 6669.
Changing the second digit results in 9969.
Changing the third digit results in 9699.
Changing the fourth digit results in 9666. 
The maximum number is 9969.


Input: num = 9996
Output: 9999
Explanation: Changing the last digit 6 to 9 results in the maximum number.
```
### Constraints:
- 1 <= num <= 10^4
- num's digits are 6 or 9.

### 6을 최소로 바꿔서 가장 큰 수 => 가장 빨리 나타나는 6 하나를 9로 바꾸면 된다.
```java
class Solution {
    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        StringBuilder result = new StringBuilder();
        int limit = 0;
        for (char c : s.toCharArray()) {
            if (c == '6' && limit == 0) {
                result.append('9');
                limit++;
            } else {
                result.append(c);
            }
        }
        return Integer.parseInt(result.toString());
    }
}
```