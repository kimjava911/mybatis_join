package kr.java.join.model.dto;

//public record UserInfoDTO(
//        String nickname,
//        String email) {
//}
public class UserInfoDTO {
    private String nickname;
    private String email;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
