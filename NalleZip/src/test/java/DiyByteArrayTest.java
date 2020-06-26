

import com.nallezip.app.util.DiyBitArrayReader;
import com.nallezip.app.util.DiyByteArray;
import com.nallezip.app.util.DiyByteArrayReader;
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
public class DiyByteArrayTest {
    
    public DiyByteArrayTest() {
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
    public void writeByteTest(){
        DiyByteArray test = new DiyByteArray(8);        
        assertEquals(0, test.getSize());
        assertEquals(0, test.getBytes().length);        
        byte testByte = 1;
        test.writeByte(testByte);
        assertEquals(1,test.getSize());
    }
    
    @Test
    public void bitArrayReaderTest(){
        byte[] bytes = new byte[8];
        bytes[0]=1;
        DiyBitArrayReader test = new DiyBitArrayReader(bytes);
        boolean result = test.readBit();
        assertFalse(result);
        bytes[1]= 0;

    }
    
    @Test
    public void byteArrayReaderTest(){
        byte[] bytes = new byte[8];
        byte input = 1;
        bytes[0]=1;
        DiyByteArrayReader test = new DiyByteArrayReader(bytes);
        byte result = test.readByte();
        assertEquals(input, result);
        
    }
     
     
}
