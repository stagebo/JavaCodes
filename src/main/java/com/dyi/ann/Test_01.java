package com.dyi.ann;



import org.encog.Encog;
import org.encog.engine.network.activation.ActivationSigmoid;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataPair;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.resilient.ResilientPropagation;

/**
 * ��������ӿ��Կ�����ʹ��Encogʵ��һ����������Ҫ��Ϊ�������֣� 1.����������Ľṹ 2.ѵ������ 3.ʹ���������Ԥ��
 * ��һ�����У�������һ������������磬BasicLayer�Ĺ���������������Ҫ�Ĳ�������һ��������������ͣ��ڶ�����ȷ���Ƿ����ƫ�ƣ��������Ǹò��ж��ٸ���Ԫ��
 * ��ѡ�ļ���������¼��֣��������в��õ���sigmoid���������������Logistic�ع���õĺ˺�����һ���ġ�
 * 
 * �ڶ������������������ѵ�����ݼ���Ŀ�����ݼ���Ȼ����һ��ѭ���н����������ѵ����ֱ�����С��0.01�Ž�����
 * 
 * ��������Ԥ�⣬����ʹ��ѵ�����ݽ���Ԥ�⣬
 * 
 * @author Stagebo
 *
 */

public class Test_01 {

	/**
	 * the input necessary for XOR
	 */
	public static double XOR_INPUT[][] = { { 0.0, 0.0 }, { 1.0, 0.0 }, { 0.0, 1.0 }, { 1.0, 1.0 } };

	/**
	 * the ideal data necessary for XOR
	 */
	public static double XOR_IDEAL[][] = { { 0.0 }, { 1.0 }, { 1.0 }, { 0.0 } };

	/**
	 * @param no
	 *            arguments are used
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create a neural network, without using a factory
		BasicNetwork network = new BasicNetwork();

		// BasicLayer ������ ��������Ƿ�ƫ�ơ��ò���Ԫ��Ŀ
		network.addLayer(new BasicLayer(null, true, 2));
		network.addLayer(new BasicLayer(new ActivationSigmoid(), true, 3));
		network.addLayer(new BasicLayer(new ActivationSigmoid(), false, 1));
		network.getStructure().finalizeStructure();

		// Reset the weight matrix and the bias values.
		// This will use a Nguyen-Widrow randomizer with a range between -1 and
		// 1.
		// If the network does not have an input, output or hidden layers, then
		// Nguyen-Widrow cannot be used and a simple range randomize between -1
		// and 1 will be used.
		network.reset();

		// create training data
		MLDataSet trainingSet = new BasicMLDataSet(XOR_INPUT, XOR_IDEAL);

		// train the neural network
		final ResilientPropagation train = new ResilientPropagation(network, trainingSet);

		int epoch = 1;

		do {
			train.iteration();
			System.out.println("Epoch #" + epoch + " Error: " + train.getError());
			epoch++;
		} while (train.getError() > 0.000000001);
		train.finishTraining();

		// test the neural network
		System.out.println("Neural Network Results: ");
		for (MLDataPair pair : trainingSet) {
			final MLData output = network.compute(pair.getInput());
			System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1) + ", actual="
					+ output.getData(0) + ",ideal=" + pair.getIdeal().getData(0));
		}
		
		double[] a=new double[]{0,1};
		double output[]=new double[2];
		network.compute(a, output);
		
		System.out.println(output[0]+"++");
		Encog.getInstance().shutdown();
	}

}
