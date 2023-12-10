package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final SelenideElement loginField = $("[data-test-id=login] input");
    private static final SelenideElement passwordFaeld = $("[data-test-id=password] input");
    private static final SelenideElement loginButton = $("[data-test-id=action-login]");
    private static final SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");

    public static void verifyErrorNotification(String expectedText){
        errorNotification.shouldHave(exactText(expectedText)).shouldBe(visible);
    }
    public static VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordFaeld.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
