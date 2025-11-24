package kr.java.join.model.mapper;

import kr.java.join.model.domain.Post;
import kr.java.join.model.dto.PostByUserDTO;
import kr.java.join.model.dto.PostWithNicknameDTO;
import kr.java.join.model.dto.UserLoginDTO;
import kr.java.join.model.dto.UserLoginWithInfoDTO;

import java.util.List;

public interface PostMapper {
    int insert(Post post);
    // user -> post
    PostByUserDTO findByUsername(String username);
    // 본인의 추천여부를 보려고 함
    List<PostWithNicknameDTO> findAll(String username);
}
