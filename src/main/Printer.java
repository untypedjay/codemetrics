package main;

import main.types.MetricsType;
import main.types.PackageMetricsType;

public class Printer {
    public static void printClassMetrics(MetricsType metrics, String className) {
        System.out.println(className + "(public methods: " + metrics.getNrOfPublicMethods() +
                ", package methods: " + metrics.getNrOfPackageMethods() +
                ", protected methods: " + metrics.getNrOfProtectedMethods() +
                ", private methods: " + metrics.getNrOfPrivateMethods() +
                ", implemented interfaces: " + metrics.getNrOfImplementedInterfaces() +
                ", class depth: " + metrics.getDepthOfInheritance() +
                ", average parameters: " + metrics.getAverageNrOfParameters() + ")");
    }

    public static void printPackageMetrics(PackageMetricsType metrics, String packageName) {
        System.out.println("--------------------" + packageName + "--------------------");
        System.out.println("min(" + metrics.getMin() + ")");
        System.out.println("max(" + metrics.getMax() + ")");
        System.out.println("avg(" + metrics.getAvg() + ")");
        System.out.println("Number of Classes: " + metrics.getNrOfClasses());
        System.out.println("Number of Subpackages: " + metrics.getNrOfSubpackages());
    }
}
