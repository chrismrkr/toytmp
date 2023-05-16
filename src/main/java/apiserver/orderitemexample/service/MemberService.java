package apiserver.orderitemexample.service;

import apiserver.orderitemexample.domain.Member;

public interface MemberService {
    Long createMember(Member member);
    Member findMember(String name);
}
