package com.hippoz.datastructure;

/**
 * @Package com.hippoz.datastructure
 * @Description: 自定义可自动伸缩的动态数组，对应JDK中的ArrayList
 * @User: mather
 * @Date: 2020-07-21
 * @Time: 06:05
 * @Since: 2020-07-21-06:05
 * @Version V1.0
 */

public class ArrayList<E> {
    // 内部维护一个数组
    private E[] data;
    // 记录数组的长度
    private int size = 0;

    /**
     * 无参构造器，默认capacity=10
     */
    ArrayList(){
        this(10);
    }

    /**
     * 自定义容量的构造器
     * @param capacity
     */
    ArrayList(int capacity){
        data = (E[]) new Object[capacity];
    }

    /**
     * 返回数组是否为空
     * @return
     */

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 返回数组已有元素的个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 返回数组的容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 添加操作，支持自动扩容
     * @param e
     * @param index
     */
    public void add(E e,int index){
        if(index < 0 || index > size){
            // 位置不合法
            throw new IllegalArgumentException("add failed, require index >= 0 and index <= size.");
        }
        if(size == data.length){
            // 当前数组容量已满，需要扩容
            resize((int) (data.length * 1.5));
        }
        for (int i = size; i > index; i--)
            data[i] = data[i-1];
        data[index] = e;
        size++;
    }

    /**
     * 在数组末尾添加
     * @param e
     */
    public void add(E e){
        add(e,size);
    }

    // 在数组末尾添加
    public void addLast(E e){
        add(e,size);
    }

    // 在数组头部添加
    public void addFirst(E e){
        add(e,0);
    }

    /**
     * 删除操作，支持自动缩容
     * @param index
     * @return
     */
    public E remove(int index){
        if(index < 0 || index >= size){
            // 位置不合法
            throw new IllegalArgumentException("add failed, require index >= 0 and index < size.");
        }
        E e  = data[index];
        if(size * 2 < data.length)
            // 延迟缩容机制
            resize((int) (data.length / 1.5));
        for (int i = index; i < size ; i++) {
            data[i] = data[i+1];
        }
        size--;
        return e;
    }

    /**
     * 删除末尾元素
     * @return
     */
    public E remove(){
        return remove(size - 1);
    }

    /**
     * 删除末尾元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除首元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
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
        return data[index];
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
        E temp = data[index];
        data[index] = e;
        return temp;
    }

    /**
     * 查找数组中是否包含某元素，如果包含则返回索引位置
     * 如果不包含则返回-1
     * @param e
     * @return
     */
    public int find(E e){
        for (int i = 0; i < size ; i++) {
            if(e.equals(data[i]))
                return i;
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

    /**
     * 调整数组的容量，可扩容或缩容
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
        newData = null;
    }

    /**
     * 打印数组内容
     * @return
     */
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
