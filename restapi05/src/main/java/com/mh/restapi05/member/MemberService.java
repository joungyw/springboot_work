package com.mh.restapi05.member;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    // 저장하는 메서드
    // email 중복체크 에러로... 빠집니다...
    public Member save(Member member) {

        Optional<Member> optionalMember
                = memberRepository.findByEmail(member.getEmail());

        if (optionalMember.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("일로오나?");

        return null;
    }
}