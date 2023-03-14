package hello.core.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("hello");   //자동으로 getter, setter, 생성자 등등 만들어 줌
        helloLombok.setAge(13);

        System.out.println("helloLombok = " + helloLombok);
    }
}
