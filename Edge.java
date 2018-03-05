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
public class Edge {

    double weight;
    Vertex src;
    Vertex dst;

    Edge(Vertex v1, Vertex v2) {
        src = v1;
        dst = v2;
        weight = Math.sqrt(Math.pow(v2.lat - v1.lat, 2)
                + Math.pow(v2.lon - v1.lon, 2));
    }
}
