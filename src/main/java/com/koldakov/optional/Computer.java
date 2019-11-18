package com.koldakov.optional;

import java.util.Optional;

public class Computer {

    private UsbPort usbPort;

    public Computer(UsbPort usbPort) {
        this.usbPort = usbPort;
    }

    public Optional<UsbPort> getUsbPort() {
        return Optional.ofNullable(usbPort);
    }
}
