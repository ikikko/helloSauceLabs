package org.ikikko.pages

import geb.Page

class LoginPage extends Page {

	static url = 'https://demo.backlog.jp/LoginDisplay.action'

	static at = {
		title == 'Backlog | デモ用ワークスペース - Login' ||
				title == 'Backlog | デモ用ワークスペース - ログイン'
	}

	static content = {
		userId { $('form').userId }
		password { $('form').password }

		submit(to:DashboardPage) {
			$('input', id:'Login_submit')
		}
	}
}
