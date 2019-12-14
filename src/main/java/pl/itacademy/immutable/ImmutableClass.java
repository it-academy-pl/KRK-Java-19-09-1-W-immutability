package pl.itacademy.immutable;

import lombok.Value;

@Value
public class ImmutableClass {
    private final String firstProperty;
    private final Address address;
    private final Certificate certificate;
}
