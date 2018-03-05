/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication88;

/**
 *
 * @author Abdullah
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class DijkstraAlgo {
    
   /* public static void main(String[] args) {
        DijkstraAlgo a = new DijkstraAlgo();
        LinkedList<Vertex> b = new LinkedList();
        b.add(new Vertex("1 4,2"));
        b.add(new Vertex("2 4,2"));
        b.add(new Vertex("3 4,2"));
        b.add(new Vertex("4 4,2"));
        b.add(new Vertex("5 4,2"));
        b.add(new Vertex("6 4,2"));
        b.add(new Vertex("7 4,2"));
        graph c = new graph();
        
        
    } */
    
    ArrayList<String> shortPath(graph a, String source, String DST) {
        Vertex start = a.findVert(source);
        ArrayList<String> LatLong = new ArrayList();
        start.dist = 0;
        PQueue queue = new PQueue(a, start);
        queue.setSource();
        int count = 0;
        Vertex current = null;
        while (!queue.isEmpty()) {
            current = queue.pop();
            if (current.label.equalsIgnoreCase(DST)) break;
            LinkedList<Edge> edges = queue.getEdges();
            
                for (int i = 0; i < edges.size(); i++) {
                    double dist = current.dist;
                    Edge c = edges.get(i);
                    dist += edges.get(i).weight;
                    if (dist < c.dst.dist) {
                        c.dst.dist = dist;
                        c.dst.prev = current;
                    }
                    
            }
                queue.reSort(current.label);
        }
        Vertex temp = current;
                while (temp != start) {
                    //String str = current.label;
                    String str = "";
                    if (str != null) 
                    str = "" + temp.lat + "," + temp.lon;
                    LatLong.add(str);
                    temp = temp.prev;
                }
        return LatLong;
    } 
}

class PQueue {
    LinkedList<Vertex> list;
    LinkedList<Edge>[] Elist;
    Vertex source;
    int count = 0;
    
    PQueue(graph a, Vertex source) {
       list = a.vList;
       this.source = source;
       Elist = a.list;
    }
    
    void setSource() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == source) {
                Vertex temp = list.get(i);
                list.set(i, list.get(0));
                list.set(0, temp);
                LinkedList tempL = Elist[i];
                Elist[i] = Elist[0];
                Elist[0] = tempL;
                break;
            }
        }
    }
    
    void reSort(String c) {
        Vertex temp = null;
        for (int i = count; i < list.size(); i++) {
            if (list.get(i).label.compareToIgnoreCase(c) == 0) {
                for (int j = i; j >= count; j--)  {
                    if (list.get(j-1).dist > list.get(j).dist)
                        temp = list.get(j);
                        list.set(j, list.get(j-1));
                        list.set(j-1, temp);
                        LinkedList tempL = Elist[j];
                        Elist[j] = Elist[j-1];
                        Elist[j-1] = tempL;
                }
                break;
            }
        }
    }
    
    Vertex pop() {
        return list.get(count++);
    }
    
    LinkedList getEdges() {
        return Elist[count-1];
    }
    
    boolean isEmpty() {
        return list.size() == count;
    }
}

