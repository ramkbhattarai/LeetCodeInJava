package others;

public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	
	
	
	// 2nd approach
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode res = null, temp = null;
		int carry = 0, sum = 0;
		while (l1 != null || l2 != null) {
			sum += carry;
			sum += (l1 != null) ? l1.val : 0;
			sum += (l2 != null) ? l2.val : 0;
			carry = sum / 10;
			sum = sum % 10;
			if (res == null) {
				res = new ListNode(sum);
				temp = res;
			} else {
				temp.next = new ListNode(sum);
				temp = temp.next;
			}
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
			sum = 0;
		}
		if (carry != 0) {
			temp.next = new ListNode(carry);
		}
		return res;
	}

}
