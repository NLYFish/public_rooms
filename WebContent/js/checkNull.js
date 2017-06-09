function checkNull(id, checkTxtId, checkTxt) {
	with (id) {
		if (value == null || value == "") {
			document.getElementById(checkTxtId).innerHTML = checkTxt;
			return false;
		} else {
			return true;
		}
	}
}