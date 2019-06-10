import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

@RunWith(Parameterized.class)
public class ProfileTest {
	
	//Test if the list is not empty
	@Test(expected= IllegalArgumentException.class)
	public void testListIsNotEmpty() {
		ArrayList<Grade> l = new ArrayList<>();
		new Profile(l);
	}
	
	//Test if is null
	@Test(expected= IllegalArgumentException.class)
	public void testNull() {
		ArrayList<Grade> l = null;
		new Profile(l);
	}
	
	//Test that the profile contain at least one fail grade
	@Test(expected= IllegalArgumentException.class)
	public void testFailGrades() {
		ArrayList<Grade> l = new ArrayList<>();
		l.add(new Grade(17));  // 17 = is a Fail grade
		l.add(new Grade(8));
		l.add(new Grade(1));
		l.add(new Grade(9));
		new Profile(l);	
	}
	

	//Test Classification First
	@Test
	public void testFirst() {
		ArrayList<Grade> l = new ArrayList<>();
		l.add(new Grade(1));
		l.add(new Grade(2));
		l.add(new Grade(3));
		l.add(new Grade(4));
		Profile p = new Profile(l);
		assertEquals(p.classify(), Classification.First);
	}
	
	//Test Classification UpperSecond
	@Test
	public void testUpperSecond() {
		ArrayList<Grade> l = new ArrayList<>();
		l.add(new Grade(5));
		l.add(new Grade(6));
		l.add(new Grade(7));
		l.add(new Grade(8));
		Profile p = new Profile(l);
		assertEquals(p.classify(), Classification.UpperSecond);
	}
	
	//Test Classification LowerSecond
	@Test
	public void testLowerSecond() {
		ArrayList<Grade> l = new ArrayList<>();
		l.add(new Grade(9));
		l.add(new Grade(10));
		l.add(new Grade(11));
		l.add(new Grade(12));
		Profile p = new Profile(l);
		assertEquals(p.classify(), Classification.LowerSecond);
	}
	
	//Test Classification Third
	@Test
	public void testThird() {
		ArrayList<Grade> l = new ArrayList<>();
		l.add(new Grade(13));
		l.add(new Grade(14));
		l.add(new Grade(15));
		l.add(new Grade(16));
		Profile p = new Profile(l);
		assertEquals(p.classify(), Classification.Third);
	}
	
	//Test for clear and for borderline
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {1, 1, 6, 4, true},     // is clear
                 {1, 1, 16, 16, false},   // borderline
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
