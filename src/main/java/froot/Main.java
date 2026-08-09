package froot;
import io.javalin.Javalin;
import java.util.*;

public class Main {
    public static void main(String[] args){
        ContactManager cm = new ContactManager();
        Javalin app = Javalin.create(config -> {
        config.bundledPlugins.enableCors(cors -> {
        cors.addRule(it -> {
            it.allowHost("http://127.0.0.1:5500");
        });
            });
        }).start(7070);
        app.get("/contact",ctx -> {
            List<Contact> list = cm.ListC();
            if(list.isEmpty()){
                ctx.status(404);
                ApiResponse response = new ApiResponse("Your list is empty");
                ctx.json(response);
                return;
            }
            ctx.status(200);
            ctx.json(list);
            return;
        });
        app.get("/contact/search",ctx -> {
            String person = ctx.queryParam("name");
            Contact user = cm.searchC(person);
            if(user == null){
                ctx.status(404);
                ApiResponse error = new ApiResponse("Contact doesn't exist");
                ctx.json(error);
                return;
            }
            ctx.status(200);
            ctx.json(user);
            return;
        });
        app.post("/contact/add", ctx -> {
            Contact contact = ctx.bodyAsClass(Contact.class);
            boolean B = cm.AddC(contact);
            if(B == false){
                ctx.status(404);
                ApiResponse error = new ApiResponse("you should enter at least name , number or email");
                ctx.json(error);
                return;
            }
            ctx.status(200);
            ApiResponse response = new ApiResponse("Contact Added Successfuly !");
            ctx.json(response);
        });
    }
}