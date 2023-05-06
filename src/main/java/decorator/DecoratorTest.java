package decorator;

public class DecoratorTest {
    UserRepository userRepository;
    UserServiceImpl userServiceImpl;
    AuditService auditService;
    AuditUserService auditUserService;
    EmailService emailService;
    EmailUserService emailUserService;

    public void testDecorator() {
        System.out.println("Testing decorator classes");
        userRepository = new UserRepository();
        userServiceImpl = new UserServiceImpl(userRepository);
        userServiceImpl.updateUser(1L,"Vasya", "Pupkin");
        auditService = new AuditService();
        auditUserService = new AuditUserService(userServiceImpl, auditService);
        auditUserService.updateUser(2L, "Petya", "Vasechkin");
        emailService = new EmailService();
        emailUserService = new EmailUserService(auditUserService, emailService);
        emailUserService.updateUser(3L, "Sasha", "Ivanov");
    }
}
