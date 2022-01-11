package com.kuang.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    //在一个特定的时间执行这个方法
    @Scheduled(cron = "0 5 14 * * ?")
    public void hello(){
        System.out.println("hhhhhhahahhaha");
    }
}
