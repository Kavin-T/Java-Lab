import searchstudent.SearchStudent;
import sturank.StudentRank;
class Main {
    public static void main(String[] args){
        try{
            SearchStudent[] arrobj = new SearchStudent[4];
            int[] marks1=new int[]{89,90,91,92,93};
            int[] marks2=new int[]{45,17,39,13,34};
            int[] marks3=new int[]{84,78,93,63,76};
            int[] marks4=new int[]{94,78,13,43,56};
            arrobj[0] = new SearchStudent("kavin",19,marks1,230,200);
            arrobj[1] = new SearchStudent("praveen",15,marks2,230,30);
            arrobj[2] = new SearchStudent("aswin",17,marks3,230,30);
            arrobj[3] = new SearchStudent("peter",12,marks4,230,30);
            StudentRank obj=new StudentRank();
            Thread gradeThread=new Thread("gradeThread"){
                public void run(){
                    arrobj[0].calculateAttendance();
                    arrobj[1].calculateAttendance();
                    arrobj[2].calculateAttendance();
                    arrobj[3].calculateAttendance();
                    arrobj[0].calculateGrade();
                    arrobj[1].calculateGrade();
                    arrobj[2].calculateGrade();
                    arrobj[3].calculateGrade();
                }
            };
            Thread rankThread=new Thread("rankThread"){
                public void run(){
                    obj.calculateRank(arrobj);
                }
            };
            Thread totalThread=new Thread("totalThread"){
                public void run(){
                    arrobj[0].printData();
                    arrobj[1].printData();
                    arrobj[2].printData();
                    arrobj[3].printData();
                    arrobj[1].searchstudentdetails(arrobj);
                    arrobj[0].displaystudentdetails();
                }
            };
            try {
                gradeThread.start();
                gradeThread.join();
                rankThread.start();
                rankThread.join();
                totalThread.start();
                totalThread.join();
            } catch (Exception e){}
        }
        catch(ArithmeticException e){
            System.out.println(e);
        }
        catch(NullPointerException e){
            System.out.println(e);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
	}
}
