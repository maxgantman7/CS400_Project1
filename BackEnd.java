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
	
	int size;
	HashTableMap<String, AcademicClass> map = new HashTableMap<String, AcademicClass>();
	
	
	/*
	 * Puts the academic class into the hash table
	 * @return true if the class is successfully put into the table, false otherwise
	 */
	public boolean put(String key, AcademicClass course) {
		if (!map.containsKey(key)) {
			return map.put(key, course);
		}
		else {
			remove(key);
			return map.put(key, course);
		}
	}
	
	/*
	 * Returns the academic class that has the specified key
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
	
	public boolean containsKey(String key) {
		return map.containsKey(key);
	}
	
	public AcademicClass remove(String key) {
		return map.remove(key);
	}
	
	public void clear() {
		map.clear();
	}
}
   
   
