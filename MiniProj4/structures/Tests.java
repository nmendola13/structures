
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Tests of the assosiative array methods.
 * 
 * @author Noah
 */
public class Tests {
  
  public void NoahTest1() throws KeyNotFoundException {
    AssociativeArray<String, Integer> aa = new AssociativeArray<>();
    aa.set("item1", 5);
    aa.set("item2", 3);

    assertEquals(5, aa.get("item1"));
  }

  @Test
  public void NoahTest2() {
    AssociativeArray<String, Integer> aa = new AssociativeArray<>();

    aa.set("item1", 5);
    aa.set("item2", 3);
    aa.remove("item1");

    assertEquals(1, aa.size());
  }

  @Test
  public void NoahEdge1() {
    AssociativeArray<String, Integer> aa = new AssociativeArray<>();

    aa.remove("item3"); // remove non-existent key

    assertEquals(0, aa.size()); // size remains 0
  }
}