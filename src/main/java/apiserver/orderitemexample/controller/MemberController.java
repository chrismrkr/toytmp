package apiserver.orderitemexample.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import apiserver.orderitemexample.domain.Member;
import apiserver.orderitemexample.domain.dto.member.create.CreateRequestDto;
import apiserver.orderitemexample.domain.dto.member.create.CreateResponseDto;
import apiserver.orderitemexample.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    CreateResponseDto createMemberRequest(@RequestBody CreateRequestDto dto) {
        Member member = Member.builder().name(dto.getName())
                                        .age(dto.getAge())
                                        .build();
        memberService.createMember(member);
        return CreateResponseDto.builder().age(member.getAge()).name(member.getName()).build();
    }

}
