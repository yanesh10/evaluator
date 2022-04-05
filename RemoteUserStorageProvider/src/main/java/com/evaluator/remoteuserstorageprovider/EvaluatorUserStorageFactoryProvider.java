package com.evaluator.remoteuserstorageprovider;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProviderFactory;

public class EvaluatorUserStorageFactoryProvider implements UserStorageProviderFactory<EvaluatorUserStorageProvider> {

    private static final String PROVIDER_NAME = "evaluator-user-storage-provider";

    @Override
    public EvaluatorUserStorageProvider create(KeycloakSession session, ComponentModel model) {
        return new EvaluatorUserStorageProvider(session, model);
    }

    @Override
    public String getId() {
        return PROVIDER_NAME;
    }
}
