package com.urise.webapp.main;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Resume resume = new Resume(null, null);
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName() + " : " + field.get(resume));
        field.set(resume, "new uuid");
        field.setAccessible(false);
        System.out.println(field.getName() + " : " + resume);
        Method method = resume.getClass().getDeclaredMethod("toString");
        System.out.println(method.invoke(resume));
    }
}
