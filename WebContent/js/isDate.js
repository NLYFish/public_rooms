function isDate(id, checkTxtId, checkTxt) {
		re = new RegExp(/^(\d{4})-(\d{1,2})-(\d{1,2})$/);
		var s;
		with(id){
			if (!(s = value.match(re))) {
				document.getElementById(checkTxtId).innerHTML = checkTxt;
				return false;
			} else {
				return true;
			}
		}
		
	}