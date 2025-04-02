package org.example.schedulerprojectv2.repository;


import org.example.schedulerprojectv2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
