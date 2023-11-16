package com.secret.dessertmap.service;

import com.secret.dessertmap.entity.MemberEntity;
import com.secret.dessertmap.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save (MemberEntity memberEntity){
        memberRepository.save(memberEntity);
    }














    public MemberEntity login(MemberEntity memberEntity){   // 지금 memberEntity는 로그인할 때 우리가 입력한 값으로 이루어짐

        Optional<MemberEntity> ResultMemberId = memberRepository.findByMemberId(memberEntity.getMemberId());
        // memberRepository에서 값이 있는지 없는지 판별해줌
        // memberRepository에서 Optional값으로 보내기 떄문에 받을 때도 Optional로 받아야 되는 듯


        if (ResultMemberId.isPresent()){  // 해당하는 아이디에 대한 정보가 있다
                            // .isPresent() 이거는 Optional기능 중 하나로 값이 있다 라는 뜻인 듯
            MemberEntity InfoMember = ResultMemberId.get();     // 해당하는 아이디에 대한 정보 모두 가져오기
            // 데이터베이스에서 로그인할 때 입력한 아이디에 해당하는 정보를 InfoMember 이름으로 받아왔다

            if(InfoMember.getMemberPassword().equals(memberEntity.getMemberPassword())){
                // 데이터베이스에 저장된 해당 아이디에 대한 비밀번호 = 로그인창에서 입력한 비밀번호
                return memberEntity;
                        // 데이터베이스랑 로그인한거랑 값이 같으니까 memberEntity를 그대로 받아 간다 인가봄
            } else {
                return null; // 잘못된 값을 넣었기 때문에 아무것도 돌려주면 안됨 -- 잘못된 값을 보내줄 필요 없음
            }

        } else { // 입력한 아이디에 대한 정보가 없다라는 뜻
            return null;
        }

    }


    public List<MemberEntity> findAll(){
        List<MemberEntity> memberEntityList = memberRepository.findAll();

        return memberEntityList;
    }


    public MemberEntity findById(String memberId){
        Optional<MemberEntity> memberone = memberRepository.findByMemberId(memberId);
        // 어차피 로그인하고 로그인한 정보를 찾는거라서 이렇게 했는데 이렇게 해도 되는건가 싶기도하고
        // memberone은 Optional로 값이 있는지 없는지 알려주는데 .get()을 통해 그 값이 있으면 그 값을 꺼내온다 대충 결과를 쓴다?
        return memberone.get();
    }



    public MemberEntity updateForm(String memberId){
        Optional<MemberEntity> memberEntity = memberRepository.findByMemberId(memberId);
        return memberEntity.get();
    }

    public void update(MemberEntity memberEntity){
        memberRepository.save(memberEntity);
    }

    public void delete(String memberId){
        memberRepository.deleteById(memberId);
    }

}
