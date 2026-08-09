package froot;
import java.util.*;

public class ContactManager {
    ContactManager(){};
    List <Contact> contacts = new ArrayList<>();
    public boolean AddC(Contact C){
        if(C.isEmpty()) return false;
        contacts.add(C);
        return true;
    }
    public Contact searchC(String name){
        boolean state = false;
        Contact user = new Contact();
        for(int i = 0 ; i < contacts.size() ; i++){
            if(contacts.get(i).getName().equals(name)){
                user = contacts.get(i);
            }
        }
        return user;
    }
    public List<Contact> ListC(){
        return contacts;
    }
}