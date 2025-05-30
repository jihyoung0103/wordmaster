package com.smu.wordmaster;

import com.smu.wordmaster.entity.MemberEntity;
import com.smu.wordmaster.repository.MemberRepository;
import com.smu.wordmaster.role.MemberRole;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MakeInitData {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void makeAdminAndUser() {
        // 관리자 계정이 없다면 생성
        if (!memberRepository.existsByMemberEmail("admin")) {
            MemberEntity admin = new MemberEntity();
            admin.setMemberEmail("admin");
            admin.setMemberName("관리자");
            admin.setMemberPassword("q1w2e3r4");
            admin.setMemberRole(MemberRole.ADMIN);
            memberRepository.save(admin);
        }

        // 일반 사용자 계정이 없다면 생성
        if (!memberRepository.existsByMemberEmail("user")) {
            MemberEntity user = new MemberEntity();
            user.setMemberEmail("user");
            user.setMemberName("일반유저");
            user.setMemberPassword("1234");
            user.setMemberRole(MemberRole.USER);
            memberRepository.save(user);
        }
    }
}
