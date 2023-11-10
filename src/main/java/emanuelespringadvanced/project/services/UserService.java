package emanuelespringadvanced.project.services;

import emanuelespringadvanced.project.entities.Device;
import emanuelespringadvanced.project.entities.User;
import emanuelespringadvanced.project.exceptions.NotFoundException;
import emanuelespringadvanced.project.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public class UserService {
    List<User> userList = new ArrayList<>();

    public User save(User body){
        this.userList.add(body);
        return body;
    };

    public List<User> getDeviceList() {
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
                selectedUser.setName(selectedUser.getName());
                selectedUser.setSurname(selectedUser.getSurname());
                selectedUser.setMail(selectedUser.getMail());
                selectedUser.setDevices(selectedUser.getDevices());
            }
        }
        if(selectedUser == null ){
            throw new UserNotFoundException(username);
        } else {
            return selectedUser;
        }
    }
}
