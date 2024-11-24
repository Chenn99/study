package com.louis;

/**
 * 泛型类
 * T:参数化类型 type 在实际使用时才会指定具体的类型
 * 泛型只作用与编译期检查,在编译后,会被擦除
 * @param <T>
 */
public class Node<T> {
    private T data;
    public Node(){}
    public Node(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
