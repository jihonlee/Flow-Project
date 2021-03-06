package kr.hs.dgsw.flow;

import kr.hs.dgsw.flow.activity.MainActivity;
import kr.hs.dgsw.flow.model.DateTime;
import kr.hs.dgsw.flow.type.MealType;

/**
 * Created by JiHeon on 2018-03-20.
 */

public class DateTimeHelper {

    // 년, 월, 일 식사종류
    private DateTime dateTime;

    @MealType.Meal
    private int mealType;

    // 현재 시간을 기준으로 하는 급식 파싱에 사용되는 생성자
    public DateTimeHelper() {
        // Calendar 객체를 통해 현재 년, 월, 일 계산
        dateTime = Utils.getCurrentDateTime();

        // 시간을 이용해 Utils 계산
        setMealType(dateTime.getHour(), dateTime.getMin());
    }

    // 지정된 시간을 기준으로 하는 급식 파싱에 사용되는 생성자
    public DateTimeHelper(DateTime dateTime) {
        this.dateTime = dateTime;

        setMealType(dateTime.getHour(), dateTime.getMin());
    }

    /**
     * 파라미터로 받은 시, 분 정보로 급식 종류를 결정
     *
     * @param hour  시
     * @param min   분
     */

    public void setMealType(int hour, int min) {
        // 시 * 100 + 분 을 함으로써 시간을 정수형으로 표현
        // ex) 7:20 => 720  |  15:30 => 1530
        int sum = hour * 100 + min;

        // 사용자 학교의 아침, 점심, 저녁 시간에 따라 가져와야할 Utils 결정
        if(sum < MainActivity.BREAKFAST_TIME)
            this.mealType = MealType.BREAKFAST;

        else if(sum < MainActivity.LUNCH_TIME)
            this.mealType = MealType.LUNCH;

        else if(sum < MainActivity.DINNER_TIME)
            this.mealType = MealType.DINNER;

        else
            this.mealType = MealType.NEXT_BREAKFAST;
    }

    @MealType.Meal
    public int getMealType() { return mealType; }

    public DateTime getDateTime() { return dateTime; }
}