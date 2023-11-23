package com.secret.dessertmap.controller;

import com.secret.dessertmap.dto.MemberDTO;
import com.secret.dessertmap.entity.MemberEntity;
import com.secret.dessertmap.entity.ShopEntity;
import com.secret.dessertmap.service.MemberService;
import com.secret.dessertmap.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    // final은 해당 변수가 한번 초기화되면 다시 할당할 수 없다는 뜻
    // memberservice 객체가 한번 초기화되면 다른 서비스 객체로 교체되지 않도록 보장하기 위함

    private final ShopService shopService;


    // CRUD에서 C 부분
    @GetMapping("/member/save")
    public String saveForm() {
        return "save";
    }


    @PostMapping("/member/save")
    public String save(@ModelAttribute MemberEntity memberEntity) {

        memberService.save(memberEntity);

        return "main";     // login이라는 html 킨다
    }









    // CRUD에서 R 부분 Read 라고 할 수 있나
    @GetMapping("/member/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/member/login")   // login html에서 actionform이 /member/login이라는 주소로 post로 값을 보낸다
    public String login(@ModelAttribute MemberEntity memberEntity, HttpSession session){

        MemberEntity loginResult = memberService.login(memberEntity);
        // memberService에서 값을 잘 넣었다면 MemberEntity 구조로 값을 return 받음
        // 값을 틀리게 넣었다면 return 값으로 null 로 보냄

        if(loginResult != null){

            session.setAttribute("loginmemberId", loginResult.getMemberId());
            // session은 웹 애플리케이션에서 클라이언트와 서버 간의 상태를 유지하기 위한 기술적인 수단 중 하나
            // 사용자의 상태 정보나 로그인 정보와 같은 데이터를 세션에 저장하여 클라이언트 간 공유 가능
            // 로그인한 결과 값에서 MemberId 만을 뽑아 session에 loginmemberId 이름으로 저장함

            return "main";  // html 소환
        } else {
            return "login"; // 로그인에 실패했으니까 다시 로그인 창으로 보내야 된다
        }

    }



    // CRUD에서 R Read 부분임 모두 불러오기
    @GetMapping("/member/memberlist")
    public String memberlist(Model model){

        List<MemberEntity> memberEntityList = memberService.findAll();  // 값이 1개가 아니니까 여러개를 받기 위해 List
        // <MemberEntity> 이건 MemberEntity 구조로 값을 받는다?
        // service에서 보내는 값이 List값으로 보내닊;
        model.addAttribute("memberlist", memberEntityList);
        // memberEntityList는 값이 여러 개
        // memberlist 이름으로 저장해줌
        // memberlist는 값이 하나가 아니기 때문에 for문으로 반복해서 뽑아줘야됨

        return "memberlist";
    }


    // CRUD에서 R Read 부분 하나만 불러오기
    @GetMapping("/member/{memberId}")
    // 로그인을 해야 메인 화면으로 와서 본인 정보를 볼 수 있으니까 session값이 들어가 있따 login에서 넣어놧으니까
    public String memberone(@PathVariable String memberId, Model model){
        // html에서 {memberId}에 어떤 값을 넣어 보낼지 써줬을 것이다
        // 그걸 그대로 받아 씀
        MemberEntity memberEntity = memberService.findById(memberId);

        model.addAttribute("logininfo", memberEntity);



        List<ShopEntity> shopEntity = shopService.findByMemeberId(memberId);

        model.addAttribute("loginshopinfo", shopEntity);


        return "logininfo";
    }



    @GetMapping("/member/update")
    public String updateForm(HttpSession session, Model model){
        String loginId = (String) session.getAttribute("loginmemberId");
        // session에 logininfo이름으로 저장한값은 로그인한 아이디 비번에 대한 정보다

        System.out.println(loginId);

        MemberEntity memberEntity = memberService.updateForm(loginId);
        // 수정하는 데이터를 보내는게 아니라 그 아이디에 해당하는 정보를 일단 꺼내와야되기 떄문에 service에서 findBy로 가져와야된다

        model.addAttribute("memberupdate", memberEntity);

        return "update";
    }


    @PostMapping("/member/update")
    public String update(@ModelAttribute MemberEntity memberEntity){
        memberService.update(memberEntity);
        return "redirect:/member/" + memberEntity.getMemberId();
        // 수정 완료하면 다른 html로 보낼 필요는 없다
        // 위에서 만든 주소로 보내면 되기때문에 redirect를 써서 주소로 보내버림
    }



    @GetMapping("/member/delete/{memberId}")
    public String delete(@PathVariable String memberId){

        memberService.delete(memberId);

        return "redirect:/member/login";
    }


    @GetMapping("/member/logout")
    public String logout(HttpSession session){
        session.invalidate();

        return "main";
    }


    @GetMapping("/")
    public String index(){
        return "main";
    }


}

