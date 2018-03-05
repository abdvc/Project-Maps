/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication88;

import java.util.LinkedList;
/**
 *
 * @author Abdullah
 */
public class graph {
    LinkedList<Edge>[] list;
    LinkedList<Vertex> vList;
    
    graph(LinkedList<Vertex> list){
        vList = list;
        this.list = new LinkedList[list.size()];
        for (int i = 0; i < this.list.length; i++) {
            this.list[i] = new LinkedList<>();
        }
    }
    
    public String findLatLong(String a) {
        Vertex c = this.findVert(a);
        String str = c.lat + "," + c.lon;
        return str;
    }
    
    public void insertEdge(String[] arr){
        int h = Integer.parseInt(arr[0]);
        Vertex v1 = findVert(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            Vertex v2 = findVert(arr[i]);
            list[h-1].add(new Edge(v1, v2));
        }
    }
    
    public Vertex findVert(String str){
        for (int i = 0; i < vList.size(); i++) {
            if (str.equals(vList.get(i).label)) {
                return vList.get(i);
            }
        }
        return null;
    }
    
    public void display(){
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].size(); j++) {
                System.out.println(list[i].get(j).weight);
            }
        }
    }
}
