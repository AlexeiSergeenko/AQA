import org.junit.jupiter.api.*;

public class JUnitExamples {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    Before each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all tests");
    }

    @AfterEach
    void afterEach() {
        System.out.println("    After each test");
    }

    @Test
    void firstTest() {
        System.out.println("        Here is the first test");

    }
    @Test
    void secondTest() {
        System.out.println("        Here is the second test");
    }
}
