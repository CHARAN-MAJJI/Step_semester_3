class PlacementRecords {
    String name;
    String company;
    double packageLpa;
    PlacementRecords(String name, String company, double packageLpa) {
        this.name = name;
        this.company = company;
        this.packageLpa = packageLpa;
    }
    void display(){
        System.out.println(name + " ---> " + company + " @ " + packageLpa + " LPA");
    }
}
public class M1 {
    public static void main(String[] args) {
        PlacementRecords[] r ={
            new PlacementRecords("Ravi", "TCS", 12.5),
            new PlacementRecords("Anitha", "ZOHO", 10.0),
            new PlacementRecords("Karthik", "Infosys", 15.0)
        };
        for(PlacementRecords l:r){
            l.display();
        }
    }
}
