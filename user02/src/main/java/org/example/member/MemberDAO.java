package org.example.member;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class MemberDAO {

    private Map<String, Member> map = new HashMap<>();
    private static Long id = 0L;

    public void insert(Member member) {
        member.setId(++id);
        map.put(member.getEmil(), member);
    }

    public Collection<Member> select()
    {
        return map.values();
    }
}
