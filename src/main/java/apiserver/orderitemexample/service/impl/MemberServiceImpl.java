package apiserver.orderitemexample.service.impl;

import org.springframework.stereotype.Service;

import apiserver.orderitemexample.domain.Member;
import apiserver.orderitemexample.repository.MemberRepository;
import apiserver.orderitemexample.service.MemberService;
import lombok.RequiredArgsConstructor;

@Service("memberSerivce")
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Long createMember(Member member) {
        Member m = memberRepository.save(member);
        return m.getId();
    }

    @Override
    public Member findMember(String name) {
        Member m = memberRepository.findByName(name).orElseThrow(() -> {
            return new IllegalAccessError("can't found member");
        });
        return m;
    }

}
