package com.arch.raon.domain.member.service;

import com.arch.raon.domain.member.dto.request.MemberSignupReqDTO;
import com.arch.raon.domain.member.dto.response.CheckActiveResDTO;
import com.arch.raon.domain.member.dto.response.MemberCheckSchoolResDTO;
import com.arch.raon.domain.member.dto.response.MemberDetailResDTO;
import com.arch.raon.global.auth.dto.AuthUserInfo;
import com.arch.raon.global.auth.dto.OAuthUserInfo;

public interface MemberService {
    public AuthUserInfo getOrRegisterUser(OAuthUserInfo oauthUserInfo);
    void signup(Long id, MemberSignupReqDTO memberSignupReqDTO);
    public CheckActiveResDTO checkActive(Long id);
    boolean checkNickname(String nickname);
    void modifyMember(Long id, MemberSignupReqDTO memberSignupReqDTO);
    MemberDetailResDTO detailMember(Long id);
    MemberCheckSchoolResDTO checkSchool(String keyword);
}
