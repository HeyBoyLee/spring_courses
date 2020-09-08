package com.boy.coll;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    @Test
    public void getMyList(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list.get(4));
        MyClass m = new MyClass();
        m.setId("a");
        m.setName("b");
        System.out.println(m);
    }
}

@Data
class MyClass{
    private String name;
    private String id;
}

