package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 내부에 private 스태틱으로 가지고 있다.
    // 스태틱으로 선언하면 클래스 레벨에 올라가기 때문에 딱 하나만 존재하게 된다.
    // 자바가 실행될 때 jvm이 static으로 선언된 객체들을 생성하고 가지고있는다.
    //1. jvm이 실행 시 static영역에 SingletonService 인스턴스를 생성해서 instance에 참조값을 넣어둔다.
    private static final SingletonService instance = new SingletonService();

    //2. public으로 열어서 객체 인스턴스가 필요한 곳에서 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    //3. 생성자를 private로 선언해서 외부에서 new로 생성할 수 없게 막는다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤로직");
    }

}
