package com.smu.wordmaster.controller;
import com.smu.wordmaster.dto.MemberDTO;
import com.smu.wordmaster.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/session-login")

public class MemberController {

    private final MemberService memberService;

    // 회원가입 페이지 출력 요청
    @GetMapping("/member/save") // Get 요청이 오면 실행됨
    public String saveForm() {
        return "save";
    }

    // 회원가입 양식을 받아서 memberDTO에 저장 후
    @PostMapping("/member/save") // Post 요청이 오면 실행됨
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);
        return "index";
    }
    @GetMapping("/member/login")
    public String loginForm(){
        return "login";
    }


    @PostMapping("/member/login") // session : 로그인 유지
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null) {
            // login 성공
            session.setAttribute("loginEmail", loginResult.getMemberEmail());
            return "main";
        } else {
            // login 실패
            return "login";
        }
    }
    @GetMapping("/member/")
    public String findAll(Model model) {
        List<MemberDTO> memberDTOList = memberService.findAll();
        // 어떠한 html로 가져갈 데이터가 있다면 model 사용
        model.addAttribute("memberList", memberDTOList);
        return "list";

    }
    // 조회
    @GetMapping("/member/{id}")
    public String findById(@PathVariable Long id, Model model) {
        MemberDTO memberDTO = memberService.findById(id);
        // login 처럼 return 값에 따라 분류 할 수 있음
        model.addAttribute("member", memberDTO);
        return "detail";
    }
    // 삭제
    @GetMapping("/member/delete/{id}") // /member/{id}로 할 수 있도록 공부
    public String deleteById(@PathVariable Long id){
        memberService.deleteByid(id);

        return "redirect:/member/"; // list 로 쓰면 껍데기만 보여짐
    }
}