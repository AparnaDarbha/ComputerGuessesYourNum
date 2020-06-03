import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;
/*
<applet code="ButtonDema.class" width=2000 height=500>
</applet>
*/
public class ButtonDema extends Applet implements ActionListener{
Random r=new Random();
int x;
static int ins=0;
static int y=6;
int cnt=0;
int a[]=new int[7];
Button yes,no,replay;
StoreBinary sb=new StoreBinary();
public void init(){
  ins=0;
  y=6;
  cnt=0;
  setLayout(null);
  setBackground(Color.YELLOW);
  yes=new Button("Yes, My num exists");
  no=new Button("No, it doesn't");
  replay=new Button("Replay");
  Font myFont=new Font("Monotype Corsiva",Font.BOLD,15);
  yes.setBackground(Color.cyan);
  yes.setFont(myFont);
  no.setBackground(Color.cyan);
  no.setFont(myFont);
  replay.setBackground(Color.cyan);
  replay.setFont(myFont);
  add(yes);
  add(no);
  add(replay);
  yes.setLocation(400,150);
  yes.setSize(150,50);
  no.setLocation(600,150);
  no.setSize(100,50);
  replay.setLocation(400,250);
  replay.setSize(100,50);
  yes.addActionListener(this);
  no.addActionListener(this);
  replay.addActionListener(this);
  //System.out.println("\nImagine a number below 99");
}
public void actionPerformed(ActionEvent ae){
  String s=ae.getActionCommand();
      y--;
     repaint();
  if(s.equals("Yes, My num exists"))
  {
    a[cnt]=x;
    cnt++;
  }
  else if(x==1 && s.equals("No, it doesn't"))   
  {
   a[cnt]=x-1;
   cnt++;
  }
  else if(x==0 && s.equals("No, it doesn't"))
  {
    a[cnt]=x+1;
    cnt++;
  }
  if(s.equals("Replay"))
  {
   init();
  }
   //if(s.equals("Quit"))
   //{
      //dispose();
    // System.exit(1);
    // this.getAppletContext().showDocument(ButtonDemas.html);
 // }
  x=0+r.nextInt(2);
}
public void paint(Graphics g)
{
 int j=40,k=50,f=0;
if(ins==0)
{
  g.setFont(new Font("Monotype Corsiva", Font.BOLD,30));
  g.setColor(Color.blue);
  g.drawString("Hello! Welcome to Number Guessing Game!!",75,75);
  g.drawString("Just click yes or no",75,105);
  ins=1;
}
else if(ins!=0){
   for(int i=0;i<100;i++)
   {
    int d[]=sb.dectobinary(i);
    String str_i=String.valueOf(i);
 if(y>=0)
 {
    try{
    if(d[y]==x)
     {
      f++;
      setBackground(Color.darkGray);
      g.setFont(new Font("Monotype Corsiva", Font.BOLD,25));
      g.setColor(Color.red);
       g.drawRect(0,10,5000,100);
       if(f<=26){
       g.drawString(str_i,j,k);
       j+=50;
       }
       else
       {
         j-=35;
         k=100;
         g.drawString(str_i,j,k);
        }
      }
   }
    catch(ArrayIndexOutOfBoundsException e){
    System.out.println("Error"); 
    }
  }
 else
 { 
BintoDec bd=new BintoDec();
    int number=bd.Bin(a);
    setBackground(Color.magenta);
    String v=String.valueOf(number);
     remove(yes);
     remove(no);
     g.setFont(new Font("Monotype Corsiva", Font.BOLD,50));
     g.setColor(Color.white);
     g.drawString("Your Number is "+v,100,100);
 }
} 
}
}
}
class StoreBinary
{
 Random r=new Random();
 Stack<Integer> s=new Stack<Integer>();
 public int[] dectobinary(int num)
 { 
if(num==0)
  s.push(0);
  while(num>0)
  {
   int rem=num%2;
   s.push(rem);
   num=num/2;
  }
  int arr[]=new int[7];
  int i=0;
  while(!s.empty() && i<=6)
  {
   for(int j=1;j<=6;j++)
   { 
   if(s.size()==j && i==0)
    {
      for(i=0;i<=6-j;i++)
       arr[i]=0;
    }
   }
 arr[i]=(int)s.pop();
   i++;
  }
return arr;
}
}
class BintoDec
{
  int sum=0,j,p=1;
  int Bin(int a[])
  { 
    for(int i=0;i<a.length;i++)
     {
      p=1;
      if(i==0)
  p=1;
      else
      {
        for(j=1;j<=i;j++){
          p=p*2;
         }
      }
       sum=sum+a[i]*p;
     }
   return sum;
  }
}