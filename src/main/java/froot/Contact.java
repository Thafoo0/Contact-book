package froot;

public class Contact {
    private String name;
    private String email;
    private String number;

    Contact(){};
    Contact(String name , String email , String number){
        this.name = name;
        this.email = email;
        this.number = number;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getNumber(){
        return number;
    }
    public boolean isEmpty(){
        return (name == null || name.isEmpty()) &&
               (email == null|| email.isEmpty()) &&
               (number == null || number.isEmpty());
    }
}