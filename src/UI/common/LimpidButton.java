package UI.common;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Transparency;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LimpidButton extends JButton
{
 Image img;
 MediaTracker mt;
 int w;
 int h;
 
 public LimpidButton(String name,String imagePath)
 {            
        try
        {            
            img=new ImageIcon(imagePath).getImage(); //��ȡ����ͼƬ
            mt=new MediaTracker(this);//Ϊ�˰�ť���ý�������
            mt.addImage(img,0);//�ڸ��������ͼƬ���±�Ϊ0
            mt.waitForAll();   //�ȴ�����
            w=img.getWidth(this);//��ȡͼƬ����
            h=img.getHeight(this);//��ȡͼƬ���
                      
            GraphicsConfiguration gc = new JFrame().getGraphicsConfiguration(); // ����ͼ���豸        
            Image image = gc.createCompatibleImage(w,h,Transparency.TRANSLUCENT);//����͸������
            Graphics2D g=(Graphics2D)image.getGraphics(); //�ڻ����ϴ�������
      
            Composite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .8f); //ָ��͸����Ϊ��͸��90%
            g.setComposite(alpha);
            g.drawImage(img,0,0,this); //ע����,��image����g�������ڵĻ�����
            g.setColor(Color.black);//������ɫΪ��ɫ
            g.drawString(name, 25, 20);//д��
            g.dispose(); //�ͷ��ڴ�
            
            Composite alpha2 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f); 
            Image image1 =gc.createCompatibleImage(w,h,Transparency.TRANSLUCENT);
            g=(Graphics2D)image1.getGraphics();       
            g.setComposite(alpha2);
            g.drawImage(img,0,0,this); //�ı�ͼ����ʼλ��,������̬Ч��
            g.setColor(Color.black);
            g.drawString(name, 25, 20);
            g.dispose();
    
            this.setIgnoreRepaint(true);
            this.setFocusable(false);//����û�н���
            this.setBorder(null);//���ò�����ť�߿�
            this.setContentAreaFilled(false);//���ò�����ť����
            this.setIcon(new ImageIcon(image1)); //�Ѹղ����ɵİ�͸��image���ImageIcon,������ť��ȥ
            this.setRolloverIcon(new ImageIcon(image1));
            this.setPressedIcon(new ImageIcon(image));//����ȥ��ͼ��
         }catch(Exception e)
         {
             e.printStackTrace();
          }
 }
}