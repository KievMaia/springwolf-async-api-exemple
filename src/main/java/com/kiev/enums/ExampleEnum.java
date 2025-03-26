package com.kiev.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ExampleEnum {
        FOO1(1),
        FOO2(2),
        FOO3(3);

        private final int code;
    }