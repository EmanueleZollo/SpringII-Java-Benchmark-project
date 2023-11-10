package emanuelespringadvanced.project.services;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import emanuelespringadvanced.project.entities.User;
import emanuelespringadvanced.project.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class UserService {

    @Autowired
    private Cloudinary cloudinary;
    List<User> userList = new ArrayList<>();

    public User save(User body){
        this.userList.add(body);
        return body;
    };

    public List<User> getUserList() {
        return userList;
    }

    public User findByUsername (String username) throws UserNotFoundException {
        User u = null;
        for (User user: this.userList) {
            if (user.getUsername().equals(username)) {
                u = user;
            }
        }
        if(u == null ){
            throw new UserNotFoundException(username);
        } else {
            return u;
        }
    }

    public void findByUsernameAndDelete(String username) {
        ListIterator<User> iterator = this.userList.listIterator();
        while (iterator.hasNext()) {
            User selectedUser = iterator.next();
            if (selectedUser.getUsername().equals(username)) {
                iterator.remove();
            }
        }
    }

    public User findByUsernameAndUpdate(String username, User body) throws UserNotFoundException{
        User selectedUser = null;

        for (User user: this.userList) {
            if (user.getUsername().equals(username)) {
                selectedUser = user;
                selectedUser.setUsername(username);
                selectedUser.setName(body.getName());
                selectedUser.setSurname(body.getSurname());
                selectedUser.setMail(body.getMail());
                selectedUser.setDevices(body.getDevices());
                selectedUser.setAvatar("http://ui-avatars.com/api/?name="+body.getName() +  "+" + body.getSurname());
            }
        }
        if(selectedUser == null ){
            throw new UserNotFoundException(username);
        } else {
            return selectedUser;
        }
    }

    public String uploadPicture(MultipartFile file) throws IOException {
        return (String) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()).get("url");
    }

}
