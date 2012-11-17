package trainings.threads;

import java.io.*;
import java.awt.*;
import javax.swing.*;

import exceptions.PrintWriter;

public class ThreadLister {

	private static void printThreadInfo(java.io.PrintWriter out, Thread t,
			String indent) {
		if (t == null)
			return;
		out.println(indent + " Thread " + t.getName() + " Priority: "
				+ t.getPriority() + " is Deamon: "
				+ (t.isDaemon() ? "Yes" : "No") + " is Alive: "
				+ (t.isAlive() ? "Yes" : "No"));
	}

	private static void printGroupInfo(java.io.PrintWriter out, ThreadGroup g,
			String indent) {
		if (g == null)
			return;

		int num_threads = g.activeCount();
		int num_groups = g.activeGroupCount();

		Thread[] threads = new Thread[num_threads];
		ThreadGroup[] groups = new ThreadGroup[num_groups];

		g.enumerate(threads);
		g.enumerate(groups);

		out.println(indent + " Running Group: " + g.getName()
				+ " Highest Priority: " + g.getMaxPriority() + " is deamon: "
				+ (g.isDaemon() ? "Yes" : "No"));

		for (int i = 0; i < num_threads; i++)
			printThreadInfo(out, threads[i], indent + "    ");
		for (int i = 0; i < num_groups; i++)
			printGroupInfo(out, groups[i], indent + "    ");

	}

	public static void listAllThreads(java.io.PrintWriter out) {
		ThreadGroup current_thread_group;
		ThreadGroup root_thread_group;
		ThreadGroup parent;

		current_thread_group = Thread.currentThread().getThreadGroup();
		root_thread_group = current_thread_group;
		parent = root_thread_group.getParent();
		while (parent != null) {
			root_thread_group = parent;
			parent = parent.getParent();
		}

		printGroupInfo(out, root_thread_group, "");
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Thread Lister");

		JTextArea jTxt = new JTextArea();

		frame.getContentPane().add(new JScrollPane(jTxt), BorderLayout.CENTER);

		frame.setSize(500, 400);
		frame.setVisible(true);
		
		StringWriter strWr = new StringWriter();
		java.io.PrintWriter outPrn = new java.io.PrintWriter(strWr);
		ThreadLister.listAllThreads(outPrn);
		
		outPrn.close();
		
		jTxt.setText(outPrn.toString());
		
	}

}
