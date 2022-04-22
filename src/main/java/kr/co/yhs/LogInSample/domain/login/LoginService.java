package kr.co.yhs.LogInSample.domain.login;

import kr.co.yhs.LogInSample.domain.member.Member;
import kr.co.yhs.LogInSample.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final MemberRepository memberRepository;

    public Member login(String loginId, String password) {
        return memberRepository.findByLoginId(loginId).filter(m -> m.getPassword().equals(password)).orElse(null);
    }
}
