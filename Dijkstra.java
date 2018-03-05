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
public class Dijkstra {

    graph g;

    Dijkstra(graph g) {
        this.g = g;
    }

    public void shortestPath(String start, String end) {
        //start and end are labels
        String[] parent = new String[g.vList.size()];
        double[] cost = new double[parent.length];
        LinkedList<String> list = new LinkedList<>();

        for (int i = 0; i < cost.length; i++) {
            cost[i] = Double.POSITIVE_INFINITY;
        }

        cost[Integer.parseInt(start) - 1] = 0;
        parent[Integer.parseInt(start) - 1] = "0";

        while (list.size() < parent.length) {
            int u = -1;
            double minCost = Double.POSITIVE_INFINITY;
            for (int i = 1; i <= parent.length; i++) {
                if (!list.contains(i + "") && cost[i - 1] < minCost) {
                    minCost = cost[i];
                    u = i;
                }
            }
            list.add(u + "");
            
            for (int i = 1; i < g.list[u].size(); i++) {
                
                String str = g.list[u].get(i).dst.label;
                
                if (!list.contains(str) && cost[Integer.parseInt(str)] > cost[u]
                        + g.list[u].get(i).weight) {
                    cost[Integer.parseInt(str)] = cost[u] + g.list[u].get(i).weight;
                    parent[Integer.parseInt(str)] = u + "";
                }
            }
        }
        
        int a = Integer.parseInt(end);
        System.out.println(cost[a]);
    }
}
