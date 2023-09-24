
db.registered_clients.insertMany([
    {
        "_id" : "a5f8b6df-b5c4-40c4-8ee1-cbbb27d5ee66",
        "clientId" : "client-server",
        "resourceIds" : [],
        "secretRequired" : false,
        "clientSecret" : "$2a$10$1r/mZMWzh71mCD7USdgFBOsdf.jPjUf7Q3SrnWlpZruDk6Z7VCwz.",
        "scoped" : true,
        "scope" : ["openid", "profile"],
        "authorizedGrantTypes" : [{"value" : "refresh_token"}, {"value" : "authorization_code"}],
        "redirectUris" : ["http://localhost:9003/login/oauth2/code/client-server-oidc"],
        "autoApprove" : false,
        "additionalInformation" : {},
        "_class" : "com.leandro.authserver.entity.Client",
        "authenticationMethods" : ["client_secret_basic"]
    },
    {
        "_id" : "dffc6060-87e8-4f8e-a6aa-509868d2e615",
        "clientId" : "app-site-b",
        "secretRequired" : false,
        "clientSecret" : "$2a$10$1r/mZMWzh71mCD7USdgFBOsdf.jPjUf7Q3SrnWlpZruDk6Z7VCwz.",
        "scoped" : true,
        "scope" : ["openid", "profile"],
        "authorizedGrantTypes" : [{"value" : "refresh_token"}, {"value" : "authorization_code"}],
        "redirectUris" : ["http://localhost:3000/authorized"],
        "autoApprove" : false,
        "additionalInformation" : {},
        "_class" : "com.leandro.authserver.entity.Client",
        "authenticationMethods" : ["client_secret_basic"]
    },
    {
        "_id" : "6a0efc30-af63-477b-9aab-79ea7b0ef06c",
        "clientId" : "client-credentials",
        "resourceIds" : [],
        "secretRequired" : false,
        "clientSecret" : "$2a$10$1r/mZMWzh71mCD7USdgFBOsdf.jPjUf7Q3SrnWlpZruDk6Z7VCwz.",
        "scoped" : false,
        "scope" : ["openid", "profile"],
        "authorizedGrantTypes" : [{"value" : "refresh_token"}, {"value" : "client_credentials"}],
        "redirectUris" : [],
        "autoApprove" : false,
        "additionalInformation" : {},
        "_class" : "com.leandro.authserver.entity.Client",
        "authenticationMethods" : ["client_secret_basic"]
    }
]);