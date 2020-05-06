package main.types;

public class MetricsType {
    private int nrOfPublicMethods = -1;
    private int nrOfPackageMethods = -1;
    private int nrOfProtectedMethods = -1;
    private int nrOfPrivateMethods = -1;
    private int nrOfImplementedInterfaces = -1;
    private int depthOfInheritance = -1;
    private double averageNrOfParameters = -1;

    public MetricsType(int nrPublic, int nrPackage, int nrProtected, int nrPrivate, int nrInterfaces, int inheritanceDepth, double avgParams) {
        this.nrOfPublicMethods = nrPublic;
        this.nrOfPackageMethods = nrPackage;
        this.nrOfProtectedMethods = nrProtected;
        this.nrOfPrivateMethods = nrPrivate;
        this.nrOfImplementedInterfaces = nrInterfaces;
        this.depthOfInheritance = inheritanceDepth;
        this.averageNrOfParameters = avgParams;
    }

    public int getNrOfPublicMethods() {
        return nrOfPublicMethods;
    }

    public void setNrOfPublicMethods(int nrOfPublicMethods) {
        if (nrOfPublicMethods >= 0) {
            this.nrOfPublicMethods = nrOfPublicMethods;
        }
    }

    public int getNrOfPackageMethods() {
        return nrOfPackageMethods;
    }

    public void setNrOfPackageMethods(int nrOfPackageMethods) {
        if (nrOfPackageMethods >= 0) {
            this.nrOfPackageMethods = nrOfPackageMethods;
        }
    }

    public int getNrOfProtectedMethods() {
        return nrOfProtectedMethods;
    }

    public void setNrOfProtectedMethods(int nrOfProtectedMethods) {
        if (nrOfProtectedMethods >= 0) {
            this.nrOfProtectedMethods = nrOfProtectedMethods;
        }
    }

    public int getNrOfPrivateMethods() {
        return nrOfPrivateMethods;
    }

    public void setNrOfPrivateMethods(int nrOfPrivateMethods) {
        if (nrOfPrivateMethods >= 0) {
            this.nrOfPrivateMethods = nrOfPrivateMethods;
        }
    }

    public int getNrOfImplementedInterfaces() {
        return nrOfImplementedInterfaces;
    }

    public void setNrOfImplementedInterfaces(int nrOfImplementedInterfaces) {
        if (nrOfImplementedInterfaces >= 0) {
            this.nrOfImplementedInterfaces = nrOfImplementedInterfaces;
        }
    }

    public int getDepthOfInheritance() {
        return depthOfInheritance;
    }

    public void setDepthOfInheritance(int depthOfInheritance) {
        if (depthOfInheritance >= 0) {
            this.depthOfInheritance = depthOfInheritance;
        }
    }

    public double getAverageNrOfParameters() {
        return averageNrOfParameters;
    }

    public void setAverageNrOfParameters(double averageNrOfParameters) {
        if (averageNrOfParameters >= 0) {
            this.averageNrOfParameters = averageNrOfParameters;
        }
    }
}
