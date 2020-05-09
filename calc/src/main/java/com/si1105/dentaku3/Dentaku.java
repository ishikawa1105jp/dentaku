package com.si1105.dentaku3;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Dentaku extends JFrame implements DentakuInterface, KeyListener {

	private static final long serialVersionUID = 1L;

	/**
	 * デモ表示フラグ
	 */
	private static boolean demo = false;

	/**
	 * コンテントペイン
	 */
	private JPanel jContentPane = null;

	/**
	 * メニューバー
	 */
	private JMenuBar theMenuBar = null;

	/**
	 * 編集メニュー
	 */
	private JMenu mnEdit = null;

	/**
	 * コピーメニューアイテム
	 */
	private JMenuItem mniCopy = null;

	/**
	 * 貼り付けメニューアイテム
	 */
	private JMenuItem mniPaste = null;

	/**
	 * オプションメニュー
	 */
	private JMenu mnOption = null;

	/**
	 * 3桁区切り設定メニュー
	 */
	private JCheckBoxMenuItem chkmniComma3 = null;

	/**
	 * キャプションメニュー
	 */
	private JMenu mnCaption = null;

	/**
	 * キャプションメニューアイテムグループ
	 */
	private ButtonGroup btngrpCaption = null;

	/**
	 * キャプションメニューアイテム標準
	 */
	private JRadioButtonMenuItem rdomniGlobal = null;

	/**
	 * キャプションメニューアイテム和式
	 */
	private JRadioButtonMenuItem rdomniDomestic = null;

	/**
	 * ルックアンドフィールメニュー
	 */
	private JMenu mnLookAndFeel = null;

	/**
	 * ルックアンドフィールグループオブジェクト
	 */
	private ButtonGroup btngrpLookAndFeel = null;

	/**
	 * ルックアンドフィールメニューアイテムJava
	 */
	private JRadioButtonMenuItem rdomniJava = null;

	/**
	 * ルックアンドフィールメニューアイテムWindows
	 */
	private JRadioButtonMenuItem rdomniWindows = null;

	/**
	 * ルックアンドフィールメニューアイテムMotif
	 */
	private JRadioButtonMenuItem rdomniMotif = null;

	/**
	 * オープニングデモメニュー
	 */
	private JCheckBoxMenuItem chkmniDemo = null;

	/**
	 * ヘルプメニュー
	 */
	private JMenu mnHelp = null;

	/**
	 * バージョン情報メニューアイテム
	 */
	private JMenuItem mniAbout = null;

	/**
	 * 表示窓
	 */
	private JTextField txtDisplay = null;

	/**
	 * 演算子表示窓
	 */
	private JTextField txtOpe = null;

	/**
	 * リピート演算中表示窓
	 */
	private JTextField txtRep = null;

	/**
	 * メモリー中表示窓
	 */
	private JTextField txtM = null;

	/**
	 * 0ボタン
	 */
	private DentakuButton btn0 = null;

	/**
	 * 1ボタン
	 */
	private DentakuButton btn1 = null;

	/**
	 * 2ボタン
	 */
	private DentakuButton btn2 = null;

	/**
	 * 3ボタン
	 */
	private DentakuButton btn3 = null;

	/**
	 * 4ボタン
	 */
	private DentakuButton btn4 = null;

	/**
	 * 5ボタン
	 */
	private DentakuButton btn5 = null;

	/**
	 * 6ボタン
	 */
	private DentakuButton btn6 = null;

	/**
	 * 7ボタン
	 */
	private DentakuButton btn7 = null;

	/**
	 * 8ボタン
	 */
	private DentakuButton btn8 = null;

	/**
	 * 9ボタン
	 */
	private DentakuButton btn9 = null;

	/**
	 * 00ボタン
	 */
	private DentakuButton btn00 = null;

	/**
	 * 小数点ボタン
	 */
	private DentakuButton btnPoint = null;

	/**
	 * 時間計算モードボタン
	 */
	private DentakuButton btnTime = null;

	/**
	 * +ボタン
	 */
	private DentakuButton btnPlus = null;

	/**
	 * -ボタン
	 */
	private DentakuButton btnMinus = null;

	/**
	 * *ボタン
	 */
	private DentakuButton btnMulti = null;

	/**
	 * /ボタン
	 */
	private DentakuButton btnDiv = null;

	/**
	 * %ボタン
	 */
	private DentakuButton btnRatio = null;

	/**
	 * 平方根ボタン
	 */
	private DentakuButton btnRoot = null;

	/**
	 * Cボタン
	 */
	private DentakuButton btnClear = null;

	/**
	 * =ボタン
	 */
	private DentakuButton btnEqual = null;

	/**
	 * M+ボタン
	 */
	private DentakuButton btnMemoryPlus = null;

	/**
	 * M-ボタン
	 */
	private DentakuButton btnMemoryMinus = null;

	/**
	 * MRボタン
	 */
	private DentakuButton btnMemoryRead = null;

	/**
	 * MCボタン
	 */
	private DentakuButton btnMemoryClear = null;

	/**
	 * 丸め処理指定スライダ
	 */
	private JSlider sldTerminator = null;

	/**
	 * 丸め処理指定スライダのラベル
	 */
	@SuppressWarnings("rawtypes")
	private Hashtable lblsTerminator = null;

	/**
	 * 小数点以下桁数指定スライダ
	 */
	private JSlider sldLength = null;

	/**
	 * 小数点以下桁数指定スライダのラベル
	 */
	@SuppressWarnings("rawtypes")
	private Hashtable lblsLength = null;

	/**
	 * 計算中フラグ
	 */
	private boolean inSession;

	/**
	 * 計算してよろしいかフラグ
	 */
	private boolean calculatable;

	/**
	 * 数字生成中フラグ
	 */
	private boolean inGeneratingNumber;

	/**
	 * 最後に押されたボタン
	 */
	private DentakuButton lastActionButton;

	/**
	 * 最後に押された演算子
	 */
	private int operator = 0;

	/**
	 * リピート演算フラグ
	 */
	private boolean repeat = false;

	/**
	 * オペランド
	 */
	private BigDecimal operand = null;

	/**
	 * 第二オペランド
	 */
	private BigDecimal operand2 = null;

	/**
	 * メモリー
	 */
	private BigDecimal memory = null;

	/**
	 * HMSモードフラグ
	 */
	private boolean hms = false;

	/**
	 * フォント
	 */
	private Font font_ = null;

	/**
	 * エントリポイント
	 *
	 * @param args
	 *            外部パラメータ
	 */
	public static void main(String[] args) {

		// 複数起動の防止
		File file = new File(getPath() + TEMP);
		if (file.exists()) {
			System.exit(0);
		}

		Dentaku dentaku = new Dentaku();
		dentaku.setVisible(true);
		// デモ
		if (demo) {
			dentaku.setEnabled(false);
			dentaku.showDemo();
			dentaku.setEnabled(true);
		}
	}

	/**
	 * このクラスのオブジェクト(インスタンス)を生成します。
	 */
	private Dentaku() {
		super();
		initialize();
	}

	/**
	 * 初期化
	 *
	 * @return void
	 */
	private void initialize() {

		// フォント設定:現在Dialogに固定中///////////////////////
		// // ウインドウズならばフォントをMSUIゴシックにセット
		// if
		// (System.getProperty("os.name").startsWith("Windows"))
		// {
		// font_ = FONT_MS;
		// }
		// // ウインドウズでないならフォントをDialogにセット
		// else {
		// font_ = FONT_STD;
		// }
		font_ = FONT_STD;

		// ウインドウ位置をセット
		setInitPosition();
		setTitle(TITLE);

		setJMenuBar(getTheMenuBar());
		setSize(new Dimension(WIDTH_, HEIGHT_));
		// setSize(new Dimension(WIDTH_,
		// HEIGHT_));
		setResizable(false);

		// パネルをセット
		setContentPane(getJContentPane());

		// スタイルをセット
		setStyle(STYLE_STD);

		// ルックアンドフィール設定
		String lookAndFeel = loadConfigration(SER_LOOKANDFEEL);
		setLookAndFeel(lookAndFeel);
		setInitSelectedLookAndFeel(lookAndFeel);

		// 終端処理設定
		int terminator = Integer.parseInt(loadConfigration(SER_ROUND));
		getSldTerminator().setValue(terminator);

		// 少数点下桁数設定
		int length = Integer.parseInt(loadConfigration(SER_LENGTH));
		getSldLength().setValue(length);

		// 3桁区切りフラグ設置
		boolean format = new Boolean(loadConfigration(SER_FORMAT));
		getChkmniComma3().setState(format);

		// キャプション設定メニューを「標準」にセット
		getRdomniGlobal().setSelected(true);

		// デモ設定
		boolean demo = new Boolean(loadConfigration(SER_DEMO));
		getChkmniDemo().setState(demo);
		Dentaku.demo = demo;

		// 終了時動作設定
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new DentakuWindowListener());

		// キーリスナ追加
		addKeyListener(this);

		// ラストアクションにイコールをセット
		lastActionButton = getBtnEqual();

		// オペランドにゼロをセット
		operand = BD_ZERO;
		operand2 = BD_ZERO;

		// メモリーにゼロをセット
		memory = BD_ZERO;

		// tempファイル作成
		createTempFile();

		// フォーカス取得
		requestFocusInWindow();

	}

	/**
	 * コンテントペインを返す。
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {

			// パネル
			jContentPane = new JPanel();
			jContentPane.setLayout(null);

			// 表示窓
			jContentPane.add(getTxtDisplay(), null);

			// 数字ボタン
			jContentPane.add(getBtn0(), null);
			jContentPane.add(getBtn1(), null);
			jContentPane.add(getBtn2(), null);
			jContentPane.add(getBtn3(), null);
			jContentPane.add(getBtn4(), null);
			jContentPane.add(getBtn5(), null);
			jContentPane.add(getBtn6(), null);
			jContentPane.add(getBtn7(), null);
			jContentPane.add(getBtn8(), null);
			jContentPane.add(getBtn9(), null);
			jContentPane.add(getBtn00(), null);
			jContentPane.add(getBtnPoint(), null);
			jContentPane.add(getTxtOpe(), null);
			jContentPane.add(getTxtRep(), null);
			jContentPane.add(getTxtM(), null);

			// 演算ボタン
			jContentPane.add(getBtnDiv(), null);
			jContentPane.add(getBtnMulti(), null);
			jContentPane.add(getBtnMinus(), null);
			jContentPane.add(getBtnPlus(), null);
			jContentPane.add(getBtnRatio(), null);
			jContentPane.add(getBtnRoot(), null);
			jContentPane.add(getBtnClear(), null);
			jContentPane.add(getBtnEqual(), null);
			jContentPane.add(getBtnMemoryPlus(), null);
			jContentPane.add(getBtnMemoryMinus(), null);
			jContentPane.add(getBtnMemoryRead(), null);
			jContentPane.add(getBtnMemoryClear(), null);

			// 時間計算モードボタン
			jContentPane.add(getBtnTime(), null);

			// スライダ
			jContentPane.add(getSldTerminator(), null);
			jContentPane.add(getSldLength(), null);

			// キーリスナ追加
			jContentPane.addKeyListener(this);
		}
		return jContentPane;
	}

	/**
	 * デモ実行
	 */
	private void showDemo() {

		try {

			// 表示窓の背景色と枠の赤
			int bgR = getBgArray()[R];
			int bdR = getBgArray()[R];

			// 表示窓の背景色と枠の緑
			int bgG = getBgArray()[G];
			int bdG = getBgArray()[G];

			// 表示窓の背景色と枠の青
			int bgB = getBgArray()[B];
			int bdB = getBgArray()[B];

			// 表示窓内のテキスト位置をセンターに
			getTxtDisplay().setHorizontalAlignment(JTextField.CENTER);

			// テキストをセット
			getTxtDisplay().setText("");

			// カラーオブジェクト生成
			Color color = new Color(bgR, bgG, bgB);

			// 表示窓の背景色をセット
			getTxtDisplay().setBackground(color);

			// 表示窓の枠線をセット
			getTxtDisplay().setBorder(BorderFactory.createLineBorder(color));

			// スリープ
			Thread.sleep(2000);

			while (true) {

				// 表示窓の背景色を変える。
				if (bgR < 255) {
					bgR++;
				}
				if (bgG < 255) {
					bgG++;
				}
				if (bgB < 255) {
					bgB++;
				}

				// 背景色をセット
				getTxtDisplay().setBackground(new Color(bgR, bgG, bgB));

				// 表示窓の枠の色を変える。
				if (bdR > BORDER[R]) {
					bdR--;
				}
				if (bdG > BORDER[G]) {
					bdG--;
				}
				if (bdB > BORDER[B]) {
					bdB--;
				}

				// 枠をセット
				getTxtDisplay().setBorder(BorderFactory.createLineBorder(new Color(bdR, bdG, bdB)));

				Thread.sleep(5);

				if (bgR == 255 && bgG == 255 && bgB == 255 && bdR == BORDER[R] && bdG == BORDER[G]
						&& bdB == BORDER[B]) {
					break;
				}
			}
		}
		// 例外時
		catch (Exception e) {
			// 特に何もしない
			System.out.println(e.getMessage());
		}
		// 必須動作
		finally {
			getTxtDisplay().setText("");
			getTxtDisplay().setHorizontalAlignment(JTextField.RIGHT);
			getTxtDisplay().setBackground(Color.white);
			getTxtDisplay().setText("0");
		}
	}

	/**
	 * メニューバーを返す。
	 *
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getTheMenuBar() {
		if (theMenuBar == null) {
			theMenuBar = new JMenuBar();
			theMenuBar.add(getMnEdit());
			theMenuBar.add(getMnOption());
			theMenuBar.add(getMnHelp());
		}
		return theMenuBar;
	}

	/**
	 * 編集メニューを返す。
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMnEdit() {
		if (mnEdit == null) {
			mnEdit = new JMenu();
			mnEdit.setText("編集(E)");
			mnEdit.setMnemonic(KeyEvent.VK_E);
			mnEdit.setFont(font_);
			mnEdit.add(getMniCopy());
			mnEdit.add(getMniPaste());
		}
		return mnEdit;
	}

	/**
	 * コピーメニューを返す。
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMniCopy() {
		if (mniCopy == null) {
			mniCopy = new JMenuItem();
			mniCopy.setText("コピー");
			mniCopy.setFont(font_);
			mniCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK, true));
			mniCopy.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					// クリップボート取得
					Clipboard clp = getToolkit().getSystemClipboard();

					// クリップボードに表示中の文字をコピー
					StringSelection copie = new StringSelection(getInputString());
					clp.setContents(copie, null);
				}
			});
		}
		return mniCopy;
	}

	/**
	 * 貼り付けメニューを返す。
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMniPaste() {
		if (mniPaste == null) {
			mniPaste = new JMenuItem();
			mniPaste.setText("磔");
			mniPaste.setFont(font_);
			mniPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK, true));
			mniPaste.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					// クリップボードを取得
					Clipboard clp = getToolkit().getSystemClipboard();
					Transferable pastie = clp.getContents(this);

					try {

						// クリップボードの文字を取得
						String tempString = (String) pastie.getTransferData(DataFlavor.stringFlavor);

						// 時間計算モード状態で文字列長が7以上の場合は貼り付け禁止
						if (tempString.length() > 6 && hms) {
							return;
						}

						// 文字をBigDecimalに変換
						BigDecimal bd = new BigDecimal(tempString);

						// ディスプレイに表示
						getTxtDisplay().setText(bd.toString());
					}

					// 例外発生時
					catch (Exception ex) {
						// 何もしない
					}

				}
			});
		}
		return mniPaste;
	}

	/**
	 * オプションメニューを返す。
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMnOption() {
		if (mnOption == null) {
			mnOption = new JMenu();
			mnOption.setText("オプション(O)");
			mnOption.setMnemonic(KeyEvent.VK_O);
			mnOption.setFont(font_);
			mnOption.add(getChkmniComma3());
			mnOption.addSeparator();
			mnOption.add(getMnCaption());
			mnOption.addSeparator();
			mnOption.add(getMnLookAndFeel());
			mnOption.addSeparator();
			mnOption.add(getChkmniDemo());
		}
		return mnOption;
	}

	/**
	 * 3桁区切り設定メニューを返す。
	 */
	private JCheckBoxMenuItem getChkmniComma3() {
		if (chkmniComma3 == null) {
			chkmniComma3 = new JCheckBoxMenuItem();
			chkmniComma3.setText("桁区切り表示(S)");
			chkmniComma3.setMnemonic(KeyEvent.VK_S);
			chkmniComma3.setFont(font_);
		}
		return chkmniComma3;
	}

	/**
	 * オープニングデモメニューを返す。
	 */
	private JCheckBoxMenuItem getChkmniDemo() {
		if (chkmniDemo == null) {
			chkmniDemo = new JCheckBoxMenuItem();
			chkmniDemo.setText("開始時にデモを表示する(D)");
			chkmniDemo.setMnemonic(KeyEvent.VK_D);
			chkmniDemo.setFont(font_);
		}
		return chkmniDemo;
	}

	/**
	 * 文字設定メニューを返す。
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMnCaption() {
		if (mnCaption == null) {
			mnCaption = new JMenu();
			mnCaption.setText("キャプション(C)");
			mnCaption.setMnemonic(KeyEvent.VK_C);
			mnCaption.setFont(font_);
			mnCaption.add(getRdomniGlobal());
			mnCaption.add(getRdomniDomestic());
			if (btngrpCaption == null) {
				btngrpCaption = new ButtonGroup();
				btngrpCaption.add(getRdomniGlobal());
				btngrpCaption.add(getRdomniDomestic());
			}
		}
		return mnCaption;
	}

	/**
	 * キャプション設定(標準)ラジオボタンを返す。
	 *
	 * @return javax.swing.JRadioButtonMenuItem
	 */
	private JRadioButtonMenuItem getRdomniGlobal() {
		if (rdomniGlobal == null) {
			rdomniGlobal = new JRadioButtonMenuItem();
			rdomniGlobal.setText("標準(S)");
			rdomniGlobal.setFont(font_);
			rdomniGlobal.setMnemonic(KeyEvent.VK_S);
			rdomniGlobal.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					setStyle(STYLE_STD);
				}
			});
		}
		return rdomniGlobal;
	}

	/**
	 * キャプション設定(和式)ラジオボタンを返す。
	 *
	 * @return javax.swing.JRadioButtonMenuItem
	 */
	private JRadioButtonMenuItem getRdomniDomestic() {
		if (rdomniDomestic == null) {
			rdomniDomestic = new JRadioButtonMenuItem();
			rdomniDomestic.setText("和式(J)");
			rdomniDomestic.setFont(font_);
			rdomniDomestic.setMnemonic(KeyEvent.VK_J);
			rdomniDomestic.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					setStyle(STYLE_JP);
				}
			});
		}
		return rdomniDomestic;
	}

	/**
	 * ルックアンドフィールメニューを返す。
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMnLookAndFeel() {
		if (mnLookAndFeel == null) {
			mnLookAndFeel = new JMenu();
			mnLookAndFeel.setText("ウインドウテーマ(W)");
			mnLookAndFeel.setMnemonic(KeyEvent.VK_W);
			mnLookAndFeel.setFont(font_);
			mnLookAndFeel.add(getRdomniJava());
			mnLookAndFeel.add(getRdomniWindows());
			mnLookAndFeel.add(getRdomniMotif());

			// ラジオボタンのグループ化
			if (btngrpLookAndFeel == null) {
				btngrpLookAndFeel = new ButtonGroup();
				btngrpLookAndFeel.add(getRdomniJava());
				btngrpLookAndFeel.add(getRdomniWindows());
				btngrpLookAndFeel.add(getRdomniMotif());
			}
		}
		return mnLookAndFeel;
	}

	/**
	 * Javaスタイル選択ラジオボタンを返す。
	 *
	 * @return javax.swing.JRadioButtonMenuItem
	 */
	private JRadioButtonMenuItem getRdomniJava() {
		if (rdomniJava == null) {
			rdomniJava = new JRadioButtonMenuItem();
			rdomniJava.setText("Java");
			rdomniJava.setFont(font_);
			rdomniJava.setMnemonic(KeyEvent.VK_J);
			rdomniJava.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					// ルックアンドフィールを設定
					setLookAndFeel(LOOKANDFEEL_JAVA);
				}
			});
		}
		return rdomniJava;
	}

	/**
	 * MS-Windowsスタイル選択ラジオボタンを返す。
	 *
	 * @return javax.swing.JRadioButtonMenuItem
	 */
	private JRadioButtonMenuItem getRdomniWindows() {
		if (rdomniWindows == null) {
			rdomniWindows = new JRadioButtonMenuItem();
			rdomniWindows.setText("Windows");
			rdomniWindows.setFont(font_);
			rdomniWindows.setMnemonic(KeyEvent.VK_W);
			rdomniWindows.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					// ルックアンドフィールを設定
					setLookAndFeel(LOOKANDFEEL_WINDOWS);
				}
			});
		}
		return rdomniWindows;
	}

	/**
	 * Motifスタイル選択ラジオボタンを返す。
	 *
	 * @return javax.swing.JRadioButtonMenuItem
	 */
	private JRadioButtonMenuItem getRdomniMotif() {
		if (rdomniMotif == null) {
			rdomniMotif = new JRadioButtonMenuItem();
			rdomniMotif.setText("Motif");
			rdomniMotif.setFont(font_);
			rdomniMotif.setMnemonic(KeyEvent.VK_M);
			rdomniMotif.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					// ルックアンドフィールを設定
					setLookAndFeel(LOOKANDFEEL_MOTIF);
				}
			});
		}
		return rdomniMotif;
	}

	/**
	 * ヘルプメニューを返す。
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu();
			mnHelp.setText("ヘルプ(H)");
			mnHelp.setMnemonic(KeyEvent.VK_H);
			mnHelp.setFont(font_);
			mnHelp.add(getMniAbout());
		}
		return mnHelp;
	}

	/**
	 * バージョン情報メニューを返す。
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMniAbout() {
		if (mniAbout == null) {
			mniAbout = new JMenuItem();
			mniAbout.setText("バージョン情報(A)");
			mniAbout.setFont(font_);
			mniAbout.setMnemonic(KeyEvent.VK_A);
			mniAbout.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog((Component) e.getSource(), ABOUT, TITLE,
							JOptionPane.CLOSED_OPTION);
				}
			});
		}
		return mniAbout;
	}

	/**
	 * 丸め指示スライダを返す。
	 *
	 * @return javax.swing.JSlider
	 */
	private JSlider getSldTerminator() {
		if (sldTerminator == null) {
			// sldTerminator = new JSlider(0,
			// LABELS_FOR_TERMINATOR.length - 1);
			// sldTerminator = new JSlider(0, 3);
			sldTerminator = new JSlider();
			sldTerminator.setMinimum(0);
			sldTerminator.setMaximum(3);
			sldTerminator.setMajorTickSpacing(1);
			sldTerminator.setPaintLabels(true);
			sldTerminator.setSnapToTicks(true);
			// sldTerminator.setPaintTrack(false);
			sldTerminator.setBounds(new Rectangle(10, 35, 120, 40));
			sldTerminator.setLabelTable(getLblsTerminator());
			sldTerminator.setToolTipText(TIP_FOR_TERMINATOR);
			sldTerminator.addKeyListener(this);
		}
		return sldTerminator;
	}

	/**
	 * 丸め指示スライダのラベルを返す。
	 *
	 * @return java.util.Hashtable
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Hashtable getLblsTerminator() {
		if (lblsTerminator == null) {

			lblsTerminator = new Hashtable();

			for (int i = 0; i < LABELS_FOR_TERMINATOR.length; i++) {
				Integer integer = new Integer(i);
				JLabel lbl = new JLabel(LABELS_FOR_TERMINATOR[i]);
				lbl.setFont(new Font(FONT_DIALOG, Font.PLAIN, 10));
				lblsTerminator.put(integer, lbl);
			}
		}
		return lblsTerminator;
	}

	/**
	 * 小数点以下桁数指示スライダを返す。
	 *
	 * @return javax.swing.JSlider
	 */
	private JSlider getSldLength() {
		if (sldLength == null) {
			// sldLength = new JSlider(0,
			// LABELS_FOR_LENGTH.length - 1);
			sldLength = new JSlider();
			sldLength.setMinimum(0);
			sldLength.setMaximum(4);
			sldLength.setMajorTickSpacing(1);
			sldLength.setPaintLabels(true);
			sldLength.setSnapToTicks(true);
			// sldLength.setPaintTrack(false);
			sldLength.setBounds(new Rectangle(220, 35, 120, 40));
			sldLength.setLabelTable(getLblsLength());
			sldLength.setToolTipText(TIP_FOR_LENGTH);
			sldLength.addKeyListener(this);
		}
		return sldLength;
	}

	/**
	 * 小数点以下桁数指示スライダのラベルを返す。
	 *
	 * @return java.util.Hashtable
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Hashtable getLblsLength() {
		if (lblsLength == null) {

			lblsLength = new Hashtable();

			for (int i = 0; i < LABELS_FOR_LENGTH.length; i++) {
				Integer integer = new Integer(i);
				JLabel lbl = new JLabel(LABELS_FOR_LENGTH[i]);
				lbl.setFont(new Font(FONT_DIALOG, Font.PLAIN, 10));
				lblsLength.put(integer, lbl);
			}
		}
		return lblsLength;
	}

	/**
	 * 表示窓を返す。
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtDisplay() {
		if (txtDisplay == null) {
			txtDisplay = new JTextField();
			txtDisplay.setBounds(new Rectangle(15, 10, 325, 22));
			txtDisplay.setHorizontalAlignment(JTextField.RIGHT);
			txtDisplay.setFont(new Font(FONT_DIALOG, Font.PLAIN, 14));
			txtDisplay.setEditable(false);
			txtDisplay.setBackground(Color.white);
			Color color = new Color(10, 10, 40);
			txtDisplay.setBorder(BorderFactory.createLineBorder(color));
			txtDisplay.setText("0");
			txtDisplay.addKeyListener(this);
		}
		return txtDisplay;
	}

	/**
	 * 演算子表示窓を返す。
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtOpe() {
		if (txtOpe == null) {
			txtOpe = new JTextField();
			txtOpe.setBounds(new Rectangle(166, 40, 18, 18));
			// txtOpe.setBounds(new Rectangle(144,
			// 40, 18, 18));
			txtOpe.setFont(new Font(FONT_DIALOG, Font.PLAIN, 10));
			txtOpe.setHorizontalAlignment(JTextField.CENTER);
			txtOpe.setEditable(false);
			int[] rgb = getBgArray();
			Color color = new Color(rgb[R], rgb[G], rgb[B]);
			txtOpe.setBackground(color);
			txtOpe.setBorder(BorderFactory.createLoweredBevelBorder());
			txtOpe.addKeyListener(this);
		}
		return txtOpe;
	}

	/**
	 * リピート演算中表示窓を返す。
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtRep() {
		if (txtRep == null) {
			txtRep = new JTextField();
			// txtRep.setBounds(new Rectangle(166,
			// 40, 18, 18));
			txtRep.setBounds(new Rectangle(144, 40, 18, 18));
			txtRep.setFont(new Font(FONT_DIALOG, Font.PLAIN, 10));
			txtRep.setHorizontalAlignment(JTextField.CENTER);
			txtRep.setEditable(false);
			int[] rgb = getBgArray();
			Color color = new Color(rgb[R], rgb[G], rgb[B]);
			txtRep.setBackground(color);
			txtRep.setBorder(BorderFactory.createLoweredBevelBorder());
			txtRep.addKeyListener(this);
		}
		return txtRep;
	}

	/**
	 * メモリー中表示窓を返す。
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getTxtM() {
		if (txtM == null) {
			txtM = new JTextField();
			txtM.setBounds(new Rectangle(189, 40, 18, 18));
			txtM.setFont(new Font(FONT_DIALOG, Font.PLAIN, 10));
			txtM.setHorizontalAlignment(JTextField.CENTER);
			txtM.setEditable(false);
			int[] rgb = getBgArray();
			Color color = new Color(rgb[R], rgb[G], rgb[B]);
			txtM.setBackground(color);
			txtM.setBorder(BorderFactory.createLoweredBevelBorder());
			txtM.addKeyListener(this);
		}
		return txtM;
	}

	/**
	 * 0ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtn0() {
		if (btn0 == null) {
			btn0 = new DentakuButton(this);
			btn0.setButtonId(ZERO);
			btn0.setLocation(15, 210);
			btn0.addActionListener(new ZeroButtonActionListener());
		}
		return btn0;
	}

	/**
	 * 1ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtn1() {
		if (btn1 == null) {
			btn1 = new DentakuButton(this);
			btn1.setButtonId(ONE);
			btn1.setLocation(15, 180);
			btn1.addActionListener(new NumberButtonActionListener());
		}
		return btn1;
	}

	/**
	 * 2ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtn2() {
		if (btn2 == null) {
			btn2 = new DentakuButton(this);
			btn2.setButtonId(TWO);
			btn2.setLocation(80, 180);
			btn2.addActionListener(new NumberButtonActionListener());
		}
		return btn2;
	}

	/**
	 * 3ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtn3() {
		if (btn3 == null) {
			btn3 = new DentakuButton(this);
			btn3.setButtonId(THREE);
			btn3.setLocation(145, 180);
			btn3.addActionListener(new NumberButtonActionListener());
		}
		return btn3;
	}

	/**
	 * 4ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtn4() {
		if (btn4 == null) {
			btn4 = new DentakuButton(this);
			btn4.setButtonId(FOUR);
			btn4.setLocation(15, 150);
			btn4.addActionListener(new NumberButtonActionListener());
		}
		return btn4;
	}

	/**
	 * 5ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtn5() {
		if (btn5 == null) {
			btn5 = new DentakuButton(this);
			btn5.setButtonId(FIVE);
			btn5.setLocation(80, 150);
			btn5.addActionListener(new NumberButtonActionListener());
		}
		return btn5;
	}

	/**
	 * 6ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtn6() {
		if (btn6 == null) {
			btn6 = new DentakuButton(this);
			btn6.setButtonId(SIX);
			btn6.setLocation(145, 150);
			btn6.addActionListener(new NumberButtonActionListener());
		}
		return btn6;
	}

	/**
	 * 7ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtn7() {
		if (btn7 == null) {
			btn7 = new DentakuButton(this);
			btn7.setButtonId(SEVEN);
			btn7.setLocation(15, 120);
			btn7.addActionListener(new NumberButtonActionListener());
		}
		return btn7;
	}

	/**
	 * 8ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtn8() {
		if (btn8 == null) {
			btn8 = new DentakuButton(this);
			btn8.setButtonId(EIGHT);
			btn8.setLocation(80, 120);
			btn8.addActionListener(new NumberButtonActionListener());
		}
		return btn8;
	}

	/**
	 * 9ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtn9() {
		if (btn9 == null) {
			btn9 = new DentakuButton(this);
			btn9.setButtonId(NINE);
			btn9.setLocation(145, 120);
			btn9.addActionListener(new NumberButtonActionListener());
		}
		return btn9;
	}

	/**
	 * 00ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtn00() {
		if (btn00 == null) {
			btn00 = new DentakuButton(this);
			btn00.setButtonId(ZERO2);
			btn00.setLocation(80, 210);
			btn00.addActionListener(new ZeroButtonActionListener());
		}
		return btn00;
	}

	/**
	 * 小数点ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnPoint() {
		if (btnPoint == null) {
			btnPoint = new DentakuButton(this);
			btnPoint.setButtonId(POINT);
			btnPoint.setLocation(145, 210);
			btnPoint.addActionListener(new PointButtonActionListener());
		}
		return btnPoint;
	}

	/**
	 * +ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnPlus() {
		if (btnPlus == null) {
			btnPlus = new DentakuButton(this);
			btnPlus.setButtonId(PLUS);
			btnPlus.setLocation(215, 210);
			btnPlus.addActionListener(new OperatorButtonActionListener());
		}
		return btnPlus;
	}

	/**
	 * -ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnMinus() {
		if (btnMinus == null) {
			btnMinus = new DentakuButton(this);
			btnMinus.setButtonId(MINUS);
			btnMinus.setLocation(215, 180);
			btnMinus.addActionListener(new OperatorButtonActionListener());
		}
		return btnMinus;
	}

	/**
	 * *ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnMulti() {
		if (btnMulti == null) {
			btnMulti = new DentakuButton(this);
			btnMulti.setButtonId(MULTI);
			btnMulti.setLocation(215, 150);
			btnMulti.addActionListener(new OperatorButtonActionListener());
		}
		return btnMulti;
	}

	/**
	 * ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnDiv() {
		if (btnDiv == null) {
			btnDiv = new DentakuButton(this);
			btnDiv.setButtonId(DIV);
			btnDiv.setLocation(215, 120);
			btnDiv.addActionListener(new OperatorButtonActionListener());
		}
		return btnDiv;
	}

	/**
	 * 率ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnRatio() {
		if (btnRatio == null) {
			btnRatio = new DentakuButton(this);
			btnRatio.setButtonId(RATIO);
			btnRatio.setLocation(280, 120);
			btnRatio.addActionListener(new RatioButtonActionListener());
		}
		return btnRatio;
	}

	/**
	 * 平方根ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnRoot() {
		if (btnRoot == null) {
			btnRoot = new DentakuButton(this);
			btnRoot.setButtonId(ROOT);
			btnRoot.setLocation(280, 150);
			btnRoot.addActionListener(new RootButtonActionListener());
		}
		return btnRoot;
	}

	/**
	 * Cボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new DentakuButton(this);
			btnClear.setButtonId(CLEAR);
			btnClear.setLocation(280, 180);
			btnClear.setForeground(Color.red);
			btnClear.addActionListener(new ClearButtonActionListener());
		}
		return btnClear;
	}

	/**
	 * =ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnEqual() {
		if (btnEqual == null) {
			btnEqual = new DentakuButton(this);
			btnEqual.setButtonId(EQ);
			btnEqual.setLocation(280, 210);
			btnEqual.addActionListener(new EqualButtonActionListener());
		}
		return btnEqual;
	}

	/**
	 * 時間ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnTime() {
		if (btnTime == null) {
			btnTime = new DentakuButton(this);
			btnTime.setButtonId(TIME);
			btnTime.setLocation(15, 80);
			btnTime.addActionListener(new TimeButtonActionListener());
		}
		return btnTime;
	}

	/**
	 * M+ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnMemoryPlus() {
		if (btnMemoryPlus == null) {
			btnMemoryPlus = new DentakuButton(this);
			btnMemoryPlus.setButtonId(MPLUS);
			btnMemoryPlus.setLocation(80, 80);
			btnMemoryPlus.addActionListener(new MPlusButtonActionListener());
		}
		return btnMemoryPlus;
	}

	/**
	 * M-ボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnMemoryMinus() {
		if (btnMemoryMinus == null) {
			btnMemoryMinus = new DentakuButton(this);
			btnMemoryMinus.setButtonId(MMINUS);
			btnMemoryMinus.setLocation(145, 80);
			btnMemoryMinus.addActionListener(new MMinusButtonActionListener());
		}
		return btnMemoryMinus;
	}

	/**
	 * MRボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnMemoryRead() {
		if (btnMemoryRead == null) {
			btnMemoryRead = new DentakuButton(this);
			btnMemoryRead.setButtonId(MRESET);
			btnMemoryRead.setLocation(215, 80);
			btnMemoryRead.addActionListener(new MReadButtonActionListener());
		}
		return btnMemoryRead;
	}

	/**
	 * MCボタンを返す。
	 *
	 * @return DentakuButton
	 */
	private DentakuButton getBtnMemoryClear() {
		if (btnMemoryClear == null) {
			btnMemoryClear = new DentakuButton(this);
			btnMemoryClear.setButtonId(MCLEAR);
			btnMemoryClear.setLocation(280, 80);
			btnMemoryClear.addActionListener(new MClearButtonActionListener());

		}
		return btnMemoryClear;
	}

	/**
	 * 計算する。ゼロ除算の場合nullを返す。
	 *
	 * @param number
	 *            数値
	 * @return BigDecimal
	 */
	// private void calculate(BigDecimal number) {
	private BigDecimal calculate(BigDecimal number) {

		// 足し算
		if (operator == PLUS) {
			// operand = operand.add(number);
			return operand.add(number);
		}
		// 引き算
		else if (operator == MINUS) {
			// operand =
			// operand.add(number.negate());
			return operand.add(number.negate());
		}
		// 掛け算
		else if (operator == MULTI) {
			// operand = operand.multiply(number);
			return operand.multiply(number);
		}
		// 割り算
		else if (operator == DIV) {

			try {
				// operand =
				// operand.divide(number);
				return operand.divide(number, BigDecimal.ROUND_UNNECESSARY);
			}
			// 割り切れない場合
			catch (ArithmeticException e) {

				try {
					// 小数100桁で切り捨て
					// operand = operand
					// .divide(number, 100,
					// BigDecimal.ROUND_DOWN);
					return operand.divide(number, 100, BigDecimal.ROUND_DOWN);
				}
				// ゼロ除算の場合
				catch (ArithmeticException ee) {
					return null;
				}
			}
		}
		return null;
	}

	/**
	 * 時間計算をする
	 *
	 */
	private void caluclateHms() {

		// オペランド1を取得
		long ope1 = getHmsBigDecimal(operand);

		// オペランド2を取得
		long ope2 = getHmsBigDecimal(getInputBigDecimal());

		// 演算子がプラスの場合
		if (operator == PLUS) {
			// 足し算
			ope1 += ope2;
		}
		// 演算子がマイナスの場合
		else {
			// 引き算
			ope1 -= ope2;
		}

		// 計算
		long h = ope1 / 3600;
		long m = (ope1 % 3600) / 60;
		long s = (ope1 % 3600) % 60;

		// マイナス表示
		String minus = (h < 1 || m < 0 || s < 0) ? "-" : "";

		// フォーマット
		DecimalFormat fmt = new DecimalFormat("00");

		// 答えを生成
		String ans = minus + fmt.format(Math.abs(h)) + ":" + fmt.format(Math.abs(m)) + ":"
				+ fmt.format(Math.abs(s));

		// ディスプレイに表示
		getTxtDisplay().setText(ans);
	}

	/**
	 * 数値を時間計算用に計算する
	 *
	 * @param number
	 *            数値
	 * @return BigDecimal
	 */
	private long getHmsBigDecimal(BigDecimal number) {

		// 6桁ゼロ詰めにフォーマット
		String numberString = formatHms(number);

		// 時分秒に分割
		long h = Long.parseLong(numberString.substring(0, 2)) * 3600;
		long m = Long.parseLong(numberString.substring(2, 4)) * 60;
		long s = Long.parseLong(numberString.substring(4, 6));

		return h + m + s;
	}

	/**
	 * 数値をHMSにフォーマット
	 *
	 * @param number
	 *            数値
	 * @return String
	 */
	private String formatHms(BigDecimal number) {

		// 6桁ゼロ詰めにフォーマット
		DecimalFormat fmt = new DecimalFormat();
		fmt.applyPattern("000000");
		return fmt.format(number);
	}

	/**
	 * ディスプレイに表示された数値をBigDecimalにして返す。
	 *
	 * @return BigDecimal
	 */
	private BigDecimal getInputBigDecimal() {

		// 表示窓に表示された値を取得
		String value = getTxtDisplay().getText();

		// 桁区切りカンマ、コロン(時間計算モードの場合のやつ)を取り除く
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) != ',' && value.charAt(i) != ':') {
				sbf.append(value.charAt(i));
			}
		}
		value = sbf.toString();

		// 小数点で始まっている場合
		if (value.startsWith(".")) {
			// 頭に0を付す
			value = "0" + value;
		}

		// 小数点で終わっている場合
		if (value.endsWith(".")) {
			// その小数点を取る
			value = value.substring(0, value.length() - 1);
		}

		// ブランクの場合ゼロとする
		if (value.equals("")) {
			value = "0";
		}

		return new BigDecimal(value);
	}

	/**
	 * 表示窓に表示された文字を文字列としてそのまま返す。
	 *
	 * @return String
	 */
	private String getInputString() {
		return getTxtDisplay().getText();
	}

	/**
	 * 数値を終端処理して返す。
	 *
	 * @param number
	 *            数値
	 * @return BigDecimal
	 */
	private BigDecimal terminateNumber(BigDecimal number) {

		// 小数点以下桁数を取得
		int scale = getSldLength().getValue();

		// 切り捨て
		if (getSldTerminator().getValue() == DOWN) {
			return number.setScale(scale, BigDecimal.ROUND_DOWN);
		}
		// 切り上げ
		else if (getSldTerminator().getValue() == UP) {
			return number.setScale(scale, BigDecimal.ROUND_UP);
		}
		// 四捨五入
		else if (getSldTerminator().getValue() == ROUND) {
			return number.setScale(scale, BigDecimal.ROUND_HALF_UP);
		}

		return number;
	}

	/**
	 * 計算結果をディスプレイに表示する
	 *
	 */
	private void showNumberOnDisplay(BigDecimal number) {

		// 数字がnullの場合
		if (number == null) {
			getTxtDisplay().setText(INFINITY);
			return;
		}

		// 数値を文字列化
		String numString = number.toString();

		// ディスプレイの幅に収まるよう数値を処理
		if (numString.length() > 38) {
			numString = numString.substring(0, 38);
		}

		// セッション中の場合
		if (inSession) {

			// そのまま表示
			// getTxtDisplay().setText(numString.toString());
			setFormatNumberOnDisplay(new BigDecimal(numString));
		}

		// セッション中でない場合
		else {

			// 終端処理して表示
			// BigDecimal bd = new
			// BigDecimal(numString.toString());
			// getTxtDisplay().setText(terminateNumber(bd).toString());
			setFormatNumberOnDisplay(terminateNumber(new BigDecimal(numString)));
		}
	}

	/**
	 * ディスプレイに表示する数字をフォーマットする。
	 *
	 * @param number
	 *            数値
	 */
	private void setFormatNumberOnDisplay(BigDecimal number) {

		// nullの場合ディスプレイにブランクをセット
		if (number == null) {
			getTxtDisplay().setText("");
			return;
		}

		// 3桁区切りフラグを取得
		boolean format = getChkmniComma3().getState();

		DecimalFormat fmt = new DecimalFormat();

		// 3桁区切りする場合
		if (format) {
			fmt.applyPattern(FORMAT_SEPARATE);
		}
		// 3桁区切りしない場合
		else {
			fmt.applyPattern(FORMAT_NOSEPARATE);
		}
		getTxtDisplay().setText(fmt.format(number));
	}

	/**
	 * フォーマットした時間をディスプレイに表示する。
	 *
	 * @param number
	 *            数値
	 */
	private void setFormatHmsOnDisplay(BigDecimal number) {

		// nullの場合ディスプレイにブランクをセット
		if (number == null) {
			getTxtDisplay().setText("");
			return;
		}

		// 6桁ゼロ詰めにフォーマット
		String numberString = formatHms(number);

		// 時分秒に分割
		String h = numberString.substring(0, 2);
		String m = numberString.substring(2, 4);
		String s = numberString.substring(4, 6);

		// 表示
		getTxtDisplay().setText(h + ":" + m + ":" + s);
	}

	/**
	 * ルックアンドフィールを変更する。
	 *
	 * @param lookAndFeel
	 */
	private void setLookAndFeel(String lookAndFeel) {
		try {

			// ルックアンドフィール変更
			UIManager.setLookAndFeel(lookAndFeel);
			SwingUtilities.updateComponentTreeUI(this);
		}
		// 例外時処理
		catch (Exception e) {
			// 特に何もしない
		}
	}

	/**
	 * 設定ファイルを読み込む
	 *
	 * @param 設定指定文字列
	 * @return 設定文字列
	 */
	private String loadConfigration(String config) {
		try {

			// ルックアンドフィール文字列をファイルから読み込み
			String fileName = getPath() + config;

			// ファイルが存在する場合は読み込んで内容を返す。
			File file = new File(fileName);
			if (file.exists()) {
				FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(fis);
				String temp = (String) in.readObject();
				in.close();
				return temp;
			}
		}
		// 例外の場合
		catch (Exception e) {
			// 特に何もしない
		}

		// ルックアンドフィール
		if (config.equals(SER_LOOKANDFEEL)) {
			return LOOKANDFEEL_WINDOWS;
		}
		// 終端処理
		else if (config.equals(SER_ROUND)) {
			return "1";
		}
		// 小数点以下桁数
		else if (config.equals(SER_LENGTH)) {
			return "2";
		}
		// スタイル
		else if (config.equals(SER_FORMAT)) {
			return "false";
		}
		// デモ
		else if (config.equals(SER_DEMO)) {
			return "false";
		}
		return "";
	}

	/**
	 * 丸め、小数点以下桁数、ルックアンドフィール設定をファイルに保存する
	 *
	 */
	private void saveConfigration() {
		try {

			// ルックアンドフィール
			String fileName = getPath() + SER_LOOKANDFEEL;

			// オブジェクト出力オブジェクト
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);

			// 現在選択されているルックアンドフィールを取得
			ButtonModel lookAndFeel = btngrpLookAndFeel.getSelection();

			// 書き込み:Java
			if (lookAndFeel.getMnemonic() == KeyEvent.VK_J) {
				out.writeObject(LOOKANDFEEL_JAVA);
			}
			// Motif
			else if (lookAndFeel.getMnemonic() == KeyEvent.VK_M) {
				out.writeObject(LOOKANDFEEL_MOTIF);
			}
			// Windows
			else {
				out.writeObject(LOOKANDFEEL_WINDOWS);
			}

			// 終端処理
			fileName = getPath() + SER_ROUND;

			// オブジェクト出力オブジェクト
			file = new FileOutputStream(fileName);
			out = new ObjectOutputStream(file);

			// 現在選択されている終端処理を取得
			String round = String.valueOf(getSldTerminator().getValue());

			// 書き込み
			out.writeObject(round);

			// 小数点以下桁数
			fileName = getPath() + SER_LENGTH;

			// オブジェクト出力オブジェクト
			file = new FileOutputStream(fileName);
			out = new ObjectOutputStream(file);

			// 現在選択されている小数点以下桁数を取得
			String length = String.valueOf(getSldLength().getValue());

			// 書き込み
			out.writeObject(length);

			// 小数点以下桁数
			fileName = getPath() + SER_FORMAT;

			// オブジェクト出力オブジェクト
			file = new FileOutputStream(fileName);
			out = new ObjectOutputStream(file);

			// 現在の3桁区切りモードを取得
			String format = new Boolean(getChkmniComma3().getState()).toString();

			// 書き込み
			out.writeObject(format);

			// デモ画面
			fileName = getPath() + SER_DEMO;

			// オブジェクト出力オブジェクト
			file = new FileOutputStream(fileName);
			out = new ObjectOutputStream(file);

			// 現在のデモを取得
			String demo = new Boolean(getChkmniDemo().getState()).toString();

			// 書き込み
			out.writeObject(demo);

			out.flush();
			out.close();
		}
		// 例外時処理
		catch (Exception e) {
			// 特に何もしない
		}
	}

	/**
	 * このアプリケーションのパスを返す。
	 *
	 * @return このアプリケーションのパス
	 */
	private static String getPath() {

		// このアプリケーションのパスを取得
		String pathes = System.getProperty("java.class.path");

		// パスをセミコロンで分割
		StringTokenizer token = new StringTokenizer(pathes, ";");

		// classesディレクトリの完全パスを返す。
		while (token.hasMoreTokens()) {
			String tempStr = token.nextToken();
			if (tempStr.endsWith("classes")) {
				return tempStr;
			}
		}

		// classesディレクトリが見つからなければnullを返す(ありえない事態)
		return null;
	}

	/**
	 * 起動時の選択済みルックアンドフィールメニューをセットする。
	 *
	 * @param lookAndFeel
	 *            ルックアンドフィール指定用文字列
	 */
	private void setInitSelectedLookAndFeel(String lookAndFeel) {
		// Java
		if (lookAndFeel.equals(LOOKANDFEEL_JAVA)) {
			getRdomniJava().setSelected(true);
		}
		// Motif
		else if (lookAndFeel.equals(LOOKANDFEEL_MOTIF)) {
			getRdomniMotif().setSelected(true);
		}
		// Windows
		else {
			getRdomniWindows().setSelected(true);
		}
	}

	/**
	 * 起動時の位置をセットする(画面中央)
	 *
	 */
	private void setInitPosition() {
		Dimension scr = getToolkit().getScreenSize();
		setLocation((scr.width - WIDTH_) / 2, (scr.height - HEIGHT_) / 2);
	}

	/**
	 * ボタンのスタイルを変える。
	 *
	 * @param style
	 *            CAPTION_S or CAPTION_J
	 */
	private void setStyle(int style) {

		// キャプション配列を選択
		String[] captions = (style == STYLE_STD) ? CAPTIONS_STD : CAPTIONS_JP;

		// メソッドリストを取得
		Method[] methods = getClass().getDeclaredMethods();

		try {

			// ボタン取得メソッドを実行してボタンのキャプションをセット
			for (int i = 0; i < methods.length; i++) {

				if (methods[i].getName().startsWith("getBtn")) {

					// ボタン取得
					DentakuButton btn = (DentakuButton) methods[i].invoke(this);
					// Java1.4以前
					// DentakuButton btn =
					// (DentakuButton)
					// methods[i].invoke(this,
					// null);

					// ボタンIDでキャプションをセット
					btn.setText(captions[btn.getButtonId()]);
				}
			}
		}
		// 例外時
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * ウインドウの背景色の初期値を返す。
	 *
	 * @return int[]
	 */
	private int[] getBgArray() {
		// String lookAndFeel =
		// getSerializedLookAndFeel();
		String lookAndFeel = loadConfigration(SER_LOOKANDFEEL);

		// Java
		if (lookAndFeel.equals(LOOKANDFEEL_JAVA)) {
			return BG_JAVA;
		}
		// Motif
		else if (lookAndFeel.equals(LOOKANDFEEL_MOTIF)) {
			return BG_MOTIF;
		}
		// Windows
		else {
			return BG_WINDOWS;
		}
	}

	/**
	 * tempファイルを作る。
	 */
	private void createTempFile() {
		try {

			// ファイル名
			String fileName = getPath() + "\\temp";
			File file = new File(fileName);
			file.setReadOnly();
			// システム終了時に削除
			file.deleteOnExit();
			file.createNewFile();
		}
		// 例外時
		catch (Exception e) {
			// 特に何もしない
		}
	}

	/**
	 * 丸ごとクリア
	 */
	private void delete() {
		inGeneratingNumber = false;
		inSession = false;
		calculatable = false;
		operator = EQ;
		operand = BD_ZERO;
		operand2 = BD_ZERO;
		getTxtDisplay().setText("0");
		getTxtOpe().setText("");
		getTxtRep().setText("");
		repeat = false;
	}

	/**
	 * 1文字消去
	 */
	private void backSpace() {
		String text = getTxtDisplay().getText();
		if (text.equals("0") || text.length() == 1) {
			getTxtDisplay().setText("0");
			return;
		}

		// 表示文字の列長
		int len_ = text.length();

		// 表示文字の最後から2番目の文字
		char preLast = text.charAt(len_ - 2);

		// 小数点で終わっている場合
		if (preLast == '.') {
			len_ = len_ - 2;
		}
		// 小数点で終わっていない場合
		else {
			len_ = len_ - 1;
		}
		getTxtDisplay().setText(text.substring(0, len_));
	}

	/**
	 * キープレス時処理
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@SuppressWarnings("unchecked")
	public void keyPressed(KeyEvent e) {
		// アクションイベント
		ActionEvent ae = null;

		// アクションイベントコンストラクタの第二引数
		int param2 = ActionEvent.ACTION_PERFORMED;

		// 押下キーの文字
		char pressedKey = e.getKeyChar();

		// 押下キーのキーコード
		int keyCode = e.getKeyCode();

		// System.out.println("aaaaaaa:" +
		// keyCode);

		try {

			// 数字の配列
			char[] chars = { '1', '2', '3', '4', '5', '6', '7', '8', '9', };

			// 数字キーの場合
			for (int i = 0; i < chars.length; i++) {

				if (pressedKey == chars[i]) {

					// メソッド取得
					String methodName = "getBtn" + chars[i];
					Method btnGetter = getClass().getDeclaredMethod(methodName);

					// ボタンを取得
					DentakuButton btn = (DentakuButton) btnGetter.invoke(this);
					// Java1.4以前/////////////////////////////////////////////
					// DentakuButton btn =
					// (DentakuButton)
					// btnGetter.invoke(this,null);

					// 当該数字ボタン押下時アクションイベント生成
					ae = new ActionEvent(btn, param2, null);

					// 押下時処理を実行
					(new NumberButtonActionListener()).actionPerformed(ae);

					return;
				}
			}

			// ゼロキーの場合
			// 小数点キーの場合
			if (pressedKey == '0') {
				ae = new ActionEvent(getBtn0(), param2, null);
				// 押下時処理を実行
				(new ZeroButtonActionListener()).actionPerformed(ae);
				return;
			}

			// 演算子のハッシュマップを生成
			@SuppressWarnings("rawtypes")
			Hashtable operators = new Hashtable();
			operators.put(new Character('+'), "Plus");
			operators.put(new Character('-'), "Minus");
			operators.put(new Character('*'), "Multi");
			operators.put(new Character('/'), "Div");

			// ハッシュマップの反復子を取得
			@SuppressWarnings("rawtypes")
			Enumeration enumer = operators.keys();

			// 演算子キーの場合
			while (enumer.hasMoreElements()) {

				// キー取得
				Character key = (Character) enumer.nextElement();

				if (pressedKey == key.charValue()) {

					// メソッド取得
					String methodName = "getBtn" + operators.get(key);
					Method btnGetter = getClass().getDeclaredMethod(methodName);

					// ボタンを取得
					DentakuButton btn = (DentakuButton) btnGetter.invoke(this);
					// Java1.4以前/////////////////////////////////////////////
					// DentakuButton btn =
					// (DentakuButton)
					// btnGetter.invoke(this,
					// null);

					// 当該数字ボタン押下時アクションイベント生成
					ae = new ActionEvent(btn, param2, null);

					// 押下時処理を実行
					(new OperatorButtonActionListener()).actionPerformed(ae);

					return;
				}
			}

			// 小数点キーの場合
			if (pressedKey == '.') {
				ae = new ActionEvent(getBtnPoint(), param2, null);
				// 押下時処理を実行
				(new PointButtonActionListener()).actionPerformed(ae);
				return;
			}

			// エンターキーの場合
			if (keyCode == KeyEvent.VK_ENTER) {
				ae = new ActionEvent(getBtnEqual(), param2, null);
				// 押下時処理を実行
				(new EqualButtonActionListener()).actionPerformed(ae);
				return;
			}

			// PageUpボタンの場合は％ボタン
			if (keyCode == KeyEvent.VK_PAGE_UP) {
				ae = new ActionEvent(getBtnRatio(), param2, null);
				// 押下時処理を実行
				(new RatioButtonActionListener()).actionPerformed(ae);
				return;
			}

			// PageDownボタンの場合は平方根ボタン
			if (keyCode == KeyEvent.VK_PAGE_DOWN) {
				ae = new ActionEvent(getBtnRoot(), param2, null);
				// 押下時処理を実行
				(new RootButtonActionListener()).actionPerformed(ae);
				return;
			}

			// //////////////////////////////////////////////////////////////////////
			// メモリー操作系：F10の動作がおかしいのでコメントアウト中(since20061201)
			// // F9ボタンの場合はM+ボタン
			// if (keyCode == KeyEvent.VK_F9) {
			// ae = new
			// ActionEvent(getBtnMemoryPlus(),
			// param2, null);
			// // 押下時処理を実行
			// (new
			// MPlusButtonActionListener()).actionPerformed(ae);
			// return;
			// }
			//
			// // F10ボタンの場合はM-ボタン
			// if (keyCode == KeyEvent.VK_F10) {
			// ae = new
			// ActionEvent(getBtnMemoryMinus(),
			// param2, null);
			// // 押下時処理を実行
			// (new
			// MMinusButtonActionListener()).actionPerformed(ae);
			// return;
			// }
			//
			// // F11ボタンの場合はMRボタン
			// if (keyCode == KeyEvent.VK_F11) {
			// ae = new
			// ActionEvent(getBtnMemoryRead(),
			// param2, null);
			// // 押下時処理を実行
			// (new
			// MReadButtonActionListener()).actionPerformed(ae);
			// return;
			// }
			//
			// // F12ボタンの場合はMCボタン
			// if (keyCode == KeyEvent.VK_F12) {
			// ae = new
			// ActionEvent(getBtnMemoryClear(),
			// param2, null);
			// // 押下時処理を実行
			// (new
			// MClearButtonActionListener()).actionPerformed(ae);
			// return;
			// }

			// BSーキーの場合:一文字消去
			if (keyCode == KeyEvent.VK_BACK_SPACE) {
				backSpace();
				return;
			}

			// deleteキーの場合：クリアボタンの動作
			if (keyCode == KeyEvent.VK_DELETE) {
				delete();
				return;
			}
		}
		// 例外時
		catch (Exception ex) {

			// コンソール出力
			System.out.println(ex.toString());
		}

	}

	/**
	 * キーリリース時処理
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {
		// 空実装
	}

	/**
	 * キータイプ時処理
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent e) {
		// 空実装
	}

	/**
	 * ウインドウリスナー
	 *
	 * @version 1.0
	 * @since 2006/11/25
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class DentakuWindowListener extends WindowAdapter {

		// @Override
		public void windowClosing(WindowEvent e) {

			// 設定保存して終了
			saveConfigration();
			System.exit(0);
		}
	}

	/**
	 * 普通の数字ボタン(1~9)のアクションリスナー
	 *
	 * @version 1.0
	 * @since 2006/11/25
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class NumberButtonActionListener extends DentakuButtonActionListener {

		/**
		 * イベント時処理
		 *
		 * @see com.si1105.dentaku3.Dentaku.DentakuButtonActionListener#dentakuButtonActionPerformed(java.awt.event.ActionEvent)
		 */
		void dentakuButtonActionPerformed(ActionEvent e) {

			// 時間計算モードの場合
			if (hms) {

				// 6文字以上の入力は許さない！
				if (getTxtDisplay().getText().length() == 6) {
					return;
				}
			}

			// 押されたボタンを取得
			DentakuButton btn = (DentakuButton) e.getSource();

			// 押されたボタンから押された数字を取得
			int buttonId = btn.getButtonId();

			// 数字生成中の場合
			if (inGeneratingNumber) {

				// 表示窓に表示されている数字の末尾に数字を付す。
				getTxtDisplay().setText(getTxtDisplay().getText() + buttonId);
			}

			// 数字生成中でない場合
			else {

				// 表示窓に当該数字を表示
				getTxtDisplay().setText(String.valueOf(buttonId));

				// 数字生成中フラグを立てる
				inGeneratingNumber = true;
			}
		}
	}

	/**
	 * ゼロボタンのアクションリスナー
	 *
	 * @version 1.0
	 * @since 2006/11/25
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class ZeroButtonActionListener extends DentakuButtonActionListener {

		/**
		 * イベント時処理
		 *
		 * @see com.si1105.dentaku3.Dentaku.DentakuButtonActionListener#dentakuButtonActionPerformed(java.awt.event.ActionEvent)
		 */
		void dentakuButtonActionPerformed(ActionEvent e) {

			// 押されたボタンを取得
			DentakuButton btn = (DentakuButton) e.getSource();

			// 押されたボタンから押された数字を取得
			int buttonId = btn.getButtonId();

			// ゼロ文字列を取得
			String zero = CAPTIONS_STD[buttonId];

			// 数字生成中の場合
			if (inGeneratingNumber) {

				// 表示されている数字の末尾にゼロをセット
				getTxtDisplay().setText(getTxtDisplay().getText() + zero);
			}
			// 数字生成中ではない場合
			else {

				// 表示窓にゼロを表示
				getTxtDisplay().setText("0");
			}

			// // 数字生成中フラグを立てる
			// inGeneratingNumber = true;
		}
	}

	/**
	 * 小数点ボタンのアクションリスナー
	 *
	 * @version 1.0
	 * @since 2006/11/28
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class PointButtonActionListener extends DentakuButtonActionListener {

		/**
		 * イベント時処理
		 *
		 * @see com.si1105.dentaku3.Dentaku.DentakuButtonActionListener#dentakuButtonActionPerformed(java.awt.event.ActionEvent)
		 */
		void dentakuButtonActionPerformed(ActionEvent e) {

			// 表示されている数字を文字列で取得
			String inputString = getInputString();

			// 数字生成中の場合
			if (inGeneratingNumber) {

				for (int i = 0; i < inputString.length(); i++) {
					if (inputString.charAt(i) == '.') {
						return;
					}
				}

				// 表示窓に表示されている数字の末尾に数字を付す。
				getTxtDisplay().setText(inputString + ".");
			}

			// 数字生成中でない場合
			else {

				// 表示窓に「0.」を表示
				getTxtDisplay().setText(String.valueOf("0."));

				// 数字生成開始
				inGeneratingNumber = true;
			}
		}
	}

	/**
	 * 演算子ボタンのアクションリスナー
	 *
	 * @version 1.0
	 * @since 2006/11/26
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class OperatorButtonActionListener extends DentakuButtonActionListener {

		/**
		 * イベント時処理
		 *
		 * @see com.si1105.dentaku3.Dentaku.DentakuButtonActionListener#dentakuButtonActionPerformed(java.awt.event.ActionEvent)
		 */
		void dentakuButtonActionPerformed(ActionEvent e) {

			// 時間計算の場合
			if (hms) {

				// 時間を表示
				setFormatHmsOnDisplay(getInputBigDecimal());

				// オペランドに値をセット
				operand = getInputBigDecimal();

				// 演算子にボタンIDをセット
				operator = ((DentakuButton) e.getSource()).getButtonId();

				// 数字生成中フラグを倒す
				inGeneratingNumber = false;

				return;
			}

			// 演算子を取得
			int currentOperator = ((DentakuButton) e.getSource()).getButtonId();

			// 同じ演算子が二度連続して押された場合
			if (lastActionButton.getButtonId() == currentOperator) {

				// リピート演算フラグを立てる
				repeat = true;

				// リピート演算中表示
				getTxtRep().setText("R");
			}

			// 計算可能フラグを立てる
			calculatable = true;

			// セッション開始前の場合
			if (!inSession) {
				operand = getInputBigDecimal();
			}

			// セッション中の場合
			else {

				// 最後に押されたボタンがイコールでないかつ数字生成中の場合
				if (lastActionButton.getButtonId() != EQ && inGeneratingNumber) {

					// 計算する
					operand = calculate(getInputBigDecimal());
				}
			}

			// 演算子にボタンIDをセット
			operator = ((DentakuButton) e.getSource()).getButtonId();

			// 演算子表示窓に演算子を表示
			getTxtOpe().setText(CAPTIONS_STD[currentOperator]);

			// セッション開始フラグを立てる
			inSession = true;

			// 数字生成中フラグを倒す
			inGeneratingNumber = false;

			showNumberOnDisplay(operand);
		}
	}

	/**
	 * イコールボタンのアクションリスナー
	 *
	 * @version 1.0
	 * @since 2006/11/28
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class EqualButtonActionListener extends DentakuButtonActionListener {

		/**
		 * イベント時処理
		 *
		 * @see com.si1105.dentaku3.Dentaku.DentakuButtonActionListener#dentakuButtonActionPerformed(java.awt.event.ActionEvent)
		 */
		void dentakuButtonActionPerformed(ActionEvent e) {

			// HMSモードの場合
			if (hms) {
				caluclateHms();
				// ActionEvent event = new
				// ActionEvent(getBtnClear(),
				// ActionEvent.ACTION_PERFORMED,
				// null);
				// (new
				// ClearButtonActionListener()).actionPerformed(event);
				inGeneratingNumber = false;
				inSession = false;
				calculatable = false;
				operator = EQ;
				operand = BD_ZERO;
				operand2 = BD_ZERO;
				// getTxtDisplay().setText("0");
				getTxtOpe().setText("");
				getTxtRep().setText("");
				repeat = false;
				// 時間計算ボタンをしらふに戻す
				hms = false;
				getBtnTime().setForeground(Color.black);
				getBtnTime().setFont(font_);
				return;
			}

			// 計算してよいかフラグが倒れていたら
			if (!calculatable) {

				// 数字生成中フラグを倒す。
				inGeneratingNumber = false;

				return;
			}

			// 最後に押されたボタンのボタンIDを取得
			int lastActionButtonId = lastActionButton.getButtonId();

			// 最後に押されたボタンがイコールボタンではない場合
			if (lastActionButtonId != EQ) {

				// 第二オペランドをディスプレイから取得
				operand2 = getInputBigDecimal();
			}

			// リピート演算ではない場合
			if (!repeat) {

				if (inGeneratingNumber) {

					// 計算する
					operand = calculate(operand2);

					// 数字生成中フラグを倒す。
					inGeneratingNumber = false;

					// セッションフラグを倒す。
					inSession = false;

					// 計算してよいかフラグを倒す
					calculatable = false;

					// 演算子表示窓をクリア
					getTxtOpe().setText("");

					operator = EQ;
				}
			}
			// リピート演算の場合
			else {
				// 計算する
				operand = calculate(operand2);
			}

			showNumberOnDisplay(operand);
		}
	}

	/**
	 * クリアボタンのアクションリスナー
	 *
	 * @version 1.0
	 * @since 2006/11/29
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class ClearButtonActionListener extends DentakuButtonActionListener {

		/**
		 * イベント時処理
		 *
		 * @see com.si1105.dentaku3.Dentaku.DentakuButtonActionListener#dentakuButtonActionPerformed(java.awt.event.ActionEvent)
		 */
		void dentakuButtonActionPerformed(ActionEvent e) {

			// System.out.println("aaaaaaaaaaaaaaaaaa:"
			// + e.getModifiers());

			// Ctrlキーが押されている場合は1文字消去
			if (e.getModifiers() == 18) {
				backSpace();
			}
			// Ctrlキーが押されていない場合はクリア
			else {
				delete();
			}

			// 時間計算ボタンをしらふに戻す
			hms = false;
			getBtnTime().setForeground(Color.black);
			getBtnTime().setFont(font_);
		}

	}

	/**
	 * 率ボタンのアクションリスナ
	 *
	 * @version 1.0
	 * @since 2006/12/02
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class RatioButtonActionListener extends DentakuButtonActionListener {

		void dentakuButtonActionPerformed(ActionEvent e) {

			// 100
			BigDecimal bd100 = new BigDecimal(100);

			// 第二オペランド取得
			BigDecimal number = getInputBigDecimal();

			// 演算子が÷の場合：普通に割合を返す
			if (operator == DIV) {
				try {
					operand = operand.divide(number, BigDecimal.ROUND_UNNECESSARY);
					operand = operand.multiply(bd100);
				}
				// 割り切れない場合
				catch (ArithmeticException ee) {

					try {
						operand = operand.divide(number, 100, BigDecimal.ROUND_DOWN);
						operand = operand.multiply(bd100);
					}
					// ゼロ除算の場合
					catch (ArithmeticException eee) {
						operand = null;
					}
				}
			}

			// 演算子が×のとき：普通に割合を返す。
			if (operator == MULTI) {
				operand = operand.multiply(number);
				operand = operand.divide(bd100);
			}

			// 演算子がーのとき
			if (operator == MINUS) {
				try {
					operand = operand.divide(number, BigDecimal.ROUND_UNNECESSARY);
					operand = operand.multiply(bd100);
					operand = operand.add(bd100.negate());
				}
				// 割り切れない場合
				catch (ArithmeticException ee) {

					try {
						operand = operand.divide(number, 100, BigDecimal.ROUND_DOWN);
						operand = operand.multiply(bd100);
						operand = operand.add(bd100);
					}
					// ゼロ除算の場合
					catch (ArithmeticException eee) {
						operand = null;
					}
				}
			}

			// 演算子がプラスのとき(マークアップ演算)
			if (operator == PLUS) {
				number = (new BigDecimal(100)).add(number.negate());
				try {
					operand = operand.divide(number, BigDecimal.ROUND_UNNECESSARY);
					operand = operand.multiply(bd100);
				}
				// 割り切れない場合
				catch (ArithmeticException ee) {

					try {
						operand = operand.divide(number, 100, BigDecimal.ROUND_DOWN);
						operand = operand.multiply(bd100);
					}
					// ゼロ除算の場合
					catch (ArithmeticException eee) {
						operand = null;
					}
				}
			}

			// 数字生成中フラグを倒す。
			inGeneratingNumber = false;

			// セッションフラグを倒す。
			inSession = false;

			// 計算してよいかフラグを倒す
			calculatable = false;

			// 演算子表示窓をクリア
			getTxtOpe().setText("");

			// 表示
			showNumberOnDisplay(operand);
		}
	}

	/**
	 * 平方根ボタンのアクションリスナ
	 *
	 * @version 1.0
	 * @since 2006/12/02
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class RootButtonActionListener extends DentakuButtonActionListener {

		void dentakuButtonActionPerformed(ActionEvent e) {

			// 入力値を倍精度小数で取得
			double value = getInputBigDecimal().doubleValue();

			// 平方根を取得
			value = Math.pow(value, 0.5);

			// 表示
			showNumberOnDisplay(new BigDecimal(value));

			// 数字生成中フラグを倒す
			inGeneratingNumber = false;

			// セッションフラグを倒す
			inSession = false;

			// 計算可能フラグを倒す
			calculatable = false;

			// ラスト演算子にイコールをセット
			operator = EQ;

			// オペランドにゼロをセット
			operand = BD_ZERO;
			// setButtonEnableExceptClear(true);
		}
	}

	/**
	 * HMSボタンのアクションリスナ
	 *
	 * @version 1.0
	 * @since 2006/12/02
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class TimeButtonActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// 6文字以上の入力がある場合は時間計算モードに移行できない
			if (getTxtDisplay().getText().length() > 6) {
				return;
			}
			hms = true;
			btnTime.setForeground(Color.red);
			// btnTime.setFont(FONT_BLD);
		}
	}

	/**
	 * M+ボタンのアクションリスナ
	 *
	 * @version 1.0
	 * @since 2006/12/02
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class MPlusButtonActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			getTxtM().setText("M");
			inGeneratingNumber = false;
			memory = memory.add(getInputBigDecimal());
		}
	}

	/**
	 * M-ボタンのアクションリスナ
	 *
	 * @version 1.0
	 * @since 2006/12/02
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class MMinusButtonActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			getTxtM().setText("M");
			inGeneratingNumber = false;
			memory = memory.add(getInputBigDecimal().negate());
		}
	}

	/**
	 * MRボタンのアクションリスナ
	 *
	 * @version 1.0
	 * @since 2006/12/02
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class MReadButtonActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			showNumberOnDisplay(memory);
		}
	}

	/**
	 * MCボタンのアクションリスナ
	 *
	 * @version 1.0
	 * @since 2006/12/02
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	class MClearButtonActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			getTxtM().setText("");
			memory = BD_ZERO;
		}
	}

	/**
	 * 電卓ボタンのアクションリスナーの親クラス
	 *
	 * @version 1.0
	 * @since 2006/11/26
	 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
	 */
	abstract class DentakuButtonActionListener implements ActionListener, DentakuInterface {

		/**
		 * イベント時処理
		 *
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {

			// 表示が∞の時はクリアボタン以外は無効
			DentakuButton button = (DentakuButton) e.getSource();
			int buttonId = button.getButtonId();
			if (getTxtDisplay().getText().equals(INFINITY)) {
				if (buttonId != CLEAR) {
					return;
				}
			}

			// 時間計算モードの場合、数字、クリア、イコール、＋、－ボタン以外は無効
			if (hms) {
				if (buttonId == MPLUS || buttonId == MMINUS || buttonId == MRESET || buttonId == MCLEAR
						|| buttonId == DIV || buttonId == MULTI || buttonId == RATIO || buttonId == ROOT
						|| buttonId == POINT) {
					return;
				}
			}

			// 押下時処理を実行
			dentakuButtonActionPerformed(e);

			// ラストボタンをセット
			lastActionButton = (DentakuButton) e.getSource();
		}

		/**
		 * 押下時処理
		 *
		 * @param e
		 */
		abstract void dentakuButtonActionPerformed(ActionEvent e);

	}
} // @jve:decl-index=0:visual-constraint="33,19"
