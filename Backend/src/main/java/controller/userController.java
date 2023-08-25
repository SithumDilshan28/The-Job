package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import model.user;
import repository.userRepo;

import java.io.IOException;

// ...

@RestController
@RequestMapping("/users")
public class userController {

    @Autowired
    private userRepo  userRepository;

    @PostMapping("/{userId}/upload-cv")
    public String uploadCv(@PathVariable Long userId, @RequestParam MultipartFile file) throws IOException {
        user user = (model.user) userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        user.setCv(file.getBytes());
        userRepository.save(user);

        return "CV uploaded successfully";
    }
}
