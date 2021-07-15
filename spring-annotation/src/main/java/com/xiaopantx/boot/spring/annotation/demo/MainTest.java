package com.xiaopantx.boot.spring.annotation.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author panxj
 */
public class MainTest {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "tx.xml");
        //Person person = context.getBean(Person.class);
        //System.out.println("person = " + person);
        System.out.println(context);
    }
}
