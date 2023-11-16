package com.secret.dessertmap.repository;

import com.secret.dessertmap.dto.MemberDTO;
import com.secret.dessertmap.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

    Optional<MemberEntity> findByMemberId(String memberId);
    // Optional<MemberEntity> 이건 값이 존재하는지 아닌지를 확인시켜준다 값이 있따, 값이 없다
    // 실제로 값이 있다면 그 값을 가져오는데 Optional은 그 값의 존재 여부를 확인해주는 듯


}
