package com.shjeong.admin.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //getter
@NoArgsConstructor //기본 생성자를 만들어주겠다.
@Entity // 테이블과 링크 명시 (entity 클래스는 절대 setter 메소드를 만들지 않습니다. - 변경 값이 있으면 명확한 변경 메소드 추가)
public class Posts {

    @Id //key값 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk생성 규칙을 나타낸다
    private Long id;

    //테이블 컬럼 명시 굳이 선언안해도됌
    //컬럼의 길이(기본값 255) , notnull 명시
    @Column(length = 500, nullable = false)
    private String title;

    //컬럼 타입을 TEXT
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    private String test01;

    //해당 클래스의 빌더 패턴 클래스를 생성
    //생성자 상단에 선언시 생성자에 포함된 빌드만 빌더에 포함
    //이걸 이용해서 setter 없이 객체생성으로 데이터 삽입이 이루어 진다.
    @Builder
    public Posts(String title, String content,String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //public Posts(){};

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
