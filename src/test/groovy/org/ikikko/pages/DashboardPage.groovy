package org.ikikko.pages

import geb.Page

class DashboardPage extends Page {
	static url = 'https://demo.backlog.jp/MyPage.action'

	static at = {
		title == 'Backlog | Dashboard' ||
				title == 'Backlog | ダッシュボード'
	}

	static content = {
		firstProject {
			$('a', href: startsWith('/projects/'))[0]
		}
	}
}
