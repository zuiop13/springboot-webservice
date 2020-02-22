package com.shjeong.admin.service.posts;

import com.shjeong.admin.domain.posts.Posts;
import com.shjeong.admin.domain.posts.PostsRepository;
import com.shjeong.admin.web.dto.PostsListResponseDto;
import com.shjeong.admin.web.dto.PostsResponseDto;
import com.shjeong.admin.web.dto.PostsSaveRequestDto;
import com.shjeong.admin.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto)
    {
        Posts posts = postsRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }

    @org.springframework.transaction.annotation.Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    public PostsResponseDto findById (Long id)
    {
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 사용자가 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

}
