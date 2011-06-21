package org.ikikko.pages

import geb.Page

class ProjectPage extends Page {

	static at = {
		title.startsWith('Backlog | Project Home') ||
				title.startsWith('Backlog | プロジェクトホーム')
	}

	static content = {
		firstIssue {
			$('a', href: startsWith('/view/'))[0]
		}
	}
}

