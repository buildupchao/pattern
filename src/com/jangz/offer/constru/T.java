package com.jangz.offer.constru;

public class T {
	
	public static void main(String[] args) throws InterruptedException {
		// �Ƕȵķָ�
		final double SPLIT = 0.01;
		
		// 2PI�ָ�Ĵ�����Ҳ����2/0.01����������һ��
		final int COUNT = (int) (2 / SPLIT);
		final double PI = Math.PI;
		
		// ʱ����
		final int INTERVAL = 200;
		long[] busySpan = new long[COUNT];
		long[] idleSpan = new long[COUNT];
		int half = INTERVAL / 2;
		double radian = 0.0;
		
		for (int i = 0; i < COUNT; i++) {
			busySpan[i] = (long) (half + (Math.sin(PI * radian) * half));
			idleSpan[i] = INTERVAL - busySpan[i];
			radian += SPLIT;
		}
		long startTime = 0;
		int j = 0;
		while (true) {
			j = j % COUNT;
			startTime = System.currentTimeMillis();
			
			while (System.currentTimeMillis() - startTime < busySpan[j]) {
				;
			}
			Thread.sleep(idleSpan[j]);
			j++;
		}
	}
	
}
