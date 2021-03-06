package kr.hs.dgsw.flow.database.table;

import kr.hs.dgsw.flow.type.MealType;
import com.orm.dsl.Table;

import kr.hs.dgsw.flow.type.MealType;

@Table
public class MealTable {
    private int year;
    private int month;
    private int day;
    @MealType.Meal
    private int type;
    private String meal;

    public MealTable() { }

    public MealTable(int year, int month, int day, @MealType.Meal int type, String meal) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.type = type;
        this.meal = meal;
    }

    public int getYear() { return year; }

    public int getMonth() { return month; }

    public int getDay() { return day; }

    @MealType.Meal
    public int getType() { return type; }

    public String getMeal() { return meal; }
}
