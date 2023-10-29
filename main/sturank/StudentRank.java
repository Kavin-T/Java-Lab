package sturank;

import searchstudent.SearchStudent;
import stugrade.StuGrade;
import inbuiltexception.*;
public class StudentRank extends StuGrade{
    public StudentRank(){
        super("", 0, new int[5], 0.0f, 0.0f);
    }
    public void calculateRank(SearchStudent[] arrobj){
        for(int i=0;i<arrobj.length;i++){
            arrobj[i].rank=1;
            for(int j=0;j<arrobj.length;j++){
                if(i!=j && arrobj[i].total_marks<arrobj[j].total_marks){
                    arrobj[i].rank++;
                }
            }
            try {
                if(arrobj[i].rank>3){
                    throw new RankHolder();
                }
            } catch (RankHolder e) {
                System.out.println("Name: "+arrobj[i].name+" "+e);
            }
        }
    }
}
