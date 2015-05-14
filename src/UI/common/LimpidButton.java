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
            img=new ImageIcon(imagePath).getImage(); //读取本地图片
            mt=new MediaTracker(this);//为此按钮添加媒体跟踪器
            mt.addImage(img,0);//在跟踪器添加图片，下标为0
            mt.waitForAll();   //等待加载
            w=img.getWidth(this);//读取图片长度
            h=img.getHeight(this);//读取图片宽度
                      
            GraphicsConfiguration gc = new JFrame().getGraphicsConfiguration(); // 本地图形设备        
            Image image = gc.createCompatibleImage(w,h,Transparency.TRANSLUCENT);//建立透明画布
            Graphics2D g=(Graphics2D)image.getGraphics(); //在画布上创建画笔
      
            Composite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .8f); //指定透明度为半透明90%
            g.setComposite(alpha);
            g.drawImage(img,0,0,this); //注意是,将image画到g画笔所在的画布上
            g.setColor(Color.black);//设置颜色为黑色
            g.drawString(name, 25, 20);//写字
            g.dispose(); //释放内存
            
            Composite alpha2 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f); 
            Image image1 =gc.createCompatibleImage(w,h,Transparency.TRANSLUCENT);
            g=(Graphics2D)image1.getGraphics();       
            g.setComposite(alpha2);
            g.drawImage(img,0,0,this); //改变图像起始位置,产生动态效果
            g.setColor(Color.black);
            g.drawString(name, 25, 20);
            g.dispose();
    
            this.setIgnoreRepaint(true);
            this.setFocusable(false);//设置没有焦点
            this.setBorder(null);//设置不画按钮边框
            this.setContentAreaFilled(false);//设置不画按钮背景
            this.setIcon(new ImageIcon(image1)); //把刚才生成的半透明image变成ImageIcon,贴到按钮上去
            this.setRolloverIcon(new ImageIcon(image1));
            this.setPressedIcon(new ImageIcon(image));//按下去的图标
         }catch(Exception e)
         {
             e.printStackTrace();
          }
 }
}