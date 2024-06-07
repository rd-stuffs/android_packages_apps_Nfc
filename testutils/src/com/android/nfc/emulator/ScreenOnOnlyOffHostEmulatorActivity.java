/*
 * Copyright (C) 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.nfc.emulator;

import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;

import com.android.nfc.service.ScreenOnOnlyOffHostService;
import com.android.nfc.service.TransportService2;

public class ScreenOnOnlyOffHostEmulatorActivity extends BaseEmulatorActivity {
    protected static final String TAG = "ScreenOnOnlyOffHost";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupServices(ScreenOnOnlyOffHostService.COMPONENT);
    }

    @Override
    public ComponentName getPreferredServiceComponent(){
        return ScreenOnOnlyOffHostService.COMPONENT;
    }

    @Override
    protected void onServicesSetup() {
        boolean setOffHostRes =
                mCardEmulation.setOffHostForService(
                        ScreenOnOnlyOffHostService.COMPONENT, "eSE");
        Log.d(TAG, "OffHostService set: " + setOffHostRes);
    }
}
