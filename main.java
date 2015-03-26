import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.undo.*;
import javax.swing.event.*;
public class main extends JFrame implements ActionListener,UndoableEditListener{
	JMenuBar jmb;
	JMenu jm1,jm2,jm3,jm4,jm5;
	JMenuItem jmi1,jmi2,jmi3,jmi4,jmi5,jmi6,jmi7,jmi8,jmi9,jmi10,jmi11,jmi12,jmi13,jmi14;
	JSeparator js1,js2,js3,js4,js5;
	JScrollPane jsp;
	JTextArea jta;
	JToolBar jtb1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8;
	File f1;
	UndoManager um1;
	public main(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon/writer.png"));
		jmb=new JMenuBar();
		jm1=new JMenu("Archivo");
		jm1.setMnemonic(KeyEvent.VK_A);
		jm2=new JMenu("Editar");
		jm2.setMnemonic(KeyEvent.VK_E);
		jm3=new JMenu("Formato");
		jm3.setMnemonic(KeyEvent.VK_F);
		jm4=new JMenu("Vista");
		jm4.setMnemonic(KeyEvent.VK_V);
		jm5=new JMenu("Help");
		jm5.setMnemonic(KeyEvent.VK_H);
		jmi1=new JMenuItem("Abrir",new ImageIcon("icon/Abrir.png"));
		jmi1.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK ));
		jmi2=new JMenuItem("Nuevo",new ImageIcon("icon/Nuevo.png"));
		jmi2.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK ));
		js1=new JSeparator();
		jmi3=new JMenuItem("Guardar",new ImageIcon("icon/Guardar.png"));
		jmi3.setAccelerator(KeyStroke.getKeyStroke('G', Event.CTRL_MASK ));
		jmi4=new JMenuItem("Guardar Como",new ImageIcon("icon/Guardar como.png"));
		js2=new JSeparator();
		jmi5=new JMenuItem("Salir",new ImageIcon("icon/Salir.png"));
		jmi5.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK ));
		jmi6=new JMenuItem("Copiar",new ImageIcon("icon/Copiar.png"));
		jmi6.setAccelerator(KeyStroke.getKeyStroke('C', Event.CTRL_MASK ));
		jmi7=new JMenuItem("Cortar",new ImageIcon("icon/Cortar.png"));
		jmi7.setAccelerator(KeyStroke.getKeyStroke('X', Event.CTRL_MASK ));
		jmi8=new JMenuItem("Pegar",new ImageIcon("icon/Pegar.png"));
		jmi8.setAccelerator(KeyStroke.getKeyStroke('V', Event.CTRL_MASK ));
		jmi12=new JMenuItem("Seleccionar Todo",new ImageIcon("icon/Seleccionar.png"));
		jmi12.setAccelerator(KeyStroke.getKeyStroke('A', Event.CTRL_MASK ));
		js3=new JSeparator();
		jmi13=new JMenuItem("Deshacer",new ImageIcon("icon/Deshacer.png"));
		jmi13.setAccelerator(KeyStroke.getKeyStroke('Z', Event.CTRL_MASK ));
		jmi14=new JMenuItem("Rehacer",new ImageIcon("icon/Rehacer.png"));
		jmi14.setAccelerator(KeyStroke.getKeyStroke('Y', Event.CTRL_MASK ));
		jmi9=new JMenuItem("Ajuste de Linea");
		jmi10=new JMenuItem("Ver Nro de Lineas");
		jmi11=new JMenuItem("Acerca de ...");
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(js1);
		jm1.add(jmi3);
		jm1.add(jmi4);
		jm1.add(js2);
		jm1.add(jmi5);
		jm2.add(jmi6);
		jm2.add(jmi7);
		jm2.add(jmi8);
		jm2.add(jmi12);
		jm2.add(js3);
		jm2.add(jmi13);
		jm2.add(jmi14);
		jm3.add(jmi9);
		jm4.add(jmi10);
		jm5.add(jmi11);
		setJMenuBar(jmb);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi3.addActionListener(this);
		jmi4.addActionListener(this);
		jmi5.addActionListener(this);
		jmi6.addActionListener(this);
		jmi7.addActionListener(this);
		jmi8.addActionListener(this);
		jmi9.addActionListener(this);
		jmi10.addActionListener(this);
		jmi11.addActionListener(this);
		jmi12.addActionListener(this);
		jmi13.addActionListener(this);
		jmi14.addActionListener(this);
		setLayout(new BorderLayout());
		jtb1=new JToolBar();
		jta=new JTextArea();
		jta.getDocument().addUndoableEditListener(this);
		jsp=new JScrollPane(jta);
		um1=new UndoManager();
		add("North",jtb1);
		add("Center",jsp);
		b1=new JButton();
		b1.setIcon(new ImageIcon("icon/Nuevo.png"));
		b1.setToolTipText("Nuevo");
		b2=new JButton();
		b2.setIcon(new ImageIcon("icon/Abrir.png"));
		b3=new JButton();
		b3.setIcon(new ImageIcon("icon/Guardar.png"));
		js4=new JSeparator();
		b4=new JButton();
		b4.setIcon(new ImageIcon("icon/Deshacer.png"));
		b5=new JButton();
		b5.setIcon(new ImageIcon("icon/Rehacer.png"));
		js5=new JSeparator();
		b6=new JButton();
		b6.setIcon(new ImageIcon("icon/Cortar.png"));
		b7=new JButton();
		b7.setIcon(new ImageIcon("icon/Copiar.png"));
		b8=new JButton();
		b8.setIcon(new ImageIcon("icon/Pegar.png"));
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		jtb1.setLayout(new FlowLayout(FlowLayout.RIGHT));
		jtb1.add(b1);
		jtb1.add(b2);
		jtb1.add(b3);
		jtb1.add(js4);
		jtb1.add(b4);
		jtb1.add(b5);
		jtb1.add(js5);
		jtb1.add(b6);
		jtb1.add(b7);
		jtb1.add(b8);
		setSize(700,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);}
	public void actionPerformed(ActionEvent e){
		if((b2==e.getSource())||jmi1==e.getSource()){
			try{
				JFileChooser jfc1=new JFileChooser(System.getProperty("user.dir"));
				jfc1.showOpenDialog(this);
				f1=jfc1.getSelectedFile();
				if(f1!=null){
					jta.setText("");
					BufferedReader br1=new BufferedReader(new FileReader(f1));
					String stra1;
					while((stra1=br1.readLine())!=null)jta.append(stra1+"\n");
					setTitle(f1.getName());}}catch(Exception exc){}}
		if((b1==e.getSource())||(jmi2==e.getSource())){
			int opc=JOptionPane.showConfirmDialog(null,"Desea guardar los cambios?","Guardar",JOptionPane.YES_NO_OPTION);
      if(opc==JOptionPane.YES_OPTION){
				try{
					if(f1==null){
						JFileChooser jfc1=new JFileChooser(System.getProperty("user.dir"));
						jfc1.showSaveDialog(this);
						f1=jfc1.getSelectedFile();
						FileWriter fw1=new FileWriter(f1);
						fw1.write(jta.getText());
						fw1.close();
						setTitle(f1.getName());}
					else{
						FileWriter fw1=new FileWriter(f1);
						fw1.write("");
						fw1.close();}}catch(Exception exc){}}
			jta.setText("");}
		if((b3==e.getSource())||jmi3==e.getSource()){
			try{
				if(f1==null){
					JFileChooser jfc1=new JFileChooser(System.getProperty("user.dir"));
					jfc1.showSaveDialog(this);
					f1=jfc1.getSelectedFile();
					FileWriter fw1=new FileWriter(f1);
					fw1.write(jta.getText());
					fw1.close();
					setTitle(f1.getName());}
				else{
					FileWriter fw1=new FileWriter(f1);
					fw1.write(jta.getText());
					fw1.close();}}catch(Exception exc){}}
		if(jmi4==e.getSource()){
			try{
				JFileChooser jfc1=new JFileChooser(System.getProperty("user.dir"));
				jfc1.showSaveDialog(this);
				f1=jfc1.getSelectedFile();
				FileWriter fw1=new FileWriter(f1);
				fw1.write(jta.getText());
				fw1.close();
				setTitle(f1.getName());}catch(Exception exc){}}
		if(jmi5==e.getSource())System.exit(0);
		if((b7==e.getSource())||jmi6==e.getSource())jta.copy();
		if((b6==e.getSource())||jmi7==e.getSource())jta.cut();
		if((b8==e.getSource())||jmi8==e.getSource())jta.paste();
		if(jmi12==e.getSource())jta.getText();
		if((b4==e.getSource())||jmi13==e.getSource())try{um1.undo();}catch(Exception exc){};
		if((b5==e.getSource())||jmi14==e.getSource())try{um1.redo();}catch(Exception exc){};}
	public void undoableEditHappened(UndoableEditEvent e){
		um1.addEdit(e.getEdit());}
	public static void main(String args[]){
		main obj=new main();}}
