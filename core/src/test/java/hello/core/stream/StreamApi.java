package hello.core.stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApi {

    @Test
    void streamApiTest() {
        List<String> oldList = Arrays.asList("1", "2", "3", "4");
        List<String> newList = Arrays.asList("7", "8", "5", "6");

        List<String> mergedList = oldList.stream().filter(old -> newList.stream().noneMatch(Predicate.isEqual(old)))
                                            .collect(Collectors.toList());

//        Assertions.assertThat(mergedList).isEqualTo(Arrays.asList("1", "2"));


        List<String> mergedList2 = oldList.stream().filter(old -> newList.stream().anyMatch(Predicate.isEqual(old)))
                .collect(Collectors.toList());

        System.out.println("mergedList2 = " + mergedList2);

        List<String> isTest = oldList.stream().filter(old -> newList.stream().anyMatch(Predicate.isEqual(old))).collect(Collectors.toList());

        if (isTest.isEmpty()) {
            System.out.println("isEmpty");
        } else {
            System.out.println("dsadasd");

        }
        System.out.println("isTest = " + isTest);



//            List<String> oldList = Arrays.asList{"1", "2", "3", "4"};
//            List<String> newList = Arrays.asList{"3", "4", "5", "6"};
//
//            List<String> resultList1 = oldList.stream()
//                    .filter(old -> newList.stream().noneMatch(Predicate.isEuqal(old)))
//                    .collect(Collectors.toList());
//
//            System.out.println(resultList1); // [1, 2]
//
//
//            List<String> resultList2 = newList.stream()
//                    .filter(new -> oldList.stream().noneMatch(Predicate.isEqual(new)))
//                            .collect(Collectors.toList());
//
//            System.out.println(resultList2); // [5, 6
    }
}
