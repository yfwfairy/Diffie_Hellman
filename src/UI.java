import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class UI extends JPanel {
	JLabel title;
	JLabel choice,generatePrimes, generatePrimitiveRoot;
	static JLabel AliceKey, BobKey, CarolKey,sessionKey;
	JTextField choose;
	static JTextField  Alice,Bob, Carol;
	static TextArea Primes, primitiveRoot,Session;
	JButton generatePri, generateKey, generateRoot;
	Font titleFont = new Font("楷体", Font.BOLD, 25);
	Font textFont = new Font("宋体", Font.PLAIN, 15);
	BigInteger gBigInteger,rBigInteger,kBigInteger;
	static String AliceSring,BobString,CarolString,bitString;
	String number[] = {"128","256","512","1024"};
	static JComboBox cmb;

//	enum People {  
//	    peopleAlice, peopleBob, peopleCarol  
//	}  
	
	public UI() {
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		choice= new JLabel("请选择素数位数");
		cmb= new JComboBox(number);
		title = new JLabel("DH三方会话密钥计算");
		generatePrimes = new JLabel("生成大素数");
		generatePrimitiveRoot = new JLabel("生成原根");
		AliceKey = new JLabel("Alice的私钥");
		BobKey = new JLabel("Bob的私钥");
		CarolKey = new JLabel("Carol的私钥");
		sessionKey = new JLabel("会话密钥是:");
		
		Primes = new TextArea(20,100);
		primitiveRoot = new TextArea(20,100);
		Alice = new JTextField(" ", 2);
		Bob = new JTextField(" ", 2);
		Carol = new JTextField(" ", 2);
		Session = new TextArea(20,100);
		
		generatePri = new JButton("点击生成素数");
		generateRoot = new JButton("点击生成原根");
		generateKey = new JButton("点击生成会话密钥");
		
		this.setLayout(null);
		add(cmb);
		add(choice);
		add(title);
		add(generatePrimes);
		add(generatePrimitiveRoot);
		add(AliceKey);
		add(BobKey);
		add(CarolKey);
		add(sessionKey);
		
		add(choice);
		add(Primes);
		add(primitiveRoot);
		add(Alice);
		add(Bob);
		add(Carol);
		add(Session);
		
		add(generatePri);
		add(generateKey);
		add(generateRoot);
		
		title.setBounds(330,25,300,50);
		title.setFont(titleFont);
		
		choice.setBounds(170, 100 , 150, 30);
		choice.setFont(textFont);
		cmb.setBounds(300, 100, 250, 30);
        cmb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				int i=cmb.getSelectedIndex();
				
			}
        });
		
		generatePrimes.setBounds(170, 150 , 100, 30);
		generatePrimes.setFont(textFont);
		Primes.setBounds(300,150,250,35);
		Primes.setEditable(false);
		generatePri.setBounds(560, 150, 170, 30);
		
		generatePrimitiveRoot.setBounds(170, 200 , 100, 30);
		generatePrimitiveRoot.setFont(textFont);
		primitiveRoot.setBounds(300, 200 , 250, 35);
		primitiveRoot.setEditable(false);
		generateRoot.setBounds(560,200 , 170, 30);
		
		AliceKey.setBounds(170, 250 , 100, 30);
		AliceKey.setFont(textFont);
		Alice.setBounds(300, 250 , 430, 30);
		
		BobKey.setBounds(170, 300 , 100, 30);
		BobKey.setFont(textFont);
		Bob.setBounds(300, 300 , 430, 30);
		
		CarolKey.setBounds(170, 350 , 100, 30);
		CarolKey.setFont(textFont);
		Carol.setBounds(300, 350 , 430, 30);
		
		sessionKey.setBounds(170, 400 , 100, 30);
		sessionKey.setFont(textFont);
		Session.setBounds(300,400,250,35);
		Session.setEditable(false);
		generateKey.setBounds(560, 400, 170, 30);
		     
		generatePri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == generatePri)
					gBigInteger=LargePrime.generatePrime(); 
				    String stringBigInteger=gBigInteger.toString();
				    Primes.setText(String.valueOf(stringBigInteger));
			}

		});
		
		generateRoot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == generateRoot)
					rBigInteger=PrimitiveRoot.generateRoot(); 
			    String stringBigInteger=rBigInteger.toString();
			    primitiveRoot.setText(String.valueOf(stringBigInteger));
			}
		});
		
		
		generateKey.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == generateKey)
					kBigInteger=DHprograming.generateSession(); 
			    String stringBigInteger=kBigInteger.toString();
			    Session.setText(String.valueOf(stringBigInteger));
			}
		});
	}

	public static int getBit() {
		bitString = cmb.getSelectedItem().toString();
		int bitInteger = Integer.parseInt(bitString);
		return bitInteger;
	}
	public static BigInteger getPrivateKey(String people) {
		switch (people) {
		case "Alice": {
			AliceSring = Alice.getText();
			BigInteger AliceKeyBigInteger = new BigInteger("AliceString ".getBytes());
			return AliceKeyBigInteger;
			}
		case "Bob": {
			BobString = Bob.getText();
			BigInteger BobKeyBigInteger = new BigInteger("BobString ".getBytes());
			return BobKeyBigInteger;
			}
		case "Carol": {
			CarolString = Carol.getText();
			BigInteger CarolKeyBigInteger = new BigInteger("CarolString ".getBytes());
			return CarolKeyBigInteger;
			}
		default: return BigInteger.valueOf(0);
		}
	}

}
