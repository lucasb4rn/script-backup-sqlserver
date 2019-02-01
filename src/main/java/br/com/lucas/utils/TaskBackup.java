package br.com.lucas.utils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TaskBackup {

	public void givenUsingTimer_whenSchedulingDailyTask_thenCorrect() {
		TimerTask repeatedTask = new TimerTask() {
			public void run() {
				System.out.println("Task performed on " + new Date());
			}
		};
		Timer timer = new Timer("Timer");

		long delay = 1000L;
		long period = 1000L * 60L * 60L * 24L;
		timer.scheduleAtFixedRate(repeatedTask, delay, period);

	}

	public static void main(String[] args) {

		TaskBackup task = new TaskBackup();

		task.givenUsingTimer_whenSchedulingDailyTask_thenCorrect();

	}

}
