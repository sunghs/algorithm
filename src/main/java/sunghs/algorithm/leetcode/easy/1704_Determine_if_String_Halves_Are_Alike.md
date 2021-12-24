You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). 

Notice that s contains uppercase and lowercase letters.

Return true if a and b are alike. Otherwise, return false.

### Examples:
```
Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.


Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2. Therefore, they are not alike.
Notice that the vowel o is counted twice.


Input: s = "MerryChristmas"
Output: false


Input: s = "AbCdEfGh"
Output: true
```

### Constraints:
- 2 <= s.length <= 1000
- s.length is even.
- s consists of uppercase and lowercase letters.

```java
class Solution {
    public boolean halvesAreAlike(String s) {
        List<String> vowels = List.of("a", "e", "i", "o", "u", "A", "E", "I", "O", "U");
        char[] a = s.substring(0, s.length() / 2).toCharArray();
        char[] b = s.substring(s.length() / 2).toCharArray();

        int aSum = 0;
        int bSum = 0;
        for (int i = 0; i < a.length; i++) {
            // char를 비교하는 vowels.contains(a[i]) 는 항상 false이니 주의, char를 String으로 감싸야함.
            if (vowels.contains(String.valueOf(a[i]))) {
                aSum++;
            }
            if (vowels.contains(String.valueOf(b[i]))) {
                bSum++;
            }
        }
        return aSum == bSum;
    }
}
```