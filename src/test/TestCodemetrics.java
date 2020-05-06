package test;

import main.types.ClassInfo;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class TestCodemetrics {
    private Class reflectClass = ClassInfo.class;

    @Test
    public void testReflectClass() {
        String className = reflectClass.getName();
        assertEquals(className, "main.types.ClassInfo");
    }

    @Test
    public void testClassModifier() {
        int classModifier = reflectClass.getModifiers();
        // isAbstract, isFinal, isInterface isPrivate, isProtected, isStatic, isStrict, isSynchronized, isVolatile
        assertFalse(Modifier.isPrivate(classModifier));
    }

    @Test
    public void testGetInterfaces() {
        Class[] interfaces = reflectClass.getInterfaces();
        assertEquals(interfaces.length, 0);
    }

    @Test
    public void testGetSuperclass() {
        Class classSuper = reflectClass.getSuperclass();
        assertEquals(classSuper.getName(), "java.lang.Object");
    }

    @Test
    public void testGetMethods() {
        Method[] classMethods = reflectClass.getMethods();
        for (Method method : classMethods) {
            System.out.println("Method name: " + method.getName());
            System.out.println("Return type: " + method.getReturnType());
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> parameter : parameterTypes) {
                System.out.print("Parameter: " + parameter.getName());
            }
            System.out.println("--------------");
        }

    }
}
