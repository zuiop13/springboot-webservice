package com.shjeong.admin.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
// EntityListeners 는 Auditing 기능을 포함시킨다는 의미 입니다. Auditing 기능은 아래 설명을 하기위한 핵심 기술입니다.
@EntityListeners(AuditingEntityListener.class)
// 해당 클레스는 모든 엔티티의 상위가 될 클레스 입니다. 그렇기 때문에 위에 MappedSuperclass 를 사용해서
// 해당 클레스를 상속할때마다 밑에 변수들 createdDate,modifiedDate를 칼럼으로 인식되도록 설정합니다.
// 모든 엔티티에 생생 시간 . 수정시간을 전부 변수로 넣으면 번거럽기때문에 공통으로 쓰는 컴럼을 모아둔다고 생각하면 될듯합니다.
public class BaseTimeEntity {

    @CreatedDate // 엔티티가 생성되어 저장될때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate // 엔티티가 수정될때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;



}
