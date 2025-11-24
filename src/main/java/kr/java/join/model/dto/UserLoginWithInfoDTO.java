package kr.java.join.model.dto;

//public record UserLoginWithInfoDTO(
//        String username,
//        // String password, // 안 가지고 다니는 게 편함
//        UserInfoDTO userInfo
//) {
//}
public class UserLoginWithInfoDTO {
    private String username;
    private UserInfoDTO userInfo;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserInfoDTO getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoDTO userInfo) {
        this.userInfo = userInfo;
    }
}