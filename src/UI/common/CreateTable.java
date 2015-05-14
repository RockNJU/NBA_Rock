package UI.common;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CreateTable extends JPanel{

	    	
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	 JScrollPane roll;
	 JTable table;
	String []headTitle;
	int rowHeight;
		Object data[][];
		Font fbig;
		Font fsmall;
		  Color a=new Color(255,219,151);
		 // int tablew=0;
		public CreateTable(String title[], Object datas[][],int x,int y,int width,int height,int rowheight,Font Fbig,Font Fsmall){
			/*这本身是一个Panel,panel 是可以直接用的，传进信息便可以了直接使用*/
			/*title 是表头信息，data 是传进来的数据，二维字符串数组,x,y 是表格的坐标，wideth,height 是大小的设置*/
			//this.setLayout(null);
			this.setBounds(x, y, width, height);
			this.data=datas;
			this.headTitle=title;
			this.rowHeight=rowheight;
			this.fbig=Fbig;
			this.fsmall=Fsmall;
			
			//table=new JTable(data,headTitle) ;
			table = new JTable();
			table.setModel(new DefaultTableModel(
					data,headTitle) {
				boolean[] columnEditables = new boolean[] {
					false, true
				};
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
			
			
			
			table.setRowHeight(rowHeight);
			table.setBackground(new Color(252, 213, 146));
			table.setSelectionBackground(new Color(67, 54, 49));
			table.setSelectionForeground(Color.WHITE);
			table.setFont(fsmall);
			table.getTableHeader().setFont(fbig);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setFillsViewportHeight(true); 
			table.setAutoCreateRowSorter(true);
			table.setDefaultRenderer(Object.class, new FenseRenderer());
			table.setOpaque(false);// 初始化表格为透明
			//table.setEnabled(false);
			// 其他一些属性
			table.setShowGrid(false);
			table.getSelectionModel().setSelectionMode(
					ListSelectionModel.SINGLE_SELECTION); // 只允许单选

			table.setDragEnabled(false); // 不许乱拖动
			table.getTableHeader().setReorderingAllowed(false);
			 //获得表头
				JTableHeader tableH = table.getTableHeader();
			    //设置表头的背景色
			    tableH.setBackground(a);
			    //设置表头的文字颜色
			     tableH.setForeground(Color.DARK_GRAY);
			    tableH.setOpaque(false);

			
			
			FitTableColumns(table);		
			roll=new JScrollPane(table);
			roll.getViewport().setBackground(a);
			roll.setPreferredSize(new Dimension(width,height-10)); 
			roll.setLocation(0, 0);
			roll.setVisible(true);
			this.setBackground(new Color(252, 213, 146));
	    	roll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    	roll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    	this.add(roll);
	    		
			
		}
		
	
		public JScrollPane getJScrollPane(){
			return roll;
		}
		
		public void updateTable(String[] newheadTitle,Object info[][]){
			/*用于刷新表格，info[][]为改动过后的数组，存储表格数据*/
			data=info;
			headTitle=newheadTitle;	
			table.setModel(new DefaultTableModel(
					data,headTitle) {
				boolean[] columnEditables = new boolean[] {
					false, true
				};
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
			table.repaint();
			FitTableColumns(table);
			this.repaint();
		}
		
		
		public JTable getTable(){
			return table;
		}
		//得到选中单元格的数据
		public String getValueAt(int selectedRow, int i) {
			return 	table.getValueAt(selectedRow, i).toString();
		}

		public int getSelectedColumn() {
			return table.getSelectedColumn();
		}
		
		public boolean isCellEditable(int row, int column) {
			return false;
			}
		
		public int getSelectedRow() {
			
			return table.getSelectedRow();
		}

		public void setLastRowWidth(int w){
			 table.getColumnModel().getColumn(headTitle.length-1).setPreferredWidth(w); 
		}
		public void setLastSecondRowWidth(int w){
			 table.getColumnModel().getColumn(headTitle.length-2).setPreferredWidth(w); 
		}
		
		//隐藏表单
		public void hideColumn(int index){ 
		    TableColumn tc= table.getColumnModel().getColumn(index); 
		    tc.setMaxWidth(0); 
		    tc.setPreferredWidth(0); 
		    tc.setMinWidth(0); 
		    tc.setWidth(0); 
		    table.getTableHeader().getColumnModel().getColumn(index).setMaxWidth(0); 
		    table.getTableHeader().getColumnModel().getColumn(index).setMinWidth(0); 
		}
		
		public void FitTableColumns(JTable myTable){
			  	 JTableHeader header = myTable.getTableHeader();
			     int rowCount = myTable.getRowCount();
			     Enumeration columns = myTable.getColumnModel().getColumns();
			     while(columns.hasMoreElements()){
			         TableColumn column = (TableColumn)columns.nextElement();
			         int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
			         int width = (int)myTable.getTableHeader().getDefaultRenderer()
			                 .getTableCellRendererComponent(myTable, column.getIdentifier()
			                         , false, false, -1, col).getPreferredSize().getWidth();
			         for(int row = 0; row<rowCount; row++){
			             int preferedWidth = (int)myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
			               myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
			             width = Math.max(width, preferedWidth);
			           
			         }
			         header.setResizingColumn(column); // 此行很重要
			         column.setWidth(width+myTable.getIntercellSpacing().width);
			        
			     }
		}
		public void setRowSorter(TableRowSorter<TableModel> sorter){
		    table.setRowSorter(sorter);
		}


		public TableModel getmodel() {
			return table.getModel();
		}


		public String getColumnName(int tempchossen) {
			// TODO 自动生成的方法存根
			return table.getColumnName(tempchossen);
		}



		
		
}
