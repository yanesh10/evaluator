package com.evaluator.remoteuserstorageprovider;

import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.user.UserLookupProvider;

public class EvaluatorUserStorageProvider implements UserStorageProvider, UserLookupProvider, CredentialInputValidator {

    private final KeycloakSession session;
    private final ComponentModel model;

    public EvaluatorUserStorageProvider(KeycloakSession session, ComponentModel model) {
        this.session = session;
        this.model = model;
    }

    @Override
    public boolean supportsCredentialType(String credentialType) {
        return false;
    }

    @Override
    public boolean isConfiguredFor(RealmModel realm, UserModel user, String credentialType) {
        return false;
    }

    @Override
    public boolean isValid(RealmModel realm, UserModel user, CredentialInput credentialInput) {
        return false;
    }

    @Override
    public void close() {

    }

    @Override
    public UserModel getUserById(String id, RealmModel realm) {
        return UserLookupProvider.super.getUserById(realm, id);
    }

    @Override
    public UserModel getUserByUsername(String username, RealmModel realm) {
        return UserLookupProvider.super.getUserByUsername(realm, username);
    }


    @Override
    public UserModel getUserByEmail(String email, RealmModel realm) {
        return UserLookupProvider.super.getUserByEmail(realm, email);
    }
}
