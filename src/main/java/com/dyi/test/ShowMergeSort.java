package com.dyi.test;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowMergeSort {
    static int[] array = getArray(Tool.W);/* ��ó���Ϊ��Ļ��ȵ��������� */
    static updateShowArrayImg m = new updateShowArrayImg(array);/* ����ʾ��ǰ�������� */

    /**
     * �鲢���򣬲���������̴�ӡ��ͼ��
     * @param args
     */
    public static void main(String[] args) {
        MyJPanel show = m.show;
        /* ������ͣ���� */
        try {
            Thread.currentThread();
            Thread.sleep(2000);
        } catch (Exception e) {
        }

        /* ��ʼ�鲢���� */
        m.updateShowArray(array);
        devide(array, 0, array.length - 1);
        m.updateShowArray(array);
    }

    /* ����һ������Ϊlength�ĸ߶�Ϊlength/2������ */
    public static int[] getArray(int length) {
        /* ���ɿ����� */
        int[] re = new int[length];
        /* �����鸽�ϸ�Ϊlength/2��������ֵ */
        for (int i = 0; i < re.length; i++)
            re[i] = i / 2;
        /* ������������� */
        for (int i = 0; i < 20 * re.length; i++) {
            int index1 = new Random().nextInt(length);
            int index2 = new Random().nextInt(length);
            int temp = re[index1];
            re[index1] = re[index2];
            re[index2] = temp;
        }

        return re;
    }

    /* �ֽ����� */
    public static void devide(int[] array, int left, int right) {

        if (left < right) {
            /* Ѱ�ҵ��м��±� */
            int mid = (right + left) / 2;
            /* ���м��±���ϣ���ǰ�����ηֱ�ֽ� */
            devide(array, left, mid);
            /* �����ָ�ڶ��� */
            devide(array, mid + 1, right);
            /* �ָ����ˣ����ù鲢 */
            merge(array, left, mid, mid + 1, right);
        }
    }

    /* �鲢���������� */
    public static void merge(int[] array, int leftStart, int leftEnd,
            int rightStart, int rightEnd) {
        /* �½���ʱ���飬��Ÿôι鲢������� */
        int[] temp = new int[array.length];
        /* ��¼�鲢����������鿪ʼ�����±� */
        int ls = leftStart, le = leftEnd, rs = rightStart, re = rightEnd;
        /* ��¼��ʱ����Ĵ��λ�� */
        int index = ls;
        /* ��һ�αȽϹ鲢������������н�С����temp */
        while (ls <= le && rs <= re) {
            if (array[ls] <= array[rs]) {
                temp[index] = array[ls];
                index++;
                ls++;
            } else {
                temp[index] = array[rs];
                index++;
                rs++;
            }
        }
        /* �ڶ���ѡ��鲢����array��ʣ���δ����temp�������뵽temp�� */
        while (ls <= le) {
            temp[index] = array[ls];
            ls++;
            index++;
        }
        while (rs <= re) {
            temp[index] = array[rs];
            rs++;
            index++;
        }
        /* temp�Ǿ����������array����ʱһ�ι鲢��ϣ��������ݽ�����һ�ι鲢 */
        while (leftStart <= rightEnd) {
            array[leftStart] = temp[leftStart];
            leftStart += 1;
        }
        try{Thread.sleep(8);}catch(Exception e){}
        /* ��ӡ���ι鲢���,�����ͼ�� */
        m.updateShowArray(array);
    }

    /* ��ӡ���� */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "  ");
        System.out.println();
    }

}

/* �����࣬��ȡ��ǰ��Ļ��С���û���ʼ����ʾ�����new�������� */
class Tool {
    public static int W = (int) Toolkit.getDefaultToolkit().getScreenSize()
            .getWidth();/* ��ǰ��Ļ��� */
    public static int H = (int) Toolkit.getDefaultToolkit().getScreenSize()
            .getHeight();/* ��ǰ��Ļ�߶� */
}

/* ��ͼ��� */
class MyJPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    int[] array;/* ���ڽ��չ��췽�������������飬���ڻ�ͼ */

    public MyJPanel(int[] a) {
        array = a;
    }

    /* ��ͼ���� */
    public void paintComponent(Graphics g) {
        /* �����ð�ɫ */
        g.setColor(Color.WHITE);
        /* ������һ�λ��Ƶ��� */
        g.fillRect(0, 0, Tool.W, Tool.H);
        /* �����ú�ɫ */
        g.setColor(Color.black);
        /* ��ʼ���Ƶ�ǰ����ͼ���ԣ�0,Tool.H��Ϊԭ�㣬����Ϊx��������±꣬����Ϊy���ǰ�±�����Ӧ������ô�С */
        for (int i = 0; i < array.length; i++) {
            g.drawLine(i, Tool.H - 80, i, Tool.H - array[i] - 80);
        }

    }
}

/* ��ʾ�����JFrame�� */
class updateShowArrayImg extends JFrame {
    private static final long serialVersionUID = 1L;
    MyJPanel show;

    /* ���캯������ʼ����ʾ��� */
    public updateShowArrayImg(int[] a) {
        show = new MyJPanel(a);
        show.setBounds(0, 0, Tool.W, Tool.H);
        this.setSize(Tool.W, Tool.H);
        this.setTitle("�鲢����");
        this.setLocation(0, 0);
        this.add(show);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * ���»���
     * 
     * @param a
     */
    public void updateShowArray(int[] a) {
        this.remove(show);
        show = new MyJPanel(a);
        this.add(show);
        this.setVisible(true);
    }
}

