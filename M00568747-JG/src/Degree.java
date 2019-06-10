import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Degree {
	//Your additions/changes below this line

	Profile p5, p6; //Create a profile 5 and profile 6
	
	private final Map<Classification, Integer> classMap = new HashMap<Classification, Integer>() {{
		put(Classification.First, 0);
		put(Classification.UpperSecond, 1);
		put(Classification.LowerSecond, 2);
		put(Classification.Third, 3);
	}};

	public Degree(List<Grade> year2, List<Grade> year3) {
		if(year2 == null || year2.size() !=4 || year3 == null || year3.size() !=4) {
			throw new IllegalArgumentException();
		} else {
			p6 = new Profile(year3);
			year2.addAll(year3); 
			p5= new Profile(year2);
		}
	}	
	
	public Classification classify() {
		if(p5.classify().equals(p6.classify())) {
			return p5.classify();
		}
		
		Profile[] profiles = {p5, p6};
		
		for(int i=0; i<profiles.length; i++) {
			Profile profile1 = profiles[i];
			Profile profile2 = profiles[Math.abs(i-1)];
			
			if(this.classMap.get(profile2.classify()) - this.classMap.get(profile1.classify()) == -1 && profile2.isClear()) {
				return profile2.classify();
			}
		} //close for-loop
		
		return Classification.Discretion;	
	}
}
