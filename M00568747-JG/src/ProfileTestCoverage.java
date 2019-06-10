import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

@RunWith(Parameterized.class)
public class ProfileTestCoverage {


	//Test Classification
	@Test
	public void testFirstStill() {
		ArrayList<Grade> l = new ArrayList<>();
		l.add(new Grade(1));
		l.add(new Grade(1));
		l.add(new Grade(16));
		l.add(new Grade(16));
		Profile p = new Profile(l);
		assertEquals(p.classify(), Classification.First);
	}
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {10, 10, 16, 16, true},   // automatically true because lower than upper second
                 {6, 6, 16, 16, false},   // clear but with upper second        
        });
    }
    
    @Parameter(0)
    public int grade1;

    @Parameter(1)
    public int grade2;
    
    @Parameter(2)
    public int grade3;

    @Parameter(3)
    public int grade4;
    
    @Parameter(4)
    public boolean result;

    @Test 
    public void testIsClear() {
    	ArrayList<Grade> grade = new ArrayList<>();
    	grade.add(new Grade(grade1));
    	grade.add(new Grade(grade2));
    	grade.add(new Grade(grade3));
    	grade.add(new Grade(grade4));
    	Profile p = new Profile(grade);
    	assertEquals(p.isClear(), result);
        
    };
	
	
}
