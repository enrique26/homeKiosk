function doClick(e) {
	alert($.label.text);
}


function callHome(){
	Ti.API.info('Button Home');
	return false;
}
$.index.addEventListener('androidhome',callHome);
$.index.open();
