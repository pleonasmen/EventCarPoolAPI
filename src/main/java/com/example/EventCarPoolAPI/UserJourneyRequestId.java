package com.example.EventCarPoolAPI;

import java.io.Serializable;

public class UserJourneyRequestId implements Serializable {
    private Long userId;
    private Long journeyId;

            UserJourneyRequestId() {}

            UserJourneyRequestId(Long userId, Long journeyId){
                this.userId = userId;
                this.journeyId = journeyId;
            }
}
