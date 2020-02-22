package com.shjeong.admin.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JpaRepository 기본적인 crud 메소드가 자동으로 생성되있음
//여기서 해당 인터페이스와 Posts(엔티티)는 같은 위치에 있어야된다.
public interface PostsRepository extends JpaRepository<Posts,Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
