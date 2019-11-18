package com.koldakov.optional;

import java.util.Optional;

/*
 See MapFlatMapDifferenceDummySample class first for detailed explanation
 */
public class MapFlatMapDifferenceRealSample {

    public static void main(String[] args) {

        UsbPort usbPort = new UsbPort("test_port");
        Computer computer = new Computer(usbPort);
        Optional<Computer> optionalComputer = Optional.of(computer);

        System.out.println(
                optionalComputer                                                            // Optional<Computer>
                        .map(c -> c.getUsbPort())                                           // Optional<Optional<UsbPort>>
                        .map(
                                optionalUsbPort -> optionalUsbPort.map(u -> u.getName())    // Optional<String>
                        )                                                                   // Optional<Optional<String>>
        );

        System.out.println(
                optionalComputer                                                            // 1. Optional<Computer>
                        .flatMap(c -> c.getUsbPort())                                       // 2. Optional<UsbPort>
                        .map(u -> u.getName())                                              // 3. Optional<String>
        );
    }
}
