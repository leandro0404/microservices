## Authorization Code Flow - Sample React Application

### Setup Sample Application

1. Clone this application repository.
2. Update the configurations in `src/config.js` file with proper values.
```
{
    "RESPONSE_TYPE": "code",
    "SCOPE": "<scopes seperated by space>",
    "REDIRECT_URI": "http://localhost:3000",
    "CLIENT_ID": "<client_id_of_the_application>",
    "CLIENT_SECRET": "<client_secret_of_the_application>",
    "GRANT_TYPE": "authorization_code"
}
```
3. Go to the project folder and run `npm install && npm start`
