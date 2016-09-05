package com.joy.oneplatform.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joy.oneplatform.dto.builders.UserDtoBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by sunnyghosh on 05/09/2016.
 */
public class UserDtoTest {

    @Test
    public void verifyJsonToObject() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final String userStringFromJson = new String(Files.readAllBytes(Paths.get("src/test/resources/json/user.json")));
        final UserDto userDtoFromJson = objectMapper.readValue(userStringFromJson, UserDto.class);
        Assert.assertNotNull("Failed Creating UserDto object", userDtoFromJson);
    }

    @Test
    public void verifyObjectToJson() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final String userStringFromJson = new String(Files.readAllBytes(Paths.get("src/test/resources/json/user.json")));
        UserDto userDto = UserDtoBuilder.anUserDto().withDefaultValues().build();
        final String userStringFromObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userDto);
        Assert.assertNotNull("Failed Creating Json String", userStringFromObject);
        Assert.assertThat(userStringFromJson, is(userStringFromObject));
    }
}
