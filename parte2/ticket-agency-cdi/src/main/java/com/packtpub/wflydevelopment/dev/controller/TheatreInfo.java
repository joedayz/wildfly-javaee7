package com.packtpub.wflydevelopment.dev.controller;

import com.google.common.collect.Lists;
import com.packtpub.wflydevelopment.dev.boundary.TheatreBox;
import com.packtpub.wflydevelopment.dev.entity.Seat;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collection;

@Model
public class TheatreInfo {

    @Inject
    private TheatreBox box;

    private Collection<Seat> seats;

    @PostConstruct
    public void retrieveAllSeatsOrderedByName() {
        this.seats = box.getSeats();
    }

    @Produces
    @Named
    public Collection<Seat> getSeats() {
        return Lists.newArrayList(seats);
    }

    public void onMemberListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Seat member) {
        retrieveAllSeatsOrderedByName();
    }
}
