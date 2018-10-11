/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class AdsPixelRealTimeEventLogResult extends APINode {
  @SerializedName("data_json")
  private String mDataJson = null;
  @SerializedName("device_type")
  private String mDeviceType = null;
  @SerializedName("event")
  private String mEvent = null;
  @SerializedName("event_detection_method")
  private String mEventDetectionMethod = null;
  @SerializedName("rule_conditions")
  private String mRuleConditions = null;
  @SerializedName("timestamp")
  private String mTimestamp = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  AdsPixelRealTimeEventLogResult() {
  }

  public AdsPixelRealTimeEventLogResult(Long id, APIContext context) {
    this(id.toString(), context);
  }

  public AdsPixelRealTimeEventLogResult(String id, APIContext context) {
    this.mId = id;

    this.context = context;
  }

  public AdsPixelRealTimeEventLogResult fetch() throws APIException{
    AdsPixelRealTimeEventLogResult newInstance = fetchById(this.getPrefixedId().toString(), this.context);
    this.copyFrom(newInstance);
    return this;
  }

  public static AdsPixelRealTimeEventLogResult fetchById(Long id, APIContext context) throws APIException {
    return fetchById(id.toString(), context);
  }

  public static ListenableFuture<AdsPixelRealTimeEventLogResult> fetchByIdAsync(Long id, APIContext context) throws APIException {
    return fetchByIdAsync(id.toString(), context);
  }

  public static AdsPixelRealTimeEventLogResult fetchById(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .execute();
  }

  public static ListenableFuture<AdsPixelRealTimeEventLogResult> fetchByIdAsync(String id, APIContext context) throws APIException {
    return
      new APIRequestGet(id, context)
      .requestAllFields()
      .executeAsync();
  }

  public static APINodeList<AdsPixelRealTimeEventLogResult> fetchByIds(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return (APINodeList<AdsPixelRealTimeEventLogResult>)(
      new APIRequest<AdsPixelRealTimeEventLogResult>(context, "", "/", "GET", AdsPixelRealTimeEventLogResult.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .execute()
    );
  }

  public static ListenableFuture<APINodeList<AdsPixelRealTimeEventLogResult>> fetchByIdsAsync(List<String> ids, List<String> fields, APIContext context) throws APIException {
    return
      new APIRequest(context, "", "/", "GET", AdsPixelRealTimeEventLogResult.getParser())
        .setParam("ids", APIRequest.joinStringList(ids))
        .requestFields(fields)
        .executeAsyncBase();
  }

  private String getPrefixedId() {
    return getId();
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdsPixelRealTimeEventLogResult loadJSON(String json, APIContext context) {
    AdsPixelRealTimeEventLogResult adsPixelRealTimeEventLogResult = getGson().fromJson(json, AdsPixelRealTimeEventLogResult.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsPixelRealTimeEventLogResult.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adsPixelRealTimeEventLogResult.context = context;
    adsPixelRealTimeEventLogResult.rawValue = json;
    return adsPixelRealTimeEventLogResult;
  }

  public static APINodeList<AdsPixelRealTimeEventLogResult> parseResponse(String json, APIContext context, APIRequest request) throws MalformedResponseException {
    APINodeList<AdsPixelRealTimeEventLogResult> adsPixelRealTimeEventLogResults = new APINodeList<AdsPixelRealTimeEventLogResult>(request, json);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adsPixelRealTimeEventLogResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
        };
        return adsPixelRealTimeEventLogResults;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsPixelRealTimeEventLogResults.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsPixelRealTimeEventLogResults.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsPixelRealTimeEventLogResults.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsPixelRealTimeEventLogResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  adsPixelRealTimeEventLogResults.add(loadJSON(entry.getValue().toString(), context));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsPixelRealTimeEventLogResults.add(loadJSON(obj.toString(), context));
            }
          }
          return adsPixelRealTimeEventLogResults;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsPixelRealTimeEventLogResults.add(loadJSON(entry.getValue().toString(), context));
          }
          return adsPixelRealTimeEventLogResults;
        } else {
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              adsPixelRealTimeEventLogResults.add(loadJSON(value.toString(), context));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsPixelRealTimeEventLogResults;
          }

          // Sixth, check if it's pure JsonObject
          adsPixelRealTimeEventLogResults.clear();
          adsPixelRealTimeEventLogResults.add(loadJSON(json, context));
          return adsPixelRealTimeEventLogResults;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }

  public APIRequestGet get() {
    return new APIRequestGet(this.getPrefixedId().toString(), context);
  }


  public String getFieldDataJson() {
    return mDataJson;
  }

  public String getFieldDeviceType() {
    return mDeviceType;
  }

  public String getFieldEvent() {
    return mEvent;
  }

  public String getFieldEventDetectionMethod() {
    return mEventDetectionMethod;
  }

  public String getFieldRuleConditions() {
    return mRuleConditions;
  }

  public String getFieldTimestamp() {
    return mTimestamp;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public String getFieldId() {
    return mId;
  }



  public static class APIRequestGet extends APIRequest<AdsPixelRealTimeEventLogResult> {

    AdsPixelRealTimeEventLogResult lastResponse = null;
    @Override
    public AdsPixelRealTimeEventLogResult getLastResponse() {
      return lastResponse;
    }
    public static final String[] PARAMS = {
    };

    public static final String[] FIELDS = {
      "data_json",
      "device_type",
      "event",
      "event_detection_method",
      "rule_conditions",
      "timestamp",
      "url",
      "id",
    };

    @Override
    public AdsPixelRealTimeEventLogResult parseResponse(String response) throws APIException {
      return AdsPixelRealTimeEventLogResult.parseResponse(response, getContext(), this).head();
    }

    @Override
    public AdsPixelRealTimeEventLogResult execute() throws APIException {
      return execute(new HashMap<String, Object>());
    }

    @Override
    public AdsPixelRealTimeEventLogResult execute(Map<String, Object> extraParams) throws APIException {
      lastResponse = parseResponse(executeInternal(extraParams));
      return lastResponse;
    }

    public ListenableFuture<AdsPixelRealTimeEventLogResult> executeAsync() throws APIException {
      return executeAsync(new HashMap<String, Object>());
    };

    public ListenableFuture<AdsPixelRealTimeEventLogResult> executeAsync(Map<String, Object> extraParams) throws APIException {
      return Futures.transform(
        executeAsyncInternal(extraParams),
        new Function<String, AdsPixelRealTimeEventLogResult>() {
           public AdsPixelRealTimeEventLogResult apply(String result) {
             try {
               return APIRequestGet.this.parseResponse(result);
             } catch (Exception e) {
               throw new RuntimeException(e);
             }
           }
         }
      );
    };

    public APIRequestGet(String nodeId, APIContext context) {
      super(context, nodeId, "/", "GET", Arrays.asList(PARAMS));
    }

    @Override
    public APIRequestGet setParam(String param, Object value) {
      setParamInternal(param, value);
      return this;
    }

    @Override
    public APIRequestGet setParams(Map<String, Object> params) {
      setParamsInternal(params);
      return this;
    }


    public APIRequestGet requestAllFields () {
      return this.requestAllFields(true);
    }

    public APIRequestGet requestAllFields (boolean value) {
      for (String field : FIELDS) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestFields (List<String> fields) {
      return this.requestFields(fields, true);
    }

    @Override
    public APIRequestGet requestFields (List<String> fields, boolean value) {
      for (String field : fields) {
        this.requestField(field, value);
      }
      return this;
    }

    @Override
    public APIRequestGet requestField (String field) {
      this.requestField(field, true);
      return this;
    }

    @Override
    public APIRequestGet requestField (String field, boolean value) {
      this.requestFieldInternal(field, value);
      return this;
    }

    public APIRequestGet requestDataJsonField () {
      return this.requestDataJsonField(true);
    }
    public APIRequestGet requestDataJsonField (boolean value) {
      this.requestField("data_json", value);
      return this;
    }
    public APIRequestGet requestDeviceTypeField () {
      return this.requestDeviceTypeField(true);
    }
    public APIRequestGet requestDeviceTypeField (boolean value) {
      this.requestField("device_type", value);
      return this;
    }
    public APIRequestGet requestEventField () {
      return this.requestEventField(true);
    }
    public APIRequestGet requestEventField (boolean value) {
      this.requestField("event", value);
      return this;
    }
    public APIRequestGet requestEventDetectionMethodField () {
      return this.requestEventDetectionMethodField(true);
    }
    public APIRequestGet requestEventDetectionMethodField (boolean value) {
      this.requestField("event_detection_method", value);
      return this;
    }
    public APIRequestGet requestRuleConditionsField () {
      return this.requestRuleConditionsField(true);
    }
    public APIRequestGet requestRuleConditionsField (boolean value) {
      this.requestField("rule_conditions", value);
      return this;
    }
    public APIRequestGet requestTimestampField () {
      return this.requestTimestampField(true);
    }
    public APIRequestGet requestTimestampField (boolean value) {
      this.requestField("timestamp", value);
      return this;
    }
    public APIRequestGet requestUrlField () {
      return this.requestUrlField(true);
    }
    public APIRequestGet requestUrlField (boolean value) {
      this.requestField("url", value);
      return this;
    }
    public APIRequestGet requestIdField () {
      return this.requestIdField(true);
    }
    public APIRequestGet requestIdField (boolean value) {
      this.requestField("id", value);
      return this;
    }
  }


  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public AdsPixelRealTimeEventLogResult copyFrom(AdsPixelRealTimeEventLogResult instance) {
    this.mDataJson = instance.mDataJson;
    this.mDeviceType = instance.mDeviceType;
    this.mEvent = instance.mEvent;
    this.mEventDetectionMethod = instance.mEventDetectionMethod;
    this.mRuleConditions = instance.mRuleConditions;
    this.mTimestamp = instance.mTimestamp;
    this.mUrl = instance.mUrl;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsPixelRealTimeEventLogResult> getParser() {
    return new APIRequest.ResponseParser<AdsPixelRealTimeEventLogResult>() {
      public APINodeList<AdsPixelRealTimeEventLogResult> parseResponse(String response, APIContext context, APIRequest<AdsPixelRealTimeEventLogResult> request) throws MalformedResponseException {
        return AdsPixelRealTimeEventLogResult.parseResponse(response, context, request);
      }
    };
  }
}