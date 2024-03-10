

class ArraySort {
    private long[] a; // ref to array a
    private int nElems; // number of data items

    //--------------------------------------------------------------
    public ArraySort(int max) // constructor
    {
        a = new long[max]; // create the array
        nElems = 0; // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value) // put element into array
    {
        a[nElems] = value; // insert it
        nElems++; // increment size
    }

    //--------------------------------------------------------------
    public void display() // displays array contents
    {
        for (int j = 0; j < nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println("");
    }

    //--------------------------------------------------------------
    public void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    //--------------------------------------------------------------
    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--) // outer loop (backward)
            for (in = 0; in < out; in++) // inner loop (forward)
                if (a[in] > a[in + 1]) // out of order?
                    swap(in, in + 1); // swap them
    }

    //--------------------------------------------------------------
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

    //--------------------------------------------------------------
    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) // out is dividing line
        {
            long temp = a[out]; // remove marked item
            in = out; // start shifts at out
            while (in > 0 && a[in - 1] >= temp) // until one is smaller,
            {
                a[in] = a[in - 1]; //


                if (a[in - 1] == temp) {
                    a[in - 1] = -1;
                    nElems--;
                }

                in--; // go left one position

            }

            a[in] = temp; // insert marked item

        }
    }

    //--------------------------------------------------------------
    public void oddEvenSort() {
        int out, in;
        for (out = 0; out < nElems - 1; out++) // outer loop
        {
            for (in = 0; in < nElems - 1; in += 2) // inner loop
            {
                if (a[in] > a[in + 1]) // out of order?
                {
                    swap(in, in + 1); // swap them
                }
            }
            for (in = 1; in < nElems - 1; in += 2) // inner loop
            {
                if (a[in] > a[in + 1]) // out of order?
                {
                    swap(in, in + 1); // swap them
                }
            }
        }
    }

    //--------------------------------------------------------------
} // end class ArraySort



class Main {
    public static void main(String[] args) {
        int maxSize = 100; // array size
        ArraySort arr; // reference to array
        arr = new ArraySort(maxSize); // create the array

        arr.insert(77); // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display(); // display items

        arr.bubbleSort(); // bubble sort them
        arr.display(); // display them again

        arr.insertionSort(); // insertion sort them
        arr.display(); // display them again

        arr.selectionSort(); // selection sort them
        arr.display(); // display them again

        arr.oddEvenSort(); // oddEven sort them
        arr.display(); // display them again
    }
}
