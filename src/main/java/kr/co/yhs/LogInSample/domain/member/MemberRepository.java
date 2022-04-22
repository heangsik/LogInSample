package kr.co.yhs.LogInSample.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class MemberRepository {
    private static final Map<Long, Member> store = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

    public Optional<Member> findByLoginId(String loginId) {
        return this.findAll().stream().filter(m->m.getLoginId().equals(loginId)).findFirst();
    }
    @PostConstruct
    public void init(){
        Member member = new Member();
        member.setLoginId("test_id");
        member.setName("test name");
        member.setPassword("testpass");
        Member rtnMember = this.save(member);
        log.info("test user insert id={}, pass={}", rtnMember.getId(), rtnMember.getPassword());
    }
}
