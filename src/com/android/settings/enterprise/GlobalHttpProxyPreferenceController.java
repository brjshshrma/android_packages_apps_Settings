/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.android.settings.enterprise;

import android.content.Context;
import android.support.v7.preference.Preference;

import com.android.settings.core.PreferenceController;
import com.android.settings.overlay.FeatureFactory;

public class GlobalHttpProxyPreferenceController extends PreferenceController {

    private static final String KEY_GLOBAL_HTTP_PROXY = "global_http_proxy";
    private final EnterprisePrivacyFeatureProvider mFeatureProvider;

    public GlobalHttpProxyPreferenceController(Context context) {
        super(context);
        mFeatureProvider = FeatureFactory.getFactory(context)
                .getEnterprisePrivacyFeatureProvider(context);
    }

    @Override
    public void updateState(Preference preference) {
        preference.setVisible(mFeatureProvider.isGlobalHttpProxySet());
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String getPreferenceKey() {
        return KEY_GLOBAL_HTTP_PROXY;
    }
}
