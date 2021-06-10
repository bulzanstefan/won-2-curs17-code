package ro.fasttrackit.curs17;

public class OldJava {
    public static void main(String[] args) {
        System.out.println(processString("inghetata", new ToUpperCaseDecorator()));
        System.out.println(processString("inghetata", new StarDecorator()));
        System.out.println(processString("inghetata", new WordDecorator() {
            @Override
            public String decorate(String word) {
                return word + "=====";
            }
        }));

    }

    private static String processString(String word, WordDecorator decorator) {
        return decorator.decorate(word);
    }

//    private static String processStringStar(String word) {
//        return "*" + word + "*";
//    }
}

interface WordDecorator {
    String decorate(String word);
}

class ToUpperCaseDecorator implements WordDecorator {
    @Override
    public String decorate(String word) {
        return word.toUpperCase();
    }
}

class StarDecorator implements WordDecorator {
    @Override
    public String decorate(String word) {
        return "*" + word + "*";
    }
}
