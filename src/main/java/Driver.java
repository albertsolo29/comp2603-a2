import java.util.ArrayList;

/**
 * Console-based demonstration of the Caribbean Wildlife Conservation Tracker.
 * Creates sanctuaries, adds animals, and exercises all major features.
 *
 * TODO M9: Implement the entire Driver class
 *
 * See the README for the complete expected output.
 */
public class Driver {
    public static void main(String[] args) {

        Sanctuary caroni  = new Sanctuary("Caroni Bird Sanctuary", "Trinidad", 20);
        Sanctuary blueLagoon = new Sanctuary("Blue Lagoon Marine Park", "Jamaica", 15);



        Animal ruby = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
        Animal blaze = new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true);
        Animal dusty = new Bird("Cocrico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true);
        Animal brutus = new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0);
        Animal medusa = new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0);
        Animal atlas = new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0, "Healthy", 1200.0, 8000);

        Animal flash = new Bird("Doctor Bird", "Flash", "Jamaica", 0.01, "Healthy", 12.0, true);
        Animal shelly = new Marine("Hawksbill Turtle", "Shelly", "Jamaica", 80.0, "Injured", 50.0, 3000);
        Animal gills = new Marine("Nurse Shark", "Gills", "Jamaica", 110.0, "Healthy", 75.0, 5000);


        caroni.addAnimal(ruby);
        caroni.addAnimal(blaze);
        caroni.addAnimal(dusty);
        caroni.addAnimal(brutus);
        caroni.addAnimal(medusa);
        caroni.addAnimal(atlas);


        blueLagoon.addAnimal(flash);
        blueLagoon.addAnimal(shelly);
        blueLagoon.addAnimal(gills);

        System.out.println("=== Caroni Bird Sanctuary roster ===");
        caroni.printRoster();

        System.out.println("\n=== Blue Lagoon Marine Park roster ===");
        blueLagoon.printRoster();

        
        System.out.println("\n=== Daily food budgets ===");
        System.out.printf("Caroni Bird Sanctuary: $%.2f TTD\n", caroni.getDailyFoodBudget());
        System.out.printf("Blue Lagoon Marine Park: $%.2f TTD\n", blueLagoon.getDailyFoodBudget());

        System.out.println("\n=== Birds at Caroni ===");
        for (Animal a : caroni.getAnimalsOfType("Bird")) {
            System.out.println("  " + a.toString());
        }

        System.out.println("\n=== Relocatable animals at Caroni ===");
        for (Animal a : caroni.getRelocatableAnimals()) {
            System.out.println("  " + a.toString());
        }

        System.out.println("\n=== Sighting logs ===");
        ((Trackable) ruby).logSighting("2026-06-10", "Caroni Swamp");
        ((Trackable) ruby).logSighting("2026-06-12", "Nariva Swamp");
        ((Trackable) atlas).logSighting("2026-06-11", "Matura Beach");


        System.out.println("Ruby sighting count: " + ((Trackable) ruby).getSightingCount());
        System.out.println("Ruby last sighting: " + ((Trackable) ruby).getLastSighting());
        System.out.println("Atlas sighting count: " + ((Trackable) atlas).getSightingCount());
        System.out.println("Atlas last sighting: " + ((Trackable) atlas).getLastSighting());
        System.out.println("Brutus last sighting: " + ((Trackable) brutus).getLastSighting());




        System.out.println("\n=== Transfer Atlas to Blue Lagoon ===");
        boolean transferred = caroni.transferAnimal(atlas.getAnimalId(), blueLagoon);
        System.out.println("Transfer successful: " + transferred);
        System.out.println("Blue Lagoon Marine Park roster after transfer:");
        blueLagoon.printRoster();



        System.out.println("\n=== Attempt to transfer Brutus (Reptile) ===");
        boolean brutusTransferred = caroni.transferAnimal(brutus.getAnimalId(), blueLagoon);
        System.out.println("Transfer successful: " + brutusTransferred);

        System.out.println("\n=== Most expensive animal at each sanctuary ===");

        Animal expCaroni = caroni.getMostExpensiveAnimal();

        System.out.printf("Caroni: %s ($%.2f TTD/day)\n", expCaroni.toString(), expCaroni.getDailyFoodCostTTD());


        Animal expBlue = blueLagoon.getMostExpensiveAnimal();

        System.out.printf("Blue Lagoon: %s ($%.2f TTD/day)\n", expBlue.toString(), expBlue.getDailyFoodCostTTD());


        System.out.println("\n=== Updated food budgets ===");
        System.out.printf("Caroni Bird Sanctuary: $%.2f TTD\n", caroni.getDailyFoodBudget());
        System.out.printf("Blue Lagoon Marine Park: $%.2f TTD\n", blueLagoon.getDailyFoodBudget());




        // TODO M9: Create two sanctuaries:
        //   "Caroni Bird Sanctuary", Trinidad, capacity 20
        //   "Blue Lagoon Marine Park", Jamaica, capacity 15

        // TODO M9: Create and add animals to Caroni:
        //   Bird: "Scarlet Ibis", "Ruby", Trinidad, 0.35, "Healthy", 60.0, true
        //   Bird: "Scarlet Ibis", "Blaze", Trinidad, 0.40, "Healthy", 58.0, true
        //   Bird: "Cocrico", "Dusty", Trinidad, 0.25, "Injured", 30.0, true
        //   Reptile: "Spectacled Caiman", "Brutus", Trinidad, 45.0, "Healthy", false, 180.0
        //   Reptile: "Green Anaconda", "Medusa", Trinidad, 30.0, "Critical", false, 350.0
        //   Marine: "Leatherback Turtle", "Atlas", Trinidad, 500.0, "Healthy", 1200.0, 8000

        // TODO M9: Create and add animals to Blue Lagoon:
        //   Bird: "Doctor Bird", "Flash", Jamaica, 0.01, "Healthy", 12.0, true
        //   Marine: "Hawksbill Turtle", "Shelly", Jamaica, 80.0, "Injured", 50.0, 3000
        //   Marine: "Nurse Shark", "Gills", Jamaica, 110.0, "Healthy", 75.0, 5000

        // TODO M9: Print "=== Caroni Bird Sanctuary roster ===" then printRoster()
        // TODO M9: Print "=== Blue Lagoon Marine Park roster ===" then printRoster()

        // TODO M9: Print "=== Daily food budgets ===" then each sanctuary's budget

        // TODO M9: Print "=== Birds at Caroni ===" then getAnimalsOfType("Bird")

        // TODO M9: Print "=== Relocatable animals at Caroni ===" then getRelocatableAnimals()

        // TODO M9: Print "=== Sighting logs ===" then:
        //   Log Ruby: ("2026-06-10", "Caroni Swamp"), ("2026-06-12", "Nariva Swamp")
        //   Log Atlas: ("2026-06-11", "Matura Beach")
        //   Print counts and last sightings for Ruby, Atlas, and Brutus

        // TODO M9: Print "=== Transfer Atlas to Blue Lagoon ===" then transfer and print result

        // TODO M9: Print "=== Attempt to transfer Brutus (Reptile) ===" then transfer and print result

        // TODO M9: Print "=== Most expensive animal at each sanctuary ==="

        // TODO M9: Print "=== Updated food budgets ==="
    }
}
