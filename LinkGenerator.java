package linkgenerator;
public class RunLinkGen {
public static void main(String[] args) {
     LinkGenerator Linkgen = new LinkGenerator();
     Linkgen.setApiKey("AIzaSyCxkwnaGiEcNqla43FKBPfNR3sW-ApIQ5E");
     Linkgen.setParam(Linkgen.center("2nd Gizri Street,Phase 4,DHA") + Linkgen.marker("Zamzama Park", "blue") + Linkgen.marker("Teen Talwar", "red"));
        System.out.println(Linkgen.generateLink());
    }
    
    
}
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
        a += Param + "&zoom=14&size=600x300&maptype=roadmap" + "&key=" + API_key;
        return a;
    }
    
    void setApiKey(String a) {
        API_key = a;
    }
}

