package com.daimler.sechub.domain.scan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class builds descriptions suitable for HTML output
 *
 * @author Albert Tregnaghi
 *
 */
public class HtmlCodeScanDescriptionSupport {

	public boolean isCodeScan(SecHubFinding finding) {
		SecHubCodeCallStack code = finding.getCode();
		return code != null;
	}

	public List<HTMLScanResultCodeScanEntry> buildEntries(SecHubFinding finding) {
		if (finding == null) {
			return Collections.emptyList();
		}
		SecHubCodeCallStack code = finding.getCode();
		if (code == null) {
			return Collections.emptyList();
		}
		SecHubCodeCallStack lastCode = code;
		while (lastCode.getCalls() != null) {
			lastCode = lastCode.getCalls();
		}

		List<HTMLScanResultCodeScanEntry> descriptionList = new ArrayList<>();
		HTMLScanResultCodeScanEntry entry1 = createEntry(code);

		descriptionList.add(entry1);

		if (lastCode != null) {
			/* create pseudo variant to show call hierarchy */
			HTMLScanResultCodeScanEntry pseudoEntry = new HTMLScanResultCodeScanEntry();
			pseudoEntry.location = "...";
			descriptionList.add(pseudoEntry);
			descriptionList.add(createEntry(lastCode));
		}

		return descriptionList;

	}

	private HTMLScanResultCodeScanEntry createEntry(SecHubCodeCallStack code) {
		HTMLScanResultCodeScanEntry entry1 = new HTMLScanResultCodeScanEntry();
		entry1.column = code.getColumn();
		entry1.line = code.getLine();
		entry1.location = code.getLocation();
		String source = code.getSource();
		if (source != null) {
			entry1.source = source.trim();// to improve HTML report readability we do trim leading spaces...
		}

		return entry1;
	}
}