import java.util.NoSuchElementException;

/**
 * remember note from TA:
 * (Back End developer): What if the user inputs duplicate data
 * (for the same key i.e class)?  Shouldn't it overwrite the old
 * values (probably we want to update to the latest semester data)
 * Note: This differs from the HashTable implementation part, where
 * you have been asked to retain the old values itself if the key
 * already exists in the HashTable.
 */

public class BackEnd {

  private int size;
  private HashTableMap<String, AcademicClass> map;

  // Back end constructor
  public BackEnd(){
    this.map = new HashTableMap<String, AcademicClass>();
    this.size = 0;
  }

  /*
	 * Puts the academic class into the hash table
	 * @return true if the class is successfully put into the table, false otherwise
	 */
  public boolean put(String key, AcademicClass course) {
    // did this based on the TA note at the top, not sure if this is what he meant
    if (!map.containsKey(key)) {
      this.size++;
      return map.put(key, course);
    }
    else {
      remove(key);
      this.size--;
      return map.put(key, course);
    }
  }


  /*
	 * Returns the academic class that has the specified key
	 * @return the academic class with the specified key
	 * @throws NoSuchElementException if the key does not exist
	 */
  public AcademicClass get(String key) throws NoSuchElementException{
    return map.get(key);
  }

  /*
	 * Returns the size of the hash table
	 * @return the size of the hash table
	 */
  public int size() {
    return size;
  }

  /*
	 * Tells whether or not the hash table contains the specified key
	 * 
	 * @return true if the table contains the key, false otherwise
	 */
	public boolean containsKey(String key) {
		return map.containsKey(key);
	}

	/*
	 * Removes the academic class with the specified key from the hash table
	 * 
	 * @return the AcademicClass that was removed
	 */
	public AcademicClass remove(String key) {
		return map.remove(key);
	}

	/*
	 * Gets rid of all items in the hash table and resets the size to zero
	 */
	public void clear() {
		map.clear();
		this.size = 0;
	}
}
   
