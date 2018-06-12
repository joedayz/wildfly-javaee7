package com.packtpub.wflydevelopment.dev.controller;

import java.io.Serializable;

import com.packtpub.wflydevelopment.dev.entity.Seat;

import javax.enterprise.event.Observes;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class BookingRecord implements Serializable {

    private int bookedCount = 0;

    public int getBookedCount() {
        return bookedCount;
    }

    public void bookEvent(@Observes Seat bookedSeat) {
        bookedCount++;
    }
}
