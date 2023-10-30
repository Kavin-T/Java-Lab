import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class GUI extends JFrame{
    GUI(){
        JLabel studLabel=new JLabel("Name :");
        JLabel age=new JLabel("Age :");
        JLabel gender=new JLabel("Gender :");
        JLabel semLabel=new JLabel("Sem No :");
        JLabel[] mark=new JLabel[5];
        JLabel attendance=new JLabel("Attendance :");
        JTextField studNameTextField=new JTextField();
        JTextField ageTextField=new JTextField();
        JTextField genderTextField=new JTextField();
        JTextField attendanceTextField=new JTextField();
        JTextField[] markFields=new JTextField[5];
        JButton submit=new JButton("Submit");
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        panel1.add(studLabel);
        panel1.add(studNameTextField);
        panel1.add(age);
        panel1.add(ageTextField);
        panel1.add(gender);
        panel1.add(genderTextField);
        for(int i=0;i<5;i++){
            mark[i]=new JLabel("Mark"+i);
            markFields[i]=new JTextField();
            panel2.add(mark[i]);
            panel2.add(markFields[i]);
        }
        panel2.add(attendance);
        panel2.add(attendanceTextField);
        JComboBox semList=new JComboBox(new String[]{"1","2","3","4","5","6","7","8"});
        panel1.setPreferredSize(new Dimension(300, 100));
        panel2.setPreferredSize(new Dimension(300, 100));
        panel1.setLayout(new GridLayout(4,2));
        panel2.setLayout(new GridLayout(6,2));
        panel1.add(semLabel);
        panel1.add(semList);
        add(panel1);
        add(panel2);
        add(submit);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(1000,1000);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GUI();
    }
}