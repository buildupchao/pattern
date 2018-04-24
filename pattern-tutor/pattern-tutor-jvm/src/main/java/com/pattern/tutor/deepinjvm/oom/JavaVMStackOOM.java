package com.pattern.tutor.deepinjvm.oom;

/**
 * VM args: -Xss2M
 * @author jangz
 *
 */
public class JavaVMStackOOM {

	private void dontStop() {
		while (true) {}
	}
	
	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}
	
	public static void main(String[] args) {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
