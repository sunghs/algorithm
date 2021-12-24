Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

### Examples:
```
Input: x = 123
Output: 321

Input: x = -123
Output: -321

Input: x = 120
Output: 21

Input: x = 0
Output: 0
```

### Constraints:
- -2^31 <= x <= 2^31 - 1

```java
class Solution {

    public int reverse(int x) {
        boolean positive = (x >= 0);
        StringBuilder sb = new StringBuilder().append(Math.abs(x));
        try {
            int result = Integer.parseInt(sb.reverse().toString());
            return positive ? result : (-result);
        } catch (Exception e) {
            return 0;
        }
    }
}
```