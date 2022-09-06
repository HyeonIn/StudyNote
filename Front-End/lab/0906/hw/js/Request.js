function getXMLHttpRequest(){
	if(window.ActiveXObject){
		try{
			return new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e1){
			try{
				return new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e2){
				return null;
			}
		}
	}else if(window.XMLHttpRequest){
		return new XMLHttpRequest();
	}else{
		return null;
	}
}

var httpRequest = null;

function sendRequest(url, params, callback, method){
	httpRequest = getXMLHttpRequest();
	
	var httpMethod = method ? method : 'GET';
	if(httpMethod != 'GET' && httpMethod != 'POST'){
		httpMethod = 'GET';
	}
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if(httpMethod == 'GET' && httpParams != null){
		httpUrl = httpUrl + "?" + httpParams;
	}
	
	//alert("method == " + httpMethod + "\turl == " + httpUrl + "\tparam == " + httpParams);
	httpRequest.open(httpMethod, httpUrl, true);
	httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	httpRequest.onreadystatechange = callback;
	//alert(httpMethod == 'POST' ? httpParams : null);
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}




let btn_http = document.querySelector('#http');



btn_http.onclick = function () {
    let url = document.querySelector('#url').value;
    sendRequest(url, null, function () {
        if (httpRequest.readyState == 4) {
            if (httpRequest.status == 200) {
                var text = httpRequest.responseText;

                parsing(text, 'http');
            }
        }
    }, 'GET');
}

let btn_fetch = document.querySelector('#fetch');

btn_fetch.onclick = function () {
    let url = document.querySelector('#url').value;
    fetch(url)
        .then((response) => response.text())
        .then((data) => parsing(data, 'fetch'))
    
}

function parsing(data, method) {
    let objs = JSON.parse(data);
    let content = '#' + method + 'Content'
    let target = document.querySelector(content);
    let close = '#' + method + '-close';
    let close_btn = document.querySelector(close);
    close_btn.setAttribute('style', 'display: ');
    close_btn.onclick = function () {
        target.setAttribute('style', 'display: none');
        close_btn.setAttribute('style', 'display: none');
    }
    target.setAttribute('style', 'display : ');
    let custom = '';
    for (const obj of objs.items) {
        custom += '<tr><td><img src="'
            + obj.image +
            '" alt="" class="rounded" style="width: 100px; height: 100px" /></td><td>'
            + obj.title +
            '</td><td>'
            + obj.lprice + '</td></tr>'
        }
    target.innerHTML = custom;
        
}