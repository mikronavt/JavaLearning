package decorator;

public class AuditService {
    public void auditUserUpdate(Long id, String firstName, String lastName) {
        System.out.println("User update audited: " + "id: " + id + "; firstName: " + firstName + "; lastName: " + lastName + ";");
    }
}
