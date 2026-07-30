package froot;
import io.javalin.Javalin;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Javalin app = Javalin.create().start(7070);
        app.get("/Contact",ctx -> {
            List <Contact> list = new ArrayList<>();
                list = searchC();
                ctx.status(200);
                if(list.isEmpty())(
                    ctx.result("your list is empty");
                    return;
                )
            ctx.json(list);
        });
        app.get("/contact/search",ctx -> {
            String person = ctx.queryParam("name");
            Contact user = searchC(person);
            if(user == null){
                ctx.satatus(404);
                ErrorResponse error = new ErrorResponse("Contact doesn't exist");
                ctx.json(error);
                return;
            }
            ctx.status(200);
            ctx.json(user);
        });
        app.post("/contact/add", ctx -> {
            Contact contact = ctx.bodyAsClass(contact.Class);
            boolean B = AddC(contact);
            if(B == false){
                ctx.satatus(404);
                ErrorResponse error = new ErrorResponse("you should enter at least name , number or email");
                ctx.json(error);
                return;
            }
            ctx.status(200);
            ErrorResponse error = new ErrorResponse("Contact Added Successfuly !");
            ctx.json(error);
        })

        ContactManager cm = new ContactManager();
        Scanner sc = new Scanner(System.in);

        while(true){
            int x = 0;
            System.out.println("1 - Add new contact");
            System.out.println("2 - search contact");
            System.out.println("3 - list all contact");
            System.out.println("4 - Exit");
            x = sc.nextInt();
            sc.nextLine();
            String name , email , number;
            if(x == 1){
                System.out.println("enter the info of your new contact :");
                System.out.println("Name :");
                name = sc.nextLine();
                System.out.println("Email :");
                email = sc.next();
                System.out.println("The Number :");
                number = sc.next();
                Contact C = new Contact(name,email,number);
                cm.AddC(C);
            }
            else if (x == 2){
                String namee;
                System.out.println("Name :");
                namee = sc.nextLine();
                cm.searchC(namee);
            }
            else if(x == 3){
                cm.ListC();
            }
            else if(x == 4) break;
        }
    }
}