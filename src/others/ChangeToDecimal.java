package others;
/**
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

 

Example 1:


Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10
Example 2:

Input: head = [0]
Output: 0
Example 3:

Input: head = [1]
Output: 1
Example 4:

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880
Example 5:

Input: head = [0,0]
Output: 0
 * @author ramkrishnabhattarai
 *
 */
public class ChangeToDecimal {
	
	public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int val = 0;
        while (cur != null) {
            val <<= 1;
            val += cur.val;
            cur = cur.next;
        }
        return val;
    }
	
	
	long pow2;
    public int getDecimalValue(ListNode head) {
        if(head==null){
			pow2 = 1
            return 0;
        }
        int val = getDecimalValue(head.next);
        val += (int)pow2*head.val;
        pow2*=2;
        return val;
    }

}
