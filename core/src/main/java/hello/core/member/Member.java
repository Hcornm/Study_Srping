package hello.core.member;


import lombok.*;

// lombok 라이브러리를 사용해서 노가다 작업을 줄일 수 있다.
// lombok 라이브러리가 자동으로 필드값들에 대한 Getter 메서드를 생성해준다.
// 클래스 위에 어노테이션을 사용시 : 클래스에 해당하는 모든 필드들 해당
// 필드값 위에 직접 @Getter 사용시: 해당 필드만 Getter 사용
@Getter
// Setter 메서드 생성
@Setter
// 파라미터가 없는 기본 생성자 생성
//@NoArgsConstructor
// 모든 필드값을 파리미터로 받는 생성자 생성
//@AllArgsConstructor
// final이나 @NonNull인 필드 값만 파라미터로 받는 생성자 생성
//@RequiredArgsConstructor

// 위의 모든 어노테이션을 한방에 설정 ㅡㅡ
// @Data
public class Member {

    // id
    private Long id;
    // 이름
    private String name;
    // 등급
    private Grade grade;

    // 생성자
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public Grade getGrade() {
//        return grade;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setGrade(Grade grade) {
//        this.grade = grade;
//    }

}
