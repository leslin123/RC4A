/*Copyright (C) 2012 Longerian (http://www.longerian.me)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/
package org.rubychina.android.api.response;

import java.util.ArrayList;
import java.util.List;

import org.rubychina.android.type.SiteGroup;

public class SitesResponse extends RCAPIResponse {

	private List<SiteGroup> siteGroups = new ArrayList<SiteGroup>();

	public List<SiteGroup> getSiteGroups() {
		return siteGroups;
	}

	public void setSiteGroups(List<SiteGroup> siteGroups) {
		this.siteGroups = siteGroups;
	}
	
}