package Resources;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UserAPI {

    public static String testUserEmail = "autotestvasilevss@yandex.ru";
    public static String testUserPassword = "q1w2e3r4t5";
    public static String testUserName = "Сергей";


    private final static String USER_REGISTER_ENDPOINT = "https://stellarburgers.nomoreparties.site/api/auth/register/";
    private final static String USER_LOGIN_ENDPOINT = "https://stellarburgers.nomoreparties.site/api/auth/login/";
    private final static String USER_ENDPOINT = "https://stellarburgers.nomoreparties.site/api/auth/user/";


    //Создание Пользователя
    @Step("Отправляем POST-запрос создания пользователя")
    public static Response createUser(String email, String name, String password) {
        User user = new User(email,name, password);
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .body(user)
                        .post(USER_REGISTER_ENDPOINT);
        return  response;
    }

    public static String loginUserAccessToken(String email, String password) {
        User user = new User(email, password);
        UserToken userResponce =
                //Логин курьером, что бы получить его id
                given()
                        .header("Content-type", "application/json")
                        .body(user)
                        .post(USER_LOGIN_ENDPOINT)
                        .as(UserToken.class);
        return userResponce.accessToken;
    }

    public static void  deleteUser(String email, String password){
        String userAccessToken = loginUserAccessToken(email,password);
        given()
                .header("Authorization", userAccessToken)
                .delete(USER_ENDPOINT);
    }

    public static class UserToken {
        public String accessToken;
        public String getAccessToken(){
            return  accessToken;
        }
        public  void setAccessToken(){
            this.accessToken = accessToken;
        }
        public String refreshToken;
        public String getRefreshToken(){
            return  refreshToken;
        }
        public  void setRefreshToken(){
            this.refreshToken = refreshToken;
        }

    }



}
