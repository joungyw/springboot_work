package com.mh.restapi04.users;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.mh.restapi04.excoption.ErrorCode;
import com.mh.restapi04.excoption.UsersException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserRepository userRepository;
    @GetMapping("user/{id}")
    public AdminUser getUserById(@PathVariable  Long id){

        User user = userRepository.findById(id).orElseThrow(
                ()-> new UsersException(ErrorCode.NOTFOUND)

        );
        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(user,adminUser);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(adminUser);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("AdminUser",
                SimpleBeanPropertyFilter.filterOutAllExcept("username","email","password"));

        mappingJacksonValue.setFilters(filterProvider);



        return adminUser;
    }

    @DeleteMapping("user/{id}")
    public User deleteUserById(@PathVariable Long id){
        return new User();
    }
}
