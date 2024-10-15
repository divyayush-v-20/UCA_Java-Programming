interface Stack{
    void initialize(int size);
    void push(int item);
    int pop();
    boolean isEmpty();
    int size();
}

class Array implements Stack{
    int[] array;
    int top;
    int cur;
    public void initialize(int size){
        this.array = new int[size];
        this.top = -1;
        this.cur = 0;
    }
    public void push(int item){
        if(this.cur >= this.array.length){
            System.out.println("stack overflow");
            return;
        }
        this.array[++this.top] = item;
        ++this.cur;
    }
    public int pop(){
        if(this.cur <= 0){
            System.out.println("stack underflow");
            return -1;
        }
        this.cur--;
        return this.array[this.top--];
    }
    public boolean isEmpty(){
        return this.cur == 0;
    }
    public int size(){
        return this.cur;
    }
}

class LinkedList implements Stack{
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }

    ListNode top;
    int cur;
    int cap;

    public void initialize(int size){
        this.cap = size;
    }
    public void push(int item){
        if(this.cur >= this.cap){
            System.out.println("stack overflow");
            return;
        }
        ListNode cur_node = this.top;
        this.top = new ListNode(item);
        this.top.next = cur_node;
        ++this.cur;
    }
    public int pop(){
        if(this.cur <= 0){
            System.out.println("stack underflow");
            return - 1;
        }
        ListNode del = this.top;
        this.top = this.top.next;
        --this.cur;
        return del.val;
    }
    public boolean isEmpty(){
        return this.cur == 0;
    }
    public int size(){
        return this.cur;
    }
}

public class stacks{
    public static void main(String[] args){
        System.out.println("implementation using array");
        Stack arraystack = new Array();
        arraystack.initialize(3);
        arraystack.push(2);
        arraystack.push(1);
        arraystack.push(0);

        while(!arraystack.isEmpty()){
            System.out.println("top element -> " + arraystack.pop() + ", current size ->" + arraystack.size());
        }

        System.out.println();

        System.out.println("implementation using linked list");
        Stack liststack = new LinkedList();
        liststack.initialize(3);
        liststack.push(4);
        liststack.push(8);
        liststack.push(16);

        while(!liststack.isEmpty()){
            System.out.println("top element -> " + liststack.pop() + ", current size ->" + liststack.size());
        }
    }
}