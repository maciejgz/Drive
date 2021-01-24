package pl.mg.recrut;


import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Zapewne znasz klawiaturę w starych telefonach. Np. taką w Nokii 3310 lub Sony Ericsson K750i:
 * <p>
 * <p>
 * W tych starych modelach, żeby napisać jakąś literę należało kilka razy wcisnąć dany przycisk.
 * I tak np. żeby uzyskać A należało wcisnąć przycisk 2 jeden raz, a żeby uzyskać Z to przycisk 9 cztery razy.
 * Dlatego np. słowo KOT oznaczało wciśnięcie klawiszy 556668.
 * <p>
 * Twoim zadaniem jest napisanie metody, która dowolne słowo zamieni właśnie na taki ciąg cyfr.
 */
public class RecrutMain {

    private final static Map<Character, String> values;

    static {
        values = new HashMap<>();
        values.put('a', "2");
        values.put('b', "22");
        values.put('c', "222");
        values.put('d', "3");
        values.put('e', "33");
        values.put('f', "333");
        values.put('g', "4");
        values.put('h', "44");
        values.put('i', "444");
        values.put('j', "5");
        values.put('k', "55");
        values.put('l', "555");
        values.put('m', "6");
        values.put('n', "66");
        values.put('o', "666");
        values.put('p', "7");
        values.put('q', "77");
        values.put('r', "777");
        values.put('s', "7777");
        values.put('t', "8");
        values.put('u', "88");
        values.put('v', "888");
        values.put('w', "9");
        values.put('x', "99");
        values.put('y', "999");
        values.put('z', "999");
    }

    private String getCode(String input) {
        StringBuilder builder = new StringBuilder();
        if (Objects.nonNull(input)) {
            for (char c : input.toCharArray()) {
                builder.append(getCharacterCode(c));
            }
        }
        return builder.toString();
    }

    private String getCodeStream(String input) {
        StringBuilder builder = new StringBuilder();
        if (Objects.nonNull(input)) {
            String res = input.chars()
                    .mapToObj(c -> String.valueOf((char) c))
                    .reduce("", (accumulator, element) -> accumulator + getCode(element));
        }
        return builder.toString();
    }

    private String getCharacterCode(char character) {
        return values.get(character);
    }

    public static void main(String[] args) {

        RecrutMain recruit = new RecrutMain();
        System.out.println(recruit.getCode("abc"));
        System.out.println(recruit.getCode("asdkhahdha"));


    }
}
