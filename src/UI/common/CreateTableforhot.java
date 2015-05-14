
		package UI.common;

		import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.util.Enumeration;

		import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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



		public class CreateTableforhot extends JPanel implements TableModelListener {
			public static void main(String[] args) {}

			private static final long serialVersionUID = 1L;
			JScrollPane roll;
			JTable table;
			String[] headTitle;
			Object data[][];
			Font fbig;
			Font fsmall;
			int picwidth;
			int piclength;
			int columnnum;
			
			// �������ͼƬ��model
			class MyTableModel extends AbstractTableModel {
				// ��Ԫ��Ԫ������
				private Class[] cellType = { Icon.class, String.class, String.class };
				// ��ͷ
				private String title[] = headTitle;

				// ģ������

				// ��װ�õĵ���ͼƬ��С����
				public ImageIcon getImageIcon(String path, int width, int height) {
					if (width == 0 || height == 0) {
						return new ImageIcon(this.getClass().getResource(path));
					}
					ImageIcon icon = new ImageIcon(path);
					icon.setImage(icon.getImage().getScaledInstance(width, height,
							Image.SCALE_DEFAULT));
					return icon;
				}
				
				//���±������
				public Object[][] updatedata(Object[][] info,int columnnum){
					columnnum = 6;
					Object Data[][]  = new Object[info.length-1][columnnum];
					for(int i = 0; i<info.length-1;i++){
						Data[i][0] = getImageIcon((String)info[i+1][0],picwidth, piclength);
						int tempadd = 1;
						while(tempadd!=columnnum-1){
							Data[i][tempadd] = info[i+1][tempadd];
							tempadd++;
						}
					}
					data = Data;
					return Data;
				}
				
				//��ʼ������
				private Object data[][] = updatedata(CreateTableforhot.this.data,columnnum);
				private static final long serialVersionUID = 1L;


				@Override
				public int getColumnCount() {
					// TODO Auto-generated method stub
					return title.length;
				}

				@Override
				public int getRowCount() {
					// TODO Auto-generated method stub
					return data.length;
				}

				@Override
				public Object getValueAt(int r, int c) {
					// TODO Auto-generated method stub
						return data[r][c];
				}

				// ��дisCellEditable����
				public boolean isCellEditable(int r, int c) {
					return false;
				}

				// ��дsetValueAt����
				public void setValueAt(Object value, int r, int c) {
					data[r][c] = value;
					this.fireTableCellUpdated(r, c);
				}
			}

			//�������
			public CreateTableforhot(String title[],final Object data[][],
					int x, int y, int width, int height, int rowHeight, int rowwidth1,int columnnum,
					Font fbig, Font fsmall,final int picwidth, final int piclength) {
				/* �Ȿ����һ��Panel,panel �ǿ���ֱ���õģ�������Ϣ�������ֱ��ʹ�� */
				/* title �Ǳ�ͷ��Ϣ��data �Ǵ����������ݣ���ά�ַ�������,x,y �Ǳ������꣬wideth,height �Ǵ�С������,columnnumΪҪ��������� */
				// this.setLayout(null);
				this.setBounds(x, y-3, width, height);
				this.data = data;
				this.headTitle = title;
				this.piclength = piclength;
				this.picwidth = picwidth;
				this.fbig = fbig;
				this.fsmall = fsmall;
				this.setBackground(new Color(252, 213, 146));
				
				MyTableModel model = new MyTableModel();
				table = new JTable(model);
				table.setRowHeight(rowHeight);
				//RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);  
				//table.setRowSorter(sorter);  
				// Ϊ���б��������������
				table.getTableHeader().setFont(fbig);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.setFillsViewportHeight(true);
				// table.setEnabled(false);
				// table.isEditing();
				table.getColumnModel().getColumn(5).setPreferredWidth(0);
				
				// ������ɫ�趨
				//table.setBorder(new LineBorder(new Color(67, 54, 49), 2, true));
				table.setForeground(Color.DARK_GRAY);
				table.setBackground(new Color(252, 213, 146));
				table.setSelectionBackground(new Color(67, 54, 49));
				table.setSelectionForeground(Color.WHITE);
				table.setShowVerticalLines(true);// �Ƿ���ʾ��ֱ������?
				table.setGridColor(new Color(67, 54, 49));
				table.setAutoCreateRowSorter(true);
				table.setDefaultRenderer(Object.class, new FenseRenderforhot());
				//FitTableColumns(table);
				// ����һЩ����
				table.setDragEnabled(true); // �������϶�
				table.getSelectionModel().setSelectionMode(
						ListSelectionModel.SINGLE_SELECTION); // ֻ����ѡ
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getTableHeader().setReorderingAllowed(false);

				this.add(table);
			}

			
			
			/* ����ˢ�±��info[][]Ϊ�Ķ���������飬�洢������� */
			public void updateTable(Object info[][],int columnnum,String[] HeadTitle) {
				data = info;
				headTitle = HeadTitle;
				//MyTableModel model = new MyTableModel();
				//FitTableColumns(table);
				MyTableModel model = (MyTableModel)table.getModel();
				model.updatedata(info,columnnum);
			}


			public JTable getTable() {
				return table;
			}

			public int getSelectedColumn() {
				return table.getColumnCount();
			}

			public int getSelectedRow() {
				return table.getSelectedRow();
			}

			@Override
			public void tableChanged(TableModelEvent e) {
				// TODO Auto-generated method stub
				row = e.getFirstRow();

				System.out.println("----row----" + row);
				column = e.getColumn();
			}

			int row;
			int column;
			//�õ�ѡ�е�Ԫ�������
			public String getValueAt(int selectedRow, int i) {
				return 	table.getValueAt(selectedRow, i).toString();
			}


			
		}



