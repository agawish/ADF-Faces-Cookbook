package com.adffaces.chapter7.view.beans;

import java.util.Collection;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;

import oracle.adf.view.rich.activedata.ActiveDataEventUtil;
import oracle.adf.view.rich.activedata.ActiveModelContext;
import oracle.adf.view.rich.activedata.BaseActiveDataModel;
import oracle.adf.view.rich.event.ActiveDataEntry;
import oracle.adf.view.rich.event.ActiveDataUpdateEvent;

@ManagedBean(name = "randomNumberBean")
@ViewScoped
public class RandomNumberBean extends BaseActiveDataModel {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final Random random = new Random();
    
    public RandomNumberBean() {
        super();
        ActiveModelContext context = ActiveModelContext.getActiveModelContext();
        context.addActiveModelInfo(this, new String[0], "randomValue");
        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        ses.scheduleAtFixedRate(new Runnable() {
            public void run() {
                updateRandomValue();
            }
        }, 5, // Initial Delay
            5, // Delay between updates
            TimeUnit.SECONDS);
    }
    
    public void updateRandomValue() {
        counter.incrementAndGet();

        ActiveDataUpdateEvent event =
            ActiveDataEventUtil.buildActiveDataUpdateEvent(ActiveDataEntry.ChangeType.UPDATE, counter.get(),
                                                           new String[0], null, new String[] { "randomValue" }, new Object[] {
                                                           getRandomValue() });

        fireActiveDataUpdate(event);
    }

    public String getRandomValue(){
        return String.valueOf(random.nextInt(301));
    }

    @Override
    protected void startActiveData(Collection<Object> collection, int i) {
        // TODO Implement this method

    }

    @Override
    protected void stopActiveData(Collection<Object> collection) {
        // TODO Implement this method
    }

    @Override
    public int getCurrentChangeCount() {
        return counter.get();
    }
}
