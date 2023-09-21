package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
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

    @Test
    public void successRegTest(){
        Specifications.installSpecifications(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);
        Assertions.assertNotNull(successReg);
        Assertions.assertEquals(id, successReg.getId());
        Assertions.assertEquals(token, successReg.getToken());
    }

    @Test
    public void unsuccessRegTest(){
        Specifications.installSpecifications(Specifications.requestSpec(URL), Specifications.responseSpecError400());
        String error = "Missing password";
        Register user = new Register("sydney@fife", "");
        UnsuccessReg unsuccessReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(UnsuccessReg.class);
        Assertions.assertNotNull(unsuccessReg);
        Assertions.assertEquals(error, unsuccessReg.getError());
    }

    @Test
    public void sortedYearsTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<ColorsData> colors = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColorsData.class);
        List<Integer> years = colors.stream().map(ColorsData::getYear).collect(Collectors.toList());
        List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
        Assertions.assertEquals(years, sortedYears);
    }

    @Test
    public void deleteUserTest() {
        Specifications.installSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(204));
        given()
            .when()
            .delete("api/users/2")
            .then().log().all();
    }

    @Test
    public void timeTest(){
        Specifications.installSpecifications(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        UserTime user = new UserTime("morpheus", "zion resident");
        UserTimeResponse response = given()
                .body(user)
                .when()
                .put("api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);
        String currentTime = Clock.systemUTC().instant().toString().replaceAll("(.{11})$", "");
        Assertions.assertEquals(currentTime, response.getUpdatedAt().replaceAll("(.{5})$", ""));
    }
}
