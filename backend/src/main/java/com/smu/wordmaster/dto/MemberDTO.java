package com.smu.wordmaster.dto;
import com.smu.wordmaster.entity.MemberEntity;
import com.smu.wordmaster.role.MemberRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString

public class MemberDTO { //회원 정보를 필드로 정의
    private Long id;
    @NotBlank(message = "이메일은 필수 입력입니다.")
    private String memberEmail;
    @NotBlank(message = "비밀번호는 필수 입력입니다.")
    private String memberPassword;
    @NotBlank(message = "이름은 필수 입력입니다.")
    private String memberName;
    private MemberRole memberRole;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setMemberName(memberEntity.getMemberName());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberRole(memberEntity.getMemberRole());
        return memberDTO;
    }
}