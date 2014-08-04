/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/









package com.brandnewengine.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;

import android.content.Context;
import android.os.SystemClock;
import android.net.TrafficStats;

public class Datausage extends CordovaPlugin {

    private String getDetails() {

        String str = "hello world";

        return str;
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        try {
            if (action.equals("getMobileData")) {

              long rebootTime = SystemClock.elapsedRealtime(); // last reboot in ms
              //int days = (int) (rebootTime / (1000*60*60*24));  // convert ms into days
              String msReboot = Long.toString(rebootTime);

              // Get Mobile Transmitted data
              long mobileTxTime = TrafficStats.getMobileTxBytes(); // transmitted reboot in ms
              String msMobileTx = Long.toString(mobileTxTime);

              // Get Mobile Received data
              long mobileRxTime = TrafficStats.getMobileRxBytes(); // last reboot i
              String msMobileRx = Long.toString(mobileRxTime);

              // Total Mobile data
              long totalMobile = mobileTxTime + mobileRxTime;



              // Get both wifi and mobile Transmitted data
              long totalTxTime = TrafficStats.getTotalTxBytes(); // transmitted reboot in ms
              String msTotalTx = Long.toString(totalTxTime);

              // Get both wifi and mobile Received data
              long totalRxTime = TrafficStats.getTotalRxBytes(); // last reboot i
              String msTotalRx = Long.toString(totalRxTime);

              // Total both wifi and mobile data
              long totalData = totalTxTime + totalRxTime;




              String result = "{\"reboot\":" + msReboot + ", \"totalDataBytes\":" + totalData + ", \"totalMobileBytes\":" + totalMobile + ", \"transmittedMobileBytes\":" + msMobileTx + ", \"receivedMobileBytes\":" + msMobileRx + "}";





                if (result != null) {
                    callbackContext.success(result);
                    return true;
                }
            }

            callbackContext.error("Invalid action");
            return false;

        } catch (Exception e) {
            String s = "Exception: " + e.getMessage();

            System.err.println(s);
            callbackContext.error(s);

            return false;
        }
    }
}

