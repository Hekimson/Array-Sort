// Write a class called ArraySort whose fields and constructor are the same as those of the ArrayBub, ArraySel and ArrayIns classes. Then copy the insert(), display(), swap(), bubbleSort(), selectionSort() and insertionSort() methods from those three classes and paste into the ArraySort class. This class will be essentially the same as those three classes except that it will contain all three sorting methods.

class ArraySort {
    private long[] a; // ref to array a
    private int nElems; // number of data items

    public ArraySort(int max) {
        a = new long[max]; // create the array
        nElems = 0; // no items yet
    }

    public void insert(long value) {
        a[nElems] = value; // insert it
        nElems++; // increment size
    }

    public void display() {
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println("");
    }

    public void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--) // outer loop (backward)
            for (in = 0; in < out; in++) // inner loop (forward)
                if (a[in] > a[in + 1]) // out of order?
                    swap(in, in + 1); // swap them
    }

    public void selectionSort() {
        int out, in, min;
        for (out = 0; out < nElems - 1; out++) // outer loop
        {
            min = out; // minimum
            for (in = out + 1; in < nElems; in++) // inner loop
                if (a[in] < a[min]) // if min greater,
                    min = in; // we have a new min
            swap(out, min); // swap them
        }
    }

    public void insertionSort() {
        // napiyorsun lan
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }
}

