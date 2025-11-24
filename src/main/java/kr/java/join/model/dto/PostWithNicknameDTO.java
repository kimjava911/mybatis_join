package kr.java.join.model.dto;

public record PostWithNicknameDTO(
        Long postId,
        String title,
        String content,
        String nickname,
        int recommendCnt,
        String myRecommend
) {
}
