import java.io.Serializable;
public class myList<T> implements Serializable {
    public T[] list;

    @SuppressWarnings("unchecked")
    public myList() {

        list = (T[]) new Object[0];
    }

    public void add(T t) {
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[list.length + 1];

        // copy everything over to the new array
        System.arraycopy(list, 0, temp, 0, list.length);

        // add the new element
        temp[list.length] = t;
        list = temp;
    }

    public T get(int inx) {
        if (inx < 0 || inx >= list.length) return null;
        return list[inx];
    }

    public void remove(T t) {
        int flag = 0;
        for (T value : list) {
            if (t.equals(value)) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) return;
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) new Object[list.length - 1];
        int rmvInd = -1;
        for (int j = 0; j < list.length; j++) {
            if (list[j].equals(t)) rmvInd = j;
        }
        for (int i = 0; i < list.length; i++) {
            if (i <= rmvInd)
                temp[i] = list[i];
            else
                temp[i - 1] = list[i];
        }
        list = temp;
    }

    public int size() {
        return list.length;
    }
}

