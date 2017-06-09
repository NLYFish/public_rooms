function isNum(id, checkTxtId, checkTxt) {
		re = new RegExp(/[^0-9]/);
		var s;
		with(id){
			if (s = value.match(re)) {
				document.getElementById(checkTxtId).innerHTML = checkTxt;
				return false;
			} else {
				return true;
			}
		}
		
	}