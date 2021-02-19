import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/** An object class that allows for the creation of objects (objectClass objects)
 *  that contain a string "classname" (the name of the class/super class) and 
 *  an integer "frequency" (the number of instances of a class within the data structure
 *  I devised in the Parser class (familyList).
 *  
 *  The setArg2 function creates an ArrayList of these objectClass objects which is then sorted
 *  by the frequency and printed onto text file (provided by argsv[2]), thanks to these modified compareTo
 *  and toString function in the objectClass class. setArg2 is called in Parser.main. 
 *  
 *  The Collections package is used to sort and find the frequency of classes within Parser's data structure.
**/

public class objectClass implements Comparable {
    private String classname;
    private int frequency;

    public objectClass(String classname, int frequency) {
         this.classname = classname;
         this.frequency = frequency;
    }

    public String getClassname() {
         return classname;
    }
    
    //necessary getters and setters
    public int getFrequency() {
	return frequency;
    }
    
    //modified compareTo
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		int freqDif = ((objectClass)o).getFrequency();
		return freqDif - frequency;
	}
	
	//modified toString
	@Override
	public String toString() {
		return "" + frequency + " objects of class " + classname + "";
	}
	
public static void setArg2(ArrayList<String> array, String argv) throws IOException {
	
		//turns the second argument into a file object
		File file = new File(argv);
		
		//the file is now able to be written into
		FileWriter arg2write = new FileWriter(file);
		
		//array of class names that will be used for the objectList ArrayList
		String[] classes = {"Assignment", "AssignmentList", "Int", "Id", 
				"Primary", "Term", "E", "DivTerm", "SingleTerm", "SubE", "MulTerm", 
				"Floatp", "SinglePrimary", "AddE", "Parenthesized", "MultipleAssignment"};		
		
		//variables that are assigned the frequency of classes within the parameterized ArrayList
		int countA = Collections.frequency(array, "Assignment");
		int countAL = Collections.frequency(array, "AssignmentList");
		int countI = Collections.frequency(array, "Int");
		int countID = Collections.frequency(array, "Id");
		int countP = Collections.frequency(array, "Primary");
		int countT = Collections.frequency(array, "Term");
		int countE = Collections.frequency(array, "E");
		int countDiv = Collections.frequency(array, "DivTerm");
		int countSingleT = Collections.frequency(array, "SingleTerm");
		int countSubE = Collections.frequency(array, "SubE");
		int countMulTerm = Collections.frequency(array, "MulTerm");
		int countFloat = Collections.frequency(array, "Floatp");
		int countSinglePrim = Collections.frequency(array, "SinglePrimary");
		int countAddE = Collections.frequency(array, "AddE");
		int countParenthesized = Collections.frequency(array, "Parenthesized");
		int countMultAssign = Collections.frequency(array, "MultipleAssignment");
		
		//another array that contains all the frequencies
		int[] counters = {countA, countAL, countI, countID, countP, countT,
				countE, countDiv, countSingleT, countSubE, countMulTerm, 
				countFloat, countSinglePrim, countAddE, countParenthesized, countMultAssign};
		System.out.println(Parser.objNum + " objects of Class Obj ");
		arg2write.write(Parser.objNum + " objects of Class Obj " + '\n');
		
		//the aforementioned ArrayList that will store all the objectClass objects with frequencies > 0
		ArrayList<objectClass> objectlist = new ArrayList<objectClass>();
		
			for(int j = 0; j < counters.length; j++) {
				if(counters[j] != 0) {
					objectlist.add(new objectClass(classes[j], counters[j]));
				}
			}
			
			//the list is sorted by frequency and written onto a file line-by-line
			Collections.sort(objectlist);
			
				for(int a = 0; a < objectlist.size(); a++){
					System.out.println(objectlist.get(a));
					arg2write.write(objectlist.get(a).toString() + '\n');
			   }
		//the filewriter can now be closed
		arg2write.close();
		}
	}