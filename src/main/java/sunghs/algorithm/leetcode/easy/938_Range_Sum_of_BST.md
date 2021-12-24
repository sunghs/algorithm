Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.


### Example 1:
```
Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
```

### Example 2:
```
Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23
``` 

### Note:

- The number of nodes in the tree is at most 10000.
- The final answer is guaranteed to be less than 2^31.

```java
public int rangeSumBST(TreeNode root, int L, int R) {
    int sum = 0;
    if (root == null) {
        // 현재 커서의 값이 없다면 0 반환
        return 0;
    } else if (root.val < L) {
        // 현재 노드의 값이 L보다 작을 경우 L보다 큰 수가 들어왔을 때 L의 오른쪽으로 들어갔으므로 오른쪽으로 진행
        return rangeSumBST(root.right, L, R);
    } else if (root.val > R) {
        // 현재 노드의 값이 R보다 클 경우 R 오른쪽으로 들어갔을테니 왼쪽으로 진행
        return rangeSumBST(root.left, L, R);
    } else {
        // L과 R 사이면 더함
        sum += root.val;
    }
    // L과 R 사이의 값을 더한 경우 좌우 판별이 불가능하니 sum에 다시 더하러 진행
    return sum + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
}
```