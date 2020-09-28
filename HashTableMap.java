// --== CS400 File Header Information ==--
// Name: Aritra Chakraborty
// Email: achakrabor24@wisc.edu
// Team: FD
// TA: Abhay
// Lecturer: Dahl
// Notes to Grader: <optional extra notes>

import java.util.LinkedList;
import java.util.NoSuchElementException;


/**
 *
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {
  /**
   * Creates key-value pairs for LinkedLists.
   * @param <KeyType>
   * @param <ValueType>
   */
  private class KeyValuePair<KeyType, ValueType> {
    private KeyType key;
    private ValueType value;

    /**
     * Initializes a key-value pair.
     * @param key
     * @param value
     */
    KeyValuePair(KeyType key, ValueType value) {
      this.key = key;
      this.value = value;
    }
  }

  private int capacity;
  private double load;
  private int size;
  private LinkedList<KeyValuePair<KeyType, ValueType>>[] hashTable;

  /**
   * Initializes hash table with given capacity and load.
   *
   * @param capacity
   */
  public HashTableMap(int capacity) {
    this.capacity = capacity;
    this.load = 0.8;
    this.size = 0;
    this.hashTable = new LinkedList[this.capacity];
  }

  /**
   * Initializes hash table with default capacity and load.
   */
  public HashTableMap() {
    this.capacity = 10;
    this.load = .8;
    this.size = 0;
    this.hashTable = new LinkedList[this.capacity];
  }


  /**
   * Doubles size of hash table if the load factor exceeds 80%.
   */
  private void rehash() {
    double loadFactor = (double)this.size / this.capacity;
    if (loadFactor < this.load) {
      return;
    }
    this.capacity = (this.capacity * 2);
    LinkedList<KeyValuePair<KeyType, ValueType>>[] newHashTable = new LinkedList[this.capacity];
    for (int i = 0; i < this.hashTable.length; i++) {
      if (hashTable[i] == null) {
        continue;
      }
      LinkedList<KeyValuePair<KeyType, ValueType>> temp = hashTable[i];
      for (KeyValuePair<KeyType, ValueType> kv : temp) {
        putHelper(kv.key, kv.value, newHashTable);
      }
    }
    this.hashTable = newHashTable;
  }


  /**
   * Inserts a key and value into a hash table.
   * @param key
   * @param value
   * @return
   */
  @Override
  public boolean put(KeyType key, ValueType value) {
    // Key already in hash map
    if (containsKey(key) == true) {
      return false;
    }

    // No collisions occur, spot is empty
    putHelper(key, value, this.hashTable);
    this.size++;
    rehash();
    return true;
  }

  /**
   * Helper method to insert a key-value pair.
   *
   * @param key
   * @param value
   * @param table
   */
  private void putHelper(KeyType key, ValueType value, LinkedList<KeyValuePair<KeyType,
      ValueType>>[] table) {
    int index = key.hashCode() % this.capacity;

    if (table[index] == null) {
      table[index] = new LinkedList<>();
    }
    table[index].add(new KeyValuePair(key, value));
  }


  /**
   * Retrieves a value using a specific key from hash table.
   * @param key
   * @return
   * @throws NoSuchElementException if key does not exist
   */
  @Override
  public ValueType get(KeyType key) throws NoSuchElementException {
    // Key does  not exist
    if (containsKey(key) == false) {
      throw new NoSuchElementException("Key is not in the hash map!");
    }

    // Key exists
    int index = key.hashCode() % this.capacity;
    for (int i = 0; i < this.hashTable[index].size(); i++) {
      if (this.hashTable[index].get(i).key.equals(key)) { // if key found
        return this.hashTable[index].get(i).value;  // return the value
      }
    }
    return null;
  }

  /**
   * Gives size of the hash map.
   *
   * @return size
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * Gives current capacity.
   * @return
   */
  public int getCapacity(){
    return this.capacity;
  }

  /**
   * Checks if the hash map has the key.
   *
   * @param key
   * @return true if key found, false otherwise
   */
  @Override
  public boolean containsKey(KeyType key) {
    int index = key.hashCode() % this.capacity;
    LinkedList<KeyValuePair<KeyType,ValueType>> list = this.hashTable[index];
    if(list == null){
      return false;
    }
    for(int i = 0; i < list.size(); i++){
      // present the return true else false.
      if(list.get(i).key.equals(key))
        return true;
    }
    return false;
  }

  /**
   * Removes the key and accompanying value from hash table.
   * @param key
   * @return
   */
  @Override
  public ValueType remove(KeyType key) {
    // Key does not exist
    if (!containsKey(key)) {
      return null;
    }

    ValueType value = get(key);
    int index = key.hashCode() % this.capacity;
    for (int i = 0; i < this.hashTable[index].size(); i++) {
      if (this.hashTable[index].get(i).key.equals(key)) { // if key found
        this.hashTable[index].remove(i);
      }
    }
    return value;
  }

  /**
   * Empties the hash table of elements.
   */
    @Override
    public void clear(){
      this.hashTable = null;
      this.size = 0;
    }


  }

