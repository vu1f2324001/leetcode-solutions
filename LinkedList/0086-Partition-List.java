class Solution {
public ListNode partition(ListNode head, int x) {
ListNode smallDummy = new ListNode(0);
ListNode largeDummy = new ListNode(0);

ListNode small = smallDummy;  
    ListNode large = largeDummy;  

    ListNode curr = head;  

    while (curr != null) {  
        if (curr.val < x) {  
            small.next = curr;  
            small = small.next;  
        } else {  
            large.next = curr;  
            large = large.next;  
        }  

        curr = curr.next;  
    }  

    large.next = null;  
    small.next = largeDummy.next;  

    return smallDummy.next;  
}

}
