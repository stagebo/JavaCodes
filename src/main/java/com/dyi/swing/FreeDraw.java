package com.dyi.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * ���ɻ���ʵ����
 * @author Stagebo
 *
 */
public class FreeDraw extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ����Ƿ��ʼ��
	 */
	private boolean isInit = false;
	/**
	 * �����Ҫ���µ�x��y����
	 */
	private int nx = 0, ny = 0;
	/**
	 * 
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setLayout(null);
		FreeDraw mp = new FreeDraw();
		mp.setBounds(20, 20, 300, 300);
		f.add(mp);
		f.setBounds(100, 100, 400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	/**
	 * ���캯����ע�������ק�¼�
	 */
	public FreeDraw() {
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

				int x = e.getX();
				int y = e.getY();

				refresh(x, y);
			}

			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}
	/**
	 * ������º�����
	 * @param xx
	 * @param yy
	 */
	public void refresh(int xx, int yy) {
		System.out.println("refresh");
		nx = xx;
		ny = yy;
		repaint();
	}
	/**
	 * ���»��ƺ���
	 */
	public void paint(Graphics g) {
		System.out.println("paint");
		if (!isInit) {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			isInit = true;
			return;
		}
		g.setColor(Color.BLACK);
		g.fillRect(nx, ny, 10, 5);
	}

}