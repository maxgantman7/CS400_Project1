all: run

compile: MapADT.class HashTableMap.class FrontEnd.class AcademicClass.class

run: compile
  java FrontEnd
  
MapADT.class: MApADT.java
  javac HashTableMap.java
  
HashTableMap.class: HashTableMap.java
  javac HashTableMap.java
  
FrontEnd.class: FrontEnd.java
  javac FrontEnd.java

AcademicClass.class: AcademicClass.java
  javac AcademicClass.java

clean: 
  $(RM) *.class
