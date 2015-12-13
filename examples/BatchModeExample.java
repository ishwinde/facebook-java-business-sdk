/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the license found in the
 * LICENSE file in the root directory of this source tree.
 */

import java.io.File;
import java.util.Arrays;
import java.util.List;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdAccount.EnumBillingEvent;
import com.facebook.ads.sdk.AdAccount.EnumCampaignStatus;
import com.facebook.ads.sdk.AdAccount.EnumAdSetStatus;
import com.facebook.ads.sdk.AdAccount.EnumCampaignObjective;
import com.facebook.ads.sdk.AdAccount.EnumOptimizationGoal;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.BatchRequest;
import com.facebook.ads.sdk.Targeting;
import com.facebook.ads.sdk.TargetingGeoLocation;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APIResponse;

public class BatchModeExample {

  public static final String ACCESS_TOKEN = "[Your access token]";
  public static final Long ACCOUNT_ID = [Your ad account id];
  public static final File imageFile = new File("[Path to test image file for ads creation]");
  
  public static final APIContext context = new APIContext(ACCESS_TOKEN).enableDebug(true);
  public static void main(String[] args) {
    try {
      Targeting targeting = new Targeting().setFieldGeoLocations(new TargetingGeoLocation().setFieldCountries(Arrays.asList(new String[]{"US"})));
      AdAccount account = new AdAccount(ACCOUNT_ID, context);
      
      // Creation of Ad
      BatchRequest batch = new BatchRequest(context);
      account.createCampaign()
        .setName("Java SDK Batch Test Campaign")
        .setObjective(EnumCampaignObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(EnumCampaignStatus.VALUE_PAUSED)
        .addToBatch(batch, "campaignRequest");
      account.createAdSet()
        .setName("Java SDK Batch Test AdSet")
        .setCampaignId("{result=campaignRequest:$.id}")
        .setStatus(EnumAdSetStatus.VALUE_PAUSED)
        .setBillingEvent(EnumBillingEvent.VALUE_IMPRESSIONS)
        .setDailyBudget(1000L)
        .setBidAmount(100L)
        .setOptimizationGoal(EnumOptimizationGoal.VALUE_IMPRESSIONS)
        .setTargeting(targeting)
        .addToBatch(batch, "adsetRequest");
      account.createAdImage()
        .addUploadFile("file", imageFile)
        .addToBatch(batch, "imageRequest");
      account.createAdCreative()
        .setTitle("Java SDK Batch Test Creative")
        .setBody("Java SDK Batch Test Creative")
        .setImageHash("{result=imageRequest:$.images.*.hash}")
        .setLinkUrl("www.facebook.com")
        .setObjectUrl("www.facebook.com")
        .addToBatch(batch, "creativeRequest");
      account.createAd()
        .setName("Java SDK Batch Test ad")
        .setAdsetId("{result=adsetRequest:$.id}")
        .setCreative("{creative_id:{result=creativeRequest:$.id}}")
        .setStatus("PAUSED")
        .setBidAmount(100L)
        .addToBatch(batch);
      List<APIResponse> responses = batch.execute();
      
      // Obtain the IDs of the newly created objects
      Ad ad = ((Ad)responses.get(4)).fetch();
      AdSet adSet = new AdSet(ad.getFieldAdsetId(), context).fetch();
      Campaign campaign = new Campaign(adSet.getFieldCampaignId(), context);
      
      // Load
      batch = new BatchRequest(context);
      ad.get().requestAllFields().addToBatch(batch);
      adSet.get().requestAllFields().addToBatch(batch);
      campaign.get().requestAllFields().addToBatch(batch);
      responses = batch.execute();
      
      System.out.println((Ad) responses.get(0));
      System.out.println((AdSet) responses.get(1));
      System.out.println((Campaign) responses.get(2));
      
      // Delete
      batch = new BatchRequest(context);
      //ad.delete().addToBatch(batch); // Deleting campaign automatically deletes ad and adset.
      //adSet.delete().addToBatch(batch); // Deleting campaign automatically deletes ad and adset.
      campaign.delete().addToBatch(batch);
      responses = batch.execute();
      System.out.println(responses.get(0));
      
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}