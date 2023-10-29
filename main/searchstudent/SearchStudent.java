package searchstudent;
import displaystudent.DisplayStudent;
import java.util.*;
public class SearchStudent extends DisplayStudent{
    public SearchStudent(String name, int age, int[] sub_marks, float total_hours, float total_absentees) {
        super(name, age, sub_marks, total_hours, total_absentees);
    }
    public void searchstudentdetails(SearchStudent[] arrobj){
        Scanner input=new Scanner(System.in);
        System.out.println("1. Search the student name starts with a character given by the user\n2. Search the name of the city ends with a character given by the user\n3. Search the student name given by the user\n4. Retrieve only the students whose name contains the string given by user\n5. Search shortest student name and longest student name in the class");
        int choice1=input.nextInt();
        while(choice1<=5 && choice1>=1){
            if(choice1==1){
                char a=input.next().charAt(0);
                for(int i=0;i<arrobj.length;i++){
                    if(arrobj[i].name.charAt(0)==a){
                        System.out.println("name:"+arrobj[i].name);
                    }
                }
            }
            else if(choice1==2){
                char a=input.next().charAt(0);
                for(int i=0;i<arrobj.length;i++){
                    if(city.charAt(city.length()-1)==a){
                        System.out.println("city:"+city);
                    }
                }
            }
            else if(choice1==3){
                String a=input.next();
                boolean flag=false;
                for(int i=0;i<arrobj.length;i++){
                    if(arrobj[i].name.equals(a)){
                        System.out.println("name found");
                        flag=true;
                    }
                }
                if(!flag){
                    System.out.println("name not found");
                }
            }
            else if(choice1==4){
                String a=input.next();
                for(int i=0;i<arrobj.length;i++){
                    if(arrobj[i].name.contains(a)){
                        System.out.println("name: "+arrobj[i].name);
                    }
                }
            }
            else if(choice1==5){
                String large="",small="";int sm=Integer.MAX_VALUE;
                for(int i=0;i<arrobj.length;i++){
                    if(arrobj[i].name.length()>large.length()){
                        large=arrobj[i].name;
                    }
                    if(arrobj[i].name.length()<sm){
                        small=arrobj[i].name;
                        sm=small.length();
                    }
                }
                System.out.println("large name:"+large+"\nsmall name:"+small);
            }
            else{
                break;
            }
            choice1=input.nextInt();
        }
        return;
    }
}
