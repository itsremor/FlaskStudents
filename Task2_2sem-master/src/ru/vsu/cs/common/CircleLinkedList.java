package ru.vsu.cs.common;

import java.util.ArrayList;
import java.util.List;

public class CircleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CircleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean add(T element) {
        boolean flag = true;
        if (contains(element)) {
            flag = false;
        }
        if (size == 0) {
            Node<T> newNode = new Node<>(element, head);
            this.tail = newNode;
            this.head = newNode;
            tail.setNext(head);
            size++;
        } else {
            Node<T> newNode = new Node<>(element, head);
            this.tail.setNext(newNode);
            this.tail = newNode;
            size++;
        }
        return flag;
    }

    public boolean add(int index, T element) {
        if(!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> newNode = new Node<>(element, null);
        Node<T> temp = head;
        for(int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        newNode.setNext(temp);
        temp.setNext(newNode);
        size++;
        return true;
    }

    public int getSize() {
        return this.size;
    }

    public boolean contains(T object) {
        Node<T> tempNode = head;
        for (int i = 0; i < size; i++) {
            if (tempNode.getData().equals(object)) {
                return true;
            }
            tempNode.setNext(tempNode.getNext());
        }
        return false;
    }

    public T remove(int index) throws Exception {
        if(!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> tempNode = head;
        T tempObject;
        for(int i = 0; i < index - 1; i++) {
            tempNode = tempNode.getNext();
        }
        tempObject = tempNode.getNext().getData();
        tempNode.setNext(tempNode.getNext().getNext());
        size--;
        return tempObject;
    }

    public T findLastPerson(int k, CircleLinkedList<T> list) throws Exception {
        Node<T> node = list.head;
        while (size > 1) {
            for (int i = 1; i < k - 1; i++) {
                node = node.getNext();
            }
            if (node.equals(tail)) {
                head = node.getNext().getNext();
            }
            if (node.getNext().equals(tail)) {
                tail = node;
            }
            node.setNext(node.getNext().getNext());
            size--;
        }
        return list.get(0);
    }

    public String toString() {
        Node<T> curr = head;
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList [");
        while (curr != null) {
            sb.append(curr.getData());
            if (curr.getNext() != null) {
                sb.append(", ");
            }
            curr = curr.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public static CircleLinkedList<Integer> createIndexList(int size) {
        CircleLinkedList<Integer> indexList = new CircleLinkedList<>();
        for(int i = 0; i < size; i++) {
            indexList.add(i + 1);
        }
        return indexList;
    }

    private Node<T> getNode(int index) throws Exception {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr;
    }

    public T get(int index) throws Exception {
        return getNode(index).getData();
    }

    public void clearList() {
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    public boolean checkIndex(int index) {
        if(index >= size || index < 0) {
            return false;
        } else {
            return true;
        }
    }
}

class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

}
