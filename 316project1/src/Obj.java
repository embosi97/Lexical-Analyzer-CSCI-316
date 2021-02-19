
abstract class Obj
{
	Obj(){
		
	//this is here for testing purposes	
//	System.out.println("The Class "+ "'" + this.getClass().getName() + "'" + 
//			" is a Descendant of " + "'" + this.getClass().getSuperclass().getName() + "'.");
		
	/**Parser's ArrayList is being filled with the name and super class names of an object 
	 * every time the Obj class is invoked.
	 * 
	 * An atomic integer is being incremented to count the number of instances of an Obj.
	 */
	Parser.objNum.getAndIncrement();
	Parser.familylist.add(this.getClass().getName());
	Parser.familylist.add(this.getClass().getSuperclass().getName()); //
	
	}
}
