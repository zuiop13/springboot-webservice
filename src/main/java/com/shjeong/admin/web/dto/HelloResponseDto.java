package com.shjeong.admin.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//겟터 자동생성
@Getter
//해당 클래스의 생성자를 자동 생성
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
