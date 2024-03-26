package com.mh.restapi05.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("")
    public List<Member> member() {
        List<Member> list = memberRepository.findAll();
        return list;
    }
    @PostMapping("")
    public String member(@Valid @RequestBody MemberDto memberDto) {
        System.out.println(memberDto);
        ModelMapper modelMapper = new  ModelMapper();
        Member member = modelMapper.map(memberDto, Member.class);
        memberService.save(member);
        return "member";
    }
    @GetMapping("list")
    public ResponseEntity<List<Member>> mermber(){
        List<Member> allMember = memberService.getAllMembers();
        return ResponseEntity.status(HttpStatus.OK).body(allMember);
    }
}