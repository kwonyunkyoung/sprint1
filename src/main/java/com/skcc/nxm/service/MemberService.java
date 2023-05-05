package com.skcc.nxm.service;

import com.skcc.nxm.domain.Member;
import com.skcc.nxm.repository.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public void save(Member member){
         System.out.println("member " +member.getMbrNm());
         memberMapper.save(member);

    }

    public List<Member> findAll (){
        return memberMapper.findAll();
    }
}
