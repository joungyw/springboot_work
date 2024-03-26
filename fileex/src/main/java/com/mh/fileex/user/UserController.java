package com.mh.fileex.user;


import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    @PostMapping(value = "/join",produces = APPLICATION_JSON_VALUE,
    consumes = MULTIPART_FORM_DATA_VALUE)
    public String join(@Valid @RequestParam(value = "userDto") UserDTO userDTO,
                       @RequestParam(value = "file")MultipartFile imageFile){
        System.out.println(userDTO);
        System.out.println(imageFile.getOriginalFilename());

        User user = new User();
        BeanUtils.copyProperties(userDTO,user);

        userService.join(user,imageFile);

        return "회원가입";
    }

}
