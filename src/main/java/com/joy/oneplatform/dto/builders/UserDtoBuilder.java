package com.joy.oneplatform.dto.builders;

import com.joy.oneplatform.dto.UserDto;

/**
 * Created by sunnyghosh on 05/09/2016.
 */
public class UserDtoBuilder {

    private int userId;
    private String userName;

    private UserDtoBuilder(){
    }

    public static UserDtoBuilder anUserDto(){
        return new UserDtoBuilder();
    }

    public UserDto build(){
        final UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setName(userName);
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

    public UserDtoBuilder withDefaultValues(){
        return withUserId(123).withUserName("sunny");
    }
}
