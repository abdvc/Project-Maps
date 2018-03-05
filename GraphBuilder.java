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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author 13100
 */
 class GraphBuilder {
    graph network;
    void buildGraph() throws FileNotFoundException, IOException { 
        FileReader in = new FileReader("data.txt.txt");
        
        BufferedReader stream = new BufferedReader(in);
        
        String k = "";
        
        String[][] edges = new String[210][20];
        String[] a;
        Vertex temp;
        LinkedList<Vertex> vlist;
        vlist = new LinkedList();
        
        k = stream.readLine();
        while (k != null && k.compareTo("Edges") != 0) { // adding vertices and storing edges
            vlist.add(new Vertex(k));
            k = stream.readLine();
        }
        
        network = new graph(vlist);
        
        k = stream.readLine();
        while (k != null) {
           a = k.split(" ");
            for (int i = 1; i < a.length; i++) {
                network.insertEdge(a);
            }
            k = stream.readLine();
        }
        
        in.close();
    }
    
}
