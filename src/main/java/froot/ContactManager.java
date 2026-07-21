package froot;
import java.util.*;

public class ContactManager {
    ContactManager(){};
    List <Contact> contacts = new ArrayList<>();
    public void AddC(Contact C){
        contacts.add(C);
    }
    public void searchC(String name){
        boolean state = false;
        for(int i = 0 ; i < contacts.size() ; i++){
            if(contacts.get(i).getName().equals(name)){
                System.out.println("your contact exsit !");
                System.out.println(contacts.get(i));
                state = true;
                break;
            }
        }
        if(!state){
                System.out.println("Contact not found");
            }
    }
}