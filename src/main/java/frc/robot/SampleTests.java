import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
/*
We (Gavin and I) used this program to try to test JUint. Look it up if you don't know what it is.
It failed, but feel free to use this document and the internet to install JUnit 5 and get it working properly on your own time.
If you do, it would help the whole team, not just Programming, a lot. Fair warning, however, attempting this gets you frustrated. Fast.
We could test code a lot faster, not just now, but possibly for the future Programmers.
Thanks - Rit
*/
public class SampleTests {
    @Test
    void test1() {
        Assertions.assertEquals(7, 7);
    }
}
