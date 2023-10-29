package stugrade;
import studentinterface.*;
import java.util.*;
import inbuiltexception.*;
public class StuGrade implements CalculateAttendance,CalculateGrade{
    public String name;
    public String city="Coimbatore";
    int age;
    float total_hours;
    float total_absentees;
    public int attendance_mark;
    int[] sub_marks;
    public int rank;
    public int total_marks;
    String grade;
    public StuGrade(String name,int age,int[] sub_marks,float total_hours,float total_absentees){
        this.name=name;
        this.age=age;
        this.sub_marks=sub_marks;
        this.total_hours=total_hours;
        this.total_absentees=total_absentees;
        this.total_marks=sub_marks[0]+sub_marks[1]+sub_marks[2]+sub_marks[3]+sub_marks[4]+(attendance_mark*5);
    }
    public void printData(){
        System.out.println("Name: "+this.name);
        System.out.println("City: "+city);
        System.out.println("Age: "+this.age);
        System.out.println("Marks: "+Arrays.toString(this.sub_marks));
        System.out.println("Total hours: "+this.total_hours);
        System.out.println("Total absentees: "+this.total_absentees);
        System.out.println("Attendance mark: "+this.attendance_mark);
        System.out.println("Grade: "+this.grade);
        System.out.println("Rank: "+this.rank);
        System.out.println("Total Marks: "+this.total_marks);
    }
    public void calculateAttendance(){
        float attendance_percentage=((total_hours-total_absentees)/total_hours)*100;
        if(attendance_percentage>90){
            attendance_mark=5;
        }
        else if(attendance_percentage>85){
            attendance_mark=4;
        }
        else if(attendance_percentage>80){
            attendance_mark=3;
        }
        else if(attendance_percentage>70){
            attendance_mark=2;
        }
        else if(attendance_percentage>60){
            attendance_mark=1;
        }
        else{
            attendance_mark=0;
        }
        try{
            if(attendance_mark<2){
                throw new LowAttendanceMark();
            }
        }
        catch(LowAttendanceMark e){
            System.out.println("Name: "+this.name+" "+e);
        }
    }
    public void calculateGrade(){
        int avg=total_marks/5;
        try{
            if(avg<50){
                throw new LowGPA();
            }
        }
        catch(LowGPA e){
            System.out.println("Name: "+this.name+" "+e);
        }
        if(avg>90){
            grade="O";
        }
        else if(avg>85){
            grade="A+";
        }
        else if(avg>80){
            grade="A";
        }
        else if(avg>70){
            grade="B+";
        }
        else if(avg>60){
            grade="B";
        }
        else if(avg>50){
            grade="C";
        }
        else{
            grade="F";
        }
    }
}
