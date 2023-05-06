package decorator;

public class EmailUserService implements UserService{
    private final UserService origin;
    private final EmailService emailService;

    public EmailUserService(UserService userService, EmailService emailService){
        origin = userService;
        this.emailService = emailService;
    }

    @Override
    public void updateUser(Long id, String firstName, String lastName) {
        origin.updateUser(id, firstName, lastName);
        emailService.notifyAdmin(id);
    }
}
