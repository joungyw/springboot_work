package org.example.member;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
public class Member {
    private Long id;
    private String emil;
    private String name;
    private String password;
    private LocalDateTime wdate;
}
