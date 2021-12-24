Remove all elements from a linked list of integers that have value val.

### Example:

Input:  1->2->6->3->4->5->6, val = 6  
Output: 1->2->3->4->5

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = null;
        ListNode cursor = null;
        
        while (head != null) {
            if (result == null && head.val != val) {
                result = new ListNode(head.val);
                cursor = result;
            } else if (result != null && head.val != val) {
                while (result.next != null) {
                    result = result.next;
                }
                result.next = new ListNode(head.val);
            }
            head = head.next;
        }
        return cursor;  
    }
}
```