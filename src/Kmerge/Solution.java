package Kmerge;

import java.util.*;


class Solution {

   
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }

        lists = removeNullLists(lists);

        if(lists.length == 0){
            return null;
        }



        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {

            @Override
            public int compare(ListNode n1,ListNode n2){
                return n1.val - n2.val;
            }
        });


        for(ListNode head : lists){

            while(head!=null){
                ListNode temp = head.next;
                head.next = null;

                queue.add(head);
                head = temp;
            }
        }


        ListNode head = queue.poll();
        ListNode temp = head;

        while(!queue.isEmpty()){
            temp.next = queue.poll();
            temp = temp.next;
        }


        return head;
    }



    public ListNode[] removeNullLists(ListNode[] lists){

        List<ListNode> list = new ArrayList<>();

        for(ListNode n : lists){
            if(n!=null){
                list.add(n);
            }
        }

        return list.toArray(new ListNode[list.size()]);
    }
}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }
}