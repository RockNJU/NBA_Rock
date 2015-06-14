package UI.Sta;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import UI.main.init;
import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;

public class A extends JPanel {

	int[] age_apart={20,30,40};//20以下，20-30,30-40,40以上
	int[] point_apart={10,20,30};//10以下，10-20,20-30,30以上
	/**
	 * Create the panel.
	 */
	public A() {
		setSize(1042,580);
		setLayout(null);
		setOpaque(false);
		//getSeasonAge("斯蒂芬-库里","12-13");
		JComboBox X = new JComboBox();
		X.setModel(new DefaultComboBoxModel(new String[] {"\u5E74\u9F84", "\u8EAB\u9AD8", "\u4F4D\u7F6E"}));
		X.setBounds(45, 57, 119, 32);
		add(X);
		
		JComboBox Y = new JComboBox();
		Y.setModel(new DefaultComboBoxModel(new String[] {"\u5F97\u5206", "\u7BEE\u677F", "\u52A9\u653B", "\u76D6\u5E3D", "\u62A2\u65AD"}));
		Y.setBounds(207, 57, 119, 32);
		add(Y);		
		
	}
	
	Object[][] paintTable(String according1,String according2,int[] apart1,int[] apart2){
		Object[][] re=new Object[apart1.length+1][apart2.length+1];
		
		ArrayList<PlayerSeasonDataVO> sample=new ArrayList<PlayerSeasonDataVO>();
		String[] season={"11-12","12-13","13-14","14-15"};
		for(int i=0;i<season.length;i++){
			ArrayList<PlayerSeasonDataVO> temp=init.pbl.getPlayerSeasonData(season[i]);
			for(int o=0;o<temp.size();o++){
				if(according1.equals("年龄")&&according2.equals("得分")){
					
				}
			}
		}
		return null;
	}
	int getSeasonAge(String na,String season){
		System.out.println(na);
		PlayerInfoVO pvo=init.pbl.getAPlayerInfo(na);
		String[] t=season.split("-");
		String curyear="20"+t[1];
		System.out.println(pvo.getBirth());
		String  y_y_y=pvo.getBirth().substring(0, 4);
		int re=Integer.parseInt(curyear)-Integer.parseInt(y_y_y);
		//System.out.println(re);
		return re;		
	}
	int Age_Apart(int x,int[] apart){
		if(x<apart[0]){
			return 0;
		}
		return x;
		
	}
}
