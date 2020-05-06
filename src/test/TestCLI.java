package test;

import main.CLI;
import main.types.ClassInfo;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class TestCLI {
    @Test
    public void testMain() {
        String[] arguments = {"JarTests/bermuda/bermudagame.jar", "JarTests/ij.jar"};
        CLI.main(arguments);
    }

    @Test
    public void testGetClassNamesFromJar() {
        final String dir = "file://" + System.getProperty("user.dir") + "/";
        try {
            URL jarUrl = new URL(dir + "JarTests/plexus-interpolation-1.24.jar");
            Vector<String> classNames = CLI.getClassNamesFromJar(jarUrl);
            assertEquals(59, classNames.size());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetClassArray() {
        final String dir = "file://" + System.getProperty("user.dir") + "/";
        URL[] jarUrls = new URL[2];
        try {
            jarUrls[0] = new URL(dir + "JarTests/plexus-sec-dispatcher-1.3.jar");
            jarUrls[1] = new URL(dir + "JarTests/org-openide-options.jar");
            Vector<String> v1 = new Vector<String>();
            v1.add("test.package");
            v1.add("another.test.package");
            Vector<Class<?>> reflectionClasses = CLI.getClassArray(jarUrls, v1);
            assertEquals(0, reflectionClasses.size());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetReflectionClassCollection() {
        Vector<Class<?>> reflectionClasses = new Vector<Class<?>>();
        reflectionClasses.add(String.class);
        reflectionClasses.add(Stack.class);
        reflectionClasses.add(Object.class);
        TreeMap<String, ClassInfo> collection = CLI.getReflectionClassCollection(reflectionClasses);
        assertEquals(3, collection.size());
    }
}
