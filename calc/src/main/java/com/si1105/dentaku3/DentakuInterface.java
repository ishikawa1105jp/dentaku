package com.si1105.dentaku3;

import java.awt.Font;
import java.math.BigDecimal;

/**
 * 電卓用定数インターフェイス
 *
 * @version 1.0
 * @since 2006/11/23
 * @author Shinya&nbsp;Ishikawa&nbsp;(ishikawa@braingate.co.jp)
 */
interface DentakuInterface {

	// ●●●ボタンの表示文字/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 0
	 */
	int ZERO = 0;

	/**
	 * 1
	 */
	int ONE = 1;

	/**
	 * 2
	 */
	int TWO = 2;

	/**
	 * 3
	 */
	int THREE = 3;

	/**
	 * 4
	 */
	int FOUR = 4;

	/**
	 * 5
	 */
	int FIVE = 5;

	/**
	 * 6
	 */
	int SIX = 6;

	/**
	 * 7
	 */
	int SEVEN = 7;

	/**
	 * 8
	 */
	int EIGHT = 8;

	/**
	 * 9
	 */
	int NINE = 9;

	/**
	 * 00
	 */
	int ZERO2 = 10;

	/**
	 * 点
	 */
	int POINT = 11;

	/**
	 * プラス
	 */
	int PLUS = 12;

	/**
	 * マイナス
	 */
	int MINUS = 13;

	/**
	 * カケ
	 */
	int MULTI = 14;

	/**
	 * ワリ
	 */
	int DIV = 15;

	/**
	 * 率
	 */
	int RATIO = 16;

	/**
	 * 平方根
	 */
	int ROOT = 17;

	/**
	 * イコール
	 */
	int EQ = 18;

	/**
	 * クリア
	 */
	int CLEAR = 19;

	/**
	 * タイム
	 */
	int TIME = 20;

	/**
	 * M+
	 */
	int MPLUS = 21;

	/**
	 * M-
	 */
	int MMINUS = 22;

	/**
	 * MR
	 */
	int MRESET = 23;

	/**
	 * MC
	 */
	int MCLEAR = 24;

	/**
	 * 数字の文字列表現
	 */
	String[] CAPTIONS_STD = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"00", ".", "＋", "－", "×", "÷", "％", "√", "＝", "C", "HMS", "M+",
			"M-", "MR", "MC", };

	/**
	 * 数字の文字列表現(日本語)
	 */
	String[] CAPTIONS_JP = { "零", "壱", "弐", "参", "四", "伍", "六", "七", "八", "九",
			"零零", "点", "和", "差", "掛", "割", "率", "根", "計", "消", "時間", "覚和",
			"覚差", "覚示", "覚消", };

	/**
	 * 数字ボタンの個数
	 */
	int NUM_OF_NUMBERBUTTON = 12;

	/**
	 * 操作ボタンの個数
	 */
	int NUM_OF_OPERATORBUTTON = 13;

	// ●●●ルックアンドフィール//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Java
	 */
	String LOOKANDFEEL_JAVA = "javax.swing.plaf.metal.MetalLookAndFeel";

	/**
	 * Windows
	 */
	String LOOKANDFEEL_WINDOWS = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

	/**
	 * Motif
	 */
	String LOOKANDFEEL_MOTIF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";

	// ●●●設定ファイル名/////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * ルックアンドフィール
	 */
	String SER_LOOKANDFEEL = "\\lookandfeel";

	/**
	 * 丸め
	 */
	String SER_ROUND = "\\round";

	/**
	 * 小数点以下桁数
	 */
	String SER_LENGTH = "\\length";

	/**
	 * 3桁区切り
	 */
	String SER_FORMAT = "\\format";

	/**
	 * デモ
	 */
	String SER_DEMO = "\\demo";

	/**
	 * tempファイル
	 */
	String TEMP = "\\temp";

	// ●●●スライダ////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 丸め指示スライダのラベルの文字列
	 */
	String[] LABELS_FOR_TERMINATOR = { "F", "D", "U", "4/5", };

	/**
	 * 丸め指示スライダのバルーンヘルプ
	 */
	String TIP_FOR_TERMINATOR = "F：丸めなし　D：切り捨て　U：切り上げ　4/5：四捨五入";

	/**
	 * 小数点以下桁数指示スライダのラベルの文字列
	 */
	String[] LABELS_FOR_LENGTH = { "0", "1", "2", "3", "4" };

	/**
	 * 小数点以下桁数指示スライダのバルーンヘルプ
	 */
	String TIP_FOR_LENGTH = "小数点下桁数指定";

	/**
	 * 丸めなし
	 */
	int FREE = 0;

	/**
	 * 切捨て
	 */
	int DOWN = 1;

	/**
	 * 切り上げ
	 */
	int UP = 2;

	/**
	 * 四捨五入
	 */
	int ROUND = 3;

	// ●●●その他------------------------------------------------------------------------------------------------------
	/**
	 * アプリケーションタイトル
	 */
	String TITLE = "電卓";

	/**
	 * バージョン情報
	 */
	// String ABOUT = "電卓
	// バージョン：評価版20061128\n開発者：石川信也(ishikawa@braingate.co.jp)\n動作環境：WindowsXP
	// SP1 or higher with JRE1.3.1_10 or higher";
	// String ABOUT = "電卓
	// バージョン：評価版20061130\n開発者：石川信也(ishikawa@braingate.co.jp)\n動作環境：WindowsXP
	// SP1 or higher with JRE1.3.1_10 or higher";
	String ABOUT = "電卓　バージョン：1.0(20061202)\n開発者：石川信也(ishikawa@braingate.co.jp)\n動作環境：WindowsXP SP1 or higher with JRE1.3.1_10 or higher";

	/**
	 * 無限
	 */
	String INFINITY = "∞";

	/**
	 * ウインドウ幅
	 */
	int WIDTH_ = 360;

	/**
	 * ウインドウ高
	 */
	int HEIGHT_ = 298;

	/**
	 * BigDecimal型のゼロ
	 */
	BigDecimal BD_ZERO = new BigDecimal(0);

	/**
	 * フォント名1
	 */
	String FONT_DIALOG = "Dialog";

	/**
	 * フォント名2(MSUIゴシック)
	 */
	String FONT_MSUI = "MS UI Gothic";

	/**
	 * フォント
	 */
	Font FONT_STD = new Font(FONT_DIALOG, Font.PLAIN, 12);

	/**
	 * フォント(太字)
	 */
	Font FONT_BLD = new Font(FONT_DIALOG, Font.BOLD, 12);

	/**
	 * フォント
	 */
	Font FONT_MS = new Font(FONT_MSUI, Font.PLAIN, 12);

	/**
	 * 表示窓の枠の青
	 */
	int[] BORDER = { 10, 10, 40 };

	/**
	 * 表示窓の背景色(Java)
	 */
	int[] BG_JAVA = { 238, 238, 238 };

	/**
	 * 表示窓の背景色(Windows)
	 */
	int[] BG_WINDOWS = { 192, 192, 192 };

	/**
	 * 表示窓の背景色(Motif)
	 */
	int[] BG_MOTIF = { 174, 178, 195 };

	/**
	 * 色の三原色赤
	 */
	int R = 0;

	/**
	 * 色の三原色緑
	 */
	int G = 1;

	/**
	 * 色の三原色青
	 */
	int B = 2;

	/**
	 * ボタン表示文字区分：標準
	 */
	int STYLE_STD = 0;

	/**
	 * ボタン表示文字区分：和風
	 */
	int STYLE_JP = 1;

	/**
	 * 書式3桁区切りアリ
	 */
	String FORMAT_SEPARATE = "#,###.####################################################################################";

	/**
	 * 書式3桁区切りなし
	 */
	String FORMAT_NOSEPARATE = "####.####################################################################################";

}
