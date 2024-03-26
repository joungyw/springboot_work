package com.mh.restapi04.users;


import com.mh.restapi04.excoption.ErrorCode;
import com.mh.restapi04.excoption.UsersException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.startup.WebAnnotationSet;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("users")
@Tag(name = "User-Controller",description = "유저 조회 등록 수정 삭제")
public class UserController {
    /*
        get 사용자 조회
        post 사용자 등록
        put 사용자 수정
        delete 사용자 삭제
     */
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("usernameemail")
    public ResponseEntity<List<User>> getAllUserName(@RequestBody UserDto userDto){
        List<User> list = userRepository.findByUsernameContainingOrEmailContaining(userDto.getUsername(),userDto.getEmail());
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }



    @Operation(summary = "사용자 전체 목록 보기", description = "사용자 전체 정보 조회를 할 수 있습니다.")
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "사용자들이 없을때 나옵니다."),
            }
    )
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> list = userService.getAllUsers();
        if (list.size() == 0)
            throw new UsersException(ErrorCode.NOTFOUND);

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getAllUsers(

            @Parameter(description = "조회하고자 하는 사용자 ID를 입력하세요.",
                    name = "사용자 ID",
                    required = true)
            @PathVariable Long id) {
        System.out.println(id);
        User user = userService.getUserById(id);

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping()
    public EntityModel<User> addUser(@RequestBody @Valid UserDto userDto) {
        userDto.setWdate(LocalDateTime.now());
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto, User.class);
        User dbuser = userService.regist(user);

        EntityModel<User> entityModel = EntityModel.of(dbuser);
        entityModel.add(
                WebMvcLinkBuilder.linkTo(UserController.class)
                        .slash(dbuser.getId())
                        .withSelfRel()
        );

        return entityModel;
    }
    @PutMapping()
    public ResponseEntity<User> updateUser(@RequestBody @Valid UserDto userDto) {
        System.out.println(userDto);
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto, User.class);
        user.setWdate(LocalDateTime.now());

        User dbUser = userService.updateUser(user);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dbUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("삭제됨");
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllUser() {
        userService.delete();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("삭제됨");
    }

    @Transactional(readOnly = true)
    @GetMapping("/tran")
    public String userstran() {

        User dbuser = userRepository.findById(1L).orElseThrow();
        dbuser.setUsername("김길동");
        dbuser.setEmail("aa@naver.com");

        return "tran";
    }
}