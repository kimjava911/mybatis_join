package kr.java.join.model.mapper;

import kr.java.join.model.domain.Post;
import kr.java.join.model.dto.UserLoginDTO;
import kr.java.join.model.dto.UserLoginWithInfoDTO;

public interface PostMapper {
    int insert(Post post);
}
