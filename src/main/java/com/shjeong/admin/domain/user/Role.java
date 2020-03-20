package com.shjeong.admin.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    //스프링 시큐리티 권한코드에 항상 ROLE이 앞에 있어야 한다.
    //나중에 테스트해보자. 없어도 되는데 ?
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;

}
