package displaystudent;
import stugrade.StuGrade;
import java.util.*;
public class DisplayStudent extends StuGrade{
    public DisplayStudent(String name, int age, int[] sub_marks, float total_hours, float total_absentees) {
        super(name, age, sub_marks, total_hours, total_absentees);
    }
    public void displaystudentdetails(){
        Scanner in=new Scanner(System.in);
        System.out.println("1. Display the starting character of name and city of students in Capital letter\n2. Display the name/ city in lowercase\n3. Display the name/ city in uppercase\n4. No change");
        int choice=in.nextInt();
        while(choice<=4 && choice>=1){
            if(choice==1){
                System.out.println("the starting character of name: "+name.toUpperCase().charAt(0));
                System.out.println("the starting character of city: "+city.toUpperCase().charAt(0));
            }
            else if(choice==2){
                System.out.println("the name/ city in lowercase: "+name.toLowerCase());
                System.out.println("the name/ city in lowercase: "+city.toLowerCase());
            }
            else if(choice==3){
                System.out.println("the name/ city in uppercase: "+name.toUpperCase());
                System.out.println("the name/ city in uppercase: "+city.toUpperCase());
            }
            else if(choice==4){
                System.out.println("no change");
                break;
            }
            else{
                System.out.println("invalid choice renter:");
                choice=in.nextInt();
            }
            choice=in.nextInt();
        }
        return;
    }
}