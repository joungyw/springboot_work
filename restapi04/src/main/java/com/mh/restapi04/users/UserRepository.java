package com.mh.restapi04.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findByEmail(String email);

    public User findByEmailAndPassword(String email, String password);


    // select * from user where username like '%길동%';
    public List<User> findByUsernameContainingOrEmailContaining(String username, String email);




}
