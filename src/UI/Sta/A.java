package UI.Sta;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import UI.common.CreateTable;
import UI.common.CreateTable_Four;
import UI.common.OftenUseMethod;
import UI.main.init;
import VO.PlayerInfoVO;
import VO.PlayerSeasonDataVO;

import javax.swing.JLabel;

public class A extends JPanel {

	//暂定区域都为4
	double[] age_apart={20,30,40};//20以下，20-30,30-40,40以上
	double[] point_apart={10,20,30};//10以下，10-20,20-30,30以上
	double[] height_apart={1.9,2.0,2.1};
	double[] rebound_apart={5,10,15};
	String[] title={"","","",""};
	CreateTable_Four datalist;
	CreateTable_Four datalist_1;
	Object[][] data=null;
	Object[][] data_1=null;
	int[] r1_4;
	int[] c1_4;
	JLabel A1,A2,A3,A4,B1,B2,B3,B4,X_A,X_B;
	JComboBox  X,Y;
	private JLabel lblNewLabel;
	private JLabel C1;
	private JLabel C2;
	private JLabel C3;
	private JLabel C4;
	private JLabel R1;
	private JLabel R2;
	private JLabel R3;
	private JLabel R4;
	JButton sure;
	private JLabel label;
	double _x2_;
	private JLabel lblNewLabel_1;
	private JLabel result;
	private JLabel lblx;
	private JLabel obvious;
	double flag=21.6660;
	/**
	 * Create the panel.
	 */
	public A() {
		setSize(1042,580);
		setLayout(null);
		setOpaque(false);
		//getSeasonAge("斯蒂芬-库里","12-13");
		X = new JComboBox();
		X.setModel(new DefaultComboBoxModel(new String[] {"年龄", "身高"}));
		X.setBounds(45, 57, 119, 32);
		add(X);
		X.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changeA1_4(X.getSelectedItem().toString());
			}
			
		});
		Y = new JComboBox();
		Y.setModel(new DefaultComboBoxModel(new String[] {"得分", "篮板"}));
		Y.setBounds(207, 57, 119, 32);
		add(Y);
		Y.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				changeB1_4(Y.getSelectedItem().toString());
			}
			
		});
		
		sure=new JButton("提交");
		sure.setLocation(369, 58);
		sure.setSize(60, 30);
		add(sure);
		sure.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if((X.getSelectedItem().toString().equals("年龄"))&&( Y.getSelectedItem().toString().equals("得分"))){
					data=paintTable(X.getSelectedItem().toString(), Y.getSelectedItem().toString(), age_apart, point_apart);				
				}else if((X.getSelectedItem().toString().equals("身高"))&&( Y.getSelectedItem().toString().equals("得分"))){
					data=paintTable(X.getSelectedItem().toString(), Y.getSelectedItem().toString(), height_apart, point_apart);
				}else if((X.getSelectedItem().toString().equals("年龄"))&&( Y.getSelectedItem().toString().equals("篮板"))){
					data=paintTable(X.getSelectedItem().toString(), Y.getSelectedItem().toString(), age_apart, rebound_apart);					
				}else {
					data=paintTable(X.getSelectedItem().toString(), Y.getSelectedItem().toString(), height_apart, rebound_apart);					
				}
				datalist.updateTable(title, data);
				datalist.setRowWidth(40);
				X_B.setText(Y.getSelectedItem().toString());
				X_A.setText(Y.getSelectedItem().toString());
				changeB1_4(Y.getSelectedItem().toString());
				changeA1_4(X.getSelectedItem().toString());
				//changeC_R(data);
				data_1=changeto_1(data);
				datalist_1.setRowWidth(30);
				datalist_1.updateTable(title, data_1);
				result.setText(String.valueOf(cal_x2_(data,data_1)));
				if(cal_x2_(data,data_1)>21.6660){
					obvious.setText(X.getSelectedItem().toString()+"和"+ Y.getSelectedItem().toString()+"具有显著关系");
				}else{
					obvious.setText(X.getSelectedItem().toString()+"和"+ Y.getSelectedItem().toString()+"不具有显著关系");
					
				}
			}
			
		});
		
		X_B = new JLabel();
		X_B.setBounds(64, 127,40, 40);
		add(X_B);
		
		
		X_A = new JLabel();
		X_A.setBounds(38, 155,40, 40);
		add(X_A);
		
		B1 = new JLabel("\u5F97\u5206");
		B1.setBounds(118, 144,40, 40);
		add(B1);
		
		B2 = new JLabel("\u5F97\u5206");
		B2.setBounds(158, 144,40, 40);
		add(B2);
		
		B3 = new JLabel("\u5F97\u5206");
		B3.setBounds(199, 144,40, 40);
		add(B3);
		
		B4 = new JLabel("\u5F97\u5206");
		B4.setBounds(241, 144,40, 40);
		add(B4);
		
		A1 = new JLabel("\u5E74\u9F84");
		A1.setBounds(64, 195,40, 40);
		add(A1);
		
		A2 = new JLabel("\u5E74\u9F84");
		A2.setBounds(64, 235,40, 40);
		add(A2);
		
		A3 = new JLabel("\u5E74\u9F84");
		A3.setBounds(64, 275,40, 40);
		add(A3);
		
		A4 = new JLabel("\u5E74\u9F84");
		A4.setBounds(64, 315,40, 40);
		add(A4);
		
		lblNewLabel = new JLabel("\u5217\u8054\u8868\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBounds(22, 99, 82, 32);
		add(lblNewLabel);
		
		C1 = new JLabel("\u5F97\u5206");
		C1.setBounds(124, 356, 40, 40);
		add(C1);
		
		C2 = new JLabel("\u5F97\u5206");
		C2.setBounds(164, 356, 40, 40);
		add(C2);
		
		C3 = new JLabel("\u5F97\u5206");
		C3.setBounds(205, 356, 40, 40);
		add(C3);
		
		C4 = new JLabel("\u5F97\u5206");
		C4.setBounds(247, 356, 40, 40);
		add(C4);
		
		R1 = new JLabel("\u5E74\u9F84");
		R1.setBounds(286, 195, 40, 40);
		add(R1);
		
		R2 = new JLabel("\u5E74\u9F84");
		R2.setBounds(286, 235, 40, 40);
		add(R2);
		
		R3 = new JLabel("\u5E74\u9F84");
		R3.setBounds(286, 275, 40, 40);
		add(R3);
		
		R4 = new JLabel("\u5E74\u9F84");
		R4.setBounds(286, 315, 40, 40);
		add(R4);
		
		datalist=new CreateTable_Four(title,data,112, 178, 175,185,40,new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
		datalist.setRowWidth(40);
		add(datalist);
		datalist_1=new CreateTable_Four(title,data_1,365, 178, 310,185,40,new Font("黑体", 0, 15), new Font("Dialog", 0, 12));
		datalist_1.setRowWidth(30);
		add(datalist_1);
		
		label = new JLabel("\u7406\u8BBA\u9891\u6570\u8868\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label.setBounds(369, 109, 119, 32);
		add(label);
		
		lblNewLabel_1 = new JLabel("\u5361\u65B9\u68C0\u9A8C\u7EDF\u8BA1\u91CF\u4E3A\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(86, 431, 145, 40);
		add(lblNewLabel_1);
		
		result = new JLabel();
		result.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		result.setBounds(231, 431, 108, 40);
		add(result);
		
		lblx = new JLabel("\u67E5\u8868\u5F97x2(0.01)(9)=21.6660");
		lblx.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblx.setBounds(86, 481, 240, 40);
		add(lblx);
		
		obvious = new JLabel("");
		obvious.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		obvious.setBounds(327, 481, 339, 40);
		add(obvious);
		
		/*
		Object[][] a={{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
		Object[][] b=changeto_1(a);
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
		cal_x2_(a,b);*/
		
		//getHeight("斯蒂芬-库里");
	}
	
	double cal_x2_(Object[][] a,Object[][]b){
		double re=0.00;
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				double temp=(Double.parseDouble(a[i][j].toString())-Double.parseDouble(b[i][j].toString()));
				System.out.println(i+"" +j+"  "+(temp*temp)/Double.parseDouble(b[i][j].toString()));
				re=re+(temp*temp)/Double.parseDouble(b[i][j].toString());
			}
		}
		re=OftenUseMethod.changedouble(re);
		System.out.println(re);
		return re;
		
	}
	
	Object[][] paintTable(String according1,String according2,double[] apart1,double[] apart2){
		Object[][] re=new Object[apart1.length+1][apart2.length+1];//4,4
		for(int m=0;m<apart1.length+1;m++){
			for(int n=0;n<apart2.length+1;n++){
				re[m][n]=0;
			}
		}
		ArrayList<PlayerSeasonDataVO> sample=new ArrayList<PlayerSeasonDataVO>();
		String[] season={"11-12","12-13","13-14","14-15"};
		for(int i=0;i<season.length;i++){
			ArrayList<PlayerSeasonDataVO> temp=init.pbl.getPlayerSeasonData(season[i]);
			for(int o=0;o<temp.size();o++){
				if(according1.equals("年龄")&&according2.equals("得分")){
					//满足年龄的区间位置
					if(getSeasonAge(temp.get(o).getName(),season[i])==0){
						//0 无效数据剔除
					}else{					
						int x1=Four_Apart(getSeasonAge(temp.get(o).getName(),season[i]),apart1);
						//满足得分的区间位置
						int x2=Four_Apart(temp.get(o).getPointNum_avg(),apart2);
						re[x1][x2]=Integer.parseInt(re[x1][x2].toString())+1;
					}
				}
				if(according1.equals("年龄")&&according2.equals("篮板")){
					//满足年龄的区间位置
					if(getSeasonAge(temp.get(o).getName(),season[i])==0){
						//0 无效数据剔除
					}else{					
						int x1=Four_Apart(getSeasonAge(temp.get(o).getName(),season[i]),apart1);
						//满足得分的区间位置
						int x2=Four_Apart(temp.get(o).getReboundNum_avg(),apart2);
						re[x1][x2]=Integer.parseInt(re[x1][x2].toString())+1;
					}
				}
				if(according1.equals("身高")&&according2.equals("得分")){
					if(getHeight(temp.get(o).getName())==0){
						//0 无效数据剔除
					}else{					
						int x1=Four_Apart(getHeight(temp.get(o).getName()),apart1);
						//满足得分的区间位置
						int x2=Four_Apart(temp.get(o).getPointNum_avg(),apart2);
						re[x1][x2]=Integer.parseInt(re[x1][x2].toString())+1;
					}
				}
				if(according1.equals("身高")&&according2.equals("篮板")){
					if(getHeight(temp.get(o).getName())==0){
						//0 无效数据剔除
					}else{					
						int x1=Four_Apart(getHeight(temp.get(o).getName()),apart1);
						//满足得分的区间位置
						int x2=Four_Apart(temp.get(o).getReboundNum_avg(),apart2);
						re[x1][x2]=Integer.parseInt(re[x1][x2].toString())+1;
					}
				}
			}
		}
		return re;
	}
	int getSeasonAge(String na,String season){
		//System.out.println(na);
		PlayerInfoVO pvo=init.pbl.getAPlayerInfo(na);
		String[] t=season.split("-");
		String curyear="20"+t[1];
		System.out.println(pvo.getBirth());
		if(pvo.getBirth().equals("??")){
			return 0; 
		}else{
			String  y_y_y=pvo.getBirth().substring(0, 4);
			int re=Integer.parseInt(curyear)-Integer.parseInt(y_y_y);
			//System.out.println(re);
			return re;		
		}
	}
	double getHeight(String na){
		PlayerInfoVO pvo=init.pbl.getAPlayerInfo(na);
		
		if(pvo.getHeight().equals("??")){
			return 0; 
		}else{
			String[]  y_y_y=pvo.getHeight().split("米");
			double re=Double.parseDouble(y_y_y[0]);
			//System.out.println(re);
			return re;		
		}
	}
	int Four_Apart(double x,double[] apart){
		if(x<=apart[0]){
			return 0;
		}else if((x>apart[0])&&(x<=apart[1]) ){
			return 1;
		}else if((x>apart[1])&&(x<=apart[2])){
			return 2;
		}else if(x>apart[2]){
			return 3;
		}else{
			return -1;
		}
	}
	void changeA1_4(String according){
		if(according.equals("年龄")){
			X_A.setText("年龄");
			A1.setText("<="+age_apart[0]);
			A2.setText(age_apart[0]+"~"+age_apart[1]);
			A3.setText(age_apart[1]+"~"+age_apart[2]);
			A4.setText(">="+age_apart[2]);
		}
		if(according.equals("身高")){
			X_A.setText("身高");
			System.out.println("ss");
			A1.setText("<="+height_apart[0]);
			A2.setText(height_apart[0]+"~"+height_apart[1]);
			A3.setText(height_apart[1]+"~"+height_apart[2]);
			A4.setText(">="+height_apart[2]);
		}
	}
	void changeB1_4(String according){
		if(according.equals("得分")){
			B1.setText("<="+point_apart[0]);
			B2.setText(point_apart[0]+"~"+point_apart[1]);
			B3.setText(point_apart[1]+"~"+point_apart[2]);
			B4.setText(">="+point_apart[2]);
		}
		if(according.equals("篮板")){
			B1.setText("<="+rebound_apart[0]);
			B2.setText(rebound_apart[0]+"~"+rebound_apart[1]);
			B3.setText(rebound_apart[1]+"~"+rebound_apart[2]);
			B4.setText(">="+rebound_apart[2]);
		}	
	}
/*
	void changeC_R(Object[][] da){
		int r1=Integer.parseInt(da[0][0].toString())+Integer.parseInt(da[0][1].toString())
				+Integer.parseInt(da[0][2].toString())+Integer.parseInt(da[0][3].toString());
		int r2=Integer.parseInt(da[1][0].toString())+Integer.parseInt(da[1][1].toString())
				+Integer.parseInt(da[1][2].toString())+Integer.parseInt(da[1][3].toString());
		int r3=Integer.parseInt(da[2][0].toString())+Integer.parseInt(da[2][1].toString())
		+Integer.parseInt(da[2][2].toString())+Integer.parseInt(da[2][3].toString());
		int r4=Integer.parseInt(da[3][0].toString())+Integer.parseInt(da[3][1].toString())
		+Integer.parseInt(da[3][2].toString())+Integer.parseInt(da[3][3].toString());
		
		int c1=Integer.parseInt(da[0][0].toString())+Integer.parseInt(da[1][0].toString())
				+Integer.parseInt(da[2][0].toString())+Integer.parseInt(da[3][0].toString());
		int c2=Integer.parseInt(da[0][1].toString())+Integer.parseInt(da[1][1].toString())
				+Integer.parseInt(da[2][1].toString())+Integer.parseInt(da[3][1].toString());
		int c3=Integer.parseInt(da[0][2].toString())+Integer.parseInt(da[1][2].toString())
		+Integer.parseInt(da[2][2].toString())+Integer.parseInt(da[3][2].toString());
		int c4=Integer.parseInt(da[0][3].toString())+Integer.parseInt(da[1][3].toString())
		+Integer.parseInt(da[2][3].toString())+Integer.parseInt(da[3][3].toString());
		r1_4[0]=r1;
		r1_4[1]=r2;
		r1_4[2]=r3;
		r1_4[3]=r4;
		c1_4[0]=c1;
		c1_4[1]=c2;
		c1_4[2]=c3;
		c1_4[3]=c4;
		
	}*/
	Object[][] changeto_1(Object[][] initial){
		int r[]=new int[4];
		int c[]=new int[4];
		for(int o=0;o<4;o++){
			r[o]=Integer.parseInt(initial[o][0].toString())+
					Integer.parseInt(initial[o][1].toString())
					+Integer.parseInt(initial[o][2].toString())
					+Integer.parseInt(initial[o][3].toString());
		}
		for(int o=0;o<4;o++){
			c[o]=Integer.parseInt(initial[0][o].toString())+
					Integer.parseInt(initial[1][o].toString())
					+Integer.parseInt(initial[2][o].toString())
					+Integer.parseInt(initial[3][o].toString());
		}
		R1.setText(String.valueOf(r[0]));
		R2.setText(String.valueOf(r[1]));
		R3.setText(String.valueOf(r[2]));
		R4.setText(String.valueOf(r[3]));
		C1.setText(String.valueOf(c[0]));
		C2.setText(String.valueOf(c[1]));
		C3.setText(String.valueOf(c[2]));
		C4.setText(String.valueOf(c[3]));
		int total=r[0]+r[1]+r[2]+r[3];
		Object[][] re=new Object[4][4];
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				re[i][j]=((double)c[j]*r[i]/(double)total);
			}
		}	
		return re;		
	}
	
	
	
}
