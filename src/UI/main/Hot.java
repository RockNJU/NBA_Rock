package UI.main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.apache.batik.apps.rasterizer.SVGConverterException;

import businessService.blservice.MatchBLService;
import VO.PlayerSeasonDataVO;




public class Hot extends JPanel {
	JToolBar toolBar;
	JToolBar toolBar1;
	
	static JPanel p1;
	static JPanel p2;
	HotPlayers hp;
	HotTeams ht;
	String cmdplayer="day";
	
	
	JButton pday;
	JButton pseason;
	JButton pfast;
	JButton tseason;
	
	//队员
	JButton defen=new JButton(new ImageIcon("newpic/hotbut/得分.jpg"));
	JButton lanban=new JButton(new ImageIcon("newpic/hotbut/篮板.jpg"));
	JButton zhugong=new JButton(new ImageIcon("newpic/hotbut/助攻.jpg"));
	JButton gaimao=new JButton(new ImageIcon("newpic/hotbut/盖帽.jpg"));
	JButton qiangduan=new JButton(new ImageIcon("newpic/hotbut/抢断.jpg"));
	
	JButton changjundefen=new JButton(new ImageIcon("newpic/hotbut/场均得分.jpg"));
	JButton changjunlanban=new JButton(new ImageIcon("newpic/hotbut/场均篮板.jpg"));
	JButton changjunzhugong=new JButton(new ImageIcon("newpic/hotbut/场均助攻.jpg"));
	JButton changjungaimao=new JButton(new ImageIcon("newpic/hotbut/场均盖帽.jpg"));
	JButton changjunqiangduan=new JButton(new ImageIcon("newpic/hotbut/场均抢断.jpg"));
	JButton sanfenmingzhonglv=new JButton(new ImageIcon("newpic/hotbut/三分命中率.jpg"));
	JButton toulanmingzhonglv=new JButton(new ImageIcon("newpic/hotbut/投篮命中率.jpg"));
	JButton faqiumingzhonglv=new JButton(new ImageIcon("newpic/hotbut/罚球命中率.jpg"));
	
	JButton changjundefena=new JButton(new ImageIcon("newpic/hotbut/场均得分.jpg"));
	JButton changjunlanbana=new JButton(new ImageIcon("newpic/hotbut/场均篮板.jpg"));
	JButton changjunzhugonga=new JButton(new ImageIcon("newpic/hotbut/场均助攻.jpg"));
	//队伍
	JButton changjundefen1=new JButton(new ImageIcon("newpic/hotbut/场均得分.jpg"));
	JButton changjunlanban1=new JButton(new ImageIcon("newpic/hotbut/场均篮板.jpg"));
	JButton changjunzhugong1=new JButton(new ImageIcon("newpic/hotbut/场均助攻.jpg"));
	JButton changjungaimao1=new JButton(new ImageIcon("newpic/hotbut/场均盖帽.jpg"));
	JButton changjunqiangduan1=new JButton(new ImageIcon("newpic/hotbut/场均抢断.jpg"));
	JButton faqiumingzhonglv1=new JButton(new ImageIcon("newpic/hotbut/罚球命中率.jpg"));
	JButton sanfenmingzhonglv1=new JButton(new ImageIcon("newpic/hotbut/三分命中率.jpg"));
	JButton toulanmingzhonglv1=new JButton(new ImageIcon("newpic/hotbut/投篮命中率.jpg"));
	

	//监听
	
	/**
	 * Create the panel.
	 */
	public Hot() {
		setLayout(null);
		setSize(1060, 639);
		setOpaque(false);
		
		
		pday = new JButton(new ImageIcon("newpic/hotbut/上侧_每日a.jpg"));
		pday.addMouseListener(new MouseListener() {
			 @Override
	            public void mouseReleased(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }           
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }          
	            @Override
	            public void mouseExited(MouseEvent e) {
	                // TODO Auto-generated method stub
	            	
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	//pday.setIcon(new ImageIcon("newpic/hotbut/上侧_每日a.jpg"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	cmdplayer="day";
	            	pday.setIcon(new ImageIcon("newpic/hotbut/上侧_每日a.jpg"));
	            	pseason.setIcon(new ImageIcon("newpic/hotbut/上侧_赛季.jpg"));
	            	pfast.setIcon(new ImageIcon("newpic/hotbut/上侧_进步最快.jpg"));
	            	changetoolp("day");
	            }	
	       
		});
		
		pday.setToolTipText("每日热点球员");
		pday.setBounds(839, 25, 53, 28);
		add(pday);
		pday.setVisible(true);
		
		pseason = new JButton(new ImageIcon("newpic/hotbut/上侧_赛季.jpg"));
		pseason.addMouseListener(new MouseListener() {
			 @Override
	            public void mouseReleased(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }           
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }          
	            @Override
	            public void mouseExited(MouseEvent e) {
	                // TODO Auto-generated method stub
	            	
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	//pseason.setIcon(new ImageIcon("newpic/hotbut/上侧_每日a.jpg"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	cmdplayer="season";
	            	pday.setIcon(new ImageIcon("newpic/hotbut/上侧_每日.jpg"));
	            	pseason.setIcon(new ImageIcon("newpic/hotbut/上侧_赛季a.jpg"));
	            	pfast.setIcon(new ImageIcon("newpic/hotbut/上侧_进步最快.jpg"));
	            	changetoolp("season");
	            }	
	       
		});
		
		pseason.setToolTipText("赛季热点球员");
		pseason.setBounds(897, 25, 53, 28);
		add(pseason);
		pseason.setVisible(true);
		
		pfast = new JButton(new ImageIcon("newpic/hotbut/上侧_进步最快.jpg"));
		pfast.addMouseListener(new MouseListener() {
			 @Override
	            public void mouseReleased(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }           
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }          
	            @Override
	            public void mouseExited(MouseEvent e) {
	                // TODO Auto-generated method stub
	            	
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                // TODO Auto-generated method stub
	            	//pseason.setIcon(new ImageIcon("newpic/hotbut/上侧_每日a.jpg"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	cmdplayer="fast";
	            	pday.setIcon(new ImageIcon("newpic/hotbut/上侧_每日.jpg"));
	            	pseason.setIcon(new ImageIcon("newpic/hotbut/上侧_赛季.jpg"));
	            	pfast.setIcon(new ImageIcon("newpic/hotbut/上侧_进步最快a.jpg"));
	            	changetoolp("fast");
	            }	
	       
		});
		
		pfast.setToolTipText("进步最快球员");
		pfast.setBounds(955, 25, 95, 28);
		add(pfast);
		pfast.setVisible(true);
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(10, 62, 1040, 25);
		toolBar.setOpaque(false);
		
		toolBar.add(defen);
		toolBar.add(lanban);
		toolBar.add(zhugong);
		toolBar.add(gaimao);
		toolBar.add(qiangduan);
		add(toolBar);
		toolBar.setBorderPainted(false);
		
		
		tseason = new JButton(new ImageIcon("newpic/hotbut/上侧_赛季a.jpg"));
		tseason.addMouseListener(new MouseListener() {
			 @Override
	            public void mouseReleased(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }           
	            @Override
	            public void mousePressed(MouseEvent e) {
	                // TODO Auto-generated method stub                
	            }          
	            @Override
	            public void mouseExited(MouseEvent e) {
	                // TODO Auto-generated method stub
	            	
	            }           
	            @Override
	            public void mouseEntered(MouseEvent e) {
	            	
	                
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	
	            	tseason.setIcon(new ImageIcon("newpic/hotbut/上侧_赛季a.jpg"));
	            	
	            }	
	       
		});
		
		tseason.setToolTipText("赛季热点球队");
		tseason.setBounds(997, 334, 53, 28);
		add(tseason);
		tseason.setVisible(true);
			
		
		toolBar1 = new JToolBar();
		toolBar1.setFloatable(false);
		toolBar1.setBounds(10, 375, 746, 25);
		toolBar1.setOpaque(false);
		
		toolBar1.add(changjundefen1);
		toolBar1.add(changjunlanban1);
		toolBar1.add(changjunzhugong1);
		toolBar1.add(changjungaimao1);
		toolBar1.add(changjunqiangduan1);			
		toolBar1.add(sanfenmingzhonglv1);
		toolBar1.add(toulanmingzhonglv1);
		toolBar1.add(faqiumingzhonglv1);
		add(toolBar1);
		toolBar1.setBorderPainted(false);

		
		HotPlayers hp = new HotPlayers("每日","总分");
		hp.setBounds(0, 0, 1040, 256);
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(10, 58, 1040,256);
		p1.setOpaque(false);
		p1.add(hp);
		add(p1);
		//changep1(hp);

		
		p2=new JPanel();
		HotTeams ht = new HotTeams("球队赛季","得分");
		ht.setBounds(0, 0, 1040, 257);
		p2.setLayout(null);
		p2.setOpaque(false);
		p2.setBounds(10, 372, 1040,257);
		p2.add(ht);
		add(p2);
		

	
		//一坨监听 
		defen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("每日","总分");
				changep1(hp);
			}
		});
		lanban.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("每日","篮板数");
				changep1(hp);
			}
		});
		zhugong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("每日","助攻数");
				changep1(hp);
			}
		});
		qiangduan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("每日","抢断数");
				changep1(hp);
			}
		});
		gaimao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("每日","盖帽数");
				changep1(hp);
			}
		});

		//赛季
		changjundefen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("赛季","得分");
				changep1(hp);
			}
		});
		changjunlanban.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("赛季","篮板");
				changep1(hp);
			}
		});
		changjunzhugong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("赛季","助攻");
				changep1(hp);
			}
		});
		changjungaimao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("赛季","盖帽");
				changep1(hp);
			}
		});
		changjunqiangduan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("赛季","抢断");
				changep1(hp);
			}
		});
		sanfenmingzhonglv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("赛季","三分命中率");
				changep1(hp);
			}
		});
		toulanmingzhonglv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("赛季","投篮命中率");
				changep1(hp);
			}
		});
		faqiumingzhonglv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("赛季","罚球命中率");
				changep1(hp);
			}
		});
		
		//进步最快
		changjundefena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("进步最快","l_f_point_rate");
				changep1(hp);
			}
		});
		changjunlanbana.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("进步最快","l_f_rebound_rate");
				changep1(hp);
			}
		});
		changjunzhugonga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("进步最快","l_f_assist_rate");
				changep1(hp);
			}
		});
		
		//队伍
				changjundefen1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						HotTeams ht = new HotTeams("球队赛季","得分");
						changep2(ht);
					}
				});
				changjunlanban1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						HotTeams ht = new HotTeams("球队赛季","篮板");
						changep2(ht);
					}
				});
				changjunzhugong1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						HotTeams ht = new HotTeams("球队赛季","助攻");
						changep2(ht);
					}
				});
				changjungaimao1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						HotTeams ht = new HotTeams("球队赛季","盖帽");
						changep2(ht);
					}
				});
				changjunqiangduan1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						HotTeams ht = new HotTeams("球队赛季","抢断");
						changep2(ht);
					}
				});
				sanfenmingzhonglv1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						HotTeams ht = new HotTeams("球队赛季","三分命中率");
						changep2(ht);
					}
				});
				toulanmingzhonglv1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						HotTeams ht = new HotTeams("球队赛季","投篮命中率");
						changep2(ht);
					}
				});
				faqiumingzhonglv1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						HotTeams ht = new HotTeams("球队赛季","罚球命中率");
						changep2(ht);
					}
				});
				
			
				ImageIcon bg1=new ImageIcon("newpic/labelcolor.png");
				bg1.setImage(bg1.getImage().getScaledInstance(  1045,255,Image.SCALE_DEFAULT));
				JLabel menubg_1 = new JLabel(bg1);
				//menubg_1.setBackground(init.syswhite);
				menubg_1.setBounds(5, 90, 1045,220);
				//menubg_1.setOpaque(false);
				add(menubg_1);
				JLabel menubg_2 = new JLabel(bg1);
				menubg_2.setBounds(5, 405, 1045, 220);
				add(menubg_2);
				
	}
	
	
	
	private void changetoolp(String com){
		if(com.equals("season")){
			toolBar.removeAll();
			toolBar.add(changjundefen);
			toolBar.add(changjunlanban);
			toolBar.add(changjunzhugong);
			toolBar.add(changjungaimao);
			toolBar.add(changjunqiangduan);			
			toolBar.add(sanfenmingzhonglv);
			toolBar.add(toulanmingzhonglv);
			toolBar.add(faqiumingzhonglv);
			toolBar.validate();
			toolBar.repaint();
		}
		else if(com.equals("day")){
			toolBar.removeAll();
			toolBar.add(defen);
			toolBar.add(lanban);
			toolBar.add(zhugong);
			toolBar.add(gaimao);
			toolBar.add(qiangduan);
			toolBar.validate();
			toolBar.repaint();
		}
		else {
			toolBar.removeAll();
			toolBar.add(changjundefena);
			toolBar.add(changjunlanbana);
			toolBar.add(changjunzhugonga);
			toolBar.validate();
			toolBar.repaint();
		}
	}
	
	static void changep1(HotPlayers newhp){
		p1.removeAll();
		p1.add(newhp);
		newhp.setLocation(0, 0);
		p1.validate();
		p1.repaint();
	}
	static void changep2(HotTeams newht){
		p2.removeAll();
		p2.add(newht);
		newht.setLocation(0, 0);
		p2.validate();
		p2.repaint();
	}
}
