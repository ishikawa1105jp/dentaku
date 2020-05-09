package com.si1105.dentaku3;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

class DentakuButton extends JButton implements DentakuInterface, MouseListener {

	private static final long serialVersionUID = 1L;

	/**
	 * ボタンID
	 */
	private int buttonId = 0;

	private Font font_ = null;

	/**
	 * このクラスのインスタンスを返す。
	 *
	 * @param buttonId
	 *            ボタンID
	 */
	public DentakuButton(Dentaku dentaku) {
		super();
		// ウインドウズならばフォントをMSUIゴシックにセット
		if (System.getProperty("os.name").startsWith("Windows")) {
			font_ = FONT_MS;
		}
		// ウインドウズでないならフォントをDialogにセット
		else {
			font_ = FONT_STD;
		}

		setSize(60, 25);
		setFocusPainted(false);
		setFont(font_);
		addMouseListener(this);
		addKeyListener(dentaku);
	}

	/**
	 * ボタンIDを返す。
	 *
	 * @return ボタンID
	 */
	public int getButtonId() {
		return this.buttonId;
	}

	/**
	 * ボタンIDをセットする。
	 *
	 * @param buttonId
	 *            ボタンID
	 */
	public void setButtonId(int buttonId) {
		this.buttonId = buttonId;
	}

	/**
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent e) {
		// 空実装
	}

	/**
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent e) {
		// 空実装
	}

	/**
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent e) {
		// 空実装
	}

	/**
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent e) {
		// 押されると太字になる
		setFont(new Font(FONT_DIALOG, Font.BOLD, 12));
	}

	/**
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent e) {
		// クリックが終わると普通の文字に戻る
		setFont(font_);

	}
}
