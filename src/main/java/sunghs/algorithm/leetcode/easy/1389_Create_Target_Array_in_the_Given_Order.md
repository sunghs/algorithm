Given two arrays of integers nums and index. Your task is to create target array under the following rules:

Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.

It is guaranteed that the insertion operations will be valid.

 

### Example 1:
```
Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
```

### Example 2:
```
Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
Output: [0,1,2,3,4]
Explanation:
nums       index     target
1            0        [1]
2            1        [1,2]
3            2        [1,2,3]
4            3        [1,2,3,4]
0            0        [0,1,2,3,4]
```

### Example 3:
```
Input: nums = [1], index = [0]
Output: [1]
```

### Constraints:

- 1 <= nums.length, index.length <= 100
- nums.length == index.length
- 0 <= nums[i] <= 100
- 0 <= index[i] <= i

```java
public int[] createTargetArray(int[] nums, int[] index) {
        // 빈번한 중간 삽입 삭제를 위해 LinkedList 사용
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = index[i];
            int val = nums[i];
            result.add(idx, val);
        }

        //List<Wrapper> to primitive 타입배열
        int[] r = new int[result.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i).intValue();
        }
        return r;
    }
```