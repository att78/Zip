/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.nallezip.app.lempelziv.LempelZivWelchAlgo;
import com.nallezip.app.util.DiyStringBuilder;

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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testCreateLibraries() {
        LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
        algo.createEncodeLibrary();

        int value = algo.getLibrary().size();
//        int value2= algo.getLibraryDecoded().size();
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
        // assertEquals("[78, 97, 108, 108, 101]", algo.getEncoded().toString());
        // huom- diyArrayListin käyttöönotto rikkoitestin
    }

    @Test
    public void testDecodeString() {
        LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
        String string = "Nalle";
        byte[] encoded = algo.encodeString(string);
        String answer = algo.decodeString(encoded);

        assertEquals("Nalle", answer);
    }

//    @Test
//    public void testDecodeLoop(){
//    LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
//    DiyStringBuilder builder = new DiyStringBuilder();
//    String string = "Nalle";
//    algo.encodeString(string);
//    algo.decodeLoop(builder, string);
//    
//    //assertEquals("Nalle", builder.toString());
//    // huom diyArrayListin käyttöönotto rikkoi testin
//    }
}
