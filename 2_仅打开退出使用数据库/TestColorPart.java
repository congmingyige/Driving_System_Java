import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class TestColorPart extends JFrame { 
JPanel jp1, jp2, jp3, jp4;
 Color[] colors = { Color.BLACK, Color.RED, Color.GRAY, Color.GREEN,   Color.BLUE, Color.WHITE }; 
public TestColorPart() {  
jp1 = new JPanel();  
jp2 = new JPanel();  
jp3 = new JPanel();  
jp4 = new JPanel();
//循环  
while(true){   
Random r = new Random();  
 int len = colors.length;
//停顿   
try {    
Thread.sleep(1000);  
 } catch (InterruptedException e) {   
 e.printStackTrace(); 
  }   
jp1.setBackground(colors[r.nextInt(len)]);//索引  
 jp2.setBackground(colors[r.nextInt(len)]);//索引  
 jp3.setBackground(colors[r.nextInt(len)]);//索引  
 jp4.setBackground(colors[r.nextInt(len)]);//索引
this.setLayout(new GridLayout(2, 2));   
this.add(jp1);   
this.add(jp2);   
this.add(jp3);   
this.add(jp4);  
 this.setSize(400, 400);   
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
 this.setVisible(true);  
     }
 } 
public static void main(String[] args) {  
new TestColorPart(); 
     }
}