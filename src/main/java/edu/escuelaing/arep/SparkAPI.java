package edu.escuelaing.arep;
import edu.escuelaing.arep.components.*;
import org.json.JSONObject;

import static spark.Spark.*;


public class SparkAPI {
    public static void main(String[] args) {
        port(getPort());
        get("/calculator",(req,res)-> {
            String values = req.queryParams("numbers");
            String[] valuesInStringArray = values.split(",");
            LinkedList linkedList = new LinkedList();
            for(String v:valuesInStringArray){
                linkedList.addNode(Float.parseFloat(v));
            }
            double mean = Calculator.mean(linkedList);
            double deviation = Calculator.deviation(linkedList,mean);
            JSONObject jsonValue = new JSONObject();
            jsonValue.put("numbers",String.join(" ",valuesInStringArray));
            jsonValue.put("mean",mean);
            jsonValue.put("deviation",deviation);
            return jsonValue;
        });
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
