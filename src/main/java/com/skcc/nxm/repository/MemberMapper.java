package com.skcc.nxm.repository;

import com.skcc.nxm.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    Optional<Member> findById(Long mbrId);

    List<Member> findAll();
    void save(Member member);
}
