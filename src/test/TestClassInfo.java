package test;

import main.ClassInfo;
import org.junit.Test;

import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class TestClassInfo {
    @Test
    public void testGetNumberOfMethodsThrowable() {
        ClassInfo ci = new ClassInfo(Throwable.class);
        int totalMethods = ci.getNumberOfPublicMethods() + ci.getNumberOfPackageMethods() + ci.getNumberOfProtectedMethods() + ci.getNumberOfPrivateMethods();
        assertEquals(totalMethods, ci.getNumberOfMethods());
    }

    @Test
    public void testGetNumberOfMethodsAbstractCollection() {
        ClassInfo ci = new ClassInfo(AbstractCollection.class);
        int totalMethods = ci.getNumberOfPublicMethods() + ci.getNumberOfPackageMethods() + ci.getNumberOfProtectedMethods() + ci.getNumberOfPrivateMethods();
        assertEquals(totalMethods, ci.getNumberOfMethods());
    }

    @Test
    public void testGetNumberOfPublicMethodsThrowable() {
        ClassInfo ci = new ClassInfo(Throwable.class);
        assertEquals(13, ci.getNumberOfPublicMethods());
    }

    @Test
    public void testGetNumberOfPublicMethodsAbstractCollection() {
        ClassInfo ci = new ClassInfo(AbstractCollection.class);
        assertEquals(14, ci.getNumberOfPublicMethods());
    }

    @Test
    public void testGetNumberOfPackageMethodsThrowable() {
        ClassInfo ci = new ClassInfo(Throwable.class);
        assertEquals(0, ci.getNumberOfPackageMethods());
    }

    @Test
    public void testGetNumberOfPackageMethodsArrayDeque() {
        ClassInfo ci = new ClassInfo(ArrayDeque.class);
        assertEquals(8, ci.getNumberOfPackageMethods());
    }

    @Test
    public void testGetNumberOfProtectedMethodsThrowable() {
        ClassInfo ci = new ClassInfo(Throwable.class);
        assertEquals(0, ci.getNumberOfProtectedMethods());
    }

    @Test
    public void testGetNumberOfProtectedMethodsObject() {
        ClassInfo ci = new ClassInfo(Object.class);
        assertEquals(2, ci.getNumberOfProtectedMethods());
    }

    @Test
    public void testGetNumberOfPrivateMethodsThrowable() {
        ClassInfo ci = new ClassInfo(Throwable.class);
        assertEquals(7, ci.getNumberOfPrivateMethods());
    }

    @Test
    public void testGetNumberOfPrivateMethodsAbstractCollection() {
        ClassInfo ci = new ClassInfo(AbstractCollection.class);
        assertEquals(2, ci.getNumberOfPrivateMethods());
    }

    @Test
    public void testGetNumberOfImplementedInterfacesAbstractCollection() {
        ClassInfo ci = new ClassInfo(AbstractCollection.class);
        assertEquals(1, ci.getNumberOfImplementedInterfaces());
    }

    @Test
    public void testGetNumberOfImplementedInterfacesArrayDeque() {
        ClassInfo ci = new ClassInfo(ArrayDeque.class);
        assertEquals(3, ci.getNumberOfImplementedInterfaces());
    }

    @Test
    public void testGetNumberOfImplementedInterfacesObject() {
        ClassInfo ci = new ClassInfo(Object.class);
        assertEquals(0, ci.getDepthOfClassHierarchy());
    }

    @Test
    public void testGetDepthOfClassHierarchyArrayDeque() {
        ClassInfo ci = new ClassInfo(ArrayDeque.class);
        assertEquals(2, ci.getDepthOfClassHierarchy());
    }

    @Test
    public void testGetDepthOfClassHierarchyStack() {
        ClassInfo ci = new ClassInfo(Stack.class);
        assertEquals(4, ci.getDepthOfClassHierarchy());
    }

    @Test
    public void testGetNumberOfParametersStack() {
        ClassInfo ci = new ClassInfo(Stack.class);
        assertEquals(2, ci.getNumberOfParameters());
    }

    @Test
    public void testGetNumberOfParametersArrayDeque() {
        ClassInfo ci = new ClassInfo(ArrayDeque.class);
        assertEquals(54, ci.getNumberOfParameters());
    }

    @Test
    public void testGetAverageNumberOfParametersArrayDeque() {
        ClassInfo ci = new ClassInfo(ArrayDeque.class);
        assertEquals(1, ci.getAverageNumberOfParameters(), 0.5);
    }

    @Test
    public void testGetAverageNumberOfParametersStack() {
        ClassInfo ci = new ClassInfo(Stack.class);
        assertEquals(0, ci.getAverageNumberOfParameters(), 0.5);
    }
}
