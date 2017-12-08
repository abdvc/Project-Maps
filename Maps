
package projectMaps;

import java.util.LinkedList;

public class ProjectMaps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
//Break
class Graph {

    Vertex vertList[];
    //Adjacency Matrix
    int adjMat[][];
    int count = 0;

    Graph(int s) {
        vertList = new Vertex[s];
        adjMat = new int[s][s];
    }

    public void addVertex(String str) {
        if (count >= vertList.length) {
            System.out.println("Graph filled: Cannot add more");
        } else {
            vertList[count] = new Vertex(str);
            count++;
        }
    }
    
    
    public int findStr(String str){
        for (int i = 0; i < vertList.length; i++) {
            if (vertList[i].label.equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }
    //Finds position of index in array that contains the vertex with the string we want to find (under vertex.label)

    public void addEdge(String str1, String str2) {
        int a = findStr(str1);
        int b = findStr(str2);
        
        if (a != -1 && b != -1) {
            adjMat[a][b] = 1;
            adjMat[b][a] = 1;
//            adjMat[a][a] = 1;
        }
    }
    
    public void suggest(){
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                if (adjMat[i][j] == 0 && i != j) {
                    System.out.println(vertList[i].label+" should add "+vertList[j].label);
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < vertList.length; i++) {
            System.out.println(vertList[i].label);
        }
        
        System.out.println("");
        
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                if (adjMat[i][j] == 1) {
                    System.out.println(vertList[i].label + " is connected to "+vertList[j].label);
                }
            }
        }
    }
}

//Break
class Graph {

    ArrayList<Vertex> adjList;

    Graph() {
        adjList = new ArrayList();
    }

    Graph(int s) {
        adjList = new ArrayList(s);
    }
    
    public void addVertex(Vertex v){
        adjList.add(v);
    }
    
    public void addEdge(Vertex v1, Vertex v2){
        v1.list.add(v2);
        v2.list.add(v1);
    }
    
    public void BFS(){
        Queue q = new Queue();
        q.enQ(adjList.get(0).data);
        for (int i = 1; i < adjList.size(); i++) {
            for (int j = 0; i < adjList.get(i).list.size()-2; j++) {
//                System.out.println(adjList.get(i).list.size()-1);
                q.enQ(adjList.get(i).list.get(j).data);
                adjList.get(i).list.get(j).visit = true;
            }
            System.out.print(q.rear + " ");
            q.deQ();
        }
    }
}

//Break
class Graph {

    ArrayList<Vertex> adjList;

    Graph() {
        adjList = new ArrayList();
    }

    Graph(int s) {
        adjList = new ArrayList(s);
    }

    public void addVertex(String a) {
        Vertex v = new Vertex(a);
//        v.list.add(v);
        adjList.add(v);
    }

    public void addEdge(String s1, String s2) {
        Vertex v1 = null, v2 = null;
        for (int i = 0; i < adjList.size(); i++) {
            if (adjList.get(i).label.equals(s1)) {
                v1 = adjList.get(i);
            }
            if (adjList.get(i).label.equals(s2)) {
                v2 = adjList.get(i);
            }
        }
        if (v1 != null && v2 != null) {
            v1.list.add(v2);
            v2.list.add(v1);
        }
    }

    public void DFS() {
        Stack<Vertex> s = new Stack();
        Vertex temp = adjList.get(0);
        s.push(temp);
        while (!s.isEmpty()) {
            Vertex find = findUnvisited(temp);
            if (find != null) {
                find.visit = true;
                s.push(find);
                temp = find;
            } else {
                System.out.println(s.pop()+ " ");
                temp = s.peek();
            }
        }
    }

    public Vertex findUnvisited(Vertex v) {
        Vertex temp = v.list.get(0);

        if (temp == null) {
            System.out.println("Null");
            return null;
        }
        int i = 1;
        while (temp.visit) {
            
            System.out.println(i);
            temp = temp.list.get(i);
            if (i >= temp.list.size()) {
                System.out.println("Null");
                return null;
            }
            i++;
        }
        return temp;
    }

    public int component() {
        return 0;
    }

    public void display() {

    }
}

//Break
public class Vertex {

    String label;
    boolean visit = false;
    LinkedList<Vertex> list = new LinkedList();
    int comp;
    Vertex right;
    

    Vertex(String label) {
        this.label = label;
        comp = 0;
    }

    Vertex() {
    }
}
