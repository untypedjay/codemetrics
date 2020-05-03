package main;

public class ClassInfo {
    private String className = null;
    private int publicMethodsNr = 0;
    private int privateMethodsNr = 0;
    private int protectedMethodsNr = 0;
    private int packageMethodsNr = 0;
    private int interfacesNr = 0;
    private int inheritanceDepth = 1;
    private int totalParameters = 0;

    public ClassInfo(Class<?> inputClass) {
        this.className = inputClass.getName();
    }

    public String getClassName() {
        return className;
    }

    public int getPublicMethodsNr() {
        return publicMethodsNr;
    }

    public int getPrivateMethodsNr() {
        return privateMethodsNr;
    }

    public int getProtectedMethodsNr() {
        return protectedMethodsNr;
    }

    public int getPackageMethodsNr() {
        return packageMethodsNr;
    }

    public int getInterfacesNr() {
        return interfacesNr;
    }

    public int getInheritanceDepth() {
        return inheritanceDepth;
    }

    public double averageParametersPerMethod() {
        return totalParameters / (publicMethodsNr + privateMethodsNr + protectedMethodsNr + packageMethodsNr);
    }
}
