package decorator;

public class UserRepository {
    public User findById(Long id) {
        System.out.println("Find by id: " + id);
        return new User(id);
    }
}
