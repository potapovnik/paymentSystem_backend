package cinimex.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = { NumberGenerator.class},
        loader = AnnotationConfigContextLoader.class)
class NumberGeneratorTest {
    @Test
    void testGenerateNumberOfBalance(){
        NumberGenerator.generateNumberOfBalance();
        assertNotNull(NumberGenerator.generateNumberOfBalance());
        assertEquals(NumberGenerator.generateNumberOfBalance().getClass(),String.class);
        assertEquals(NumberGenerator.generateNumberOfBalance().length(),20);
    }
}