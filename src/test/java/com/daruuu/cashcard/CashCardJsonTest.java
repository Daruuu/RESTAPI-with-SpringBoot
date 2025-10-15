package com.daruuu.cashcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/*
class CashCardJsonTest {

    @Test
    void myFirstTest() {
        assertThat(1).isEqualTo(42);
    }
}
*/
@JsonTest
class CashCardJsonTest {

    @Autowired
    private JacksonTester<CashCard> json;

    @Test
    void cashCardSerializationTest() throws IOException {
//        JacksonTester<CashCard> newJT = new JacksonTester<>();
//        CashCard cashCard = new CashCard(99L, 123.45, new Name("Daruu", ""));
        CashCard cashCard = new CashCard(99L, 123.45);

        assertThat(json.write(cashCard)).isStrictlyEqualToJson("expected.json");
//        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.id");
//        assertThat(json.write(cashCard)).hasJsonPathNumberValue("@.amount");
//        assertThat(json.write(cashCard)).hasJsonPathStringValue("@.name.lastName");

//        assertThat(json.write(cashCard)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);
    }

    @Test
    void cashCardDeserializationTest() throws IOException {
        String expected = """
           {
                   "id":99,
               "amount":123.45
           }
           """;
        assertThat(json.parse(expected))
                .isEqualTo(new CashCard(99L, 123.45));
//        assertThat(json.parseObject(expected).id()).isEqualTo(1000);
//        assertThat(json.parseObject(expected).amount()).isEqualTo(67.89);
    }
}

