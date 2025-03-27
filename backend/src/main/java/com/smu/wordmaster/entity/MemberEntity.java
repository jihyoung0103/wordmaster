package com.smu.wordmaster.entity;
import com.smu.wordmaster.dto.MemberDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;

@Entity
@Setter
@Getter
@Table(name = "member_table") //database에 해당 이름의 테이블 생성
public class MemberEntity { //table 역할
    //jpa ==> database를 객체처럼 사용 가능

    @Id // Primary Key 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true)          // memberEmail이라는 어트리뷰트 추가 (중복 X)
    private String memberEmail;
    @Column                         // memberPassword라는 어트리뷰트 추가
    private String memberPassword;
    @Column                         // memberName이라는 어트리뷰트 추가
    private String memberName;

    // 객체 하나 만들어서 MemberEntity의 엔티티로 만들어주는 메서드
    public static MemberEntity toMemberEntity(MemberDTO memberDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberDTO.getId());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberName(memberDTO.getMemberName());
        memberEntity.setMemberPassword(memberDTO.getMemberPassword());
        return memberEntity;
    }
}