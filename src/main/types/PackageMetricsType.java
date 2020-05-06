package main.types;

public class PackageMetricsType {
    private MetricsType min;
    private MetricsType max;
    private MetricsType avg;
    private int nrOfClasses;
    private int nrOfSubpackages;

    public PackageMetricsType() {
        this.min = null;
        this.max = null;
        this.avg = null;
        this.nrOfClasses = 0;
        this.nrOfSubpackages = 0;
    }

    public PackageMetricsType(MetricsType min, MetricsType max, MetricsType avg, int nrOfClasses, int nrOfSubpackages) {
        this.min = min;
        this.max = max;
        this.avg = avg;
        this.nrOfClasses = nrOfClasses;
        this.nrOfSubpackages = nrOfSubpackages;
    }

    public String getMin() {
        return "public methods: " + min.getNrOfPublicMethods() +
                ", package methods: " + min.getNrOfProtectedMethods() +
                ", protected methods: " + min.getNrOfProtectedMethods() +
                ", private methods: " + min.getNrOfPrivateMethods() +
                ", implemented interfaces:" + min.getNrOfImplementedInterfaces() +
                ", class depth: " + min.getDepthOfInheritance() +
                ", average parameters: " + min.getAverageNrOfParameters();
    }

    public void setMin(MetricsType min) {
        this.min = min;
    }

    public String getMax() {
        return "public methods: " + max.getNrOfPublicMethods() +
                ", package methods: " + max.getNrOfProtectedMethods() +
                ", protected methods: " + max.getNrOfProtectedMethods() +
                ", private methods: " + max.getNrOfPrivateMethods() +
                ", implemented interfaces:" + max.getNrOfImplementedInterfaces() +
                ", class depth: " + max.getDepthOfInheritance() +
                ", average parameters: " + max.getAverageNrOfParameters();
    }

    public void setMax(MetricsType max) {
        this.max = max;
    }

    public String getAvg() {
        return "public methods: " + avg.getNrOfPublicMethods() +
                ", package methods: " + avg.getNrOfProtectedMethods() +
                ", protected methods: " + avg.getNrOfProtectedMethods() +
                ", private methods: " + avg.getNrOfPrivateMethods() +
                ", implemented interfaces:" + avg.getNrOfImplementedInterfaces() +
                ", class depth: " + avg.getDepthOfInheritance() +
                ", average parameters: " + avg.getAverageNrOfParameters();
    }

    public void setAvg(MetricsType avg) {
        this.avg = avg;
    }

    public int getNrOfClasses() {
        return nrOfClasses;
    }

    public void setNrOfClasses(int nrOfClasses) {
        this.nrOfClasses = nrOfClasses;
    }

    public int getNrOfSubpackages() {
        return nrOfSubpackages;
    }

    public void setNrOfSubpackages(int nrOfSubpackages) {
        this.nrOfSubpackages = nrOfSubpackages;
    }
}
