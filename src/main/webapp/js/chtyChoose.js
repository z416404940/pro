var xmlHttp;
function creatXMLHttpRequest()
{
  if(window.ActiveXObject){xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");}
  else if(window.XMLHttpRequest){xmlHttp=new XMLHttpRequest();}
}
function updateSelect()
{
  var selected=document.all.slt1.value;
  creatXMLHttpRequest();
  xmlHttp.onreadystatechange=processor;
  xmlHttp.open("GET","/cityChoose/"+selected);
  xmlHttp.send(null);
}
function updateSelectCity() {
  var selected=document.all.slt2.value;
  creatXMLHttpRequest();
  xmlHttp.onreadystatechange=processor;
  xmlHttp.open("GET","/cityChoose/city"+selected);
  console.log(selected)
  xmlHttp.send(null);
}
function processor()
{
  var result;
  if(xmlHttp.readyState==4&&xmlHttp.status==200)
  {
    result=xmlHttp.responseXML.getElementsByTagName("city");
    while(document.all.slt2.length>0){ document.all.slt2.removeChild(document.all.slt2.childNodes[0]);}
    for(var i=0;i<result.length;++i)
    {
      var option=document.createElement('option');
      option.text=result[i].children[0].childNodes[0].nodeValue;
      option.value=result[i].children[1].childNodes[0].nodeValue;
      document.all.slt2.options.add(option,null);
    }
  }
}
