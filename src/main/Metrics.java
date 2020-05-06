package main;

import jdk.nashorn.api.tree.Tree;
import main.types.ClassInfo;
import main.types.MetricsType;
import main.types.PackageMetricsType;

import java.util.*;

public class Metrics {
    public static MetricsType getClassMetrics(String className, TreeMap<String, ClassInfo> container) {
        ClassInfo classMetrics = container.get(className);
        return new MetricsType(classMetrics.getNumberOfPublicMethods(),
                               classMetrics.getNumberOfPackageMethods(),
                               classMetrics.getNumberOfProtectedMethods(),
                               classMetrics.getNumberOfPrivateMethods(),
                               classMetrics.getNumberOfImplementedInterfaces(),
                               classMetrics.getDepthOfClassHierarchy(),
                               classMetrics.getAverageNumberOfParameters());
    }

    public static PackageMetricsType getPackageMetrics(String packageName, TreeMap<String, ClassInfo> container) {
        TreeMap<String, ClassInfo> packageContainer = new TreeMap<String, ClassInfo>();
        PackageMetricsType packageMetrics = new PackageMetricsType();
        TreeSet<Double> publicMethods = new TreeSet<Double>();
        TreeSet<Double> packageMethods = new TreeSet<Double>();
        TreeSet<Double> protectedMethods = new TreeSet<Double>();
        TreeSet<Double> privateMethods = new TreeSet<Double>();
        TreeSet<Double> interfaces = new TreeSet<Double>();
        TreeSet<Double> inheritanceDepth = new TreeSet<Double>();
        TreeSet<Double> averageParam = new TreeSet<Double>();
        for (Map.Entry<String, ClassInfo> c : container.entrySet()) {
            if (c.getValue().getClassName().contains(packageName)) {
                packageContainer.put(c.getValue().getClassName(), c.getValue());
            }
        }
        for (Map.Entry<String, ClassInfo> c : packageContainer.entrySet()) {
            publicMethods.add((double)c.getValue().getNumberOfPublicMethods());
            packageMethods.add((double)c.getValue().getNumberOfPackageMethods());
            protectedMethods.add((double)c.getValue().getNumberOfProtectedMethods());
            privateMethods.add((double)c.getValue().getNumberOfPrivateMethods());
            interfaces.add((double)c.getValue().getNumberOfImplementedInterfaces());
            inheritanceDepth.add((double)c.getValue().getDepthOfClassHierarchy());
            averageParam.add((double)c.getValue().getAverageNumberOfParameters());
        }
        packageMetrics.setMin(new MetricsType((int)findMin(publicMethods), (int)findMin(packageMethods),
                                              (int)findMin(protectedMethods), (int)findMin(privateMethods),
                                              (int)findMin(interfaces), (int)findMin(inheritanceDepth),
                                              findMin(averageParam)));
        packageMetrics.setMin(new MetricsType((int)findMax(publicMethods), (int)findMax(packageMethods),
                                              (int)findMax(protectedMethods), (int)findMax(privateMethods),
                                              (int)findMax(interfaces), (int)findMax(inheritanceDepth),
                                              findMax(averageParam)));
        packageMetrics.setMin(new MetricsType((int)findAvg(publicMethods), (int)findAvg(packageMethods),
                                              (int)findAvg(protectedMethods), (int)findAvg(privateMethods),
                                              (int)findAvg(interfaces), (int)findAvg(inheritanceDepth),
                                              findAvg(averageParam)));
        packageMetrics.setNrOfClasses(packageContainer.size());
        packageMetrics.setNrOfSubpackages(getSubpackagesNumber(getSubpackages(packageContainer)));
        return packageMetrics;
    }

    public static String getPackageHierarchy(String packageName) {
        return packageName;
    }

    public static double findMax(TreeSet<Double> values) {
        double max = 0;
        for (double d : values) {
            if (d > max) max = d;
        }
        return max;
    }

    public static double findMin(TreeSet<Double> values) {
        double min = Double.POSITIVE_INFINITY;
        for (double d : values) {
            if (d < min) min = d;
        }
        return min;
    }

    public static double findAvg(TreeSet<Double> values) {
        double accumulator = 0;
        for (double d : values) {
            accumulator += d;
        }
        return accumulator / values.size();
    }

    public static TreeSet<String> getSubpackages(TreeMap<String, ClassInfo> cont) {
        TreeSet<String> subpackages = new TreeSet<String>();
        for (Map.Entry<String, ClassInfo> elem : cont.entrySet()) {
            int count = (int)elem.getValue().getClassName().chars().filter(num -> num == '.').count();
            String substring = elem.getValue().getClassName();
            for (int i = 0; i < count; ++i) {
                if (subpackages.contains(substring.substring(0, elem.getValue().getClassName().indexOf('.')))) {
                    subpackages.add(elem.getValue().getClassName());
                    substring = elem.getValue().getClassName().substring(elem.getValue().getClassName().indexOf('.') + 1);
                }
            }
        }
        return subpackages;
    }

    public static int getSubpackagesNumber(TreeSet<String> subpackages) {
        return subpackages.size();
    }
}
