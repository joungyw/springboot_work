package com.mh.restapi04.users;

import com.mh.restapi04.excoption.ErrorCode;
import com.mh.restapi04.excoption.LogicException;
import com.mh.restapi04.excoption.UsersException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public User regist(User user){
        User emailUser = userRepository.findByEmail(user.getEmail());
        if(emailUser != null){
            System.out.println(user.getEmail()+"중복 이메일이 있습니다.");
            System.out.println(user.getEmail()+"중복 이메일이 있습니다.");
            throw new LogicException(ErrorCode.TEST);
        }
        // insert 구문 실행...
        User dbUser = userRepository.save(user);
        return dbUser;
    }
    public List<User> getAllUsers() {
        List<User> list = userRepository.findAll();
        return list;
    }
    public User getUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new UsersException(ErrorCode.NOTFOUND);
        }
        else {
            return optionalUser.get();
        }
    }
    public User updateUser(User user){

        User emailUser = userRepository.findByEmail(user.getEmail());
        if(emailUser ==  null)
        {
            throw new UsersException(ErrorCode.NOTUPDATEEMAIL);
        }
        emailUser.setWdate(user.getWdate());
        emailUser.setUsername(user.getUsername());
        emailUser.setPassword(user.getPassword());
        emailUser.setGender(user.getGender());
        User dbUser = userRepository.save(emailUser);
        return null;
    }
    public void delete(Long id) {
        Optional<User> dbUser = userRepository.findById(id);
        if(dbUser.isEmpty())
        {
            throw new UsersException(ErrorCode.NOTUPDATEEMAIL);
        }
        User getUser = dbUser.get();
        userRepository.delete(getUser);
    }
    public void delete(){
        userRepository.deleteAll();
    }
}