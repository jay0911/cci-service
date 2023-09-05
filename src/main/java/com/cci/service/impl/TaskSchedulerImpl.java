package com.cci.service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cci.service.Scheduler;
import com.cci.service.UserTaskSchedulerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;

/**
 * scheduler for task
 */
@Component
@Slf4j
@AllArgsConstructor
public class TaskSchedulerImpl implements Scheduler {
	
	private UserTaskSchedulerService userTaskSchedulerService;

	@Override
	@Scheduled(cron = "${cci.scheduler.task}")
	@SchedulerLock(name = "taskSchedulerChangeStatus", lockAtMostFor = "1m", lockAtLeastFor = "1m")
	public void runSchedule() {
		log.info("TaskSchedulerImpl running start...");
		
		userTaskSchedulerService.updateTaskStatus();
		
		log.info("TaskSchedulerImpl running end...");
	}

}
