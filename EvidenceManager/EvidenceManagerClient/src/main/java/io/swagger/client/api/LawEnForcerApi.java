

package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.swagger.client.model.CriminalCaseMap;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LawEnForcerApi {
    private ApiClient apiClient;

    public LawEnForcerApi() {
        this(Configuration.getDefaultApiClient());
    }

    public LawEnForcerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for getCasesFromId */
    private com.squareup.okhttp.Call getCasesFromIdCall(String employeeId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'employeeId' is set
        if (employeeId == null) {
            throw new ApiException("Missing the required parameter 'employeeId' when calling getCasesFromId(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/lawEnforcer/{employeeId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "employeeId" + "\\}", apiClient.escapeString(employeeId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * gets a hashmap with caseId as key and Case name as value
     * returns a hashmap
     * @param employeeId  (required)
     * @return CriminalCaseMap
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public CriminalCaseMap getCasesFromId(String employeeId) throws ApiException {
        ApiResponse<CriminalCaseMap> resp = getCasesFromIdWithHttpInfo(employeeId);
        return resp.getData();
    }

    /**
     * gets a hashmap with caseId as key and Case name as value
     * returns a hashmap
     * @param employeeId  (required)
     * @return ApiResponse&lt;CriminalCaseMap&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<CriminalCaseMap> getCasesFromIdWithHttpInfo(String employeeId) throws ApiException {
        com.squareup.okhttp.Call call = getCasesFromIdCall(employeeId, null, null);
        Type localVarReturnType = new TypeToken<CriminalCaseMap>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * gets a hashmap with caseId as key and Case name as value (asynchronously)
     * returns a hashmap
     * @param employeeId  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getCasesFromIdAsync(String employeeId, final ApiCallback<CriminalCaseMap> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getCasesFromIdCall(employeeId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<CriminalCaseMap>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
