package edu.umb.cs680.hw06;

public interface State {

    public void login(EncryptedString pwd);
    public void logout();

}
