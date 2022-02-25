package lista;

import java.util.Iterator;

public class ArrayListEDD<Tipo> implements ListEDD<Tipo> {
  private Object[] elements;

  public ArrayListEDD() {
    elements = new Object[0];
  }

  /**
   * Appends elem to the end of this list.
   *
   * @param elem The element to append.
   * @return Whether it was able to append the element.
   */
  @Override // Etiqueta que especifica la fdunción eclarada en la interfaz
  public boolean add(Tipo elem) {
    final int CURR_NUM_ELEMS = elements.length;

    Object[] tmp = elements;
    elements = new Object[CURR_NUM_ELEMS + 1];

    for (int i = 0; i < CURR_NUM_ELEMS; ++i) {
      elements[i] = tmp[i];
    }
    elements[CURR_NUM_ELEMS] = elem;

    return true;
  }

  /**
   * Inserts elem at the specified position pos in the list.
   *
   * @param pos The position where elem will be appended.
   * @param elem The element to append.
   * @throws IndexOutOfBoundsException if pos is a position out of the range of this list.
   */
  @Override
  public void add(int pos, Tipo elem) throws IndexOutOfBoundsException {
    final int CURR_NUM_ELEMS = elements.length;

    if (pos < 0 || pos > CURR_NUM_ELEMS) throw new IndexOutOfBoundsException();

    Object[] tmp = elements;
    elements = new Object[CURR_NUM_ELEMS + 1];

    for (int i = 0; i < pos; ++i) {
      elements[i] = tmp[i];
    }
    elements[pos] = elem;
    for (int i = pos + 1; i <= CURR_NUM_ELEMS; ++i) {
      elements[i] = tmp[i - 1];
    }
  } 

// Vamos a hacer un array con lenght 0 para no estar todo el rato redimensionandolo gastando tiempo. tal que 
  /*
int longuitud 
Object elements[]

elements = new Object[5] (siendo 5 la capacidad inicial)
longitud = 0;

add{
  if (longuitud < capacidad){
    elements[longuitud] = elements;
    ++longitud;
  } else{
    OBject[]tmp = elemntes
    elements = new Object[tmp.length*2]
  }
}
*/

  /** Removes all elements from this list. */
  @Override
  public void clear() {
    elements = new Object[0];
  }

  /** @return A new List equal to this list. */
  @Override
  public ListEDD<Tipo> clone() {
    ListEDD<Tipo> list = new ArrayListEDD<>();
    for (Object o : elements) {
      list.add((Tipo) o);
    }
    return list;
  }

  /**
   * Returns whether this list contains elem.
   *
   * @param elem The element to find.
   * @return Whether this list contains elem.
   */
  @Override
  public boolean contains(Object elem) {
    for (Object o : elements) {
      if (o.equals(elem)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Compares this list against the provided list.
   *
   * @param list The list to compare against.
   * @return Whether both lists are equals.
   */
  @Override
  public boolean equals(ListEDD<Tipo> list) {
    if (elements.length != list.size()) {
      return false;
    }
    for (int i = 0; i < elements.length; ++i) {
      if (!elements[i].equals(list.get(i))) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns the element at pos.
   *
   * @param pos The position of the element to find.
   * @return The element at pos.
   * @throws IndexOutOfBoundsException if pos is a position out of the range of this list.
   */
  @Override
  public Tipo get(int pos) throws IndexOutOfBoundsException {
    if (pos < 0 || pos >= elements.length) {
      throw new IndexOutOfBoundsException();
    } else {
      return (Tipo) elements[pos];
    }
  }

  /**
   * Returns the index of the first occurrence of elem.
   *
   * @param elem The element to find.
   * @return The index of the first occurrence of elem or -1 if not present.
   */
  @Override
  public int indexOf(Tipo elem) {
    for (int i = 0; i < elements.length; ++i) {
      if (elements[i].equals(elem)) {
        return i;
      }
    }
    return -1;
  }

  /** @return Whether the list is empty; */
  @Override
  public boolean isEmpty() {
    return elements.length == 0;
  }

  /** @return An iterator over the elements in this list; */
  @Override
  public Iterator iterator() {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from
    // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  }

  /**
   * Removes the element at pos.
   *
   * @param pos The position of the element to remove.
   * @return The removed element.
   * @throws IndexOutOfBoundsException if pos is a position out of the range of this list.
   */
  @Override
  public Tipo remove(int pos) throws IndexOutOfBoundsException { // Remueve por posicion
    final int CURR_NUM_ELEMS = elements.length;

    if (pos < 0 || pos >= CURR_NUM_ELEMS) {
      throw new IndexOutOfBoundsException();
    }

    Object[] tmp = elements;
    elements = new Object[CURR_NUM_ELEMS - 1];

    for (int i = 0; i < pos; ++i) {
      elements[i] = tmp[i];
    }

    for (int i = pos + 1; i < CURR_NUM_ELEMS; ++i) {
      elements[i - 1] = tmp[i];
    }

    return (Tipo) tmp[pos];
  }

  /**
   * Removes the first occurrence of elem.
   *
   * @param elem The element to remove.
   * @return Whether any element was removed.
   */
  @Override
  public boolean removeElem(Tipo elem) {  // Remueve por elemento
    int index = indexOf(elem);
    if (index == -1) {
      return false;
    } else {
      remove(index);
    }

    return true;
  }

  /**
   * Replaces the element at pos by elem.
   *
   * @param pos The position of the element to replace.
   * @param elem The new element to store.
   * @return The previous stored element.
   * @throws IndexOutOfBoundsException if pos is a position out of the range of this list.
   */
  @Override
  public Tipo set(int pos, Tipo elem) throws IndexOutOfBoundsException {
    if (pos < 0 || pos >= elements.length) {
      throw new IndexOutOfBoundsException();
    }
    Tipo tmp = (Tipo) elements[pos];
    elements[pos] = elem;
    return tmp;
  }

  /** @return The number of elements in this list. */
  @Override
  public int size() {
    return elements.length;
  }
}
