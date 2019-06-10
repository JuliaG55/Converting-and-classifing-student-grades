import java.util.List;

public class Profile {
	// Your additions/changes below this line
	List<Grade> g;
	
	double firstClassCount =0.0;
	double upperSecondClassCount = 0.0;
	double lowerSecondClassCount = 0.0;
	double thirdClassCount = 0.0;
	
	public Profile(List<Grade> g) {
		if(g == null || g.isEmpty()) {
			throw new IllegalArgumentException();
		} for(int i=0; i<g.size(); i++) {
			if(g.get(i).classify().equals(Classification.Fail)) {
				throw new IllegalArgumentException();
			}
		}
		this.g= g;
		countEachClass();
		
	}
	
	private void countEachClass(){
		
        for (Grade grade : g) {
        	switch (grade.classify()) {
        	case First:
        		firstClassCount += 1.0;
        		break;
        	case UpperSecond:
        		upperSecondClassCount += 1.0;
        		break;
        	case LowerSecond:
        		lowerSecondClassCount += 1.0;
        		break;
        	default:
        		thirdClassCount += 1.0;
        		break;
        		
        	}
        }
        
	}

	
	public Classification classify() {
		if (firstClassCount / g.size() >= 0.5) {
			return Classification.First;
		} 
		else if (upperSecondClassCount / g.size() >= 0.5){
			return Classification.UpperSecond;
		} 
		else if (lowerSecondClassCount / g.size() >= 0.5 ){
			return Classification.LowerSecond;
		} 
		else {
			return Classification.Third;
		}
		
	}

	public boolean isClear() {
	    if ((this.classify().equals(Classification.First)) 
	    		|| (this.classify().equals(Classification.UpperSecond))){
            if (thirdClassCount <= g.size() / 4) {
                return true;
            } else {
                return false;
            }
        } else {
	        return true;
        }

    }
	
}
