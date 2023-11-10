package emanuelespringadvanced.project.controllers;
import emanuelespringadvanced.project.entities.User;
import emanuelespringadvanced.project.exceptions.UserNotFoundException;
import emanuelespringadvanced.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> userList(){
        return userService.getUserList();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User body) {
        return userService.save(body);
    }

    @GetMapping("/{username}")
    public User findByUsername(@PathVariable String username) throws UserNotFoundException {
        return userService.findByUsername(username);
    }

    @PutMapping("/{username}")
    public User findByIdAndUpdate(@PathVariable String username, @RequestBody User body) throws UserNotFoundException {
        return userService.findByUsernameAndUpdate(username, body);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByUsernameAndDelete(@PathVariable String username){
        userService.findByUsernameAndDelete(username);
    }

    @PostMapping("/upload")
    public String uploadExample(@RequestParam("avatar") MultipartFile body) throws IOException {
        System.out.println(body.getSize());
        System.out.println(body.getContentType());
        return userService.uploadPicture(body);
    }

}
