package com.koldakov.optional;

import java.util.Optional;

public class MapFlatMapDifferenceDummySample {

    // Map returns Optional<U>, so if T is already Optional<R>, then map returns Optional<Optional<R>>
    //
    // FlatMap returns Optional<U> too, but it requires from map function to return also Optional<U>,
    // so it does not wrap return value in one more Optional
    public static void main(String[] args) {
        Optional<String> optionalString = Optional.of("test");

        // map parameter function returns String -> map returns Optional<String>
        System.out.println(optionalString.map(s -> s.toUpperCase()));

        // map parameter function returns Optional<String> -> map returns Optional<Optional<String>>
        System.out.println(optionalString.map(s -> Optional.of(s.toUpperCase())));

        // does not work because flatMap parameter function is required to return Optional
        // System.out.println(optionalString.flatMap(s -> s.toUpperCase()));

        // flatMap parameter function returns Optional<String> -> flatMap returns Optional<String>
        System.out.println(optionalString.flatMap(s -> Optional.of(s.toUpperCase())));


        // in case of empty everything returns Optional.empty
        Optional<String> optionalEmptyString = Optional.empty();
        System.out.println(optionalEmptyString.map(s -> s.toUpperCase()));
        System.out.println(optionalEmptyString.map(s -> Optional.of(s.toUpperCase())));
        System.out.println(optionalEmptyString.flatMap(s -> Optional.of(s.toUpperCase())));
    }
}
