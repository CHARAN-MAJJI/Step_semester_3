class PlacementRecord {
    String name, company;
    double packageLpa;

    PlacementRecord(String n, String c, double p) {
        name = n;
        company = c;
        packageLpa = p;
    }

    void printRecord() {
        System.out.println(name + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class M1 {
    public static void main(String[] args) {
        PlacementRecord[] r = {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        for (PlacementRecord x : r)
            x.printRecord();
    }
}