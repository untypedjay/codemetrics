package main.types;

public class PackageMetricsType {
    private MetricsType min;
    private MetricsType max;
    private MetricsType avg;
    private int nrOfClasses;
    private int nrOfSubpackages;

    public MetricsType getMin() {
        return min;
    }

    public void setMin(MetricsType min) {
        this.min = min;
    }

    public MetricsType getMax() {
        return max;
    }

    public void setMax(MetricsType max) {
        this.max = max;
    }

    public MetricsType getAvg() {
        return avg;
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
