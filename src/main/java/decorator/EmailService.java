package decorator;

public class EmailService {
    public void notifyAdmin(Long id){
        System.out.println("Email notification send about user with id: " + id);
    }
}
