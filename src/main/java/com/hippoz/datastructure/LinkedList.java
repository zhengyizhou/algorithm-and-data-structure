package com.hippoz.datastructure;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

/**
 * @Package com.hippoz.datastructure
 * @Description: Linked List
 * @User: mather
 * @Date: 2020-07-22
 * @Time: 06:09
 * @Since: 2020-07-22-06:09
 * @Version V1.0
 */

public class LinkedList<E> {

    /**
     * inner class as node
     */
    private class Node {
        E data;
        Node next;
        Node(E e, Node next){
            this.data = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return data.toString();
        }
    }

    // 链表包含节点的个数
    private int size;
    // 定义一个虚拟的头结点
    private Node dummyHead;


    public LinkedList (){
        this.size = 0;
        this.dummyHead = new Node();
    }

    /**
     * get size of LinkedList
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * LinkedList is empty or not
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * add node at index
     * @param e
     * @param index
     */
    public void add(E e,int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add failed, require index > 0 and index <= size ");
        }
        Node currentNode = dummyHead;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
//        Node newNode = new Node(e,currentNode.next);
//        currentNode.next = newNode;
        // 优化
        currentNode.next = new Node(e,currentNode.next);
        size++;
    }

    /**
     * add node at first location
     * @param e
     */
    public void addFirst(E e){
        add(e,0);
    }

    /**
     * add node at last location
     * @param e
     */
    public void addLast(E e){
        add(e,size);
    }


    /**
     * remove element at index
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            // 位置不合法
            throw new IllegalArgumentException("remove failed, require index >= 0 and index < size.");
        }
        Node currentNode = this.dummyHead;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        Node temp = currentNode.next;
        currentNode.next = currentNode.next.next;
        size--;
        return temp.data;
    }

    /**
     * remove first node
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * remove last node
     * @return
     */
    public E removeLast(){
        return remove(size);
    }


    /**
     * 根据下标随机访问
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            // 位置不合法
            throw new IllegalArgumentException("add failed, require index >= 0 and index < size.");
        }
        Node currentNode = this.dummyHead;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;

        }
        return currentNode.data;
    }

    /**
     * 获取末尾元素
     * @return
     */
    public E get(){
        return get(size - 1);
    }

    /**
     * 获取末尾元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取首元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 根据索引修改元素
     * @param e
     * @param index
     * @return
     */
    public E set(E e, int index){
        if(index < 0 || index >= size){
            // 位置不合法
            throw new IllegalArgumentException("add failed, require index >= 0 and index < size.");
        }
        Node currentNode = this.dummyHead;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;

        }
        E ret = currentNode.data;
        currentNode.data = e;
        return ret;
    }

    /**
     * 查找数组中是否包含某元素，如果包含则返回索引位置
     * 如果不包含则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        Node currentNode = this.dummyHead.next;
        for (int i = 0; i < size; i++) {
            if(e.equals(currentNode.data))
                return i;
            currentNode = currentNode.next;
        }
        return -1;
    }

    /**
     * 判断数组中是否包含某元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        return find(e) >= 0;
    }


    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        Node currentNode = this.dummyHead.next;
        while(currentNode != null){
            ret.append(currentNode.toString() + "-->");
            currentNode = currentNode.next;
        }
        ret.append("NULL");
        return ret.toString();
    }
}
