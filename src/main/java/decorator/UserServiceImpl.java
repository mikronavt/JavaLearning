package decorator;

public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void updateUser(Long id, String firstName, String lastName) {
        User user = userRepository.findById(id);
        user.update(firstName, lastName);
    }
}
