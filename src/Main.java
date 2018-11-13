import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

public class Main {

    // Java 11 - 'Data Classes' concept - as I understand, currently not available to use:
    // record Alkene(Integer carbNo, String name) {};

    public static void main(String[] args) {
        // Java 9 - map literals
        // Java 10 - `var` keyword (instead of `Map<Integer, String>`)
        var alkanes = Map.of(1, "methane",
                2, "ethane",
                3, "propane");


        IntStream.range(2,5).forEach(
                (var carbonNo) -> {
                    printAlkaneInfo(alkanes, carbonNo);
                }
        );
    }

    private static void printAlkaneInfo(Map<Integer, String> alkanes, int carbonNo) {
        Optional<String> name =
                Optional.ofNullable(alkanes.get(carbonNo));

        // ToDo: better usage of Optional?
        if (name.isPresent()) {
            System.out.printf("Alkane for %d carbons is called: %s%n", carbonNo, name.get());
        } else {
            System.out.println("Unable to find alkane information");
        }
    }
}
