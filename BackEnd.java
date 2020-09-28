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
	
	
	
	public boolean put(String key, AcademicClass course) {
		if (!map.containsKey(key)) {
			return map.put(key, course);
		}
		else {
			remove(key);
			return map.put(key, course);
		}
	}
	
	
	public AcademicClass get(String key) throws NoSuchElementException {
		return map.get(key);
	}
	
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
   
   
