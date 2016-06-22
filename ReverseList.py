# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#in place, one pass
class Solution(object):
    def reverseInPlace(self, hook, n):
        cur = 0
        start = hook
        while(cur < n and hook != None):
            tmp = start.next
            start.next = start.next.next
            tmp.next = hook
            hook = tmp
            cur = cur + 1
        return hook

    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        cur = 1
        if m > 1:
            tmp = head
            while(cur < m - 1):
                tmp = tmp.next
                cur = cur + 1
            hook = tmp.next
            tmp.next = self.reverseInPlace(hook, n - m)

            
        else:
            hook = head
            head = self.reverseInPlace(hook, n - m)
        return head
