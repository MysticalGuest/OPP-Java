package com.linkList;

/**
 * 逆置一个单链表有3种方法，这里我们将完整的实现：
 * 
 * 方法 1）：头插法建立新的链表，建立一个新的链表，把原来的单链表从头顺序遍历，遍历的每个结点都用头插法插入到新的链表中，这样新的链表自然就成原来
 * 的逆置得了。由于要遍历原来链表和建立新的链表，所以这种方法时间和空间复杂度都为O(n)，好处是不用修改原来的链表，坏处就是多了空间复杂度。这种方
 * 法是最常用。
 *
 * 方法2）： 原地逆置这种方法主要是每每修改两个相邻结点p,q的前后关系，增加一个t保存下一次的修改目标结点，既然都叫原地逆置了，所以空间复杂度为O(1)
 * ，时间同样为O(n)，但是这种方法修改了原来的链表，所以要特*别注意，慎重使用。注意不要形成环了，可以在idea中跑跑。
 * 
 * 方法3）： 使用递归，reverse(head),出口设置为head==null 和head.next==null ,但是特别注意递归子情况的判断，详情参见代码。
 * 
 * 方法4） ：Collections.reverse(); 这个方法之后做剖析，下一篇和Arrays.asList()以及toArray()结合介绍。
 **/

/// 第一次接触到Java处理数据结构
//定义一个节点
class Node {
    int data;
    Node next;
 
    public Node(int data) {
        this.data = data;
        next = null;
    }
}

//完整实现
public class TestReverse {
    public static void main(String args[]) {
        int a[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        TestReverse s = new TestReverse();
        System.out.print("逆置前链表为: ");
        Node L = s.init(a);
        s.show(L);
        //每次逆置可能改变L，所以就重新建立一次链表
        System.out.print("逆置方法1：   ");
        L = s.init(a);
        s.show(s.reverse1(L));
        System.out.print("逆置方法2：   ");
        L = s.init(a);
        s.show(s.reverse2(L));
        //递归最好不要头结点
        System.out.print("逆置方法3：   ");
        L = s.init(a);
        Node newL = new Node(-1);
        newL.next = s.reverse3(L.next);
        s.show(newL);
 
    }
 
    //初始化，用尾插法建立链表
    private Node init(int a[]) {
        //增加一个头结点，方便操作
        Node L = new Node(-1);
        int n = a.length;
        if (n == 0)
            return L;
        Node rear = L;
        for (int i = 0; i < n; i++) {
            Node p = new Node(a[i]);
            rear.next = p;
            rear = p;
        }
        return L;
    }
 
    //打印一个链表
    private void show(Node L) {
        if (L.next == null) return;
        Node p = L.next;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
 
    //逆置方法1:头插建立新链表
    private Node reverse1(Node L) {
        Node t = new Node(-1);
        Node p = L.next, q;
        while (p != null) {
            q = p.next;
            p.next = t.next;
            t.next = p;
            p = q;
        }
        return t;
    }
 
    //逆置方法2：原地逆置
    private Node reverse2(Node L) {
        Node p = L.next;
        //空链表和一个元素时候
        if (p == null || p.next == null)
            return L;
        //p,q两个相邻结点的前后关系改变，t保存下一次修改的结点
        Node q = p.next, t = q.next;
        while (q != null) {
            q.next = p;
            p = q;
            q = t;
            if (t != null)
                t = t.next;
 
 
        }
        //注意修改逆置的最后一个结点的后继为空，并且头结点指向原来的最后一个结点
        L.next.next = null;
        L.next = p;
        return L;
 
    }
 
    //递归逆置，注意这里用的是L.next
    private Node reverse3(Node head) {
        //递归出口
        if (head == null || head.next == null)
            return head;
        //递归子情况
        Node pre = reverse3(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
 
 
}