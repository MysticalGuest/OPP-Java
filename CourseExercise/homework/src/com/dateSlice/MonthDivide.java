package com.dateSlice;

import java.util.*;

//月份划分类
public class MonthDivide {
  private int year, month;//年份、月份
  private int weekend;  //周数(第几周)
  private int leapYear[] = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};   //闰年每月天数
  private int commonYear[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //平年每月天数
  private int start, end;
   
  //输入
  public void inputData(){
      Scanner in = new Scanner(System.in);
       
      System.out.print ("输入年份:");
      year = in.nextInt();
      System.out.print ("输入月份:");
      month = in.nextInt();
      //System.out.print ("输入周数:");  
      //weekend = in.nextInt();
  }
   
   //判断闰年
   public boolean isLeapYear(int year){
       return (year%4 == 0 && year%100 != 0) || (year%400 == 0);
   }
   
  //计算
  public void count(){
      int day, weekday, allDays=0;
      //分别表示当月天数、当月一号是星期几、1900.1.1到当前输入日期之间的天数
       
      day = isLeapYear(year)?leapYear[month]:commonYear[month];
      if(weekend > (day==28?4:5)){
          System.out.println ("周数越界了!");
          return;
      }
       
      //计算天数
      for(int i=1900; i<year; i++){
          allDays += isLeapYear(i)?366:365;
      }
      for(int i=1; i<month; i++){
          allDays += isLeapYear(year)?leapYear[i]:commonYear[i];
      }
      //计算星期几
      weekday = 1+allDays%7;
       
      //计算第weekend周的开始和结束
      if(weekend == 1){
          start = 1;
          end = 8 - weekday;
      }
      else{
          start = (weekend-2)*7 + (9-weekday);
          end = start + 6;
          if(end > day)
              end = day;
      }
  }
   
  //设置weekend周数
  public void setWeekend(int wk){
      weekend = wk;
  }
   
  //以下三个是获取属性
  public int getStart(){
      return start;
  }
  public int getEnd(){
      return end;
  }
  public int getWeekend(){
      return weekend;
  }
   
  //main
  public static void main(String[] args) {
      MonthDivide md = new MonthDivide();
       
      md.inputData();
   
      for (int i = 1; i <= 5; i++){
          md.setWeekend(i);
          md.count();        
          System.out.print ("\n第"+md.getWeekend()+"周开始于"+md.getStart()+"号\t结束至"+md.getEnd()+"号");
      }
  }
}

