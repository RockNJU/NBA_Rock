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
	
	//MatchBLService mbl;
	/*
	JButton changjundefen;
	JButton changjungaimao;
	JButton changjunlanban;
	JButton changjunqiangduan;
	JButton changjunzhugong;
	JButton faqiumingzhonglv;
	JButton gaimao;
	
	JButton lanban;
	JButton qiangduan;
	JButton sanfenmingzhonglv;
	JButton toulanmingzhonglv;
	JButton zhugong;
	*/
	JButton pday;
	JButton pseason;
	JButton pfast;
	JButton tseason;
	
	//队员
	JButton defen=new JButton(new ImageIcon("pic/hotbut/得分.jpg"));
	JButton lanban=new JButton(new ImageIcon("pic/hotbut/篮板.jpg"));
	JButton zhugong=new JButton(new ImageIcon("pic/hotbut/助攻.jpg"));
	JButton gaimao=new JButton(new ImageIcon("pic/hotbut/盖帽.jpg"));
	JButton qiangduan=new JButton(new ImageIcon("pic/hotbut/抢断.jpg"));
	
	JButton changjundefen=new JButton(new ImageIcon("pic/hotbut/场均得分.jpg"));
	JButton changjunlanban=new JButton(new ImageIcon("pic/hotbut/场均篮板.jpg"));
	JButton changjunzhugong=new JButton(new ImageIcon("pic/hotbut/场均助攻.jpg"));
	JButton changjungaimao=new JButton(new ImageIcon("pic/hotbut/场均盖帽.jpg"));
	JButton changjunqiangduan=new JButton(new ImageIcon("pic/hotbut/场均抢断.jpg"));
	JButton sanfenmingzhonglv=new JButton(new ImageIcon("pic/hotbut/三分命中率.jpg"));
	JButton toulanmingzhonglv=new JButton(new ImageIcon("pic/hotbut/投篮命中率.jpg"));
	JButton faqiumingzhonglv=new JButton(new ImageIcon("pic/hotbut/罚球命中率.jpg"));
	
	JButton changjundefena=new JButton(new ImageIcon("pic/hotbut/场均得分.jpg"));
	JButton changjunlanbana=new JButton(new ImageIcon("pic/hotbut/场均篮板.jpg"));
	JButton changjunzhugonga=new JButton(new ImageIcon("pic/hotbut/场均助攻.jpg"));
	//队伍
	JButton changjundefen1=new JButton(new ImageIcon("pic/hotbut/场均得分.jpg"));
	JButton changjunlanban1=new JButton(new ImageIcon("pic/hotbut/场均篮板.jpg"));
	JButton changjunzhugong1=new JButton(new ImageIcon("pic/hotbut/场均助攻.jpg"));
	JButton changjungaimao1=new JButton(new ImageIcon("pic/hotbut/场均盖帽.jpg"));
	JButton changjunqiangduan1=new JButton(new ImageIcon("pic/hotbut/场均抢断.jpg"));
	JButton faqiumingzhonglv1=new JButton(new ImageIcon("pic/hotbut/罚球命中率.jpg"));
	JButton sanfenmingzhonglv1=new JButton(new ImageIcon("pic/hotbut/三分命中率.jpg"));
	JButton toulanmingzhonglv1=new JButton(new ImageIcon("pic/hotbut/投篮命中率.jpg"));
	

	//监听
	
	/**
	 * Create the panel.
	 */
	public Hot() {
		setLayout(null);
		setSize(764,635);
		setOpaque(false);
		
		
		
		pday = new JButton(new ImageIcon("pic/hotbut/上侧_每日a.jpg"));
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
	            	//pday.setIcon(new ImageIcon("pic/hotbut/上侧_每日a.jpg"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	cmdplayer="day";
	            	pday.setIcon(new ImageIcon("pic/hotbut/上侧_每日a.jpg"));
	            	pseason.setIcon(new ImageIcon("pic/hotbut/上侧_赛季.jpg"));
	            	pfast.setIcon(new ImageIcon("pic/hotbut/上侧_进步最快.jpg"));
	            	changetoolp("day");
	            }	
	       
		});
		
		pday.setToolTipText("每日热点球员");
		pday.setBounds(540, 139, 53, 28);
		add(pday);
		pday.setVisible(true);
		
		pseason = new JButton(new ImageIcon("pic/hotbut/上侧_赛季.jpg"));
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
	            	//pseason.setIcon(new ImageIcon("pic/hotbut/上侧_每日a.jpg"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	cmdplayer="season";
	            	pday.setIcon(new ImageIcon("pic/hotbut/上侧_每日.jpg"));
	            	pseason.setIcon(new ImageIcon("pic/hotbut/上侧_赛季a.jpg"));
	            	pfast.setIcon(new ImageIcon("pic/hotbut/上侧_进步最快.jpg"));
	            	changetoolp("season");
	            }	
	       
		});
		
		pseason.setToolTipText("赛季热点球员");
		pseason.setBounds(598, 139, 53, 28);
		add(pseason);
		pseason.setVisible(true);
		
		pfast = new JButton(new ImageIcon("pic/hotbut/上侧_进步最快.jpg"));
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
	            	//pseason.setIcon(new ImageIcon("pic/hotbut/上侧_每日a.jpg"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	cmdplayer="fast";
	            	pday.setIcon(new ImageIcon("pic/hotbut/上侧_每日.jpg"));
	            	pseason.setIcon(new ImageIcon("pic/hotbut/上侧_赛季.jpg"));
	            	pfast.setIcon(new ImageIcon("pic/hotbut/上侧_进步最快a.jpg"));
	            	changetoolp("fast");
	            }	
	       
		});
		
		pfast.setToolTipText("进步最快球员");
		pfast.setBounds(656, 139, 95, 28);
		add(pfast);
		pfast.setVisible(true);
		
		toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(10, 174, 746, 25);
		toolBar.setOpaque(false);
		
		toolBar.add(defen);
		toolBar.add(lanban);
		toolBar.add(zhugong);
		toolBar.add(gaimao);
		toolBar.add(qiangduan);
		add(toolBar);
		
		
		
		tseason = new JButton(new ImageIcon("pic/hotbut/上侧_赛季a.jpg"));
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
	            	
	                // TODO Auto-generated method stub
	            	//pseason.setIcon(new ImageIcon("pic/hotbut/上侧_每日a.jpg"));
	            	
	            }            
	                         
	            @Override
	            public void mouseClicked(MouseEvent e) {
	            	
	            	tseason.setIcon(new ImageIcon("pic/hotbut/上侧_赛季a.jpg"));
	            	
	            }	
	       
		});
		
		tseason.setToolTipText("赛季热点球队");
		tseason.setBounds(700, 390, 53, 28);
		add(tseason);
		tseason.setVisible(true);
			
		
		toolBar1 = new JToolBar();
		toolBar1.setFloatable(false);
		toolBar1.setBounds(10, 425, 746, 25);
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
		
		/*
		defen = new JButton("");
		defen.setIcon(new ImageIcon("pic\\hotbut\\\u5F97\u5206.jpg"));
		toolBar.add(defen);
		
		lanban = new JButton("");
		lanban.setIcon(new ImageIcon("pic\\hotbut\\\u7BEE\u677F.jpg"));
		toolBar.add(lanban);
		
		zhugong = new JButton("");
		zhugong.setIcon(new ImageIcon("pic\\hotbut\\\u52A9\u653B.jpg"));
		toolBar.add(zhugong);
		
		gaimao = new JButton("");
		gaimao.setIcon(new ImageIcon("pic\\hotbut\\盖帽.jpg"));
		toolBar.add(gaimao);
		
		qiangduan = new JButton("");
		qiangduan.setIcon(new ImageIcon("pic\\hotbut\\抢断.jpg"));
		toolBar.add(qiangduan);
		
		
		ArrayList<String> tmps=new ArrayList<String>();
		tmps.add("Aaron Brooks");
		tmps.add("Aaron Gray");
		tmps.add("Adonis Thomas");
		tmps.add("Al Harrington");
		tmps.add("Al Horford");
		
		hp=new HotPlayers("","");
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(10, 200, 746,170);
		p1.setOpaque(false);
		p1.add(hp);
		
		hp.setLocation(0, 0);
		add(p1);
		
		ArrayList<String> tmps2=new ArrayList<String>();
		tmps2.add("ATL");
		tmps2.add("BKN");
		tmps2.add("DEN");
		tmps2.add("DET");
		tmps2.add("DAL");
		
		ht=new HotTeams("tmps","");
		p2=new JPanel();
		p2.setLayout(null);
		p2.setOpaque(false);
		p2.setBounds(10, 450, 746,170);
		p2.add(ht);	
		
		ht.setLocation(0, 0);
		add(p2);
		*/
		init.currentpanel="hot&"+"每日,得分总;球队赛季,得分";

		
		HotPlayers hp = new HotPlayers("每日","得分总");
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(10, 200, 746,170);
		p1.setOpaque(false);
		p1.add(hp);
		add(p1);
		//changep1(hp);

		
		p2=new JPanel();
		HotTeams ht = new HotTeams("球队赛季","得分");
		p2.setLayout(null);
		p2.setOpaque(false);
		p2.setBounds(10, 450, 746,170);
		p2.add(ht);
		add(p2);
		
		//一坨监听 
		defen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("每日","得分总");
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
				HotPlayers hp = new HotPlayers("进步最快","得分");
				changep1(hp);
			}
		});
		changjunlanbana.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("进步最快","篮板");
				changep1(hp);
			}
		});
		changjunzhugonga.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HotPlayers hp = new HotPlayers("进步最快","助攻");
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
				
				ImageIcon image1 = new ImageIcon("pic/热门信息.jpg");
				//image1.setImage(image1.getImage().getScaledInstance(753, 510,Image.SCALE_DEFAULT)); 		
				JLabel lblNewLabel = new JLabel(image1);
				lblNewLabel.setBounds(10, 5, 746, 120);
				lblNewLabel.setOpaque(false);
				add(lblNewLabel);
				
				ImageIcon image = new ImageIcon("pic/热点.png");
				image.setImage(image.getImage().getScaledInstance(753, 510,Image.SCALE_DEFAULT)); 		
				JLabel photo = new JLabel(image);		
				photo.setBounds(7, 125, 753, 510);		
				photo.setOpaque(false);
				add(photo);
				
				
	
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
