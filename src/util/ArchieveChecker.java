package util;

import com.achieve.model.Achieve;
import com.achieveprogress.model.AchieveProgress;

public class ArchieveChecker {

	public ArchieveChecker() {}
	
	
	public boolean isComplete(Achieve goal, AchieveProgress progressNow) {
		
		if(this.isCompleteArticleGoal(goal, progressNow) && this.isCompleteOrderGoal(goal, progressNow)) {
			return true;
		}
		return false;
	}
	
	private boolean isCompleteArticleGoal(Achieve goal, AchieveProgress progressNow) {
		
		if(goal.getAchiArticle() <= progressNow.getCurrentArticle()) {
			return true;
		}
		return false;
	}
	
	private boolean isCompleteOrderGoal(Achieve goal, AchieveProgress progressNow) {
		
		if(goal.getAchiOrder() <= progressNow.getCurrentOrder()) {
			return true;
		}
		return false;
	}
}
