

import com.nallezip.app.lempelziv.LempelZivWelchAlgo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tallbera
 */
public class LZWAlgoTest {

    public LZWAlgoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }


    @Test
    public void testCreateLibraries() {
        LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
        algo.createEncodeLibrary();

        int value = algo.getLibrary().size();
        assertEquals(512, value);

        algo.createDecodeLibrary();
        int value2 = algo.getLibraryDecoded().size();
        assertEquals(512, value2);

    }

    @Test
    public void testFillLibrary() {
        LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
        algo.createEncodeLibrary();
        String s = "Nalle";
        algo.fillLibrary(s);

    }

    @Test
    public void testDecodeString() {
        LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
        String string = "Nalle";
        byte[] encoded = algo.encodeString(string);
        String answer = algo.decodeString(encoded);

        assertEquals("Nalle", answer);
    }


}
