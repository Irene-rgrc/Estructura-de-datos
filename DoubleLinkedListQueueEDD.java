/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cola;

import java.util.Iterator;
import cola.ColaEDD;
import static java.lang.Math.E;
import java.util.NoSuchElementException;
import lista.ListEDD;

/**
 *
 * @author i.rodriguezga.2021
 */
public class DoubleLinkedListQueueEDD<Type> implements ColaEDD<Type>, Iterable<Type>, ListEDD<Type> {

    // La longitud del vector será el número de elementos albergados.
    private final int MAX_ELEM = 5; // tamaño del array fijo, no redimensionable
    private Type cola;
    private int principio; //indice del primer elemento de la cola
    private int fin; //indice ultimo elemento de la cola
    private int longitud;
    
    public DoubleLinkedListQueueEDD() {
        cola = (Type) new Object[MAX_ELEM];
        principio = 0;
        fin = -1;
        longitud = 0;
    }

    @Override
    public boolean isEmpty() {
        return (longitud == 0);
    }
    
    @Override
    public Type front() throws NoSuchElementException  {
        if (isEmpty()){
            throw new NoSuchElementException("Error en front: Cola vacia");
        }
        return cola[principio];
    }

    @Override
    public void insert(Type elem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Type remove() throws NoSuchElementException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
