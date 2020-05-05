package main;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassInfo {
    private Class<?> classObject;
    private String className = null;
    private Method[] methods;
    private Class<?>[] interfaces;

    private Class<?>[] parameterTypes;

    public ClassInfo(Class<?> inputClass) {
        this.classObject = inputClass;
        this.className = inputClass.getName();
        this.methods = inputClass.getDeclaredMethods();
        this.interfaces = inputClass.getInterfaces();
    }

    public int getNumberOfMethods() {
        return methods.length;
    }

    public int getNumberOfPublicMethods() {
        int count = 0;
        for (int i = 0; i < getNumberOfMethods(); ++i) {
            if (Modifier.isPublic(methods[i].getModifiers())) {
                ++count;
            }
        }
        return count;
    }

    public int getNumberOfPackageMethods() {
        int count = 0;
        for (int i = 0; i < getNumberOfMethods(); ++i) {
            if (!Modifier.isPublic(methods[i].getModifiers()) &&
                    !Modifier.isProtected(methods[i].getModifiers()) &&
                    !Modifier.isPrivate(methods[i].getModifiers())) {
                ++count;
            }
        }
        return count;
    }

    public int getNumberOfProtectedMethods() {
        int count = 0;
        for (int i = 0; i < getNumberOfMethods(); ++i) {
            if (Modifier.isProtected(methods[i].getModifiers())) {
                ++count;
            }
        }
        return count;
    }

    public int getNumberOfPrivateMethods() {
        int count = 0;
        for (int i = 0; i < getNumberOfMethods(); ++i) {
            if (Modifier.isPrivate(methods[i].getModifiers())) {
                ++count;
            }
        }
        return count;
    }

    public int getNumberOfImplementedInterfaces() {
        return interfaces.length;
    }

    public int getDepthOfClassHierarchy() {
        int depth = 0;
        Class<?> tempClass = classObject.getSuperclass();
        while (tempClass != null) {
            tempClass = tempClass.getSuperclass();
            ++depth;
        }
        return depth;
    }

    public int getNumberOfParameters() {
        int count = 0;
        for (Method m : methods) {
            count += m.getParameterTypes().length;
        }
        return count;
    }

    public double getAverageNumberOfParameters() {
        return (double)getNumberOfParameters() / getNumberOfMethods();
    }
}
