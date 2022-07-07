package chapter2;

public class SampleFunctionalInterface {

    public static void main(String[] args) {
        //람다 사용
        Runnable r1 = () -> System.out.println("Hello World 1");

        //익명 클래스 사용
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };

        process(r1);
        process(r2);

        //직접 전달된 람다, 만약 문자열을 변수로 받아서 출력을 한다면 참조형으로 바꿀 수 있다.
        process(()-> System.out.println("Hello World 3"));
    }

    public static void process(Runnable r){
        r.run();
    }


}
