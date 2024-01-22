package ru.netology.banklogin.page;

import ru.netology.banklogin.data.DataHelper;

public class LoginPage {
    private final selenideElement loginField =$("[data-test-id=login] input");
    private final selenideElement passwordField =$("[data-test-id=password] input");
    private final selenideElement loginButton =$("[data-test-id=action-login]");
    private final selenideElement errorNotification =$("[data-test-id='error-notification'] .notification__content");

    public void verificationErrorNotification(String expectedText) {
        errorNotification.shouldHace(exactText(expectedText)).shouldBe(visible);
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
