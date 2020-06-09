import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UI extends JPanel {
	JLabel title;
	JLabel generatePrimes, generatePrimitiveRoot;
	static JLabel AliceKey, BobKey, CarolKey,sessionKey;
	JTextField Primes, primitiveRoot;
	static JTextField  Alice,Bob, Carol,Session;
	JButton generatePri, generateKey, generateRoot;
	Font titleFont = new Font("楷体", Font.BOLD, 25);
	Font textFont = new Font("宋体", Font.PLAIN, 15);
	BigInteger gBigInteger,rBigInteger,kBigInteger;
	static String AliceSring,BobString,CarolString;
//	enum People {  
//	    peopleAlice, peopleBob, peopleCarol  
//	}  
	
	public UI() {
		initUI();
	}

	private void initUI() {
		// TODO Auto-generated method stub
		title = new JLabel("DH三方会话密钥计算");
		generatePrimes = new JLabel("生成一个大素数");
		generatePrimitiveRoot = new JLabel("生成原根");
		AliceKey = new JLabel("Alice的私钥");
		BobKey = new JLabel("Bob的私钥");
		CarolKey = new JLabel("Carol的私钥");
		sessionKey = new JLabel("会话密钥是:");
		
		Primes = new JTextField("", 2);
		primitiveRoot = new JTextField("", 2);
		Alice = new JTextField(" ", 2);
		Bob = new JTextField(" ", 2);
		Carol = new JTextField(" ", 2);
		Session = new JTextField("", 2);
		
		generatePri = new JButton("点击生成素数");
		generateRoot = new JButton("点击生成原根");
		generateKey = new JButton("点击生成会话密钥");
		
		this.setLayout(null);
		add(title);
		add(generatePrimes);
		add(generatePrimitiveRoot);
		add(AliceKey);
		add(BobKey);
		add(CarolKey);
		add(sessionKey);
		
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
		
		generatePrimes.setBounds(170, 100 , 150, 30);
		generatePrimes.setFont(textFont);
		Primes.setBounds(300,100,200,30);
		Primes.setEditable(false);
		generatePri.setBounds(530, 100, 200, 30);
		
		generatePrimitiveRoot.setBounds(170, 150 , 100, 30);
		generatePrimitiveRoot.setFont(textFont);
		primitiveRoot.setBounds(300, 150 , 200, 30);
		primitiveRoot.setEditable(false);
		generateRoot.setBounds(530, 150 , 200, 30);
		
		AliceKey.setBounds(170, 200 , 100, 30);
		AliceKey.setFont(textFont);
		Alice.setBounds(300, 200 , 430, 30);
		
		BobKey.setBounds(170, 240 , 100, 30);
		BobKey.setFont(textFont);
		Bob.setBounds(300, 240 , 430, 30);
		
		CarolKey.setBounds(170, 280 , 100, 30);
		CarolKey.setFont(textFont);
		Carol.setBounds(300, 280 , 430, 30);
		
		sessionKey.setBounds(170, 340 , 100, 30);
		sessionKey.setFont(textFont);
		Session.setBounds(300,340,200,30);
		Session.setEditable(false);
		generateKey.setBounds(530, 340, 200, 30);
		
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
