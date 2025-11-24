package kr.java.join.model.mapper;

import kr.java.join.model.domain.Post;
import kr.java.join.model.dto.*;

import java.util.List;

public interface PostMapper {
    int insert(Post post);
    // user -> post
    PostByUserDTO findByUsername(String username);
    // 본인의 추천여부를 보려고 함
    List<PostWithNicknameDTO> findAll(String username);
    // 유저가 추천한 게시물 모음
    PostByUserRecommendDTO findByRecommend(String username);

    List<PostDTO> findByIds(int... ids);

    int insertPostsBatch(List<Post> posts);

    List<PostDTO> findWithKeyword(String keyword);
}