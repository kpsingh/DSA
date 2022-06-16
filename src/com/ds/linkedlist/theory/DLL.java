package com.ds.linkedlist.theory;

public class DLL {

    Node head;
    int size;

    public DLL() {
        size = 0;
    }

    // insertFirst
    // insertLast
    // insert at index
    //delete at index etc... methods can be made.


    public void insertFirst(int value) {

        Node node = new Node(value);

        // when head and tails are null
        if (head == null){
            head = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;


    }

    public void display(){
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.value + " <--> ");
            temp = temp.next;
        }
        System.out.println("END");

    }


    private class Node {
        int value;
        Node next;
        Node prev;

        private Node(int value) {
            this.value = value;
        }

        private Node() {
        }
    }

}
