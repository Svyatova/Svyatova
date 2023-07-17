public class MyArrayList<T> {
    private final int INIT_SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[INIT_SIZE];
    private int pointer = 0;

    public void add(T item) {
        array[pointer++] = item;

            if(pointer == array.length-1)
                resize(array.length*2);
            array[pointer++] = item;
        }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
    public T get(int index) {
        return (T) array[index];
    }
    public int size() {
        return pointer;
    }
    public void remove(int index) {
        for (int i = index; i<pointer; i++)
            array[i] = array[i+1];
        array[pointer] = null;
        pointer--;
        if (array.length > INIT_SIZE && pointer < array.length /
                CUT_RATE)
            resize(array.length/2); // если элементов в CUT_RATE размер меньше чем длина массива, то уменьшу в два раза
    }
}
