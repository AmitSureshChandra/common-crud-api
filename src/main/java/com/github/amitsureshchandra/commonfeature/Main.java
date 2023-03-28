package com.github.amitsureshchandra.commonfeature;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Sample<T> {

//    Type getEntityType() {
//        System.out.println(Arrays.toString(getClass().getGenericInterfaces()));
//        return ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
//    }

    void print(T t){
        Set<String> entityFields = Arrays.stream(
                        t.getClass().getDeclaredFields()
                )
                .map(Field::getName)
                .collect(Collectors.toSet());

        System.out.println(entityFields);
    }
}

class Demo {
    private String name;
}

public class Main {
    public static void main(String[] args) {
        new Sample<Demo>().print(new Demo());
    }
}
