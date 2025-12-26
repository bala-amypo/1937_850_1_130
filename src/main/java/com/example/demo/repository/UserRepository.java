public interface UserRepository {
    Optional<User> findByEmail(String email);
    User save(User u);
}
