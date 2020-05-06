package main;

import main.types.MetricsType;

public class Printer {
    public static void printClassMetrics(MetricsType metrics) {
        System.out.println("-----------------");
        System.out.println("Number of public methods: " + metrics.getNrOfPublicMethods());
        System.out.println("Number of package methods: " + metrics.getNrOfPackageMethods());
        System.out.println("Number of protected methods: " + metrics.getNrOfProtectedMethods());
        System.out.println("Number of private methods: " + metrics.getNrOfPrivateMethods());
        System.out.println("Number of implemented interfaces: " + metrics.getNrOfImplementedInterfaces());
        System.out.println("Depth of inheritance: " + metrics.getDepthOfInheritance());
        System.out.println("Average parameters per method: " + metrics.getAverageNrOfParameters());
        System.out.println("-----------------");
    }
}
