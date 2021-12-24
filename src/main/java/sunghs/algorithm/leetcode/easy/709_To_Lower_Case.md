Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

### Example 1:
Input: "Hello"
Output: "hello"

### Example 2:
Input: "here"
Output: "here"

### Example 3:
Input: "LOVELY"
Output: "lovely"

```java
class Solution {
    public String toLowerCase(String str) {
        char[] arr = str.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            if ((int) arr[i] >= 65 && (int) arr[i] <= 90)
                arr[i] = (char) ((int) arr[i] + 32);
        }
        return new String(arr);
    }
}
```