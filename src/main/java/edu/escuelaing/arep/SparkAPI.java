package edu.escuelaing.arep;
import edu.escuelaing.arep.components.*;
import org.json.JSONObject;
import spark.Request;
import spark.Response;

import static spark.Spark.*;


public class SparkAPI {
    public static void main(String[] args) {
        port(getPort());
        get("/calculator",(req,res)-> inputDataPage(req,res));
        get("/results",(req,res)->{
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
            return outputDataPage(jsonValue);
        });
    }

    /**
     * This function returns the HTML structure to present the output data
     * @param json A JSON with the structure numbers, mean and deviation
     * @return A String that have a template of a HTML
     */
    private static String outputDataPage(JSONObject json){
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Mean and Standard Deviation Calculator</h2>"
                + "<h4>Values</h4>"
                + json.get("numbers")
                + "<h4>Mean</h4>"
                + json.get("mean")
                + "<h4>Standard Deviation</h4>"
                + json.get("deviation")
                + "</body>"
                + "</html>";
        return pageContent;
    }

    /**
     * This function returns the HTML structure to present the input data
     * @param req The Spark HTTP Request
     * @param res The Spark HTTP Response
     * @return A String that have a template of a HTML
     */
    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h2>Mean and Standard Deviation Calculator</h2>"
                + "<form action=\"/results\">"
                + "  Numbers:<br>"
                + "  <input type=\"text\" name=\"numbers\" value=\"\">"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<b>You need to put the floatings numbers separated by a comma \",\" in the Numbers space.</b>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    /**
     * This function see the enviorment variable PORT if this exist that is returned if not the function return 4567
     * @return int that is the port that use Spark
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
