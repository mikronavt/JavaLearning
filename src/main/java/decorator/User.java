package decorator;

public class User {
    private Long id;

    public User(Long id) {
        this.id = id;
    }

    public void update(String firstName, String lastName) {
        System.out.println("User with id " + id + " updated: " + firstName + " " + lastName);
    }
}
