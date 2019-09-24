import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> evenNumbers = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());

        for (int i = 0; i < evenNumbers.size(); i ++){
            System.out.println(evenNumbers.get(i));
        }
    }
}
