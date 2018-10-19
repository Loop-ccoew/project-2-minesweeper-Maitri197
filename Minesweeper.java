import java.util.*;
public class Minesweeper
{
Scanner sc=new Scanner(System.in);
int point;
char arr[][]=new char[4][4];
char arr1[][]=new char[4][4];
static int p;
Minesweeper obj[];
void main()
{
System.out.println("\t\t\t\t\t\t\tMINESWEEPER");
System.out.println("Enter the number of players");
p=sc.nextInt();
obj=new Minesweeper[p];
for(int i=0;i<p;i++)
{
 System.out.println("Player "+(i+1));
 obj[i]=new Minesweeper();
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
for(int j=0;j<arr.length;j++)
{
arr1[i][j]='*';
arr[i][j]='S';
System.out.print(arr1[i][j]+" ");
}
System.out.println();
}
arr[2][0]='B';
arr[0][3]='B';
arr[3][1]='B';
arr[1][2]='B';
arr[0][0]='B';
arr[2][3]='B';
}
void display()
{
for(int i=0;i<4;i++)
{
for(int j=0;j<arr.length;j++)
{
System.out.print(arr1[i][j]+" ");
}
System.out.println();
}
}
void play()
{
point=0;
int l=2;
int flag=0;
while((l>-1)&&(flag<10))
{
System.out.println("Lives:"+l);
System.out.println("Enter row number");
int r=sc.nextInt();
r=r-1;
System.out.println("Enter column number");
int c=sc.nextInt();
c=c-1;
arr1[r][c]=arr[r][c];
if(arr[r][c]!='B')
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
for(int i=0;i<4;i++)
{
for(int j=0;j<arr.length;j++)
System.out.print(arr[i][j]+" ");
System.out.println();
}
}
}







