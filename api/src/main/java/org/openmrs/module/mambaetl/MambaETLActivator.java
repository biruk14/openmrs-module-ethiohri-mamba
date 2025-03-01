/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * <p>
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.mambaetl;

import org.openmrs.api.context.Context;
import org.openmrs.module.reporting.report.manager.ReportManager;
import org.openmrs.module.reporting.report.manager.ReportManagerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openmrs.module.BaseModuleActivator;

/**
 * This class contains the logic that is run every time this module is either started or shutdown
 */
public class MambaETLActivator extends BaseModuleActivator {
	
	private static final Logger log = LoggerFactory.getLogger(MambaETLActivator.class);
	
	@Override
	public void started() {
		log.info("Started MambaETL Reference Module");
		for (ReportManager reportManager : Context.getRegisteredComponents(ReportManager.class)) {
			log.info("Setting up report " + reportManager.getName() + "...");
			ReportManagerUtil.setupReport(reportManager);
		}
	}
	
	@Override
	public void stopped() {
		log.info("Stopped MambaETL Reference Module");
	}
	
	public void shutdown() {
		log.info("Shutdown MambaETL Reference Module");
	}
	
	@Override
	public void willRefreshContext() {
		log.info("willRefreshContext MambaETL Reference Module");
	}
}
