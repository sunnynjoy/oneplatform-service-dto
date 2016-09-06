package com.joy.oneplatform.dto.builders;

import com.joy.oneplatform.dto.UserDto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by sunnyghosh on 05/09/2016.
 */
public class UserDtoBuilder {

    public static final String TIME_ZONE = "UTC";
    public static final String DATE_FORMAT = "dd-MM-yyyy HH:mm";
    private int userId;
    private String userName;
    private Date createdDate;

    private UserDtoBuilder(){
    }

    public static UserDtoBuilder anUserDto(){
        return new UserDtoBuilder();
    }

    public UserDto build(){
        final UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setUserName(userName);
        userDto.setCreatedDate(createdDate);
        return userDto;
    }

    public UserDtoBuilder withUserId(final int userId){
        this.userId = userId;
        return this;
    }

    public UserDtoBuilder withUserName(final String userName){
        this.userName = userName;
        return this;
    }

    public UserDtoBuilder withCreatedDate(final String createdDate) throws ParseException {
        final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setTimeZone(TimeZone.getTimeZone(TIME_ZONE));
        this.createdDate = dateFormat.parse(createdDate);
        return this;
    }


    public UserDtoBuilder withDefaultValues() throws ParseException {
        return withUserId(123).withUserName("sunny").withCreatedDate("06-09-2016 3:00");
    }
}
