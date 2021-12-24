You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

### Examples:
```
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps


Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
```

### Constraints:
- 1 <= n <= 45

### 5항까지 구해보면 규칙이 보임
피보나치 수열과 같음
```java
/**
n = 1 -> 1
    1 
n = 2 -> 2
    1 1
    2
n = 3 -> 3
    1 1 1
    2 1
    1 2
n = 4 -> 5
    1 1 1 1 
    1 1 2
    1 2 1
    2 1 1
    2 2
n = 5 -> 8
    1 1 1 1 1
    1 1 1 2
    1 1 2 1
    1 2 1 1
    2 1 1 1
    1 2 2 
    2 1 2
    2 2 1

n = 1,2,3,4,5.....
k = 1,2,3,5,8.....
f(n) = f(n-1) + f(n-2)
*/
```

다만 해당 문제는 O(2^n)의 시간복잡도 발생 시 Time Exceed 에러를 내도록 되어있었음.  
이전에 구한 값을 메모리에 올려 n-1 이 전부 다 구해지면 n-2 항 구할 시 메모리에서 빠르게 가져오도록 하는 방법이 필요

```java
class Solution {

    public Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        if (n <= 3) {
            return Math.max(n, 0);
        } else {
            Integer v1 = map.get(n - 1);
            Integer v2 = map.get(n - 2);
            if (v1 == null) {
                v1 = climbStairs(n - 1);
                map.put(n - 1, v1);
            }
            if (v2 == null) {
                v2 = climbStairs(n - 2);
                map.put(n - 2, v2);
            }
            return v1 + v2;
        }
    }
}
```