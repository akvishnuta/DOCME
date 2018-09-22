var typingTimer;                //timer identifier
var doneTypingInterval = 1000;
$(document).ready(function(){
	$('#username').on('keyup', '', function(event) {
		var deferred = $.Deferred();
   			clearTimeout(typingTimer);
  			typingTimer = setTimeout(function(){
  				var pattern = $('#searchText').val();
  				doUserSearch().then(function(){
  					deferred.resolve();
  				});
  				return deferred.promise();
  			}, doneTypingInterval);
		});
	$('#searchText').on('keydown', '', function(event) {
			clearTimeout(typingTimer);
	});
});

var doUserSearch = function(){
	var deferred = $.Deferred();
	var rowCount = 0;
	var methodName = 'doLoad';
	var dataString = 'methodName='+methodName;
	var dataMap = {};
	dataMap.user='akhil';
//	dataMap.table = table==null?'':table;
//	dataMap.colList = colList==null?'':colList;
//	dataMap.pattern = pattern==null?'':pattern;
//	dataMap.compareCol = compareCol==null?'':compareCol;
//	dataString =dataString+'&'+'dataString='+JSON.stringify(dataMap);
	$.ajax({
    type:'POST',
    contentType : "application/json",
    data:dataString,
    dataType:'json',
    url:'user/searchUser',
    success:function(data) {
    	if(data === 'Failed'){
    		alert(data);
    	}else{
    		alert(data);
    	}
    	deferred.resolve();
    }
	});
	return deferred.promise();
};