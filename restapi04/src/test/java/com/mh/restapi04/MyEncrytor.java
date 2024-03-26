package com.mh.restapi04;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;


public class MyEncrytor {



    String password = "mh1234";

    @Test
    void name(){
        System.out.println("실행됩니다"+password);

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setPoolSize(4);
        encryptor.setPassword(password);
        encryptor.setAlgorithm("PBEWithMD5ANdtripleDES");

        String content = "jdbc:mysql://localhost:3306/member?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
        String encString = encryptor.encrypt(content);
        String decString = encryptor.decrypt(encString);
        System.out.println(String.format("root encString = %s decString = %s", encString, decString));

        content = "root";
        encString = encryptor.encrypt(content);
        decString = encryptor.decrypt(encString);
        System.out.println(String.format("root encString = %s decString = %s", encString, decString));

        content = "1234";
        encString = encryptor.encrypt(content);
        decString = encryptor.decrypt(encString);
        System.out.println(String.format("root encString = %s decString = %s", encString, decString));
    }
}
