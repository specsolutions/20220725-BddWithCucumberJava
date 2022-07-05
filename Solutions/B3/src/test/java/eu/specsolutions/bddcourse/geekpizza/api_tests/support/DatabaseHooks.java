package eu.specsolutions.bddcourse.geekpizza.api_tests.support;

import io.cucumber.java.Before;
import eu.specsolutions.bddcourse.geekpizza.model.MenuItem;
import eu.specsolutions.bddcourse.geekpizza.model.User;
import eu.specsolutions.bddcourse.geekpizza.repository.GeekPizzaRepository;

import java.util.Arrays;

public class DatabaseHooks {

    @Before(order = 10)
    public void resetDatabaseToBaseline(){

        GeekPizzaRepository repository = new GeekPizzaRepository();
        repository.clearData();
        repository.saveChanges();

        addDefaultPizzas();
        addDefaultUsers();
    }

    //TODO: Use this helper methods to ensure a "baseline" database
    private static void addDefaultUsers() {
        GeekPizzaRepository repository = new GeekPizzaRepository();
        repository.getUsers().addAll(
                Arrays.asList(
                        new User("Marvin", "1234"),
                        new User("Ford", "1423")
                )
        );
        repository.saveChanges();
    }

    private static void addDefaultPizzas() {
        GeekPizzaRepository repository = new GeekPizzaRepository();
        repository.getMenuItems().addAll(
                Arrays.asList(
                        new MenuItem("Margherita", "tomato slices, oregano, mozzarella", 1920),
                        new MenuItem("Fitness", "sweetcorn, broccoli, feta cheese, mozzarella", 1340),
                        new MenuItem("BBQ", "BBQ sauce, bacon, chicken breast strips, onions", 1580),
                        new MenuItem("Mexican", "taco sauce, bacon, beans, sweetcorn, mozzarella", 2340),
                        new MenuItem("Quattro formaggi", "blue cheese, parmesan, smoked mozzarella, mozzarella", 2150),
                        new MenuItem("The old one", "No one remembers...", 1010, true)
                ));
        repository.saveChanges();
    }

}
