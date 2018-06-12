package com.packtpub.wflydevelopment.dev.boundary;

import com.packtpub.wflydevelopment.dev.exception.NoSuchSeatException;
import com.packtpub.wflydevelopment.dev.exception.NotEnoughMoneyException;
import com.packtpub.wflydevelopment.dev.exception.SeatBookedException;

import javax.ejb.Asynchronous;
import java.util.concurrent.Future;

public interface TheatreBookerRemote {

    int getAccountBalance();

    String bookSeat(int seatId) throws SeatBookedException, NotEnoughMoneyException, NoSuchSeatException;

    @Asynchronous
    Future<String> bookSeatAsync(int seatId);
}