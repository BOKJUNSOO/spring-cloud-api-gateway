package com.welab.api_gateway.security.jwt.authentication;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.Objects;

@Getter
@RequiredArgsConstructor
// Pricipal 메서드를 구현하는 클래스
// NOTE: 해당 클래스를 통해 "인증 인가 처리에서 인증된 사용자의 식별자 (userId)" 를 표하는데 사용된다.
public class UserPrincipal implements Principal {
    private final String userId;

    public boolean hasMandatory() {
        return userId != null;
    }

    @Override
    public String getName() {
        return userId;
    }

    @Override
    public String toString(){
        return getName();
    }

    // hash Code 와 equals 는 꼭 같이 구현되어 있어야함
    @Override
    public int hashCode() {
        // 비교를 위한 고유한 정수값 지정
        int result = userId != null ? userId.hashCode() :0;
        return result;
    }

    @Override
    public boolean equals(Object another) {
        // 일반적인 equals 의 구현
        // 같은 객체라면 true
        if (this == another) {
            return true;
        }
        
        // null 혹은 타입체크를 했을때 다르다면 false
        if (another == null) {
            return false;
        }
        
        // 타입체크
        if (!getClass().isAssignableFrom(another.getClass())) {
            return false;
        }
        
        // 다운케스팅 하여 값 비교
        UserPrincipal anotherUserPrincipal = (UserPrincipal) another;
        // 다르다면 false
        if (!Objects.equals(userId, anotherUserPrincipal.userId)) {
            return false;
        }

        return  true;
    }
}
