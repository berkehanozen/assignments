import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
    Util c;

    @Before
    public void setUp() { c = new Util(); }

    @Test
    public void example() { assertTrue(true); }

    @Test
    public void testLength1() { assertFalse(c.compute(2)); }

    @Test
    public void testLengthEven() { assertFalse(c.compute(1,2,3,4)); }

    @Test
    public void testModTrue() { assertTrue(c.compute(1,2,3,4,5)); }

    @Test
    public void testModFalse() { assertFalse(c.compute(5,5,6)); }

    @Test(expected = RuntimeException.class)
    public void testException() { c.compute(1,0,2); }
}