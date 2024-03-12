package com.mh.restapi03.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
@Entity
@ToString
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "User Table 에 대한 내용입니다.")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(title = "사용자 ID",description = "talbe에서 자동으로 생성되는 칼럼입니다.")
    private Long id;

    @Column(length = 50)
    @Schema(title = "사용자 username",description = "사용자 이름을 넣어 주세요.")
    private String username;

    @Column(length = 50, unique = true)
    private String email;

    private String password;

    // @Enumerated(EnumType.ORDINAL) male = 0 , female = 1
    // @Enumerated(EnumType.STRING) => Male,feMale
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime wdate;

}
