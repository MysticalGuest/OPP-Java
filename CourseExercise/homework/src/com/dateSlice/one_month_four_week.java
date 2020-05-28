package com.dateSlice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class one_month_four_week {
	
//	public static void main(String[] args) {
	public void one_month_four_week_method(int year , int month) {
//	    int year = 2019;
//	    int month = 9;//改成你要的年月，运行即可查看结果
	    Calendar cal = Calendar.getInstance();
	    cal.set(Calendar.YEAR, year);
	    cal.set(Calendar.MONTH, month - 1);// -1才正确
	    int days = cal.getActualMaximum(Calendar.DATE);// Calendar.DAY_OF_MONTH也对
	    System.out.println("首先，计算这个月有" + days + "天");

	    String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };// 国外一周起始
	    int[] chinaWeek = { 7, 1, 2, 3, 4, 5, 6 };// 对应成中国一周的第几天

	    SimpleDateFormat str_date_format = new SimpleDateFormat("yyyy-MM-dd");

	    List<EachDayAttr> monthDay = new ArrayList<>();
	    int week_of_month = 1;
	    for (int i = 1; i <= days; i++) {
	        EachDayAttr oneDay = new EachDayAttr();
	        oneDay.setWhich(i);
	        // 计算这个月的每一天，对应星期几
	        String dayStr = year + "-" + month + "-" + i;
	        Date daysDate = null;
	        try {
	        daysDate = str_date_format.parse(dayStr);
	        } catch (ParseException e) {
	        e.printStackTrace();
	        }
	        cal.setTime(daysDate);
	        int w1 = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的第几天
	        int which_day_chinaWeek = chinaWeek[w1];
	        System.out.println("该月的第"+ i +"天，该星期（外国习惯）的第"+ w1 +"天："+ weekDays[w1] +">>对应中国周的第"+ which_day_chinaWeek +"天！");
	        //关键：该月每一天对应，中国周里面的第几周
	        if (which_day_chinaWeek == 1) {// 星期一，中国习惯里新的一周的开始
	        week_of_month++;
	        oneDay.setWeek(week_of_month);
	        } else {
	        oneDay.setWeek(week_of_month);
	        }
	        monthDay.add(oneDay);
	    }

	    // 分组：按中国习惯分组
	    Map<Integer, List<EachDayAttr>> weekGroup = new TreeMap<>();

	    for (EachDayAttr oneDay : monthDay) {
	        if (weekGroup.containsKey(oneDay.getWeek())) {
	        weekGroup.get(oneDay.getWeek()).add(oneDay);
	        } else {
	        List<EachDayAttr> addGroup = new ArrayList<>();
	        addGroup.add(oneDay);
	        weekGroup.put(oneDay.getWeek(), addGroup);
	        }
	    }
	    
	    // 再分组：合并成四周
	    if (weekGroup.size() == 4) {
	        // weekGroup不做处理
	    } else if (weekGroup.size() == 5) {
	        if (weekGroup.get(1).size() < weekGroup.get(5).size()) {
	        weekGroup.get(2).addAll(weekGroup.get(1));
	        weekGroup.remove(1);
	        } else {
	        weekGroup.get(4).addAll(weekGroup.get(5));
	        weekGroup.remove(5);
	        }
	    } else if (weekGroup.size() == 6) {
	        weekGroup.get(2).addAll(weekGroup.get(1));
	        weekGroup.get(5).addAll(weekGroup.get(6));
	        weekGroup.remove(1);
	        weekGroup.remove(6);
	    }

	    // 吧weekGroup按天数排序，取最小为开始日期，最大为结束日期即可
	    for (Entry<Integer, List<EachDayAttr>> entry : weekGroup.entrySet()) {
	        Collections.sort(entry.getValue(), new Comparator<EachDayAttr>() {
	        public int compare(EachDayAttr day1, EachDayAttr day2) {
	            return day1.getWhich() - day2.getWhich();
	        }
	        });
	    }
	    // 最后从分好组、排好序的weekGroup中取值封装
	    // weekGroup-->entry中健为整数，而值为list<?>集合
	    Map<Integer, String[]> rtResult = new HashMap<>();
	    int signWeek = 1;
	    for (Entry<Integer, List<EachDayAttr>> entry : weekGroup.entrySet()) {
	        String[] addResult = new String[2];
	        int firstDay = entry.getValue().get(0).getWhich();
	        int lastDay = entry.getValue().get(entry.getValue().size() - 1).getWhich();
	        addResult[0] = year + "-" + month + "-" + firstDay;
	        addResult[1] = year + "-" + month + "-" + lastDay;
	        rtResult.put(signWeek, addResult);
	        signWeek++;
	    }

	    // 至此，输出看下结果
	    for (Entry<Integer, String[]> entry : rtResult.entrySet()) {
	        System.out.println("----该月第"+ entry.getKey() +"周-----");
	        System.out.println("开始日期：" + entry.getValue()[0]);
	        System.out.println("结束日期：" + entry.getValue()[1]);
	    }

	    }

}

