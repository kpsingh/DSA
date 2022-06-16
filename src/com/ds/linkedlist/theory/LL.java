package com.ds.linkedlist.theory;

public class LL {

    ListNode head;
    int size;

    public LL() {
        size = 0;
    }


    public void add(int val){
        ListNode node = new ListNode(val);
        if(head == null){
            head = node;
            size++;
            return;
        }
        node.next = head;
        head = node;
        size++;
    }

    public void show(){
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
        System.out.print(" END ");

    }



    private class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }
        ListNode(int val) {
            this.val = val;

        }
        ListNode(int val, ListNode next) {
            this.val= val;
            this.next= next;

        }
    }
}

