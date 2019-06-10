import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

@RunWith(Parameterized.class)

public class DegreeTestCoverage {
	
	//Test the null constructor for year 3
	@Test(expected= IllegalArgumentException.class)
	public void testNullConstructor() {
		List<Grade> year2 = new ArrayList<>();
    	year2.add(new Grade(1));
    	year2.add(new Grade(2));
    	year2.add(new Grade(3));
    	year2.add(new Grade(4));
    	
		ArrayList<Grade> year3 = null;
		new Degree(year2, year3);
	}
	
	//Test the size < 4 constructor in year3
	@Test(expected= IllegalArgumentException.class)
	public void testInavalidSizeOfConstructor() {
		List<Grade> year2 = new ArrayList<>();
    	year2.add(new Grade(5));
    	year2.add(new Grade(5));
    	year2.add(new Grade(5));
    	year2.add(new Grade(5));
    	//just providing 1 instead of 4
    	List<Grade> year3 = new ArrayList<>();
    	year3.add(new Grade(6));
    	
		new Degree(year2, year3);
	}

	//Test Classification
	@Parameters
    public static Collection<Object[]> data() {
		//Test 1 != 1
		List<Grade> year2 = new ArrayList<>();
		year2.add(new Grade(16));
		year2.add(new Grade(16));
		year2.add(new Grade(16));
		year2.add(new Grade(16));
		
		List<Grade> year3 = new ArrayList<>();
		year3.add(new Grade(1));
		year3.add(new Grade(1));
		year3.add(new Grade(1));
		year3.add(new Grade(16));
		
    	// Test classification
    	List<Grade> year2_2 = new ArrayList<>();
    	year2_2.add(new Grade(6));
    	year2_2.add(new Grade(6));
    	year2_2.add(new Grade(6));
    	year2_2.add(new Grade(6));
    	
    	List<Grade> year3_2 = new ArrayList<>();
    	year3_2.add(new Grade(1));
    	year3_2.add(new Grade(1));
    	year3_2.add(new Grade(16));
    	year3_2.add(new Grade(16));
    	
    	// Test classification
    	List<Grade> year2_3 = new ArrayList<>();
    	year2_3.add(new Grade(1));
    	year2_3.add(new Grade(1));
    	year2_3.add(new Grade(1));
    	year2_3.add(new Grade(16));
    	
    	List<Grade> year3_3 = new ArrayList<>();
    	year3_3.add(new Grade(6));
    	year3_3.add(new Grade(16));
    	year3_3.add(new Grade(1));
    	year3_3.add(new Grade(16));
		
		return Arrays.asList(new Object[][] {     
	        { year2, year3, Classification.Discretion}, //1 != 1
	        { year2_2, year3_2, Classification.Discretion},
	        { year2_3, year3_3, Classification.Discretion}
	
		});
}
		@Parameter(0)
		public List<Grade> year2;  //Input grade
		
		@Parameter(1)
		public List<Grade> year3;  //Input grade
		
		@Parameter(2)
		public Classification result;		
		
		@Test 
		public void testTheEqualityForResults() {
			Degree d = new Degree(year2, year3);
			assertEquals(d.classify(), result);
		};

}
