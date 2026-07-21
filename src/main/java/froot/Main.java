package froot;
import java.util.*;

public class Main {
    public static void main(String[] args){
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