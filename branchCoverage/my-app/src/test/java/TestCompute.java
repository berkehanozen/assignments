import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testSize0() {
    MessageQueue mq = mock(MessageQueue.class);
    Mockito.when(mq.size()).thenReturn(0);
    c = new Compute(mq);
    assertEquals(c.countNumberOfOccurrences("Anything"),-1);
  }

  @Test
  public void testNotContains() {
      MessageQueue mq = mock(MessageQueue.class);
      Mockito.when(mq.contains(anyString())).thenReturn(false);
      Mockito.when(mq.size()).thenReturn(1);
      c = new Compute(mq);
      assertEquals(c.countNumberOfOccurrences("Anything"),0);
  }

    @Test
    public void testCounterNot0() {
        MessageQueue mq = mock(MessageQueue.class);
        Mockito.when(mq.contains(anyString())).thenReturn(true);
        Mockito.when(mq.size()).thenReturn(5);
        Mockito.when(mq.getAt(anyInt())).thenReturn("Anything");
        c = new Compute(mq);
        assertEquals(c.countNumberOfOccurrences("Anything"),5);
    }

    @Test
    public void testCounter0() {
        MessageQueue mq = mock(MessageQueue.class);
        Mockito.when(mq.contains(anyString())).thenReturn(true);
        Mockito.when(mq.size()).thenReturn(5);
        Mockito.when(mq.getAt(anyInt())).thenReturn(" ");
        c = new Compute(mq);
        assertEquals(c.countNumberOfOccurrences("Anything"),0);
    }
}