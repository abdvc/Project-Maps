//From Abdvc
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication84;

import java.util.Stack;

/**
 *
 * @author Abdullah
 */
public class graph {

    vertex head = null;
    vertex tail;
    Stack<String> s = new Stack<String>();
    Queue que;

    graph() {
        que = new Queue(10);
    }

    graph(int i) {
        que = new Queue(i);
    }

    public void BFS() {
        vertex temp = head;

        que.Enqueue(temp.label);
        System.out.println("Calling BFS: ");
        while (temp != null) {
            vertex temp2 = temp.ver.head;
            while (temp2 != null) {
                if (!temp2.visited) {
                    temp2.visited = true;
                    que.Enqueue(temp2.label);
                }
                temp2 = temp2.Right;

            }
            que.DeQueue();
            temp = temp.down;
        }
        while (!que.isEmpty()) {
            que.DeQueue();
        }
    }

    public void DFS() {
        vertex temp = head;
        s.push(head.label);
        System.out.println("Calling DFS: ");
        while (true) {
            vertex finding = this.findUnvisited(temp);
            if (finding != null) {
                finding.visited = true;
                s.push(finding.label);
                temp = finding;
            } else {

                System.out.println(s.pop() + " ");
                if (s.isEmpty()) {
                    break;
                }
                temp = this.find(s.peek());

            }
        }
    }

    public vertex findUnvisited(vertex ver) {
        vertex temp = ver.ver.head;
        if (temp == null) {
            return null;
        }
        while (temp.visited != false) {
            temp = temp.Right;
            if (temp == null) {
                return null;
            }
        }
        return temp;
    }

    public void insertVertex(String d) {
        vertex v = new vertex(d);
        if (head == null) {
            head = v;
            tail = head;
        } else {
            tail.down = v;
            tail = tail.down;
        }
    }

    public vertex find(String d) {
        vertex temp = head;
        while (temp != null) {
            if (temp.label.equalsIgnoreCase(d)) {
                return temp;
            }
            temp = temp.down;
        }
        return null;
    }

    public void insertEdge(String vertex, String edge) {
        vertex temp = find(vertex);
        vertex temp2 = find(edge);
        if (temp != null) {
            temp.ver.insert(temp2);
        }
    }

    public void Display() {
        vertex temp = head;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.down;
        }
    }

}

class LinkedList {

    vertex head;
    vertex tail;

    public void insert(vertex v) {

        if (head == null) {
            head = v;
            tail = head;
        } else {
            tail.Right = v;
            tail = tail.Right;
        }

    }

    public String toString() {
        vertex temp = head;
        String str = "Is connected to: ";
        while (temp != null) {
            str = str + temp.label + " ";
            temp = temp.Right;
        }
        return str;

    }

}

class vertex {

    String label;
    vertex Right;
    vertex down;
    LinkedList ver = new LinkedList();
    boolean visited = false;

    vertex(String d) {
        label = d;
    }

    public String toString() {
        String str = "";
        str = str + this.label + " " + ver.toString();
        return str;
    }

}

class Queue {

    int Front;
    int Rear;
    String arr[];

    Queue() {
        Front = 0;
        Rear = 0;
        arr = new String[10];
    }

    Queue(int size) {
        Front = 0;
        Rear = 0;
        arr = new String[size];
    }

    public boolean isEmpty() {
        return Rear == Front;
    }

    public boolean isFull() {
        if (Rear - Front == arr.length || Front - Rear == 1) {
            return true;
        } else {
            return false;
        }
    }

    public void DeQueue() {
        if (Front == arr.length) {
            Front = 0;
        }
        System.out.println(arr[Front]);
        arr[Front] = "";
        Front = Front + 1;

    }

    public void Dispplay() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void Enqueue(String data) {
        if (!isFull()) {
            if (Rear != arr.length) {
                arr[Rear] = data;
                //System.out.println("Data: "+data+" arra posi : "+Rear);
                Rear = Rear + 1;

            } else {
                Rear = 0;
                arr[Rear] = data;
                //System.out.println("Data: "+data+" arra posi : "+Rear);
                Rear = Rear + 1;

            }

        } else {
            System.out.println("Not possible");
        }
    }
}
