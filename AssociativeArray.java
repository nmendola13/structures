import static java.lang.reflect.Array.newInstance;

/**
 * A basic implementation of Associative Arrays with keys of type K
 * and values of type V. Associative Arrays store key/value pairs
 * and permit you to look up values by key.
 *
 * @author Noah Mendola
 * @author Samuel A. Rebelsky
 */
public class AssociativeArray<K, V> {
    // +-----------+---------------------------------------------------
    // | Constants |
    // +-----------+

    /**
     * The default capacity of the initial array.
     */
    static final int DEFAULT_CAPACITY = 16;

    // +--------+------------------------------------------------------
    // | Fields |
    // +--------+

    /**
     * The size of the associative array (the number of key/value pairs).
     */
    int size;

    /**
     * The array of key/value pairs.
     */
    KVPair<K, V> pairs[];

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a new, empty associative array.
     */
    @SuppressWarnings({"unchecked"})
    public AssociativeArray() {
        // Creating new arrays is sometimes a PITN.
        this.pairs = (KVPair<K, V>[]) newInstance((new KVPair<K, V>()).getClass(),
                DEFAULT_CAPACITY);
        this.size = 0;
    } // AssociativeArray()

    // +------------------+--------------------------------------------
    // | Standard Methods |
    // +------------------+

    /**
     * Create a copy of this AssociativeArray.
     */
    public AssociativeArray<K, V> clone() {
        return null; // STUB
    } // clone()

    /**
     * Convert the array to a string.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }

        StringBuilder arr2str = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            arr2str.append(pairs[i]).append(", ");
        }
        arr2str.append(pairs[size - 1]).append("}");
        return arr2str.toString();
    } // toString()

    // +----------------+----------------------------------------------
    // | Public Methods |
    // +----------------+

    /**
     * Set the value associated with key to value. Future calls to
     * get(key) will return value.
     */
    public void set(K key, V value) {
        int index = locate(key);
        if (index != -1) {
            pairs[index].value = value;
        } else {
            if (size == pairs.length) {
                expand();
            }
            pairs[size++] = new KVPair<>(key, value);
        }
    }

    /**
     * Get the value associated with key.
     *
     * @throws KeyNotFoundException
     *                              when the key does not appear in the associative
     *                              array.
     */

    //helper method for get
    private int locate(K key) {
        for (int i = 0; i < size; i++) {
            if (this.pairs[i].key.equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public V get(K key) throws KeyNotFoundException {
        int index = locate(key);
        if (index == -1) {
            throw new KeyNotFoundException();
        }
        return this.pairs[index].value;
    }
    // get(K)

    /**
     * Determine if key appears in the associative array.
     */
    public boolean hasKey(K key) {
        return locate(key) != -1;
    } // hasKey(K)

  /**
   * Remove the key/value pair associated with a key. Future calls
   * to get(key) will throw an exception. If the key does not appear
   * in the associative array, does nothing.
   */
    public void remove(K key) {
        int index = locate(key);
        if (index != -1) {
            this.pairs[index] = this.pairs[this.size-1];
            this.size--;
        }
    }

  /**
   * Determine how many values are in the associative array.
   */
    public int size() {
        return this.size;
    } // size()

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Expand the underlying array.
   */
    public void expand() {
        this.pairs = java.util.Arrays.copyOf(this.pairs, this.pairs.length * 2);
    } // expand()
} // class AssociativeArray
