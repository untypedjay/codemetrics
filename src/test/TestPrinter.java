package test;

import main.types.MetricsType;
import main.types.PackageMetricsType;
import org.junit.Test;
import main.Printer;

public class TestPrinter {
    @Test
    public void testPrintClassMetrics() {
        Printer.printClassMetrics(new MetricsType(14, 2, 3, 0, 3, 2, 0.33), "test.package");
    }

    @Test
    public void testPrintPackageMetrics() {
        MetricsType mt1 = new MetricsType(15, 0, 2, 3, 4, 8, 0.53);
        MetricsType mt2 = new MetricsType(5, 8, 1, 5, 8, 2, 1);
        MetricsType mt3 = new MetricsType(4, 4, 7, 6, 2, 3, 0.5);
        Printer.printPackageMetrics(new PackageMetricsType(mt1, mt2, mt3, 33, 7), "test.package");
    }
}
