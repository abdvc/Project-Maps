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
public class Vertex {
    String label;
    double lat;
    double lon;
    double dist = Double.MAX_VALUE;
    Vertex prev;
    
    Vertex(String str){
        String[] s1 = str.split(" ");
        label = s1[0];
        String[] s2 = s1[1].split(",");
        lat = Double.parseDouble(s2[0]);
        lon = Double.parseDouble(s2[1]);
    }
}
