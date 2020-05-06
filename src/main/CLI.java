package main;

import main.types.ClassInfo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.TreeMap;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class CLI {


    public static void main(String[] args) {
        final String dir = "file://" + System.getProperty("user.dir") + "/";
        Vector<String> classNames = new Vector<String>();
        URL[] jarUrls = new URL[args.length];
        for (int i = 0; i < args.length; ++i) {
            try {
                jarUrls[i] = new URL(dir + args[i]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            classNames.addAll(getClassNamesFromJar(jarUrls[i]));
        }
        TreeMap<String, ClassInfo> classCollection = getReflectionClassCollection(getClassArray(jarUrls, classNames));

        for (String name : classNames) {
            try {
                Printer.printClassMetrics(Metrics.getClassMetrics(name, classCollection) , name);
            } catch (Throwable e) {
                // ignore empty values
            }
        }

        for (String name : Metrics.getSubpackages(classCollection)) {
                Printer.printPackageMetrics(Metrics.getPackageMetrics(name, classCollection) , name);
        }
    }

    public static Vector<String> getClassNamesFromJar(URL jarUrl) {
        Vector<String> classNames = new Vector<String>();
        try {
            JarFile jf = new JarFile(jarUrl.getPath());
            Enumeration<JarEntry> e = jf.entries();
            while (e.hasMoreElements()) {
                JarEntry entry = e.nextElement();
                if (entry.getName().endsWith(".class")) {
                    classNames.add(entry.getName().replace(".class", "").replace("/", "."));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classNames;
    }

    public static Vector<Class<?>> getClassArray(URL[] jarUrls, Vector<String> classNames) {
        Vector<Class<?>> reflectionClasses = new Vector<Class<?>>();
        URLClassLoader loader = new URLClassLoader(jarUrls);
        int classesLoaded = 0;
        for (int i = 0; i < classNames.size(); ++i) {
            try {
                reflectionClasses.add(loader.loadClass(classNames.get(i)));
                ++classesLoaded;
            } catch (Throwable e) {
                // ignore external dependencies
            }
        }
        System.out.println("Classes loaded: " + classesLoaded + "/" + classNames.size() + " (" + (int)(((double)classesLoaded / classNames.size()) * 100) + "%)");
        return reflectionClasses;
    }

    public static TreeMap<String, ClassInfo> getReflectionClassCollection(Vector<Class<?>> classVector) {
        TreeMap<String, ClassInfo> collection = new TreeMap<String, ClassInfo>();
        ClassInfo current;
        for (int i = 0; i < classVector.size(); ++i) {
            try {
                current = new ClassInfo(classVector.get(i));
                collection.put(current.getClassName(), current);
            } catch (Throwable e) {
                // ignore external dependencies
            }
        }
        return collection;
    }
}
