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

import UI.main.init;

public class CreateTable_pic extends JPanel{

	    	
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
		public CreateTable_pic(String title[], Object datas[][],int x,int y,int width,int height,int rowheight,Font Fbig,Font Fsmall){
			/*�Ȿ����һ��Panel,panel �ǿ���ֱ���õģ�������Ϣ�������ֱ��ʹ��*/
			/*title �Ǳ�ͷ��Ϣ��data �Ǵ����������ݣ���ά�ַ�������,x,y �Ǳ������꣬wideth,height �Ǵ�С������*/
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
			table.setBackground(init.syslightblue);			
			table.setFont(fsmall);
			table.getTableHeader().setFont(fbig);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setFillsViewportHeight(true); 
			table.setAutoCreateRowSorter(true);
			 TableColumn column = table.getColumnModel().getColumn(1);// ��ȡ����4�ж���
		        table.setRowHeight(32);
		        
		        column.setCellRenderer(new TableCellRenderer() {// ���õ�4�е���Ⱦ��
		                    @Override
		                    public Component getTableCellRendererComponent(
		                            JTable table, Object value, boolean isSelected,
		                            boolean hasFocus, int row, int column) {
		                        ImageIcon icon = (ImageIcon) value;
		                        JLabel label = new JLabel(icon);// ����������	
		                        if (row % 2 == 0) {
		                            label.setForeground(Color.black);
		                            label.setBackground(Color.WHITE);
		                        } else {
		                            label.setForeground(Color.black);
		                            label.setBackground(init.syslightblue);
		                        }
		                        label.setOpaque(true);
		                        return label;// �ѽ�������Ϊ��Ⱦ�ؼ�
		                    }
		                });
			
			table.setDefaultRenderer(Object.class, new FenseRenderer_pic());
			table.setOpaque(false);// ��ʼ�����Ϊ͸��
			//table.setEnabled(false);
			// ����һЩ����
			table.setShowGrid(false);
			table.getSelectionModel().setSelectionMode(
					ListSelectionModel.SINGLE_SELECTION); // ֻ����ѡ

			table.setDragEnabled(false); // �������϶�
			table.getTableHeader().setReorderingAllowed(false);
			 //��ñ�ͷ
				JTableHeader tableH = table.getTableHeader();
			    //���ñ�ͷ�ı���ɫ
			    tableH.setBackground(init.syslightblue);
			    //���ñ�ͷ��������ɫ
			     tableH.setForeground(Color.DARK_GRAY);
			    tableH.setOpaque(false);
			    
			   
			
			
			//FitTableColumns(table);		
			roll=new JScrollPane(table);
			roll.getViewport().setBackground(init.syslightblue);
			roll.setPreferredSize(new Dimension(width,height-10)); 
			roll.setLocation(0, 0);
			roll.setVisible(true);
			this.setBackground(init.syslightblue);
	    	roll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    	roll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    	this.add(roll);
	    		
			
		}
		
	
		public JScrollPane getJScrollPane(){
			return roll;
		}
		
		public void updateTable(String[] newheadTitle,Object info[][]){
			/*����ˢ�±��info[][]Ϊ�Ķ���������飬�洢�������*/
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
			
			  TableColumn column = table.getColumnModel().getColumn(1);// ��ȡ����4�ж���
		        table.setRowHeight(32);
		        
		        column.setCellRenderer(new TableCellRenderer() {// ���õ�4�е���Ⱦ��
		                    @Override
		                    public Component getTableCellRendererComponent(
		                            JTable table, Object value, boolean isSelected,
		                            boolean hasFocus, int row, int column) {
		                        ImageIcon icon = (ImageIcon) value;
		                        JLabel label = new JLabel(icon);// ����������
		                        if (row % 2 == 0) {
		                        	label.setForeground(Color.black);
		                        	label.setBackground(Color.WHITE);
		                        } else {
		                        	label.setForeground(Color.black);
		                        	label.setBackground(init.syslightblue);
		                        }
		                        //label.setBackground(table.getSelectionBackground());
		                        if (isSelected)// ��ѡ��ı�ǩ����Ϊ��͸��
		                            label.setOpaque(true);
		                        return label;// �ѽ�������Ϊ��Ⱦ�ؼ�
		                        
		                    }
		                });
		        table.repaint();
				//FitTableColumns(table);
				this.repaint();
		}
		
		
		public JTable getTable(){
			return table;
		}
		//�õ�ѡ�е�Ԫ�������
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
		
		//���ر�
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
			         header.setResizingColumn(column); // ���к���Ҫ
			         column.setWidth(22+width+myTable.getIntercellSpacing().width);
			        
			     }
		}
		public void setRowSorter(TableRowSorter<TableModel> sorter){
		    table.setRowSorter(sorter);
		}


		public TableModel getmodel() {
			return table.getModel();
		}


		public String getColumnName(int tempchossen) {
			// TODO �Զ����ɵķ������
			return table.getColumnName(tempchossen);
		}



		
		
}
