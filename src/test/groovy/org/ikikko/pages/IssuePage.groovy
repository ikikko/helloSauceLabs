package org.ikikko.pages

import geb.Page

class IssuePage extends Page {

	static at = {
		title.endsWith('Backlog | Show issue') ||
				title.endsWith('Backlog | 課題の表示')
	}

	static content = {
		comment {
			// Gebのformショートカット記法は、'comment.content'のような記法だと認識されない？
			// $('form').'comment.content'

			$('textarea', name: 'comment.content')
		}

		submit {
			// [firefox]
			// find時にClassCastException発生
			// Google Colectionのインスタンスをjava.utilのListにキャストしようとしている
			// $('form', name: 'AddComment').find('input', type: 'submit')

			// id指定してるはずなのに、何故か複数要素が取得できてる？
			$('input', id:'submitbtn')[0]
		}
	}
}