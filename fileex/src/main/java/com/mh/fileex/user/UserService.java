package com.mh.fileex.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final Path imagePath;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
        this.imagePath = Paths.get("")
                .toAbsolutePath().normalize();
        try{
            Files.createDirectories(this.imagePath);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
    public void join(com.mh.fileex.user.User user, MultipartFile imageFile) {
        try {
            File dest = new File(imagePath + "/"+imageFile.getOriginalFilename());
            imageFile.transferTo(dest);
        }catch (Exception e){
            e.printStackTrace();
            return;
        }



    }
}
