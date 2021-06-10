package ro.fasttrackit.curs17;

import java.util.function.Function;

public class NewJava {
    public static void main(String[] args) {
        System.out.println(processString("inghetata", word -> word.toUpperCase()));
        System.out.println(processString("inghetata", String::toUpperCase));

        System.out.println(processString("inghetata", String::valueOf));
        System.out.println(processString("inghetata", word -> String.valueOf(word)));

        System.out.println(processString("inghetata", word -> "*" + word + "*"));
        System.out.println(processString("inghetata", word -> word + "====="));
    }

    private static String processString(String word, Function<String, String> decorator) {
        return decorator.apply(word);
    }
}

//@FunctionalInterface
//interface NewWordDecorator<I, O> {
//    O decorate(I word);
//}
