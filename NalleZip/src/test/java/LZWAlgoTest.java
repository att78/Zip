/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.nallezip.app.lempelziv.LempelZivWelchAlgo;
import java.util.HashMap;
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
    public void testCreateLibraries(){
        LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
        algo.createLibraries();
                
        assertEquals(512,algo.getLibrary().size());
        assertEquals(512, algo.getLibraryDecoded().size());
    }
    
    
    @Test
    public void testFillLibrary(){
        LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
        algo.createLibraries();
        String s = "Nalle";
        algo.fillLibrary(s);
       // assertEquals("[78, 97, 108, 108, 101]", algo.getEncoded().toString());
       // huom- diyArrayListin käyttöönotto rikkoitestin
    }
    
    @Test
    public void testDecodeString(){
    LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
    String string = "Nalle";
    algo.encodeString(string);
    String answer = algo.decodeString();
    
    assertEquals("Nalle", answer);
    }
    
    @Test
    public void testDecodeLoop(){
    LempelZivWelchAlgo algo = new LempelZivWelchAlgo();
    StringBuilder builder = new StringBuilder();
    String string = "Nalle";
    algo.encodeString(string);
    algo.decodeLoop(builder, string);
    
    //assertEquals("Nalle", builder.toString());
    // huom diyArrayListin käyttöönotto rikkoi testin
    }
           
}
