package com.mmattei.BlackJack.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestClassTest {

    @Test
    public void shouldReturnString() {
        var test = new TestClass();
        assertNotNull(test.returnString());
    }

}