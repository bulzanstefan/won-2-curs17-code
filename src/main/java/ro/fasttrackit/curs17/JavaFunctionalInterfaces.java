package ro.fasttrackit.curs17;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaFunctionalInterfaces {
    public static void main(String[] args) {
        tryFunction("word", a -> a.length());
        tryFunction("wordmailung", String::length);
        tryFunction("test123", word -> (int) word.charAt(0));

        String name = "Ana";
        trySupplier(() -> name);

        tryConsumer(price -> System.out.println(price + 100));
        tryConsumer(price -> System.out.println("Pretul este " + price));

        tryPredicate(s -> s.length() > 10);
        tryPredicate(s -> s.charAt(0) == 'a');
        tryPredicate(s -> Character.isUpperCase(s.charAt(0)));
        tryPredicate(JavaFunctionalInterfaces::methodPredicate);
    }

    public static boolean methodPredicate(String word) {
        return word.length() > 5;
    }

    public static void tryPredicate(Predicate<String> stringPredicate) {
        System.out.println(stringPredicate.test("abc123"));
    }

    public static void tryConsumer(Consumer<Long> longConsumer) {
        longConsumer.accept(123L);
    }

    public static void trySupplier(Supplier<String> stringSupplier) {
        System.out.println("inside trySupplier");
        System.out.println(stringSupplier.get());
    }

    public static void tryFunction(String word, Function<String, Integer> func) {
        System.out.println(func.apply(word));
    }
}
