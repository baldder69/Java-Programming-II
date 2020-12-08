
public class Program {

    public static void main(String[] args) {

        StorageFacility unit = new StorageFacility();
        unit.add("a111", "mouse");
        unit.add("a111", "cheese");
        unit.add("a111", "cheese");
        unit.add("b123", "projector");
        unit.add("g63", "ice skates");
        unit.remove("b123", "projector");
        unit.storageUnits();
        System.out.println(unit.storageUnits());

    }
}
