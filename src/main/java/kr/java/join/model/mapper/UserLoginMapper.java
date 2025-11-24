package kr.java.join.model.mapper;

import kr.java.join.model.dto.UserLoginDTO;

public interface UserLoginMapper {
    UserLoginDTO findByUsername(String username);
}
