package csc207.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Tests of the assosiative array methods.
 * @author Noah
 */
public class Tests {
  /**
   * A test that should succeed.
   */
  public void NoahTest1() {
  AssociativeArray<String, Integer> aa = new AssociativeArray<>();
  aa.set("apples", 5);
  aa.set("bananas", 3);
  
  assertEquals(2, aa.size());
}

public void NoahTest2() {
  AssociativeArray<String, Integer> aa = new AssociativeArray<>();

  aa.set("apples", 5);
  aa.set("bananas", 3);
  aa.remove("apples");
  
  assertEquals(1, aa.size());
}

public void NoahEdge1() {
  AssociativeArray<String, Integer> aa = new AssociativeArray<>();

  aa.remove("oranges"); // remove non-existent key
  
  assertEquals(0, aa.size()); // size should remain 0
}
}