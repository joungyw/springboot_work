package org.example.member;
import org.example.conponent.AABBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.util.Collection;

@Component
public class MemberService {

    @Autowired
    @Qualifier("AABBService")
    AABBService aabbService;

    @Autowired
    MemberDAO memberDAO;

    public void Regist(Member member){
    memberDAO.insert(member);
    }
    public void list(){
       Collection<Member>  collection = memberDAO.select();
       collection.forEach(System.out::println);
    }
}