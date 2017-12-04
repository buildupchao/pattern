package com.jangz.syntax.serialize;

import java.io.*;
import java.util.Objects;

/**
 * Created by yachao on 17/12/4.
 */
public class SerializeExample {

    public static void main(String[] args) {
        Person person = new Person("Jang Zhang", 23, '男');
        String fileName = "src/com/jangz/syntax/serialize/result.txt";

        serialize(person, fileName);

        Person newPerson = (Person) deserialize(fileName);
        System.out.println(newPerson.getName() + ", " + newPerson.getAge() + ", " + newPerson.getSex());

        System.out.println("equals? " + (Objects.equals(person, newPerson)));
    }

    public static void serialize(Object object, String writeFile) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(writeFile)));
            out.writeObject(object);
            out.flush();
        } catch (Exception e) {

        }
    }

    public static Object deserialize(String readFile) {
        Object object = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(readFile)));
            object = in.readObject();

        } catch (Exception e) {

        }
        return object;

    }
}
