package chess;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
��������
*/

class mypanel extends Panel implements MouseListener
{
    //����һ��11*11������
	int chess[][] = new int[11][11];
	//��ʶ��ǰӦ�ú��廹�ǰ�������һ��
    boolean Is_Black_True;
    mypanel()
    {
        Is_Black_True = true;
        for(int i = 0;i < 11;i++)
           {
              for(int j = 0;j < 11;j++)
                 {
            	//��ʼ������
                     chess[i][j] = 0;
                 }
            }
      //����������������
         addMouseListener(this);
       //�������̱�����ɫ
         setBackground(Color.GREEN);
       //����x,y�������Լ����ȿ��
         setBounds(0, 0, 360,360);
       //��������ʾ����
         setVisible(true);
     }
 
 /*
   ���úڰ�˫�������㷨
  */
    
 /*
  *��갴�·���
  */
 public void mousePressed(MouseEvent e)
 {
  //��ȡ��������
     int x = e.getX();
     int y = e.getY();
     
  //�ж������Ƿ񳬳����̱�Ե
     if(x < 25 || x > 330 + 25 ||y < 25 || y > 330+25)
        {
    	 JOptionPane.showMessageDialog(this, "�������̷�Χ");
          return;
        }
     
   //�жϴ˴��Ƿ�������
     if(chess[x/30-1][y/30-1] != 0)
       {
    	 JOptionPane.showMessageDialog(this, "��������");
         return;
       }
     
   //��ʼ���壬��������
     if(Is_Black_True == true)
       {
    	//����Ϊ1
          chess[x/30-1][y/30-1] = 1;
          Is_Black_True = false;
        //����paint�ػ淽��
          repaint();
          Justisewiner();
          return;
       }
     if(Is_Black_True == false)
       {
    	//����Ϊ2
          chess[x/30-1][y/30-1] = 2;
          Is_Black_True = true;
          repaint();
          Justisewiner();
          return;
       }
 }
 /*
  * ��������
  */
 void Drawline(Graphics g)
 {
     for(int i = 30;i <= 330;i += 30)	 
        {
          for(int j = 30;j <= 330; j+= 30)
            {
               g.setColor(Color.WHITE);
               //����ֱ�ߣ�����ÿ���������
               g.drawLine(i, j, i, 330);
            }
        }

     for(int j = 30;j <= 330;j += 30)
        {
          g.setColor(Color.WHITE);
        //������
          g.drawLine(30, j, 330, j);
        }
 }
 
 /*
  * ��������
  */
 void Drawchess(Graphics g)
 {
    for(int i = 0;i < 11;i++)
     {
       for(int j = 0;j < 11;j++)
        {
          if(chess[i][j] == 1)
            {
        	//����Ϊ1
              g.setColor(Color.BLACK);
              g.fillOval((i + 1) * 30 - 8, (j + 1) * 30 - 8, 16, 16);
            }
          if(chess[i][j] == 2)
            {
        	//����Ϊ2
              g.setColor(Color.WHITE);
              g.fillOval((i + 1) * 30 - 8, (j + 1) * 30 - 8, 16, 16);
            }
        }
     }
 }
 
 /*
  * �ж�˫����ʤ��
  */
 void Justisewiner()
 {
    int black_count = 0;
    int white_count = 0;
    int i = 0;
 
  //�����ж���Ӯ
    for(i = 0;i < 11;i++)
       {
         for(int j = 0;j < 11;j++)
             {
               if(chess[i][j] == 1)
                 {
                    black_count++;
                  //��������ж�
                    if(black_count == 5)
                      {
                        JOptionPane.showMessageDialog(this, "����ʤ��");
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
                   //��������ж�
                     if(white_count == 5)
                       {
                          JOptionPane.showMessageDialog(this, "����ʤ��");
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
   
    
  //�����ж���Ӯ
    for(i = 0;i < 11;i++)
      {
        for(int j = 0;j < 11;j++)
          {
            if(chess[j][i] == 1)
             {
               black_count++;
               if(black_count == 5)//��������ж�
                 {
                   JOptionPane.showMessageDialog(this, "����ʤ��");
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
            if(white_count == 5)//��������ж�
              {
                JOptionPane.showMessageDialog(this, "����ʤ��");
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

  //������б�ж�
   for(i = 0;i < 7;i++)
     {
       for(int j = 0;j < 7;j++)
         {
            for(int k = 0;k < 5;k++)
              {
                 if(chess[i + k][j + k] == 1)
                   {
                      black_count++;
                      if(black_count == 5)//��б�����ж�
                        {
                          JOptionPane.showMessageDialog(this, "����ʤ��");
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
                      if(white_count == 5)//��б�����ж�
                        {
                           JOptionPane.showMessageDialog(this, "����ʤ��");
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
   
 //������б�ж�
   for(i = 4;i < 11;i++)
     {
       for(int j = 6;j >= 0;j--)
         {
            for(int k = 0;k < 5;k++)
              {
                 if(chess[i - k][j + k] == 1)
                   {
                      black_count++;
                    //��б�����ж�
                      if(black_count == 5)
                        {
                           JOptionPane.showMessageDialog(this, "����ʤ��");
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
                     //��б�����ж�
                       if(white_count == 5)
                         {
                           JOptionPane.showMessageDialog(this, "����ʤ��");
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
       ��������ϵ��������������Ӧ����
       �������
       �ػ�����
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
 //����paint�ػ淽��
   repaint();
 }
 
 /*
  * ���û����̺ͻ����ӵķ���
  */
 public void paint(Graphics g)
 {
   Drawline(g);
   Drawchess(g);
 }
//������������ʱ������
 public void mouseExited(MouseEvent e){}
//����������ʱ������
 public void mouseEntered(MouseEvent e){}
//��갴�����ͷ�ʱ������
 public void mouseReleased(MouseEvent e){}
//��������¼�ʱ������
 public void mouseClicked(MouseEvent e){}
 
}

/*
 * �����ڹ���
 */
class myframe extends Frame implements WindowListener
{
  mypanel panel;
  myframe()
   {
	//����NULL����
     setLayout(null);
     panel = new mypanel();
     add(panel);
     panel.setBounds(0,23, 360, 360);
     setTitle("����������");
     setBounds(200, 200, 360, 383);
   //��ʾ����
     setVisible(true);
   //���ü���
     addWindowListener(this);
 
   }
  
  //��Ϸ�˳�
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
//������
public class chess
{
  public static void main(String[] argc)
   {
	  myframe f = new myframe() ;
   }
}


  
  








