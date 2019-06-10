import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

@RunWith(Parameterized.class)
public class GradeTest {

	// Test the invalid range for the Grade constructor = below
	@Test(expected= IllegalArgumentException.class)
	public void testOutOfBoundaries1() {
		new Grade(-2);
	}
	// Test the invalid range for the Grade constructor = above
	@Test(expected= IllegalArgumentException.class)
	public void testOutOfBoundaries2() {
		new Grade(25);
	}
	
	// Test for a valid input, checking that getPoints returns the right value
	@Test
	public void getPoints() {
		Grade p = new Grade(5);
		assertEquals(p.getPoints(), 5);
	}
	
	// Test for classify - Fail
	@Test
	public void testFail() {
		Grade p = new Grade(17);
		assertEquals(p.classify(), Classification.Fail);
	}
	// Test for classify - Third
	@Test
	public void testThird() {
		Grade p = new Grade(14);
		assertEquals(p.classify(), Classification.Third);
	}
	// Test for classify - Lower Second
	@Test
	public void testLowerSecond() {
		Grade p = new Grade(11);
		assertEquals(p.classify(), Classification.LowerSecond);
	}
	// Test for classify - Upper Second
	@Test
	public void testUpperSecond() {
		Grade p = new Grade(7);
		assertEquals(p.classify(), Classification.UpperSecond);
	}	
	// Test for classify - First
	@Test
	public void testFirst() {
		Grade p = new Grade(4);
		assertEquals(p.classify(), Classification.First);
	}	
	
	// Test the valid range for fromPercentage = below
	@Test(expected= IllegalArgumentException.class)
	public void testOutOfBoundaries3() {
		Grade.fromPercentage(-6);
	}
	// Test the valid range for fromPercentage = above
	@Test(expected= IllegalArgumentException.class)
	public void testOutOfBoundaries4() {
		Grade.fromPercentage(120);
	}	
	
	// Test for fromPercentage
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {     
                 {-1, 20}, // Grade 20
                 {20, 19}, // Grade 19
                 {32, 18}, // Grade 18
                 {37, 17}, // Grade 17
                 {40, 16}, // Grade 16
                 {43, 15}, // Grade 15
                 {45, 14}, // Grade 14
                 {48, 13}, // Grade 13
                 {50, 12}, // Grade 12
                 {53, 11}, // Grade 11
                 {55, 10}, // Grade 10
                 {58, 9},  // Grade 9
                 {60, 8},  // Grade 8
                 {63, 7},  // Grade 7
                 {65, 6},  // Grade 6
                 {68, 5},  // Grade 5
                 {71, 4},  // Grade 4
                 {73, 3},  // Grade 3
                 {77, 2},  // Grade 2
                 {80, 1}   // Grade 1            
        });
    }
    
    @Parameter(0)
    public int input;  //Input grade in percentage

    @Parameter(1)
    public int grade;		

    @Test 
    public void testTheEqualityForResults() {
    	Grade p = Grade.fromPercentage(input);
    	assertEquals(p.getPoints(), grade);
    };
    
}