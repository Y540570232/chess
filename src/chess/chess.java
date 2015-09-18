package chess;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
设置棋盘
*/

class mypanel extends Panel implements MouseListener
{
    //设置一个11*11的棋盘
	int chess[][] = new int[11][11];
	//标识当前应该黑棋还是白棋下下一步
    boolean Is_Black_True;
    mypanel()
    {
        Is_Black_True = true;
        for(int i = 0;i < 11;i++)
           {
              for(int j = 0;j < 11;j++)
                 {
            	//初始化棋盘
                     chess[i][j] = 0;
                 }
            }
      //对棋盘设置鼠标监听
         addMouseListener(this);
       //设置棋盘背景颜色
         setBackground(Color.GREEN);
       //设置x,y轴的起点以及长度宽度
         setBounds(0, 0, 360,360);
       //将窗体显示出来
         setVisible(true);
     }
 
 /*
   设置黑白双方对弈算法
  */
    
 /*
  *鼠标按下方法
  */
 public void mousePressed(MouseEvent e)
 {
  //获取棋子坐标
     int x = e.getX();
     int y = e.getY();
     
  //判断棋子是否超出棋盘边缘
     if(x < 25 || x > 330 + 25 ||y < 25 || y > 330+25)
        {
    	 JOptionPane.showMessageDialog(this, "超出棋盘范围");
          return;
        }
     
   //判断此处是否有棋子
     if(chess[x/30-1][y/30-1] != 0)
       {
    	 JOptionPane.showMessageDialog(this, "已有棋子");
         return;
       }
     
   //开始下棋，黑子先手
     if(Is_Black_True == true)
       {
    	//黑棋为1
          chess[x/30-1][y/30-1] = 1;
          Is_Black_True = false;
        //调用paint重绘方法
          repaint();
          Justisewiner();
          return;
       }
     if(Is_Black_True == false)
       {
    	//白棋为2
          chess[x/30-1][y/30-1] = 2;
          Is_Black_True = true;
          repaint();
          Justisewiner();
          return;
       }
 }
 /*
  * 绘制棋盘
  */
 void Drawline(Graphics g)
 {
     for(int i = 30;i <= 330;i += 30)	 
        {
          for(int j = 30;j <= 330; j+= 30)
            {
               g.setColor(Color.WHITE);
               //画垂直线，设置每个点的坐标
               g.drawLine(i, j, i, 330);
            }
        }

     for(int j = 30;j <= 330;j += 30)
        {
          g.setColor(Color.WHITE);
        //画横线
          g.drawLine(30, j, 330, j);
        }
 }
 
 /*
  * 绘制棋子
  */
 void Drawchess(Graphics g)
 {
    for(int i = 0;i < 11;i++)
     {
       for(int j = 0;j < 11;j++)
        {
          if(chess[i][j] == 1)
            {
        	//黑棋为1
              g.setColor(Color.BLACK);
              g.fillOval((i + 1) * 30 - 8, (j + 1) * 30 - 8, 16, 16);
            }
          if(chess[i][j] == 2)
            {
        	//白棋为2
              g.setColor(Color.WHITE);
              g.fillOval((i + 1) * 30 - 8, (j + 1) * 30 - 8, 16, 16);
            }
        }
     }
 }
 
 /*
  * 判断双方获胜者
  */
 void Justisewiner()
 {
    int black_count = 0;
    int white_count = 0;
    int i = 0;
 
  //横向判断输赢
    for(i = 0;i < 11;i++)
       {
         for(int j = 0;j < 11;j++)
             {
               if(chess[i][j] == 1)
                 {
                    black_count++;
                  //横向黑棋判断
                    if(black_count == 5)
                      {
                        JOptionPane.showMessageDialog(this, "黑棋胜利");
                        Clear_Chess();
                        return;
                      }
                  }
               else
                  {
                    black_count = 0;
                  }
              if(chess[i][j] == 2)
                  {
                     white_count++;
                   //横向白棋判断
                     if(white_count == 5)
                       {
                          JOptionPane.showMessageDialog(this, "白棋胜利");
                          Clear_Chess();
                          return;
                       }
                   }
              else
                   {
                     white_count = 0;
                   }
       }
 }
   
    
  //纵向判断输赢
    for(i = 0;i < 11;i++)
      {
        for(int j = 0;j < 11;j++)
          {
            if(chess[j][i] == 1)
             {
               black_count++;
               if(black_count == 5)//纵向黑棋判断
                 {
                   JOptionPane.showMessageDialog(this, "黑棋胜利");
                   Clear_Chess();
                   return;
                 }
             }
        else
          {
            black_count = 0;
          }
        if(chess[j][i] == 2)
          {
            white_count++;
            if(white_count == 5)//纵向白棋判断
              {
                JOptionPane.showMessageDialog(this, "白棋胜利");
                Clear_Chess();
                return;
              }
           }
        else
           {
              white_count = 0;
           }
        }
      }

  //左向右斜判断
   for(i = 0;i < 7;i++)
     {
       for(int j = 0;j < 7;j++)
         {
            for(int k = 0;k < 5;k++)
              {
                 if(chess[i + k][j + k] == 1)
                   {
                      black_count++;
                      if(black_count == 5)//右斜黑棋判断
                        {
                          JOptionPane.showMessageDialog(this, "黑棋胜利");
                          Clear_Chess();
                          return;
                         }
                    }
                  else
                    {
                       black_count = 0;
                    }
                 if(chess[i + k][j + k] == 2)
                   {
                      white_count++;
                      if(white_count == 5)//右斜白棋判断
                        {
                           JOptionPane.showMessageDialog(this, "白棋胜利");
                           Clear_Chess();
                           return;
                         }
                    }
                  else
                    {
                      white_count = 0;
                    }
              }
         }
     }
   
 //右向左斜判断
   for(i = 4;i < 11;i++)
     {
       for(int j = 6;j >= 0;j--)
         {
            for(int k = 0;k < 5;k++)
              {
                 if(chess[i - k][j + k] == 1)
                   {
                      black_count++;
                    //左斜黑棋判断
                      if(black_count == 5)
                        {
                           JOptionPane.showMessageDialog(this, "黑棋胜利");
                           Clear_Chess();
                           return;
                         }
                    }
                  else
                    {
                       black_count = 0;
                    }
                  if(chess[i - k][j + k] == 2)
                    {
                       white_count++;
                     //左斜白棋判断
                       if(white_count == 5)
                         {
                           JOptionPane.showMessageDialog(this, "白棋胜利");
                           Clear_Chess();
                           return;
                          }
                    }
                 else
                    {
                        white_count = 0;
                    }
               }
        }
     }
 
 }
 
 /*
       清除棋盘上的所有棋子坐标对应数据
       清除棋子
       重绘棋盘
*/
 void Clear_Chess()
 {
   for(int i=0;i<11;i++)
    {
      for(int j=0;j<11;j++)
        {
          chess[i][j]=0;
        }
    }
 //调用paint重绘方法
   repaint();
 }
 
 /*
  * 调用画棋盘和画棋子的方法
  */
 public void paint(Graphics g)
 {
   Drawline(g);
   Drawchess(g);
 }
//将光标移入组件时被触发
 public void mouseExited(MouseEvent e){}
//光标移入组件时被触发
 public void mouseEntered(MouseEvent e){}
//鼠标按键被释放时被触发
 public void mouseReleased(MouseEvent e){}
//发生点击事件时被触发
 public void mouseClicked(MouseEvent e){}
 
}

/*
 * 主窗口构造
 */
class myframe extends Frame implements WindowListener
{
  mypanel panel;
  myframe()
   {
	//设置NULL布局
     setLayout(null);
     panel = new mypanel();
     add(panel);
     panel.setBounds(0,23, 360, 360);
     setTitle("简易五子棋");
     setBounds(200, 200, 360, 383);
   //显示窗体
     setVisible(true);
   //设置监听
     addWindowListener(this);
 
   }
  
  //游戏退出
  public void windowClosing(WindowEvent e)
   {
     System.exit(0);
   }
  
   public void windowDeactivated(WindowEvent e){}
   public void windowActivated(WindowEvent e){}
   public void windowOpened(WindowEvent e){}
   public void windowClosed(WindowEvent e){}
   public void windowIconified(WindowEvent e){}
   public void windowDeiconified(WindowEvent e){}

}
//主函数
public class chess
{
  public static void main(String[] argc)
   {
	  myframe f = new myframe() ;
   }
}


  
  








