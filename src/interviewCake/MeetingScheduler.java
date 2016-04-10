package interviewCake;

import java.util.ArrayList;
import java.util.List;

/*
 * Your company built an in-house calendar tool called HiCal. You want to add a feature to see the times in a day when everyone is available.
 To do this, you’ll need to know when any team is having a meeting. In HiCal, a meeting is stored as an object of a Meeting class with integer variables startTime and endTime. These integers represent the number of 30-minute blocks past 9:00am.
 * 
 * 
 */

class Meeting {

	int startTime;
	int endTime;

	public Meeting(int startTime, int endTime) {
		// number of 30 min blocks past 9:00 am
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String toString() {
		return String.format("(%d, %d)", startTime, endTime);
	}

}

// ( 1,2)(2,3) (3,4) (5,6)
public class MeetingScheduler {

	List<Meeting> condenseMeetingList(List<Meeting> in) {

		List<Meeting> result = new ArrayList<Meeting>();
		Meeting previous = in.get(0);

		for (Meeting m : in) {
			if (previous.endTime >= m.startTime) {
				previous.endTime = Math.max(previous.endTime, m.endTime);
			} else {
				result.add(previous);
				previous = m;
			}
		}
		result.add(previous);
		return result;

	}

}
