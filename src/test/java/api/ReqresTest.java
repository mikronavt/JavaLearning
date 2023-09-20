package api;

import api.UserData;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    public static final String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest(){
        Specifications.installSpecifications(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<UserData> users = given()
                                .when()
                                .get( "api/users?page=2")
                                .then().log().all()
                                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(user -> Assertions.assertTrue(user.getAvatar().contains(user.getId().toString())));
        Assertions.assertTrue(users.stream().allMatch(user -> user.getEmail().endsWith("@reqres.in")));

        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(user -> user.getId().toString()).collect(Collectors.toList());

        for (int i = 0; i < avatars.size(); i++) {
            Assertions.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }
}
