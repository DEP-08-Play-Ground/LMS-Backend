package dep8.ijse.lk.lmsbackend.api;

import dep8.ijse.lk.lmsbackend.Customer;
import dep8.ijse.lk.lmsbackend.dto.StudentDTO;
import jakarta.json.*;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.bind.ValidationException;
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

//        Jsonb jsonb = JsonbBuilder.create();
//        List<Customer> customerList = jsonb.fromJson(request.getReader(),
//                new ArrayList<Customer>(){}.getClass().getGenericSuperclass());
//
//        customerList.forEach(System.out::println);

        /*=====================================================================*/

//        List<Customer> anotherCustomerList = new ArrayList<>();
//        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
//        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
//        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
//        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
//        anotherCustomerList.add(new Customer("C001", "Nuwan", "Galle"));
//
//        response.setContentType("application/json");
//        jsonb.toJson(anotherCustomerList, response.getWriter());

        /*=============================================================*/

        Jsonb jsonb = JsonbBuilder.create();
        StudentDTO student = null;
        try {
            student = jsonb.fromJson(request.getReader(), StudentDTO.class);
            if (student.getName() == null || !student.getName().matches("[A-Za-z ]+")){
                throw new ValidationException("Invalid student name");
            }else if (student.getNic() == null || !student.getNic().matches("\\d{9}[Vv]")){
                throw new ValidationException("Invalid student nic");
            }else if (student.getEmail() == null || !student.getEmail().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")){
                throw new ValidationException("Invalid student email");
            }

        }catch (JsonbException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JSON");
        }catch (ValidationException e){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
        }catch(Throwable e){
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

        System.out.println(student);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
