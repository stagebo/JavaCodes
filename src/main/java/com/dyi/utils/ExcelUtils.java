/*package com.dyi.utils;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.data.category.DefaultCategoryDataset;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public class ExcelUtils {
	public static File createChartLine(List<Object[]> list, String title,
			String xTitle, String yTitle, String num) {

		// public static void main(String args[]){
		// 构造数据集合
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 0; list != null && i < list.size(); i++) {
			Object[] obj = list.get(i);
			dataset.addValue(Integer.parseInt(obj[0].toString()), "数据",
					obj[1].toString() + "\n" + obj[2].toString());
		}

		// 核心对象
		JFreeChart chart = ChartFactory.createLineChart(title, // 图形的主标题
				xTitle, // X轴外标签的名称
				yTitle, // Y轴外标签的名称
				dataset, PlotOrientation.VERTICAL, // 图形的显示方式（水平和垂直）
				true, // 是否显示子标题
				true, // 是否在图形上显示数值的提示
				true); // 是否生成URL地址
		// 解决主标题的乱码
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
		// 解决子标题的乱码
		chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
		chart.getLegend().setPosition(RectangleEdge.RIGHT);// 右侧显示子菜单
		// 获取图表区域对象
		CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
		// categoryPlot.setBackgroundPaint(null);
		// 获取X轴对象
		CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
		// 获取Y轴对象
		NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
		// 解决X轴上的乱码
		categoryAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
		// 解决X轴外的乱码
		categoryAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));
		// 解决Y轴上的乱码
		numberAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 15));
		// 解决Y轴外的乱码
		numberAxis.setLabelFont(new Font("宋体", Font.BOLD, 15));

		// 改变Y轴的刻度，默认值从1计算
		numberAxis.setAutoTickUnitSelection(false);
		NumberTickUnit unit = new NumberTickUnit(Integer.parseInt(num));
		numberAxis.setTickUnit(unit);

		// 获取绘图区域对象
		LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot
				.getRenderer();
		lineAndShapeRenderer.setBaseShapesVisible(true);// 设置转折点

		// 让数值显示到页面上
		lineAndShapeRenderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		lineAndShapeRenderer.setBaseItemLabelsVisible(true);
		lineAndShapeRenderer
				.setBaseItemLabelFont(new Font("宋体", Font.BOLD, 15));

		// 显示图形
		// ChartFrame chartFrame = new ChartFrame("xyz", chart);
		// chartFrame.setVisible(true);
		// chartFrame.pack();

		String filename =UUID.randomUUID()
				+ ".png";// 用时间作为文件名防止重名的问题发生
		File file = new File(filename);// 保存文件到web容器中
		try {
			ChartUtilities.saveChartAsPNG(file, chart, 600, 500);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return file;
	}
}
*/