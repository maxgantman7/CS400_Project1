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
	
	
	public boolean isValid(String key) {
		if (key.length() < 5 || key.length() > 7) {
			for (int i = 0; i < key.length(); i ++) {
				char ch = key.charAt(i);
				if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
					// if the string has any characters that aren't letters or digits
					return false;
				}
			}
			if (!Character.isDigit(key.charAt(0))) {
				if (!Character.isDigit(key.charAt(1))) {
					if (!Character.isDigit(key.charAt(2))) {
						if (!Character.isDigit(key.charAt(3))) {
							if (key.length() == 7 && Character.isDigit(key.charAt(4)) && 
									Character.isDigit(key.charAt(5)) && Character.isDigit(key.charAt(6))) {
								// if the first four characters are non-digits
								// and the next 3 digits are digits
								return true;
							}
							else {
								return false;
							}
						}
						else { // if the fourth character is a digit
							if (key.length() == 6 && Character.isDigit(key.charAt(4)) && 
									Character.isDigit(key.charAt(5))) {
								// if the first three characters are non-digits
								// and the next three are digits
								return true;
							}
							else {
								return false;
							}
						}
					}
					else { // if the third character is a digit
						if (key.length() == 5 && Character.isDigit(key.charAt(3)) && 
								Character.isDigit(key.charAt(4))) {
							// if the first two characters are non-digits
							return true;
						}
						else {
							return false;
						}
					}
				}
				else { // if the second character is a digit
					return false;
				}
			}
			else { // if the first character is a digit
				return false;
			}
		}
		else { // if the length of the key is not between 5 and 7 characters
			return false;
		}
	}
	
	public boolean put(String key, AcademicClass course) {
		if (isValid(key)) {
			return map.put(key, course);
		}
		else {
			return false;
		}
	}
	
	
	public AcademicClass get(String key) throws NoSuchElementException {
		return map.get(key);
	}
	
	public int size() {
		return size;
	}
}
   
   
