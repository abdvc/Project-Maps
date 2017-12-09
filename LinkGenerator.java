public class LinkGenerator {
    StringBuilder Param = new StringBuilder();
    String API_key = "";
    
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
    
    String generateLink() {
        String a = "https://maps.googleapis.com/maps/api/staticmap?";
        a += Param + "&key=" + API_key;
        return a;
    }
    
    void setApiKey(String a) {
        API_key = a;
    }
}
