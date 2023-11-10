package emanuelespringadvanced.project.exceptions;

public class UserNotFoundException extends Throwable {
    public UserNotFoundException(String username) {
            super("ID " + username + "non trovato!!");
    }
}
