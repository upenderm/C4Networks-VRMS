
/*// Get the container element
var atc = document.getElementById("menuItemList");
console.log("main menu container:"+atc);

// Get all buttons with class="btn" inside the container
var btns = atc.getElementsByClassName("menuItem");
console.log("sub menu container:"+btns);

// Loop through the buttons and add the active class to the current/clicked button
for (var i = 0; i < btns.length; i++) {
  btns[i].addEventListener("click", function() {
    var current = document.getElementsByClassName("active");

    // If there's no active class
    if (current.length > 0) { 
      current[0].className = current[0].className.replace(" active", "");
    }

    // Add the active class to the current/clicked button
    this.className += " active";
  });
}
*/
function setSelectedMenuItem(item){
	var ctx = "'${pageContext.request.contextPath}'";
	console.log('ctx is ::'+ctx);
	console.log("In javascript setSelectedMenuItem");
	console.log("item :"+item);
//	this.forms.selectItemToHighlight=e;
	x=getXmlHttpObject();
    if(x==null){
        alert("Browser doesn't support HTTP Request");
        return
    }
    var url = "./selectedMenu";
    url+="?selectItemToHighlight="+item;
    x.onreadystatechange=stateChangedForSelectedMenu;
    x.open("POST",url,true);
    x.send(null);
}
function stateChangedForSelectedMenu(){
    if(x.readyState==4||x.readyState=="complete"){
    		var result=x.responseText;
    		console.log("stateChangedForSelectedMenu - Ajax response is :"+result);
    		
    }else if (x.readyState == '803'){
		alert("No select option available on the server");
	}
}