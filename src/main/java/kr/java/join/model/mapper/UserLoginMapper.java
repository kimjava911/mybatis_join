package kr.java.join.model.mapper;

import kr.java.join.model.dto.UserLoginDTO;
import kr.java.join.model.dto.UserLoginWithInfoDTO;

public interface UserLoginMapper {
    UserLoginDTO findByUsername(String username);
    UserLoginWithInfoDTO findByUsernameWithInfo(String username);
}
