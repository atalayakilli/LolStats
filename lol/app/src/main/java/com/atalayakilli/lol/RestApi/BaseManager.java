package com.atalayakilli.lol.RestApi;



public class BaseManager {
    protected RestApi getRestApiClient(){
        RestApiClient restApiClient = new RestApiClient(BaseUrl.url);
        return restApiClient.getmRestApi();
    }
    protected RestApi getRestApiClientKey(){
        RestApiClient restApiClient = new RestApiClient(BaseUrl.urlKey);
        return restApiClient.getmRestApi();
    }

}
