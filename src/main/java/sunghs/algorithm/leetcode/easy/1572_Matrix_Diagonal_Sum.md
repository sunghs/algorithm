Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

### Examples:

![](../../../../../../../static/1572.png)

```
Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.


Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8


Input: mat = [[5]]
Output: 5
```

### Constraints:
- n == mat.length == mat[i].length
- 1 <= n <= 100
- 1 <= mat[i][j] <= 100

```java
class Solution {
    public int diagonalSum(int[][] mat) {
        Set<String> set = new HashSet<>(); // 지나온 좌표를 저장
        int vertical = mat.length; // 세로 최대길이
        int horizon = mat[0].length; // 가로 최대길이
        int result = 0;

        // 좌상단 시작 우하단 종료 (primary diagonal)
        int x = 0;
        int y = 0;
        while (x < horizon && y < vertical) {
            String pt = x + "," + y;
            if (!set.contains(pt)) {
                result += mat[x][y];
                set.add(pt);
            }
            x++;
            y++;
        }

        // 우상단 시작 좌하단 종료 (secondary diagonal)
        x = horizon - 1;
        y = 0;
        while (x >= 0 && y < vertical) {
            String pt = x + "," + y;
            if (!set.contains(pt)) {
                result += mat[x][y];
                set.add(pt);
            }
            x--;
            y++;
        }

        return result;
    }
}
```