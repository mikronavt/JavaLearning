package decorator;

public class AuditUserService implements UserService{
    private final UserService origin;
    private final AuditService auditService;

    public AuditUserService(UserService userService, AuditService auditService){
        this.origin = userService;
        this.auditService = auditService;
    }

    @Override
    public void updateUser(Long id, String firstName, String lastName) {
        origin.updateUser(id, firstName, lastName);
        auditService.auditUserUpdate(id, firstName, lastName);
    }

}
