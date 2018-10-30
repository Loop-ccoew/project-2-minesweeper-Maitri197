import java.util.*;
public class Minesweeper_sparse
{
Scanner sc=new Scanner(System.in);
int point;
int sparse[][];
int sparse1[][];
static int p;
Minesweeper_sparse obj[];
void main()
{
System.out.println("\t\t\t\t\t\t\tMINESWEEPER");
System.out.println("Enter the number of players");
p=sc.nextInt();
obj=new Minesweeper_sparse[p];
for(int i=0;i<p;i++)
{
 System.out.println("Player "+(i+1));
 obj[i]=new Minesweeper_sparse();
 obj[i].intro();
 obj[i].play();
}
if(p>1)
compare();
}
void compare()
{
System.out.println("\f");
int temp=obj[0].point;
int win=1;
System.out.println("Result:");
for(int i=0;i<p;i++)
System.out.println("Player "+(i+1)+" : "+obj[i].point);
for(int i=1;i<p;i++)
{
if(obj[i].point>temp)
{
temp=obj[i].point;
win=i+1;
}
}
System.out.println("Player "+win+" is the winner.");
}
void intro()
{
System.out.println("INSTRUCTION:For every correct move you get 3 point and for every wrong move 2 points are deducted.Also you have only 2 lives.");
System.out.println("* represents the choices you haven't guessed,B means bomb and S represents the safe places.");
for(int i=0;i<4;i++)
{
for(int j=0;j<4;j++)
System.out.print("* ");
System.out.println();
}
int sparse[][]={
{0,3,2,1,0,1},
{2,3,1,0,3,2}
};
this.sparse=sparse;
}
void display()
{
//{0,3,2,1,0,1},
//{2,3,1,0,3,2}
boolean set=true;
for(int i=0;i<4;i++)
{
for(int j=0;j<4;j++)
{
if(sparse1[i][j]==0)
System.out.print("* ");
else
{
for(int size=0;size<6;size++)
{
if((sparse[0][size]==i)&&(sparse[1][size]==j))
set=false;
}
if(set==true)
System.out.print("S ");
else
System.out.print("B ");
}
set=true;
}
System.out.println();
}
}
void play()
{
point=0;
int l=2;
int flag=0;
sparse1=new int[4][4];
boolean test=true;
while((l>-1)&&(flag<10))
{
System.out.println("Lives:"+l);
int r=0,c=0;
do
{
System.out.println("Enter row number");
r=sc.nextInt();
}while(r<0&&r>5);
do
{
System.out.println("Enter column number");
c=sc.nextInt();
}while(c<0&&c>5);
r=r-1;
c=c-1;
sparse1[r][c]=sparse1[r][c]+1;
test=true;
for(int i=0;i<6;i++)
{
if((sparse[0][i]==r)&&(sparse[1][i]==c))
{
test=false;
break;
}
}
if(test==true)
{
System.out.println("Right choice!");
flag++;
point+=3;
}
else
{
System.out.println("Wrong choice!");
l--;
point-=2;
}
display();
}
System.out.println("\t\t\t\t\t\tGame over.");
if(p<2)
{
if(l>0)
System.out.println("You win");
else
System.out.println("You lose");
}
System.out.println("Your points:"+point);
System.out.println("The correct pattern was:");
boolean set;
for(int i=0;i<4;i++)
{
for(int j=0;j<4;j++)
{
set=true;
for(int size=0;size<6;size++)
{
if((sparse[0][size]==i)&&(sparse[1][size]==j))
{
set=false;
break;
}
}
if(set==true)
System.out.print("S ");
else
System.out.print("B ");
}
System.out.println();
}
}
}







