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
import android.telephony.TelephonyManager;
import android.accounts.Account;
import android.accounts.AccountManager;

public class Datausage extends CordovaPlugin {

    private String getDetails() {

        String str = "hello world";

        return str;
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        try {
            if (action.equals("getMobileDataUsage")) {
                TelephonyManager tm = (TelephonyManager) this.cordova.getActivity().getSystemService(Context.TELEPHONY_SERVICE);
                AccountManager am = AccountManager.get(this.cordova.getActivity());

                //String result = "getDetails();"
                String result = "Hello WORLD."
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

