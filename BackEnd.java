/**
* Class used to help interface front end with hash table mapping
*/
public class BackEnd {
	HashTableMap<String, AcademicClass> map = new HashTableMap<String, AcademicClass>();
	
	
	/*
	 * Puts the academic class into the hash table
	 * @param key - key value to be put in hash table
	 * @param course - AcademicClass to be put in hash table
	 * @return true if the class is successfully put into the table, false otherwise
	 */
	public boolean put(String key, AcademicClass course) {
		if (!map.containsKey(key)) {
			// if the key is not in the hash table
			return map.put(key, course);
		}
		else {
			// if the key is already in the hash table, then the old data for the class with that 
			// key is replaced with the new data
			remove(key);
			return map.put(key, course);
		}
	}
	
	/*
	 * Returns the academic class that has the specified key
	 * @param key - key to look for
	 * @return the academic class with the specified key
	 * @throws NoSuchElementException if the key does not exist
	 */
	public AcademicClass get(String key) throws NoSuchElementException {
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
	* Communicates if the key argument is contained in the hash table
	* @param key - key to look for
	* @return true if the key is in the hash table
	*/
	public boolean containsKey(String key) {
		return map.containsKey(key);
	}
	
	/*
	* Removes data in the HashTable associated with the key argument
	* @param key - key associated with data to be removed
	* @return the AcademicClass associated with the key
	*/
	public AcademicClass remove(String key) {
		return map.remove(key);
	}
	
	/*
	* Clears the HashTable
	*/
	public void clear() {
		map.clear();
	}
}
   
   
