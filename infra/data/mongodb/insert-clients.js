
db.registered_clients.insertMany([

    {
        "_id" : "dffc6060-87e8-4f8e-a6aa-509868d2e615",
        "clientId" : "consumer",
        "secretRequired" : false,
        "clientSecret" : "$2a$10$1r/mZMWzh71mCD7USdgFBOsdf.jPjUf7Q3SrnWlpZruDk6Z7VCwz.",
        "scoped" : true,
        "scope" : [
            "openid",
            "profile"
        ],
        "authorizedGrantTypes" : [
            {
                "value" : "refresh_token"
            },
            {
                "value" : "authorization_code"
            }
        ],
        "redirectUris" : [
            "https://microservices-app-consumer.onrender.com"
        ],
        "autoApprove" : false,
        "additionalInformation" : {
    
        },
        "_class" : "com.leandro.authserver.entity.Client",
        "authenticationMethods" : [
            "client_secret_basic"
        ]
    },
    {
        "_id" : "6a0efc30-af63-477b-9aab-79ea7b0ef06c",
        "clientId" : "client-credentials",
        "resourceIds" : [
    
        ],
        "secretRequired" : false,
        "clientSecret" : "$2a$10$1r/mZMWzh71mCD7USdgFBOsdf.jPjUf7Q3SrnWlpZruDk6Z7VCwz.",
        "scoped" : false,
        "scope" : [
            "openid",
            "profile"
        ],
        "authorizedGrantTypes" : [
            {
                "value" : "refresh_token"
            },
            {
                "value" : "client_credentials"
            }
        ],
        "redirectUris" : [
    
        ],
        "autoApprove" : false,
        "additionalInformation" : {
    
        },
        "_class" : "com.leandro.authserver.entity.Client",
        "authenticationMethods" : [
            "client_secret_basic"
        ]
    },
    {
        "_id" : "5ffb83b7-9745-4b00-89c8-70758b70c3b8",
        "clientId" : "creator",
        "secretRequired" : false,
        "clientSecret" : "$2a$10$1r/mZMWzh71mCD7USdgFBOsdf.jPjUf7Q3SrnWlpZruDk6Z7VCwz.",
        "scoped" : true,
        "scope" : [
            "openid",
            "profile"
        ],
        "authorizedGrantTypes" : [
            {
                "value" : "refresh_token"
            },
            {
                "value" : "authorization_code"
            }
        ],
        "redirectUris" : [
            "https://microservices-app-creator.onrender.com/"
        ],
        "autoApprove" : false,
        "additionalInformation" : {
    
        },
        "_class" : "com.leandro.authserver.entity.Client",
        "authenticationMethods" : [
            "client_secret_basic"
        ]
    },
    {
        "_id" : "e7d010f4-6ac4-4f52-afc6-7efb73c187c6",
        "clientId" : "account",
        "secretRequired" : false,
        "clientSecret" : "$2a$10$1r/mZMWzh71mCD7USdgFBOsdf.jPjUf7Q3SrnWlpZruDk6Z7VCwz.",
        "scoped" : true,
        "scope" : [
            "openid",
            "profile"
        ],
        "authorizedGrantTypes" : [
            {
                "value" : "refresh_token"
            },
            {
                "value" : "authorization_code"
            }
        ],
        "redirectUris" : [
            "https://microservices-app-account.onrender.com/"
        ],
        "autoApprove" : false,
        "additionalInformation" : {
    
        },
        "_class" : "com.leandro.authserver.entity.Client",
        "authenticationMethods" : [
            "client_secret_basic"
        ]
    }
    
]);