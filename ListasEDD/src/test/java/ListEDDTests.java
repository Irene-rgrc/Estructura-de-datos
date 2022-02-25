import lista.ArrayListEDD;
import lista.ListEDD;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/** @author marcct */
public class ListEDDTests {

  private ListEDD<String> list;

  public ListEDDTests() {}

  @BeforeAll // Se ejecuta despues de cada test
  public static void setUpClass() throws Exception {}

  @AfterAll
  public static void tearDownClass() throws Exception {}

  @BeforeEach
  public void setUp() throws Exception {
    list = new ArrayListEDD<>();
    System.out.println("Hello");
  }

  @AfterEach
  public void tearDown() throws Exception {}

  @Test
  public void testConstructor() {
    System.out.println("Running testConstructor()");

    System.out.println("A list should be empty when instantiated.");
    System.out.println(list);
    assertEquals(list.size(), 0);
  }

  @Test
  public void testAddElem() {
    System.out.println("Running testAddElem()");

    System.out.println("A list should have one element after calling add.");
    assertTrue(list.add("Hello"));
    assertEquals(list.size(), 1);

    System.out.println("A list should have two elements after calling add twice.");
    assertTrue(list.add("World"));
    assertEquals(list.size(), 2);
  }

  @Test
  public void testGetElem() {
    System.out.println("Running testGetElem()");
    list.add("Hello");
    list.add("World");
    list.add("Lorem");
    list.add("Ipsum");

    System.out.println("A list should add item in order and retrieve them correctly.");
    assertEquals(list.get(0), "Hello");
    assertEquals(list.get(1), "World");
    assertEquals(list.get(2), "Lorem");
    assertEquals(list.get(3), "Ipsum");

    System.out.println(
        "An IndexOutOfBoundsException must be thrown when getting an element at an invalid index.");
    Exception ex =
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> {
              list.get(-1);
            });
    System.out.println(ex.toString());
    ex =
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> {
              list.get(4);
            });
    System.out.println(ex.toString());
  }

  @Test
  public void testAddElemPos() {
    System.out.println("Running testAddElemPos()");

    System.out.println(
        "An exception should be thrown when adding an element at an invalid position.");
    Exception ex =
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> {
              list.add(1, "Hello");
            });
    System.out.println(ex.toString());

    System.out.println("A list should have one element after calling add.");
    assertTrue(list.add("Hello"));
    assertEquals(list.size(), 1);

    System.out.println("A list should have two elements after calling 'add' twice.");
    list.add(0, "World");
    assertEquals(list.size(), 2);

    System.out.println("The inserted items should be appended at the correct position.");
    assertEquals(list.get(0), "World");
    assertEquals(list.get(1), "Hello");

    System.out.println("A list should have three elements after calling 'add' thrice.");
    list.add(1, "Lorem");
    assertEquals(list.size(), 3);

    System.out.println("The inserted items should be appended at the correct position.");
    assertEquals(list.get(0), "World");
    assertEquals(list.get(1), "Lorem");
    assertEquals(list.get(2), "Hello");
  }

  @Test
  public void testClear() {
    System.out.println("Running testClear()");
    list.add("Hello");
    list.add("World");
    list.add("Lorem");
    list.add("Ipsum");
    list.clear();

    System.out.println("A list should not contain any element after calling clear.");
    assertEquals(list.size(), 0);
  }

  @Test
  public void testClone() {
    System.out.println("Running testClone()");
    list.add("Hello");
    list.add("World");
    list.add("Lorem");
    list.add("Ipsum");

    ListEDD<String> newList = list.clone();
    list.clear();

    System.out.println("A list should not contain any element after calling clear.");
    assertEquals(list.size(), 0);

    System.out.println(
        "A cloned list should be equal to the original one, but independent from it.");
    assertEquals(newList.size(), 4);
    assertEquals(newList.get(0), "Hello");
    assertEquals(newList.get(1), "World");
    assertEquals(newList.get(2), "Lorem");
    assertEquals(newList.get(3), "Ipsum");
  }

  @Test
  public void testContain() {
    System.out.println("Running testContain()");
    list.add("Hello");
    list.add("World");

    System.out.println("A list should contain the inserted items.");
    assertTrue(list.contains("Hello"));
    assertTrue(list.contains("World"));

    System.out.println("A list should not contain items that have not been inserted.");
    assertFalse(list.contains("Lorem"));
    assertFalse(list.contains("Ipsum"));
  }

  @Test
  public void testEquals() {
    System.out.println("Running testEquals()");
    list.add("Hello");
    list.add("World");
    list.add("Lorem");
    list.add("Ipsum");

    ListEDD<String> newList = list.clone();
    System.out.println("Two lists containing the same elements should be equal.");
    assertTrue(list.equals(newList));

    list.add("Dolor");
    System.out.println("Two lists containing different number of elements should be different.");
    assertFalse(list.equals(newList));

    newList.add("Sit amet");
    System.out.println("Two lists containing different elements should be different.");
    assertFalse(list.equals(newList));

    list.clear();
    newList.clear();
    System.out.println("Two empty lists should be equal.");
    assertTrue(list.equals(newList));
  }

  @Test
  public void testIndexOf() {
    System.out.println("Running testIndexOf()");
    list.add("Hello");
    list.add("World");
    list.add("Lorem");
    list.add("Ipsum");

    System.out.println("A list should add item in order and retrieve them correctly.");
    assertEquals(list.indexOf("Hello"), 0);
    assertEquals(list.indexOf("World"), 1);
    assertEquals(list.indexOf("Lorem"), 2);
    assertEquals(list.indexOf("Ipsum"), 3);

    System.out.println("A list should not contain items that have not been inserted.");
    assertEquals(list.indexOf("Dolor"), -1);
    assertEquals(list.indexOf("Sit amet"), -1);
  }

  @Test
  public void testIsEmpty() {
    System.out.println("Running testIsEmpty()");

    System.out.println("A list should be empty when instantiated.");
    assertTrue(list.isEmpty());

    System.out.println("A list should not be empty after inserting elements.");
    list.add("Hello");
    list.add("World");
    list.add("Lorem");
    list.add("Ipsum");
    assertFalse(list.isEmpty());

    System.out.println("A list should be empty after a clear.");
    list.clear();
    assertTrue(list.isEmpty());
  }

  @Test
  public void testRemove() {
    System.out.println("Running testRemove()");
    list.add("Hello");
    list.add("World");
    list.add("Lorem");
    list.add("Ipsum");

    System.out.println(
        "An exception should be thrown when removing an element at an invalid position.");
    Exception ex =
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> {
              list.remove(-1);
            });
    System.out.println(ex.toString());
    ex =
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> {
              list.remove(4);
            });
    System.out.println(ex.toString());

    System.out.println("After removing an element from a list, the rest should remain.");
    list.remove(1);
    assertEquals(list.size(), 3);
    assertEquals(list.get(0), "Hello");
    assertEquals(list.get(1), "Lorem");
    assertEquals(list.get(2), "Ipsum");
  }

  @Test
  public void testRemoveElem() {
    System.out.println("Running testRemoveElem()");
    list.add("Hello");
    list.add("World");
    list.add("Lorem");
    list.add("Ipsum");

    System.out.println("It should not be possible to remove a nonexistent element.");
    assertFalse(list.removeElem("Dolor"));
    assertFalse(list.removeElem("Sit amet"));

    System.out.println("After removing an element from a list, the rest should remain.");
    assertTrue(list.removeElem("World"));
    assertEquals(list.size(), 3);
    assertEquals(list.get(0), "Hello");
    assertEquals(list.get(1), "Lorem");
    assertEquals(list.get(2), "Ipsum");
  }

  @Test
  public void testSet() {
    System.out.println("Running testSet()");
    list.add("Hello");
    list.add("World");
    list.add("Lorem");
    list.add("Ipsum");

    System.out.println(
        "An exception should be thrown when setting an element at an invalid position.");
    Exception ex =
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> {
              list.remove(-1);
            });
    System.out.println(ex.toString());
    ex =
        assertThrows(
            IndexOutOfBoundsException.class,
            () -> {
              list.remove(4);
            });
    System.out.println(ex.toString());

    System.out.println(
        "Setting an element should return the original one and the rest should remain the same.");
    assertEquals(list.set(1, "Dolor"), "World");
    assertEquals(list.size(), 4);
    assertEquals(list.get(0), "Hello");
    assertEquals(list.get(1), "Dolor");
    assertEquals(list.get(2), "Lorem");
    assertEquals(list.get(3), "Ipsum");
  }
}
