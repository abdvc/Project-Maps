/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication88;

import java.util.ArrayList;

/**
 *
 * @author Abdullah
 */

class LinkGenerator {
    LinkGenerator(){}
    StringBuilder Param = new StringBuilder();
    String API_key = "";
    char markerLetter = 'A';
    
        //set or change a specific parameter. i.e zoom, maptype.
    //para = specific parameter to set. value: the value assigned to that parameter.
    void setOverwriteParam(String para, String value) {  
        para.replace(" ", "+");
       if (Param.indexOf(para) == -1) {                     
           para = "&" + para;
            Param.append(para + "=" + value);
        }
       else {
           int start = Param.indexOf(para);
           int end = start + para.length() - 1;
           Param.replace(start, end, para);
           for (int i = end; i <= Param.length(); i++) {
               if (Param.charAt(i) == '&') {
                   Param.replace(end+1, i-1, "="+value);
               }
               else if (i == Param.length()) {
                   Param.replace(end+1, i-1, "="+value);
               }
           }
                   }
    }
    
    
    /*set parameters to add objects. such as markers, lines etc.
      value and parameter name must be given in a single String literal.
    */
    void setParam(String para) {  
        Param.append(para);
    }
    
     
    void clearParam() {
        Param.delete(0, Param.length());
    }
     
    String center(String location){
        location = location.replaceAll(" ", "+");
        return "center=" + location;
    }
    
    String marker(String loc, String color)
    {
    String str = "&markers=" +"color:" + color + "|label:" + markerLetter + "|" + loc.replaceAll(" ","+");
    markerLetter++;
    return str;
    }
    
    
    String generateLink() {
        String a = "https://maps.googleapis.com/maps/api/staticmap?";
        a += Param + "&zoom=12&size=1024x1024&maptype=roadmap" + "&key=" + API_key;
        return a;
    }
    
    void setPath(String start, String end) {
         start.replaceAll(" ", "+");
         end.replaceAll(" ", "+");
         String colour = "blue";
         String str = "&path=color:" +colour+ "|weight:5|" + start + "|" + end;
         Param.append(str);
    }
    
    void setPath(double startlat,double startlong, double endlat, double endlong) {
         String colour = "blue";
         String str = "&path=color:" +colour + "|weight:5|" + startlat + "," + startlong
                 + "|" + endlat + "," + endlong;
         Param.append(str);
    }
     
   void SetPath(ArrayList<String> path) { //Takes an array of latlongs strings to make a path between multiple locations.
        String colour = "blue";
        String str = "&path=color:" +colour + "|weight:5";
        str += "|" + path.get(0);
        for (int i = 1; i < path.size(); i++) {
            str += "|" + path.get(i);
        }
        Param.append(str);
    }
    
     
    void addPath(double addlat, double addlong) {
         String str = "|" + addlat + "," + addlong;
         Param.append(str);
    }
     
    void setApiKey(String a) {
        API_key = a;
    }
}
