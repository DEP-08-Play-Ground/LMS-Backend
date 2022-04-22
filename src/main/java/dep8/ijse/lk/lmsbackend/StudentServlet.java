package dep8.ijse.lk.lmsbackend;

import jakarta.json.*;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getContentType()==null || !request.getContentType().toLowerCase().startsWith("application/json")) {
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            return;
        }

//        BufferedReader reader = request.getReader();
//        StringBuilder stb = new StringBuilder();
//        Stream<String> lines = reader.lines();
//        lines.forEach(s -> stb.append(s+"\n"));
//        System.out.println(stb.toString());

        /*=====================================================================*/

//        JsonReader jsonReader = Json.createReader(request.getReader());
//        JsonArray jsonArray = jsonReader.readArray();
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JsonObject jsonObject = jsonArray.getJsonObject(0);
//            System.out.println(jsonObject.getString("id"));
//            System.out.println(jsonObject.getString("name"));
//        }

        /*=====================================================================*/


//        response.setContentType("application/json");
//        JsonWriter jsonWriter = Json.createWriter(response.getWriter());
//        JsonObjectBuilder obj = Json.createObjectBuilder();
//        obj.add("id","C005");
//        obj.add("name","Ruwan");
//        JsonObject build = obj.build();
//        jsonWriter.writeObject(build);

        /*=====================================================================*/

//        response.setContentType("application/json");
//        JsonWriter jsonWriter = Json.createWriter(response.getWriter());
//        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
//        arrayBuilder.add(0,10);
//        arrayBuilder.add(1,false);
//        arrayBuilder.add(2,Json.createArrayBuilder().add(10).add(20).build());
//
//        /*=====================================================================*/
//
//        //language=JSON
////        String json= "{\n" +
////                "  \"id\":" +
////                " \"C001\",\n" +
////                "  \"name\": \"Kasun\"\n" +
////                "}\n";
//
//        /*=====================================================================*/
//        arrayBuilder.add(3,Json.createObjectBuilder().add("C001","Kasun").build());
//        jsonWriter.writeArray(arrayBuilder.build());

        Jsonb jsonb = JsonbBuilder.create();
        List<Customer> customerList = jsonb.fromJson(request.getReader(),
                new ArrayList<Customer>(){}.getClass().getGenericSuperclass());

        customerList.forEach(System.out::println);

        /*=====================================================================*/

        List<Customer> anotherCustomerList = new ArrayList<>();
        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));

        response.setContentType("application/json");
        jsonb.toJson(anotherCustomerList, response.getWriter());

        /*=============================================================*/

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
