/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if( head == nullptr || head ->next == nullptr){
            return head;
        }

        int count = 0;
        ListNode* temp = head;
        while(temp!=nullptr){
            count++;
            temp=temp->next;
        }

        if( count < k){
            return head;
        }

        ListNode* prev = nullptr;
        ListNode* next = nullptr;
        ListNode* curr = head;
        int cnt = 0;
        while(cnt<k){
            next = curr->next;
            curr->next=prev;
            prev = curr;
            curr = next;
            cnt++;
        }

        head->next = reverseKGroup(curr,k);

        return prev;
      
    }
};