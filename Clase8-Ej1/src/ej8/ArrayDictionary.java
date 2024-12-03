package ej8;

import java.util.Arrays;

public class ArrayDictionary<K, V> implements Dictionary<K, V> {

    private Entry<K, V[]>[] array; // Cada entrada tiene una clave y un arreglo de valores
    private int size; // Cantidad de entradas en el diccionario

    public ArrayDictionary() {
        array = (Entry<K, V[]>[]) new Entrada[100]; // Capacidad inicial del arreglo
        size = 0;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    
    public V[] get(K k) {
  
        for (int i = 0; i < size; i++) {
            if (array[i].getKey().equals(k)) {
            	Object[] arrayAux = new Object[array[i].getValue().length];
            	arrayAux = array[i].getValue();
                return (V[])arrayAux;
            }
        }
        return null; 
    }

    public void put(K k, V v) {
        for (int i = 0; i < size; i++) {
            if (array[i].getKey().equals(k)) {
                V[] values = array[i].getValue();
                for (V existingValue : values) {
                    if (existingValue.equals(v)) {
                        return; // No se permiten valores duplicados
                    }
                }
                values = Arrays.copyOf(values, values.length + 1);
                values[values.length - 1] = v;
                array[i].setValue(values);
                return;
            }
        }
        // Si la clave no existe, creamos una nueva entrada
        if (size < array.length) {
            V[] values = (V[]) new Object[1];
            values[0] = v;
            array[size] = new Entrada<>(k, values);
            size++;
        } else {
            throw new IllegalStateException("El diccionario está lleno");
        }
    }

    public V[] remove(K k) {
        for (int i = 0; i < size; i++) {
            if (array[i].getKey().equals(k)) {
                V[] values = array[i].getValue();
                array[i] = array[size - 1]; // Reemplazamos con el último elemento
                array[size - 1] = null;
                size--;
                return values;
            }
        }
        return null; // Retorna null si no encuentra la clave
    }


    public V remove(K k, V v) {
        for (int i = 0; i < size; i++) {
            if (array[i].getKey().equals(k)) {
                V[] values = array[i].getValue();
                int index = -1;
                for (int j = 0; j < values.length; j++) {
                    if (values[j].equals(v)) {
                        index = j;
                        break;
                    }
                }
                if (index != -1) {
                    // Eliminamos el valor del arreglo
                    V removedValue = values[index];
                    V[] newValues = Arrays.copyOfRange(values, 0, index);
                    newValues = Arrays.copyOf(newValues, values.length - 1);
                    System.arraycopy(values, index + 1, newValues, index, values.length - index - 1);
                    array[i].setValue(newValues);
                    if (newValues.length == 0) {
                        remove(k); // Si el conjunto de valores queda vacío, eliminamos la clave
                    }
                    return removedValue;
                }
            }
        }
        return null; // Si la clave o el valor no existen
    }

    public K[] keys(K k) {
        // Retorna solo las claves asociadas a la entrada `k`
        for (int i = 0; i < size; i++) {
            if (array[i].getKey().equals(k)) {
                K[] result = (K[]) new Object[1];
                result[0] = array[i].getKey();
                return result;
            }
        }
        return null;
    }


    public Entry<K, V[]>[] entries() {
        Entry<K, V[]>[] result = (Entry<K, V[]>[]) new Entrada[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i];
        }
        return result;
    }

}
