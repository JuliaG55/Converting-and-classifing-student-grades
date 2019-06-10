import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

@RunWith(Parameterized.class)

public class DegreeTest {

	//Test the null constructor == year2
	@Test(expected= IllegalArgumentException.class)
	public void testNullConstructor() {
		ArrayList<Grade> year2 = null;
		new Degree(year2, year3);
	}
	//Test the size < 4 constructor == just providing 1 instead of 4
	@Test(expected= IllegalArgumentException.class)
	public void testInavalidSizeOfConstructor() {
		List<Grade> year2 = new ArrayList<>();
    	year2.add(new Grade(5));
    	List<Grade> year3 = new ArrayList<>();
    	year3.add(new Grade(6));
    	
		new Degree(year2, year3);
	}
	
	//Test if it contains fail in Degree constructor
	@Test(expected= IllegalArgumentException.class)
	public void testContainsFails() {
		List<Grade> year2 = new ArrayList<>();
    	year2.add(new Grade(17));
    	List<Grade> year3 = new ArrayList<>();
    	year3.add(new Grade(20));
    	
    	new Degree(year2, year3);

	}
	
	
	//Test Classification
	@Parameters
    public static Collection<Object[]> data() {
    	
    	// Test for UpperSecond with First
    	List<Grade> year2 = new ArrayList<>();
    	year2.add(new Grade(6));
    	year2.add(new Grade(6));
    	year2.add(new Grade(6));
    	year2.add(new Grade(6));
    	
    	List<Grade> year3 = new ArrayList<>();
    	year3.add(new Grade(1));
    	year3.add(new Grade(2));
    	year3.add(new Grade(3));
    	year3.add(new Grade(6));
    	
    	// Test for UpperSecond with LowerSecond
    	List<Grade> year2_2 = new ArrayList<>();
    	year2_2.add(new Grade(5));
    	year2_2.add(new Grade(6));
    	year2_2.add(new Grade(7));
    	year2_2.add(new Grade(8));
    	
    	List<Grade> year3_2 = new ArrayList<>();
    	year3_2.add(new Grade(10));
    	year3_2.add(new Grade(12));
    	year3_2.add(new Grade(11));
    	year3_2.add(new Grade(8));
    	
    	// Test for LowerSecond with Third
    	List<Grade> year2_3 = new ArrayList<>();
    	year2_3.add(new Grade(9));
    	year2_3.add(new Grade(10));
    	year2_3.add(new Grade(11));
    	year2_3.add(new Grade(12));
    	
    	List<Grade> year3_3 = new ArrayList<>();
    	year3_3.add(new Grade(13));
    	year3_3.add(new Grade(14));
    	year3_3.add(new Grade(15));
    	year3_3.add(new Grade(9));
    	
    	// Test for Third only
    	List<Grade> year2_4 = new ArrayList<>();
    	year2_4.add(new Grade(13));
    	year2_4.add(new Grade(14));
    	year2_4.add(new Grade(15));
    	year2_4.add(new Grade(16));
    	
    	List<Grade> year3_4 = new ArrayList<>();
    	year3_4.add(new Grade(13));
    	year3_4.add(new Grade(14));
    	year3_4.add(new Grade(15));
    	year3_4.add(new Grade(16));
    	
    	//Test for borderline
    	List<Grade> year2_borderline = new ArrayList<>();
    	year2_borderline.add(new Grade(10));
    	year2_borderline.add(new Grade(10));
    	year2_borderline.add(new Grade(10));
    	year2_borderline.add(new Grade(10));
    	
    	List<Grade> year3_borderline = new ArrayList<>();
    	year3_borderline.add(new Grade(1));
    	year3_borderline.add(new Grade(1));
    	year3_borderline.add(new Grade(16));
    	year3_borderline.add(new Grade(16));
    	

    	
        return Arrays.asList(new Object[][] {     
                 { year2, year3, Classification.First }, //1 == 1
                 { year2_2, year3_2, Classification.UpperSecond}, //2:1, 2:2
                 { year2_3, year3_3, Classification.LowerSecond}, //2:2, 3
                 { year2_4, year3_4, Classification.Third}, //3, 3
                 { year2_borderline, year3_borderline, Classification.Discretion},

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